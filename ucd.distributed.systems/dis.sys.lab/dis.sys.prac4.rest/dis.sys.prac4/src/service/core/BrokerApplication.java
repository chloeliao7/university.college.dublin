package service.core;
import client.Main;
import com.google.gson.Gson;
import org.restlet.*;
import org.restlet.data.MediaType;
import org.restlet.data.Method;
import org.restlet.data.Protocol;
import org.restlet.data.Status;
import org.restlet.routing.Router;
import service.broker.LocalBrokerService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class BrokerApplication extends Application {
  static Map<String, Quotation> quotations = new HashMap<String, Quotation>();
  static Gson gson = new Gson();
  public static void main(String[] args) throws Exception {
      Component component = new Component();
      component.getServers().add(Protocol.HTTP, 9003);
      component.getClients().add(Protocol.HTTP); // getting all clients from http
      component.getDefaultHost().attach("", new BrokerApplication());
      component.start();
  }

  public Restlet createInboundRoot() {
    Router router = new Router(getContext());
    router.attach("/brokers", new Restlet() {
      public void handle(Request request, Response response) {
        if (request.getMethod().equals(Method.POST)) {
          List<Quotation> allQuotations = new ArrayList<Quotation>();
          for(ClientInfo clientInfo : Main.clients){
            List<Quotation> quotations = new LocalBrokerService().getQuotations(Main.clients[0]);
            if(quotations!=null){
              allQuotations.addAll(quotations);
            }
          }

          String toJson = gson.toJson(allQuotations); // getting all quotations and setting them into toJson
          response.setEntity(toJson, MediaType.APPLICATION_JSON); // postman
          System.out.println("source posted toJson: " + toJson); 
          System.out.println("source posted allQuotations: " + allQuotations); // will call to string
          response.setStatus(Status.SUCCESS_OK);
        } else
          response.setStatus(Status.CLIENT_ERROR_FORBIDDEN);
      }
    });
    return router;
  }
}
