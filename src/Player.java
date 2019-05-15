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
		System.out.println("Estou na posicao" +numPokemons);
		numPokemons++;
	}
	
	public String getName() {
		return name;
	}
	
	public boolean chgPokemon(){
		Pokemon aux;
		if ((6 - atual - 1) <= 0) return false;
		int n = decide(6 - atual - 1) + atual + 1;
		aux = p[n];
		p[n] = p[atual];
		p[atual] = aux;
		return true;
	}
	public static int decide(int x) {
		return r.nextInt(x);
	}
	public Pokemon getAtual() {
		return p[atual];
	}
	public void setAtual(int n) {
		atual = n;
	}
	public boolean nextPokemon() {
		atual++;
		if(atual == 6) {
			return false;
		}
		return true;
	}
}