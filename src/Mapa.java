import java.util.Random;

public class Mapa extends Player {
	int x;
	int y;
	int[][] mapa;// 0 representa gramado e 1 concreto
	public Mapa(int x, int y, int[][] concretoGramado) {
		super("Pokemon selvagem");
		mapa = concretoGramado;
		this.x = x;
		this.y = y;
		Random gerador = new Random();
		posicaoX = gerador.nextInt(x);
		posicaoY = gerador.nextInt(y);
	}

}
