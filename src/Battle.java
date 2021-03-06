public class Battle extends Event{
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
			Pokemon pk = Ps[1-i].getAtual();
			int hp = pk.damage(n.getDano());
			System.out.println(Ps[1-i].getName()+"'s "+pk.getName()+" is now with "+hp+"hp");
			if (hp == 0) 
				if(!Ps[1-i].nextPokemon()) throw new end(1-i,"has no more Pokemon");
		}
	}
	class changePokemon extends Event {
		public changePokemon(){
			super("Pokemon change",Ps[i].getName()+" changed his Pokemon to ");
		}
		public void action(){
			Ps[i].chgPokemon();
			this.description += Ps[i].getAtual().getName();
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
			super("Battle ended",Ps[p].getName()+" "+reason+". "+Ps[1-p].getName()+" wins!");
		}
		public void action() {
			return;
		}
	}
	public boolean add(Event e){
		return true;
	}

	public Battle(Player[] Ps) {
		super("Battle",Ps[0].getName()+" vs. "+Ps[1].getName());
		this.Ps = Ps;
	}
	public void action() {//throws Event{
		Class<?>[] Evs = { attack.class, changePokemon.class, useItem.class, flee.class, end.class};
		int[] E = new int[2];
		while (true){ //rodadas
			for(int j = 0;j < 2; j++) {	
				E[j] = Ps[j].decide(8);
				E[j] = (E[j] >= 4)?0:E[j];
			}
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
		Pokemon.populate(Ps);

		Battle b = new Battle(Ps);
		try{
			b.happen();
		} catch (Event e){
			return;
		}
	}
}

