public class Player {
	private String name;
	Pokemon[] p = new Pokemon[6];
	private int atual = 0;
	
	public Player(){
	}
	
	public void chgPokemon(){
		Pokemon aux;
		int n = decide(6 - atual - 1) + atual + 1;
		aux = p[n];
		p[n] = p[atual];
		p[atual] = aux;
	}
	public int decide(int x) {
		return (int) Math.floor(Math.random()*(x));
	}
	public int getAtual() {
		return atual;
	}
	public boolean nextPokemon() {
		atual++;
		if(atual == 6) {
			return false;
		}
		return true;
	}
}