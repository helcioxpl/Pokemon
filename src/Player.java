public class Player {
	private String name;
	Pokemon[] p = new Pokemon[6];
	int atual = 0;
	
	Player(){
	}
	private class attack extends Event {
		attack(){
			super(0);
		}
		public void action(){
			
		}
		public String description() {
			return "Yay";
		}
	}
	private class changePokemon extends Event {
		changePokemon(){
			super(0);
		}
		public void action(){
			
		}
		public String description() {
			return "Yay";
		}
	}
	private class flee extends Event {
		flee(){
			super(0);
		}
		public void action(){
			
		}
		public String description() {
			return "Yay";
		}
	}
	private class useItem extends Event {
		useItem(){
			super(0);
		}
		public void action(){
			
		}
		public String description() {
			return "Yay";
		}
	}
}