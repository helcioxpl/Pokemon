import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

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

	public static void populate(Player[] Ps){
		Pokemon[] pokes = new Pokemon[12];
		String s;
		BufferedReader input;
		try{
			input = new BufferedReader(new FileReader("./src/Pokemon.txt"));
			
			for(int i = 0; i < 12; i++){
				s = input.readLine();
				pokes[i] = new Pokemon(s.substring(4, s.length()-1), Integer.parseInt(s.substring(0,3)));
				for(int j = 0;j < 4; j++){
					s = input.readLine();
					pokes[i].addAttack(j,s.substring(4, s.length()-1), Integer.parseInt(s.substring(0,3)));
				}
				input.readLine();
			}
			input.close();

			Random r = new Random();
			Pokemon pk;
			int n;
			for(int i = 11, j = 0; i > 0; i--){
				n = r.nextInt(i+1);
				pk = pokes[n];
				pokes[n] = pokes[i];
	
				Ps[j].addPokemon(pk);
				j = 1-j;
			}
		} catch (FileNotFoundException e){
			System.out.println("Game coundn't find Pokemon file, please make sure it is in the same directory as the script.");
			return;
		} catch (IOException e) {
			System.out.println("Game coundn't read Pokemon file, please make sure it is in the same directory as the script.");
			return;
		}
	}
}