public class Battle extends EventSet{
	int i;
	private Player[] Ps ;

	private class attack extends Event {
		int n;
		public attack() {
			super("Attack","");
			n = Ps[i].getAtual().attack(Ps[i].decide(4)).getDano();
			this.description = Ps[i].getName()+"'s "+Ps[i].getAtual().getName()+" used his "+Ps[i].getAtual().attack(n);
		}
		public void action() throws end{
			if (Ps[1-i].getAtual().damage(n) == 0) 
				if(!Ps[1-i].nextPokemon()) throw new end(1-i,"has no more Pokemon");
		}
	}
	private class changePokemon extends Event {
		changePokemon(){
			super("Pokemon change",Ps[i].getName()+" changed his Pokemon to "+Ps[i].getAtual().getName());
		}
		public void action(){
			Ps[i].chgPokemon();
		}
	}
	private class flee extends end {
		public flee() {
			super(i,"flew");
		}
	}
	private class useItem extends Event {
		useItem(){
			super("Item usage",Ps[i]+" used "+Potion.name()+".");
		}
		public void action(){
			Ps[i].getAtual().heal(Potion.mana());
		}
	}
	private class end extends Event{
		public end(int p, String reason) {
			super("Battle end",Ps[p].getName()+" "+reason+". Battle ended. "+Ps[1-p].name+" wins!");
		}
		public void action() {
			return;
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
		Class<?>[] Evs = { attack.class, changePokemon.class, useItem.class, flee.class, end.class};
		int[] E = new int[2];
		while (true){ //rodadas
			E[0] = Ps[0].decide(4);
			E[1] = Ps[1].decide(4);
			
			i = (E[1] > E[0])?1:0;
			//throw new
			//Evs[E[i]].happen();
			try {
				//this.add((Event) new Evs[E[i]]());
				//this.add(Evs[E[i]]);
				((Event) Evs[E[i]].getConstructor().newInstance()).happen();
			} catch(Event e) {
				e.happen();
				return;
			} catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
	public static void main (String[] args) {
		Player[] Ps = {new Player("A"),new Player("B")};
		//[new Pokemon("Pikachu",100,[new attack("Raio de trovão",30)]
		//,new Pokemon(300)])
		Battle b = new Battle(Ps);
		b.run();
	}
}

