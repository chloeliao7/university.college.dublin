import org.restlet.Context;
import org.restlet.data.Form;
import org.restlet.data.MediaType;
import org.restlet.data.Request;
import org.restlet.data.Response;
import org.restlet.data.Status;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.resource.Representation;
import org.restlet.resource.Resource;
import org.restlet.resource.ResourceException;
import org.restlet.resource.StringRepresentation;
import org.restlet.resource.Variant;

/**
 * Represents a collection of widgets.  This resource processes HTTP requests that come in on the URIs
 * in the form of:
 * 
 * http://host:port/widgets/{id}
 * 
 * This resource supports both HTML and JSON representations.
 * 
 * @author Jonathan Engelsma (http://themobilemontage.com)
 *
 */
public class WidgetResource extends Resource {

	private Widget widget = null;
	private WebServiceApplication app;

	public WidgetResource(Context context, Request request, Response response) {
		super(context, request, response);
		
		// URL requests routed to this resource have the widget id on them. 
		String widgetid = null;
		widgetid = (String) getRequest().getAttributes().get("id");
		
		// retrieve the specified widget from the Application instance
		this.app = (WebServiceApplication) this.getApplication();
		this.widget = app.getWidget(widgetid);
		
		// these are the representation types this resource supports.
		getVariants().add(new Variant(MediaType.TEXT_HTML));
		getVariants().add(new Variant(MediaType.APPLICATION_JSON));
	}

	/**
	 * Allow a PUT http request
	 * 
	 * @return
	 */
	public boolean allowPut() {
		return true;
	}


	/**
	 * Allow a DELETE http request
	 * 
	 * @return
	 */
	public boolean allowDelete() {
		return true;
	}

	/**
	 * Allow the resource to be modified
	 * 
	 * @return
	 */
	public boolean setModifiable() {
		return true;
	}

	/**
	 * Allow the resource to be read
	 * 
	 * @return
	 */
	public boolean setReadable() {
		return true;
	}

	/**
	 * Represent the widget object in the requested format.
	 * 
	 * @param variant
	 * @return
	 * @throws ResourceException
	 */
	public Representation represent(Variant variant) throws ResourceException {
		Representation result = null;
		if (null == this.widget) {
			ErrorMessage em = new ErrorMessage();
			return representError(variant, em);
		} else {
			if (variant.getMediaType().equals(MediaType.APPLICATION_JSON)) {
				result = new JsonRepresentation(this.widget.toJSON());
			} else {
				result = new StringRepresentation(this.widget.toHtml(false));
				result.setMediaType(MediaType.TEXT_HTML);
			}
		}
		return result;
	}

	/**
	 * Handle a PUT Http request. Update an existing widget
	 * 
	 * @param entity
	 * @throws ResourceException
	 */
	public void storeRepresentation(Representation entity)
	throws ResourceException {
		try {
			if (null == this.widget) {
				ErrorMessage em = new ErrorMessage();
				Representation rep = representError(entity.getMediaType(), em);
				getResponse().setEntity(rep);
				getResponse().setStatus(Status.CLIENT_ERROR_BAD_REQUEST);
				return;
			}
			if (entity.getMediaType().equals(MediaType.APPLICATION_WWW_FORM,
					true)) {
				Form form = new Form(entity);
				this.widget.setName(form.getFirstValue("name"));
				this.app.saveWidget(this.widget);

				getResponse().setStatus(Status.SUCCESS_OK);
				Representation rep = new JsonRepresentation(this.widget.toJSON());
				getResponse().setEntity(rep);
				
			} else {
				getResponse().setStatus(Status.CLIENT_ERROR_BAD_REQUEST);
			}
		} catch (Exception e) {
			getResponse().setStatus(Status.SERVER_ERROR_INTERNAL);
		}
	}

	/**
	 * Handle a DELETE Http Request. Delete an existing widget
	 * 
	 * @param entity
	 * @throws ResourceException
	 */
	public void removeRepresentations()
	throws ResourceException {
		try {
			if (null == this.widget) {
				ErrorMessage em = new ErrorMessage();
				Representation rep = representError(MediaType.APPLICATION_JSON, em);
				getResponse().setEntity(rep);
				getResponse().setStatus(Status.CLIENT_ERROR_BAD_REQUEST);
				return;
			}
			this.app.deleteWidget(this.widget.getId());
			getResponse().setStatus(Status.SUCCESS_OK);
		} catch (Exception e) {
			getResponse().setStatus(Status.SERVER_ERROR_INTERNAL);
		}
	}

	/**
	 * Represent an error message in the requested format.
	 * 
	 * @param variant
	 * @param em
	 * @return
	 * @throws ResourceException
	 */
	private Representation representError(Variant variant, ErrorMessage em)
	throws ResourceException {
		Representation result = null;
		if (variant.getMediaType().equals(MediaType.APPLICATION_JSON)) {
			result = new JsonRepresentation(em.toJSON());
		} else {
			result = new StringRepresentation(em.toString());
		}
		return result;
	}

	protected Representation representError(MediaType type, ErrorMessage em)
	throws ResourceException {
		Representation result = null;
		if (type.equals(MediaType.APPLICATION_JSON)) {
			result = new JsonRepresentation(em.toJSON());
		} else {
			result = new StringRepresentation(em.toString());
		}
		return result;
	}
}
