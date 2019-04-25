public class Pokemon {
	String nome;
	int Hp[] = new int[2];
	
	public class attack{
		String nome;
		int dano;
		attack(String n, int d){
			nome = n;
			dano = d;
		}
		public String getNome() {
			return nome;
		}
		public int getDano() {
			return dano;
		}
	}
	
	attack[] ataques = new attack[4];
	Pokemon(int Hp, attack[] attacks){
		this.Hp[0] = this.Hp[0] = Hp;
		ataques = attacks;
	}
	public attack attack(int i) {
		return ataques[i];
	}
	
	public void damage(int d) {
		Hp[1]-=d;
	}
}