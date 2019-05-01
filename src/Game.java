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
		
		private class attack extends Move {
			public void action(){
				n = Ps[i].atual.attack(decide(4)).getDano();
				if (!Ps[1-i].atual.damage(n)) 
					if(!Ps[1-i].nextPokemon()) this.add(end(1-i,"has no more Pokemon"));
			}
		}
		private class changePokemon extends Move {
			public void action(){
				Ps[i].chgPokemon();
			}
		}
		private class flee extends Move {
			public void action(){
				this.add(end(i,"flew"))
			}
		}
		private class useItem extends Move {
			public void action(){
				Ps[1].atual.heal(Potion.mana());
			}
		}
		private class end extends Event{
			public end(int p, String reason) {
				super("Battle end",Ps[p].name+" "+reason+". Battle ended. "+Ps[1-p].name+" wins!");
			}
		}
		public void end(){
		}
		public add(){
			return true;
		}

		public Battle(Player[] Ps) {
			this.Ps = Ps;
		}
		public void run() {
			int[] E = new int[2];
			while (true){ //rodadas
				E[0] = Ps[0].decide(4);
				E[1] = Ps[1].decide(4);
				
				int i = (E[1] > E[0])?1:0;
				if(this.add(E[i])) return;
				if(this.add(E[1-i])) return;
			}
		}
		
	}
	public static void main (String[] args) {
		private Player[] Ps = [new Pĺayer(),new Player()];
		Battle b = new Battle(Ps);
		b.run();
	}
}

