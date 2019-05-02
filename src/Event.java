@SuppressWarnings("serial")
abstract public class Event extends Throwable {
	private String name;
	protected String description;
	
	public Event(String name, String description) {
		this.name =  name;
		this.description =  description;
	}
	public void happen() throws Event {
		System.out.println(this.name+": "+this.description);
		this.action();
	}
	abstract public void action() throws Event;
}