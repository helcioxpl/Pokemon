import java.io.IOException;
import java.util.Random;
import java.lang.String;
import java.util.Scanner;

public class Mapa extends Player {
	private int x;
	private int y;

	static char[][] mapa;// . quando gramado, ' ' quando concreto e P a posicao do player
	private int[] pos = new int[2];

	public Mapa(int x, int y, char[][] concretoGramado) {
		this(x,y,concretoGramado,"Aleatório");
	}
	public Mapa(int x, int y, char[][] concretoGramado, String nome) {
		super("Mapa "+nome);
		mapa = concretoGramado;
		this.x = x;
		this.y = y;
	}

	public void imprimirMapa() {
		int j = 0;
		for(int i = 0;i < x;i++) {
			for (j = 0;j < y;j++)
				System.out.print("--");
			System.out.println("");
			for(j = 0;j < y;j++)
				System.out.print((pos[0] == i && pos[1] == j)?"|P":("|"+mapa[i][j]));
			System.out.println("|");
		}
		for (j = 0;j < y;j++)
			System.out.print("- ");
	}

	private boolean AndandoNaGrama() {
		return (mapa[pos[0]][pos[1]] == '.');
	}

	private void playerMoves(int mov) { 
		pos[mov % 2] += (mov > 1)?1:-1;
		String dir[] = {"norte","oeste","sul","leste"};
		System.out.println("\nO player se moveu na direcao "+dir[mov]);
	}

	private boolean possibleMovement(int mov) {
		if (mov < 2) return (pos[mov % 2] > 0);
		else return (pos[mov % 2] < ((mov % 2 == 1)?y:x));
	}

	public static void main (String[] args) {
		int[] dim = { r.nextInt(7)+5 , r.nextInt(5)+15 };
		char[][] teste = new char[dim[0]][dim[1]];

		for(int i = 0; i < dim[0]; i++)
			for(int j = 0; j < dim[1]; j++) 
				teste[i][j] = (r.nextBoolean())?' ':'.';

		Mapa mapa = new Mapa(dim[0], dim[1], teste);
		Player[] Ps = { mapa, new Player("A") };
		Pokemon.populate(Ps);

		mapa.pos[0] = r.nextInt(mapa.x);
		mapa.pos[1] = r.nextInt(mapa.y);
		mapa.imprimirMapa();

		int mov;
		while (true){
			if(mapa.AndandoNaGrama()) {
				if(mapa.decide(3) == 2){
					System.out.println("Achou pokemon");
					Battle batalha = new Battle(Ps);
					try{ batalha.happen(); }
					catch (Event e){ return; }
					return;
				}
			}
			else {
				mov = Ps[1].decide(4);
				while(!mapa.possibleMovement(mov)) {
					System.out.println("Movimento inválido");
					mov = Ps[1].decide(4); // w = cima, s = abaixo, a = esquerda e d =direita q = quit
				}

				mapa.playerMoves(mov);
				mapa.imprimirMapa();
			}
		}
	}
}
