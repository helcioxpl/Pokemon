public class Game{
	private class Battle extends EventSet{
		int i;
		private Player[] Ps ;

		private class attack extends Event {
			public void action() throws end{
				int n = Ps[i].getAtual().attack(Ps[i].decide(4)).getDano();
				if (Ps[1-i].getAtual().damage(n) == 0) 
					if(!Ps[1-i].nextPokemon()) throw new end(1-i,"has no more Pokemon");
			}
		}
		private class changePokemon extends Event {
			public void action(){
				Ps[i].chgPokemon();
			}
		}
		private class flee extends Event {
			public void action() throws end{
				throw new end(i,"flew");
			}
		}
		private class useItem extends Event {
			public void action(){
				Ps[i].getAtual().heal(Potion.mana());
			}
		}
		private class end extends Event{
			public end(int p, String reason) {
				super("Battle end",Ps[p].getName()+" "+reason+". Battle ended. "+Ps[1-p].name+" wins!");
			}
		}
		public void end(){
		}
		public boolean add(Event e){
			return true;
		}

		public Battle(Player[] Ps) {
			this.Ps = Ps;
		}
		public void run() {//throws Event{
			Class[] Evs = { attack.class, changePokemon.class, useItem.class, flee.class, end.class};
			int[] E = new int[2];
			while (true){ //rodadas
				E[0] = Ps[0].decide(4);
				E[1] = Ps[1].decide(4);
				
				i = (E[1] > E[0])?1:0;
				//throw new
				Evs[E[i]].action();
				System.out.println(Evs[E[i]].description());
				try {
					this.add(Evs[E[i]]);
					this.add(Evs[E[i]]);
				} catch(end e) {
					e.action();
					System.out.println(e.description());
					return;
				}
			}
		}
		
	}
	public static void main (String[] args) {
		Player[] Ps = {new Pĺayer("A"),new Player("B")};
		Battle b = new Battle(Ps);
		b.run();
	}
}

