import Game.Battle.end;

abstract public class Event extends Throwable {
	private static String name;
	private static String description;
	
	public Event(String name, String description) {
		this.name =  name;
		this.description =  description;
	}
	abstract public void action() throws Event;
	public String description(){
		return this.description;
	}
}