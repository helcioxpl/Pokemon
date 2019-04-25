public class Player {
	private String name;
	Pokemon[] p = new Pokemon[6];
	
	Player(){
	}
	private class attack extends Event {
		attack(){
			super(0);
		}
		public void action(){
			
		}
		public String description() {
			return "Yay";
		}
	}
	private class changePokemon extends Event {
		changePokemon(){
			super(0);
		}
		public void action(){
			
		}
		public String description() {
			return "Yay";
		}
	}
	private class flee extends Event {
		flee(){
			super(0);
		}
		public void action(){
			
		}
		public String description() {
			return "Yay";
		}
	}
	private class useItem extends Event {
		useItem(){
			super(0);
		}
		public void action(){
			
		}
		public String description() {
			return "Yay";
		}
	}
}
/*
Vocˆes devem agora escrever o c ́odigo que simule uma batalha do jogo
Pok ́emon  Red/Blue/Yellow
, com as
seguintes caracter ́ısticas:
•
Vocˆes ir ̃ao simular uma batalha entre dois jogadores no modo Versus
4
.  Cada jogador pode ter at ́e 6
Pok ́emons
.  Cada
Pok ́emon
tem seu nome e quantidade de HP, al ́em de at ́e 4 ataques diferentes.
•
Cada a ̧c ̃ao do treinador ser ́a um evento; atacar (usando uma habilidade do
Pok ́emon
atual), trocar o
Pok ́emon
ativo, usar um item e fugir da batalha.
•
Para simplificar a modelagem, n ̃ao  ́e necess ́ario implementar status especiais, PPs ou modificadores de
dano.  As habilidades devem apenas causar dano e ter uma prioridade, que deve ser respeitada (se a
prioridade de um ataque for menor que a da outra, ela deve ser executada primeiro).  Itens devem ser
apenas de cura, e n ̃ao precisam ter limite.  Entre os tipos de evento a prioridade  ́e fugir da batalha
>
trocar o
Pok ́emon
ativo
>
usar um item
>
atacar.  O crit ́erio de desempate  ́e o primeiro jogador.
•
A batalha
Pok ́emon
termina quando um dos treinadores n ̃ao tiver mais
Pok ́emons
sobrando ou fugir
da batalha.
Al ́em  da  classe
Events
,  vocˆes  tem  que  desenvolver  classes  que  modelem
Pok ́emons
,  Treinadores  e  etc.
Respeitem a Orienta ̧c ̃ao a Objetos ;).
Cr ́edito extra:
implemente um sistema de fraqueza baseado no tipo do
Pok ́emon
.  Para simplificar, o tipo
do ataque do
Pok ́emon
 ́e baseado no tipo b ́asico do mesmo.  Vocˆe pode usar o
Type chart
do site Bulbapedia
para isso, ou invente seu pr ́oprio*/