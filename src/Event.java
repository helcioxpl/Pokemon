abstract public class Event {
	void run() {}
	private long evtTime;
	private int priority;
	
	public Event(long eventTime) {
		evtTime = eventTime;
	}
	public boolean ready() {
		return System.currentTimeMillis() >= evtTime;
	}
	public int getPriority() {
		return priority;
	}
	
	abstract public void action();
	abstract public String description();
}