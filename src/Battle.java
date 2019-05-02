public class Battle extends EventSet{
	int i;
	private Player[] Ps;
	private Item Potion = new Item();

	class attack extends Event {
		Pokemon.attack n;
		public attack() {
			super("Attack","");
			n = Ps[i].getAtual().attack(Ps[i].decide(4));
			this.description = Ps[i].getName()+"'s "+Ps[i].getAtual().getName()+" used his "+n.getNome();
		}
		public void action() throws end{
			int v = Ps[1-i].getAtual().damage(n.getDano());
			System.out.println("Hp Pok B: "+v);
			if (v == 0) 
				if(!Ps[1-i].nextPokemon()) throw new end(1-i,"has no more Pokemon");
		}
	}
	class changePokemon extends Event {
		public changePokemon(){
			super("Pokemon change",Ps[i].getName()+" changed his Pokemon to "+Ps[i].getAtual().getName());
		}
		public void action(){
			Ps[i].chgPokemon();
		}
	}
	class flee extends Event{
		public flee(){
			super("Fugir","flew");
		}
		public void action() throws end{
			throw new end(i,"flew");
		}
	}
	class useItem extends Event {
		public useItem(){
			super("Item usage",Ps[i].getName()+" used "+Potion.name()+".");
		}
		public void action(){
			Ps[i].getAtual().heal(Potion.mana());
		}
	}
	class end extends Event{
		public end(int p, String reason) {
			super("Battle end",Ps[p].getName()+" "+reason+". Battle ended. "+Ps[1-p].getName()+" wins!");
		}
		public void action() {
			return;
		}
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
			E[0] = Ps[0].decide(8);
			E[0] = (E[0] >= 4)?0:E[0];
			E[1] = Ps[1].decide(8);
			E[1] = (E[1] >= 4)?0:E[1];
			
			i = (E[1] > E[0])?1:0;
			for(int j = 0;j < 2;j++, i = 1-i) {
				try {
					((Event) Evs[E[i]].getConstructors()[0].newInstance(this)).happen();
				} catch(Event e2) {
					try{
						e2.happen();
					} catch(Event e) {
						return;
					}
					return;
				} catch(Exception e) {
					System.out.println("Erro: "+e.getClass());
					System.out.println("Erro: "+e.getMessage());
					e.printStackTrace(System.out);
					System.out.println("Erro: "+Evs[E[i]]);
					return;
				}
			}
		}
	}
	public static void main (String[] args) {
		Player[] Ps = {new Player("A"),new Player("B")};
		Pokemon p = new Pokemon("Pikachu",200);
		p.addAttack(0,"Raio do trovão",30);
		p.addAttack(1,"Raio do trovão",30);
		p.addAttack(2,"Raio do trovão",30);
		p.addAttack(3,"Raio do trovão",30);
		Ps[1].setAtual(5);
		Ps[1].addPokemon(p);
		Ps[0].setAtual(5);
		Ps[0].addPokemon(p);

		Battle b = new Battle(Ps);
		b.run();
	}
}

