import java.util.Collection;
import java.util.Hashtable;

import org.restlet.Application;
import org.restlet.Component;
import org.restlet.Restlet;
import org.restlet.Router;
import org.restlet.data.MediaType;
import org.restlet.data.Protocol;
import org.restlet.data.Request;
import org.restlet.data.Response;
import org.restlet.resource.StringRepresentation;

/**
 * This class defines our Application object and starts up a standard-alone HTTP server to processes
 * incoming HTTP requests.
 * @author Jonathan Engelsma (http://themobilemontage.com)
 *
 */
public class WebServiceApplication extends Application {
	
	// Our resource data will be stored in memory in a hash table.
	private Hashtable widgets;

	public static void main(String[] args) throws Exception {

		// Create a component
		Component component = new Component();
		component.getServers().add(Protocol.HTTP, 8100);

		WebServiceApplication application = new WebServiceApplication(
				/*component.getContext()*/);

		// Attach the application to the component and start it
		component.getDefaultHost().attach(application);
		component.start();
	}

	/**
	 * Constructor to create a WebServiceApplication instance.
	 */
	public WebServiceApplication() {
		super();
		this.widgets = new Hashtable();
	}
	
	@Override
	public Restlet createRoot() {

		// Have the router, route resource requests to the appropriate resource class based on the URL pattern.
		Router router = new Router(getContext());
		router.attach("/widgets", WidgetsResource.class);
		router.attach("/widgets/{id}", WidgetResource.class);

		// This page is going to show up if somebody access the default page of the web server.
		Restlet mainpage = new Restlet() {
			@Override
			public void handle(Request request, Response response) {
				StringBuilder stringBuilder = new StringBuilder();

				stringBuilder.append("<html>");
				stringBuilder
				.append("<head><title>Sample Application Default Page</title></head>");
				stringBuilder.append("<body bgcolor=white>");
				stringBuilder.append("<h1>I am an example webserver that supports RESTful web services</h1>");
				stringBuilder.append("Click <a href=\"/widgets\">here</a> to see all my widgets.");
				stringBuilder.append("</body>");
				stringBuilder.append("</html>");

				response.setEntity(new StringRepresentation(stringBuilder
						.toString(), MediaType.TEXT_HTML));

			}
		};        
		router.attach("", mainpage);
		return router;
	}
	
	/**
	 * Return a specific widget;
	 * @param id the id of the widget to return.
	 * @return reference to a widget.
	 */
	public Widget getWidget(String id) 
	{
		return (Widget)this.widgets.get(id);
	}
	
	/**
	 * Store a new widget.
	 * @param w the widget to store.
	 * 
	 */
	public void saveWidget(Widget w) {
		this.widgets.put(w.getId(), w);
	}
	
	/**
	 * Delete an existing widget.
	 * @param id the id of the widget to delete.
	 */
	public void deleteWidget(String id) 
	{
		this.widgets.remove(id);
	}
	
	/**
	 * Returns the hashed set of all widgets.
	 * @return a reference to an enumeration of widgets..
	 */
	public Collection getWidgets() {
		return this.widgets.values();
	}
	
}