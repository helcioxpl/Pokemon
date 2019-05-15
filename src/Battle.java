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
		super("Battle",Ps[0].getName()+" vs. "+Ps[1].getName());
		this.Ps = Ps;
	}
	public void action() {//throws Event{
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
		Pokemon pikachu = new Pokemon("Pikachu",200);
		pikachu.addAttack(0,"Raio do trovão",30);
		pikachu.addAttack(1,"Esfera eletrica",40);
		pikachu.addAttack(2,"Investida trovão",35);
		pikachu.addAttack(3,"Ataque Rapido",20);
		Pokemon charmander = new Pokemon("Charmander",200);
		charmander.addAttack(0,"Fire",30);
		charmander.addAttack(1,"Fogao",40);
		charmander.addAttack(2,"Fogo",35);
		charmander.addAttack(3,"Foguinho",20);
		Pokemon pidgey = new Pokemon("Pidgey",200);
		pidgey.addAttack(0,"Fire",30);
		pidgey.addAttack(1,"Fogao",40);
		pidgey.addAttack(2,"Fogo",35);
		pidgey.addAttack(3,"Foguinho",20);
		Pokemon meowth = new Pokemon("Pidgey",200);
		meowth.addAttack(0,"Fire",30);
		meowth.addAttack(1,"Fogao",40);
		meowth.addAttack(2,"Fogo",35);
		meowth.addAttack(3,"Foguinho",20);
		Pokemon golduck = new Pokemon("Pidgey",200);
		golduck.addAttack(0,"Fire",30);
		golduck.addAttack(1,"Fogao",40);
		golduck.addAttack(2,"Fogo",35);
		golduck.addAttack(3,"Foguinho",20);
		Pokemon arcanine = new Pokemon("Pidgey",200);
		arcanine.addAttack(0,"Fire",30);
		arcanine.addAttack(1,"Fogao",40);
		arcanine.addAttack(2,"Fogo",35);
		arcanine.addAttack(3,"Foguinho",20);
		Pokemon kadabra = new Pokemon("Pidgey",200);
		kadabra.addAttack(0,"Fire",30);
		kadabra.addAttack(1,"Fogao",40);
		kadabra.addAttack(2,"Fogo",35);
		kadabra.addAttack(3,"Foguinho",20);
		Pokemon magnemite = new Pokemon("Pidgey",200);
		magnemite.addAttack(0,"Fire",30);
		magnemite.addAttack(1,"Fogao",40);
		magnemite.addAttack(2,"Fogo",35);
		magnemite.addAttack(3,"Foguinho",20);
		Pokemon onix = new Pokemon("Pidgey",200);
		onix.addAttack(0,"Fire",30);
		onix.addAttack(1,"Fogao",40);
		onix.addAttack(2,"Fogo",35);
		onix.addAttack(3,"Foguinho",20);
		Pokemon sandslash = new Pokemon("Pidgey",200);
		sandslash.addAttack(0,"Fire",30);
		sandslash.addAttack(1,"Fogao",40);
		sandslash.addAttack(2,"Fogo",35);
		sandslash.addAttack(3,"Foguinho",20);
		Pokemon squirtle = new Pokemon("Squirtle",200);
		squirtle.addAttack(0,"Fire",30);
		squirtle.addAttack(1,"Fogao",40);
		squirtle.addAttack(2,"Fogo",35);
		squirtle.addAttack(3,"Foguinho",20);
		Pokemon bulbassauro = new Pokemon("Bulbassauro",200);
		bulbassauro.addAttack(0,"Fire",30);
		bulbassauro.addAttack(1,"Fogao",40);
		bulbassauro.addAttack(2,"Fogo",35);
		bulbassauro.addAttack(3,"Foguinho",20);
		//Ps[1].setAtual(5);
		Ps[1].addPokemon(pikachu);
		Ps[1].addPokemon(charmander);
		Ps[1].addPokemon(pidgey);
		Ps[1].addPokemon(meowth);
		Ps[1].addPokemon(golduck);
		Ps[1].addPokemon(arcanine);
		//Ps[0].setAtual(5);
		Ps[0].addPokemon(kadabra);
		Ps[0].addPokemon(magnemite);
		Ps[0].addPokemon(onix);
		Ps[0].addPokemon(sandslash);
		Ps[0].addPokemon(squirtle);
		Ps[0].addPokemon(bulbassauro);

		Battle b = new Battle(Ps);
		try{
			b.happen();
		} catch (Event e){
			return;
		}
		//b.action();
	}
}

