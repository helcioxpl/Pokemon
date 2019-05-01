public class Game{
	private class Battle extends EventSet{
		
		private Player[] Ps ;

		private class Move extends Event{
			private int priority;
			
			public Move(String name, String description, int priority) {
				suoer(name,description);
				this.priority =  priority;
			}
			public int getPriority() {
				return priority;
			}
		}
		
		private class attack extends Event {
			public void action(){
				n = Ps[i].atual.attack(decide(4)).getDano();
				if (!Ps[1-i].atual.damage(n)) {
					Ps[1-i].atual++;
				}				
			}
		}
		private class changePokemon extends Event {
			public void action(){
				Ps[i].chgPokemon();
			}
		}
		private class flee extends Event {
			public void action(){
				endBattle(Ps[i].name+" flew. Battle ended. "+Ps[1-i].name+" wins!");
			}
		}
		private class useItem extends Event {
			public void action(){
				Ps[1].atual.damage(-Potion.mana());
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
				
				int j = (E[1] > E[0])?1:0;
				E[i].happen();
				E[1-i].happen();
			}
		}
		
	}
	public static void main (String[] args) {
		private Player[] Ps = [new Pĺayer(),new Player()];
		Battle b = new Battle(Ps);
		b.run();
	}
}

