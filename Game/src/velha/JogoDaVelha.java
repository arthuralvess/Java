package velha;

import java.util.Scanner;

public class JogoDaVelha {
	public static void main(String[] args) {
		Campo[][] velha=new Campo[3][3];
		Boolean game=true;
		char simboloAtual='X';
		char vitoria =' ';
		Scanner scan=new Scanner(System.in);
		
		iniciarJogo(velha);

		while(game) {
			desenhaJogo(velha);
			vitoria=verificaVitoria(velha);
			if(vitoria!= ' ') {
				
				System.out.printf("Jogador %s venceu%n", vitoria);
				break;
			}
			try {
				if(verificarJogada(velha, jogar(scan, simboloAtual),simboloAtual)) {
					if(simboloAtual == 'X') {
						simboloAtual = 'O';
					}else {
						simboloAtual = 'X';
					}
				}


		}catch(Exception e) {
			
			System.out.printf("Error");
			}
			
		}
		System.out.printf("Fim do jogo");
	}
	
	public static void desenhaJogo(Campo[][] velha) {
		limparTela();
		System.out.println("   0   1   2"); 
		System.out.printf("0   %c| %c |%c %n", velha[0][0].getSimbolo(), velha[0][1].getSimbolo(), velha[0][2].getSimbolo());
		System.out.println("   ---------");
		System.out.printf("1   %c| %c |%c %n", velha[1][0].getSimbolo(), velha[1][1].getSimbolo(), velha[1][2].getSimbolo());
		System.out.println("   ---------");
		System.out.printf("2   %c| %c |%c %n", velha[2][0].getSimbolo(), velha[2][1].getSimbolo(), velha[2][2].getSimbolo());
		
	}
	
	public static void limparTela() {
		for(int count=0;count<200;count++) {
			System.out.println("");	
		}
	}
	
	public static void iniciarJogo(Campo [][] velha) {
		for(int i=0;i<3;i++) {
			for(int c=0;c<3;c++)
			   velha[i][c]=new Campo();
			
		}
		
	}
	
	public static Boolean verificarJogada(Campo[][] velha, int p[], char simboloAtual) {
		if(velha[p[0]][p[1]].getSimbolo()== ' ') {
			velha[p[0]][p[1]].setSimbolo(simboloAtual);
			return true;
		}else {
			return false;
		}
		
		
	}
	
	public static int[] jogar(Scanner scan, char sa) {
		int p[]=new int[2];
		System.out.printf("%s %c%n", "Quem joga: ", sa);
		System.out.print("Informe a linha: ");
		p[0]=scan.nextInt();
		System.out.print("Informa a coluna: ");
		p[1]=scan.nextInt();
		return p;
		
	}
	
	
	public static char verificaVitoria(Campo[][] velha) {
		if(velha[0][0].getSimbolo()== velha[1][0].getSimbolo() && velha[1][0].getSimbolo() == velha[2][0].getSimbolo()) {
			return velha[2][0].getSimbolo();
		}else if (velha[0][1].getSimbolo()== velha[1][1].getSimbolo() && velha[1][1].getSimbolo()== velha[2][1].getSimbolo()) {
			return velha[1][1].getSimbolo();
		}else if(velha[0][2].getSimbolo()== velha[1][2].getSimbolo() && velha[1][2].getSimbolo()== velha[2][2].getSimbolo()) {
			return velha[2][2].getSimbolo();
		}else if(velha[0][0].getSimbolo()== velha[0][1].getSimbolo() && velha[0][1].getSimbolo()== velha[0][2].getSimbolo()) {
			return velha[0][0].getSimbolo();
		}else if(velha[1][0].getSimbolo()== velha[1][1].getSimbolo() && velha[1][1].getSimbolo()== velha[1][2].getSimbolo()) {
			return velha[1][2].getSimbolo();
		}else if(velha[2][0].getSimbolo()== velha[2][1].getSimbolo() && velha[2][1].getSimbolo()== velha[2][2].getSimbolo()) {
			return velha[2][2].getSimbolo();
		}else if(velha[0][0].getSimbolo()== velha[1][1].getSimbolo() && velha[1][1].getSimbolo()== velha[2][2].getSimbolo()) {
			return velha[2][2].getSimbolo();
		}else if(velha[2][2].getSimbolo()== velha[1][1].getSimbolo() && velha[1][1].getSimbolo()== velha[2][0].getSimbolo()) {
			return velha[2][0].getSimbolo();
		}
		
		Campo a = new Campo();
		a.setSimbolo('X');
		
		Campo b = new Campo();
		b.setSimbolo('X');
		
		
		
		
		return ' ';
	}
}







