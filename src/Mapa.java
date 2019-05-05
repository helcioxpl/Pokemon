import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Mapa extends Player {
	private int x;
	private int y;
	static char[][] mapa;// . quando gramado, ' ' quando concreto e P a posicao do player
	private int posicaoXPlayer;
	private int posicaoYPlayer;
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
				System.out.print((posicaoXPlayer == i && posicaoYPlayer == j)?"|P":("|"+mapa[i][j]));
			System.out.println("|");
		}
		for (j = 0;j < y;j++)
			System.out.print("- ");
	}
	private boolean AndandoNaGrama() {
		if(mapa[posicaoXPlayer][posicaoYPlayer] == '.') {
			return true;
		}
		return false;
	}
	private static char movimentoAleatorio() {
		int i = decide(4);
		switch(i) {
			case 0: return 'w';
			case 1: return 's';
			case 2: return 'a';
			case 3: return 'd';
		}
		return'q';
	}
	private void playerMoves(char direcao) {// w = cima, s = abaixo, a = esquerda e d =direita
		switch(direcao) {
			case 'w': 
				posicaoYPlayer--;
				break;
			case 's': 
				posicaoYPlayer++;
				break;
			case 'a': 
				posicaoXPlayer--;
				break;
			case 'd': 
				posicaoXPlayer++;
				break;
		}
	}
	private boolean possibleMovement(char movement) {
		
		if(movement == 'w') {
			if(posicaoXPlayer == x - 1) {
				return false;
			}
			else {
				return true;
			}
		}
		if(movement == 's') {
			if(posicaoXPlayer == 0) {
				return false;
			}
			else {
				return true;
			}
		}
		if(movement == 'a') {
			if(posicaoYPlayer == 0) {
				return false;
			}
			else {
				return true;
			}
		}
		if(movement == 'd') {
			if(posicaoYPlayer == y - 1) {
				return false;
			}
			else {
				return true;
			}
		}
		return false;
	}
	private boolean achouPokemonSelvagem() {
		if(2 < decide(5)) {
			return true;
		}
		return false;
	}
	public static void main (String[] args) {
		Random gerador = new Random();
		char movement;
		boolean batalhaJaOcorreu = false;
		Player[] Ps = {new Player("A"),new Player("Pokemon Selvagem")};
		int[] dim = {gerador.nextInt(7)+5,gerador.nextInt(5)+15};
		char[][] teste = new char[dim[0]][dim[1]];
		int i,j;
		for(i = 0; i < dim[0]; i++) {
			for(j = 0; j < dim[1]; j++) {
				teste[i][j] = (gerador.nextBoolean())?' ':'.';
			}
		}
		Mapa mapaTeste = new Mapa(dim[0], dim[1], teste);
		mapaTeste.posicaoXPlayer = gerador.nextInt(mapaTeste.x);
		mapaTeste.posicaoYPlayer = gerador.nextInt(mapaTeste.y);
		mapaTeste.imprimirMapa();
		while(batalhaJaOcorreu) {
			if(mapaTeste.AndandoNaGrama()) {
				if(mapaTeste.achouPokemonSelvagem()) {
					Battle batalha = new Battle(Ps);
					//batalha.action();
					return;
				}
			}
			else {
				movement = movimentoAleatorio();
				if(mapaTeste.possibleMovement(movement)) {
					mapaTeste.playerMoves(movement);
				}
				else {
					while(!mapaTeste.possibleMovement(movement)) {
						System.out.println("Movimento invalido");
						movement = movimentoAleatorio();
				
					}
				}
				
			}
			
		}
		
		
	}

}
