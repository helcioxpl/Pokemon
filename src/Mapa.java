import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Mapa extends Player {
	private int x;
	private int y;
	static char[][] mapa;// . quando gramado, ' ' quando concreto e P a posicao do player
	private int pos = new int[2];
	public Mapa(int x, int y, char[][] concretoGramado) {
		super("Pokemon selvagem");
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
		pos[mov % 2] += (mov>1)?1:-1;
		String dir[] = ["norte","oeste","sul","leste"]
		System.out.println("\nO player se moveu na direcao "+dir[mov]);
	}
	private boolean possibleMovement(int mov) {
		if (mov < 2) return pos[mov % 2] > 0;
		else return pos[mov % 2] < (mov % 2)?y:x;
	}
	private boolean achouPokemonSelvagem() {
		return (2 == decide(3))
	}
	public static void main (String[] args) {
		Random gerador = new Random();
		char movement;
		boolean batalhaJaOcorreu = false;

		Player[] Ps = { new Player("A"),new Player("Pokemon Selvagem") };
		int[] dim = { gerador.nextInt(7)+5 , gerador.nextInt(5)+15 };
		char[][] teste = new char[dim[0]][dim[1]];

		int i,j;
		for(i = 0; i < dim[0]; i++) {
			for(j = 0; j < dim[1]; j++) {
				teste[i][j] = (gerador.nextBoolean())?' ':'.';
			}
		}

		Mapa mapa = new Mapa(dim[0], dim[1], teste);
		mapa.pos = [gerador.nextInt(mapa.x),gerador.nextInt(mapa.y)];
		mapa.imprimirMapa();
		while(!batalhaJaOcorreu) {
			if(mapa.AndandoNaGrama()) {
				if(mapa.achouPokemonSelvagem()) {
					System.out.println("Achou pokemon");
					Battle batalha = new Battle(Ps);
					//batalha.action();
					return;
				}
			}
			else {
				mov = this.decide(4)
				while(!mapa.possibleMovement(mov)) {
					System.out.println("Movimento inválido");
					mov = this.decide(4) // w = cima, s = abaixo, a = esquerda e d =direita q = quit
				}

				mapa.playerMoves(mov);
				mapa.imprimirMapa();
			}
		}
	}
}
