public class Player {
	private String name;
	Pokemon[] p = new Pokemon[6];
	int atual = 0;
	
	Player(){
	}
	
	public int decide() {
		return (int) Math.floor(Math.random()*4);
	}
}