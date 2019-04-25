abstract public class Event {
	private int priority;
	
	public Event(int priority) {
		this.priority =  priority;
	}
	public int getPriority() {
		return priority;
	}
	
	abstract public void action();
	abstract public String description();
}