import java.util.Random;

public class Player {
	private String name;

	Pokemon[] p = new Pokemon[6];
	Item[] pt = new Item[5];

	protected int atual = 0;
	private int numPokemons = 0;
	static Random r = new Random();
	
	public Player(String nome){
		name = nome;
	}
	
	public void addPokemon(Pokemon p) {
		if(numPokemons == 6) {
			System.out.println("Pokedex cheia");
			return;
		}
		this.p[numPokemons] = p;
		numPokemons++;
	}
	
	public String getName() {
		return name;
	}
	
	public boolean chgPokemon(){
		Pokemon aux;
		int n = 6 - atual - 1;
		if (n <= 0) return false;
		
		n = decide(n) + atual + 1;
		aux = p[n];
		p[n] = p[atual];
		p[atual] = aux;
		return true;
	}
	public int decide(int x) {
		return r.nextInt(x);
	}
	public int choose(Choice c){
		return r.nextInt(c.n);
	}
	public Pokemon getAtual() {
		return p[atual];
	}
	public void setAtual(int n) {
		atual = n;
	}
	public boolean nextPokemon() {
		atual++;
		return atual < 6;
	}
}