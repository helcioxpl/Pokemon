public class Game{
	private class Battle extends EventSet{
		
		private Player[] Ps ;
		
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
		
		public Battle(Player[] Ps) {
			this.Ps = Ps;
		}
		public  void run() {
			int[] E = new int[2];
			while (true){ //rodadas
				E[0] = Ps[0].decide();
				E[1] = Ps[1].decide();
				
				int i = (E[1] > E[0])?E[1]:E[0];
			}
		}
		
	}
	public static void main (String[] args) {
		private Player[] Ps = [new Pĺayer(),new Player()];
		Battle b = new Battle(Ps);
		b.run();
	}
}

