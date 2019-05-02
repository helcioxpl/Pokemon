@SuppressWarnings("serial")
abstract public class Event extends Throwable {
	private String name;
	protected String description;
	
	public Event(String name, String description) {
		this.name =  name;
		this.description =  description;
	}
	public void happen() throws Event {
		this.action();
		System.out.println(this.name);
		System.out.println(this.description);
	}
	abstract public void action() throws Event;
}