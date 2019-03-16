import org.json.JSONObject;

/**
 * A POJO representing the actual widget resource.
 * 
 * @author Jonathan Engelsma (http://themobilemontage.com)
 *
 */
public class Widget {

	private static int idGen = 1;
	private String id = null;
	private String name = null;

	
	public Widget()
	{
		this.id = new String(""+idGen++);
	}
	
	/**
	 * @return Returns the id.
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 *            The id to set.
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return Returns the name.
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            The name to set.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Convert this object to a JSON object for representation
	 */
	public JSONObject toJSON() {
		try{
			JSONObject jsonobj = new JSONObject();
			jsonobj.put("id", this.id);
			jsonobj.put("name", this.name);
			return jsonobj;
		}catch(Exception e){
			return null;
		}
	}

	/**
	 * Convert this object to a string for representation
	 */
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("id:");
		sb.append(this.id);
		sb.append(",name:");
		sb.append(this.name);
		return sb.toString();
	}
	
	/** 
	 * Convert this object into an HTML representation.
	 * @param fragment if true, generate an html fragment, otherwise a complete document.
	 * @return an HTML representation.
	 */
	public String toHtml(boolean fragment) 
	{
		String retval = "";
		if(fragment) {
			StringBuffer sb = new StringBuffer();
			sb.append("<b>id:</b> ");
			sb.append(id);
			sb.append("<b> Name: </b>");
			sb.append(name);
			sb.append(" <a href=\"/widgets/" + id + "\">View</a>");
			sb.append("<br/>");
			retval = sb.toString();
		} else {
			StringBuffer sb = new StringBuffer("<html><head><title>Widget Resource</title></head><body><h1>Widget Representation</h1>");
			sb.append("<b>id:</b> ");
			sb.append(id);
			sb.append("<br/><b>Name: </b>");
			sb.append(name);
			sb.append("<br/><br/>Return to <a href=\"/widgets\">widget list<a>.</body></html>");
			retval = sb.toString();
		}
		return retval;
	}
}

