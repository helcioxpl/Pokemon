import java.util.Random;

public class Mapa extends Player {
	private int x;
	private int y;
	static char[][] mapa;// . quando gramado, ' ' quando concreto e P a posicao do player
	public Mapa(int x, int y, char[][] concretoGramado) {
		super("Pokemon selvagem");
		mapa = concretoGramado;
		this.x = x;
		this.y = y;
	}
	public void imprimirMapa(int posicaoX, int posicaoY) {
		int j = 0;
		for(int i = 0;i < x;i++) {
			for (j = 0;j < y;j++)
				System.out.print("--");
			System.out.println("");
			for(j = 0;j < y;j++)
				System.out.print((posicaoX == i && posicaoY == j)?"|P":("|"+mapa[i][j]));
			System.out.println("|");
		}
		for (j = 0;j < y;j++)
			System.out.print("- ");
	}
	private void playerMoves(char direcao) {// w = cima, s = abaixo, a = esquerda e d =direita
		switch(direção) {
			case 'w': posicaoYPlayer--;
			case 's': posicaoYPlayer++;
			case 'a': posicaoXPlayer--;
			case 'd': posicaoXPlayer++;
		}
	}
	public static void main (String[] args) {
		Random gerador = new Random();
		int[] dim = {gerador.nextInt(7)+5,gerador.nextInt(5)+15};
		char[][] teste = new char[dim[0]][dim[1]];
		int i,j;
		for(i = 0; i < dim[0]; i++) {
			for(j = 0; j < dim[1]; j++) {
				teste[i][j] = (gerador.nextBoolean())?' ':'.';
			}
		}
		Mapa mapaTeste = new Mapa(dim[0], dim[1], teste);
		int posicaoXPlayer = gerador.nextInt(mapaTeste.x);
		int posicaoYPlayer = gerador.nextInt(mapaTeste.y);
		mapaTeste.imprimirMapa(posicaoXPlayer, posicaoYPlayer);
		
	}

}
