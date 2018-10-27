package service.auldfellas;
import com.google.gson.Gson;
import org.restlet.*;
import org.restlet.data.MediaType;
import org.restlet.data.Method;
import org.restlet.data.Protocol;
import org.restlet.data.Status;
import org.restlet.routing.Router;
import service.core.Quotation;
import service.core.Utility;
import java.util.HashMap;
import java.util.Map;

public class AFApplication extends Application {
  static Map<String, Quotation> afpQuotationsall = new HashMap<String, Quotation>();
  static Gson gson = new Gson();


// adding component and attaching port number 9000 to http 
// starting the server 
  public static void main(String[] args) throws Exception {
    Component component = new Component();
    component.getServers().add(Protocol.HTTP, 9000);
    component.getDefaultHost().attach("", new AFApplication());
    component.start();
  }


  // post method
  public Restlet createInboundRoot() {
      Router router = new Router(getContext()); // create router
      router.attach("/quotations", new Restlet() { // attach router to quotations
        public void handle(Request request, Response response) { // start handle with res and req
          String json = request.getEntityAsText(); // json setup as string (req get alll text)
          Quotation quotation = gson.fromJson(json, Quotation.class); // attaching statig google gson to quotation
          if (request.getMethod().equals(Method.POST)) { // starting post method with request param 
            if (!afpQuotationsall.containsKey(quotation.reference)) { // if this service contains quotation reff
              afpQuotationsall.put(quotation.reference, quotation); 
              String out = "["; // manual json
              out += ",";
              String url = request.getHostRef() + "/quotations/" + quotation.reference; // adds quotation reff to url 
              response.setLocationRef(url); //
              out += "{\"reference\" : \"" + quotation.reference + "\", \"link\":\"" + url + "\"}"; // adds to urs
              String toJson = gson.toJson(quotation); 
              response.setEntity(toJson, MediaType.APPLICATION_JSON); 
              System.out.println("source posted toJson" + toJson);
              System.out.println("source posted quotation" + quotation); 
              response.setStatus(Status.SUCCESS_OK); // making sure its systained 
            }
          } else
            response.setStatus(Status.CLIENT_ERROR_FORBIDDEN);
        }
      });

      // get method
      router.attach("/quotations/{reference}", new Restlet() { // attaching refference as get
        @Override
        public void handle(Request request, Response response) { 
          String id = (String) request.getAttributes().get("reference"); // getting the attributes refference attaching them as stirng 
          if (afpQuotationsall.containsKey(id)) { // asking if quotation contains id then do this:
            response.setStatus(Status.SUCCESS_OK); // tells us ok
            if (request.getMethod().equals(Method.GET)) {
              response.setEntity(gson.toJson(afpQuotationsall.get(id)), MediaType.APPLICATION_JSON); //sets the entity  
              response.setStatus(Status.SUCCESS_OK);
            } else if (request.getMethod().equals(Method.PUT)) {
              Quotation quotation = gson.fromJson(request.getEntityAsText(), Quotation.class); // creates quotation from quotation class 
              quotation.merge(afpQuotationsall.get(id)); // merges the id to quotation 
              afpQuotationsall.put(quotation.reference, quotation); // puts the quotation refference
              response.setStatus(Status.SUCCESS_NO_CONTENT); 
            } else if (request.getMethod().equals(Method.DELETE)) {
              afpQuotationsall.remove(id); // if id doesnt work remove it 
              response.setStatus(Status.SUCCESS_NO_CONTENT);
            }
          } else {
            response.setStatus(Status.CLIENT_ERROR_NOT_FOUND);
          }
        }
      });
      return router; // returns the router
    }
  }
