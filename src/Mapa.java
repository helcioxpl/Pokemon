import java.util.Random;

public class Mapa extends Player {
	private int x;
	private int y;
	static char[][] mapa;// G quando gramado, C quando concreto e P a posicao do player
	public Mapa(int x, int y, char[][] concretoGramado) {
		super("Pokemon selvagem");
		mapa = concretoGramado;
		this.x = x;
		this.y = y;
	}
	public void imprimirMapa(int posicaoX, int posicaoY) {
		int i = 0;
		int j = 0;
		while (i < x) {
			while (j < y) {
				System.out.print("- ");
				j++;
			}
			System.out.println("");
			j = 0;
			while (j < y) {
				if(posicaoX == i && posicaoY == j) {
					System.out.print("|P");
					j++;
				}
				else {
					System.out.print("|"+mapa[i][j] );
					j++;
				}
			}
			System.out.println("|");
			j = 0;
			i++;
		}
		while (j < y) {
			System.out.print("- ");
			j++;
		}
		
	}
	public static void main (String[] args) {
		Random gerador = new Random();
		char[][] teste = new char[10][11];
		int i,j;
		for(i = 0; i < 10; i++) {
			for(j = 0; j < 11; j++) {
				teste[i][j] = 'C';
			}
		}
		Mapa mapaTeste = new Mapa(10, 11, teste);
		int posicaoXPlayer = gerador.nextInt(mapaTeste.x);
		int posicaoYPlayer = gerador.nextInt(mapaTeste.y);
		mapaTeste.imprimirMapa(posicaoXPlayer, posicaoYPlayer);
		
	}

}
