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
	Pokemon(String nome, int Hp) {//, attack[] attacks){
		this.nome = nome;
		this.Hp[0] = this.Hp[1] = Hp;
		//ataques = attacks;
	}
	public void addAttack(int n, String s, int d) {
		ataques[n] = new attack(s,d);		
	}
	
	public String getName() {
		return nome;
	}
	public attack attack(int i) {
		return ataques[i];
	}
	
	public int damage(int d) {
		Hp[1] = (Hp[1]-d > 0)?Hp[1]-d:0;
		return Hp[1];
	}
	public int heal(int h) {
		Hp[1] = (Hp[1]+h > Hp[0])?Hp[0]:Hp[1]+h;
		return Hp[1];
	}
}