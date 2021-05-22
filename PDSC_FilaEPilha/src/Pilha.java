import java.util.Scanner;

public class Pilha {

//	2) Faça um programa para controlar uma pilha de caixas. Cada caixa tem um identificador (CX1, CX2, CX3), As
//	medidas da altura, largura, profundidade e um atributo que diga se o conteúdo é fragil. O sistema permitirá o
//	empilhamento máximo de 10 caixas. Será possível empilhar e desempilhar caixas.

	public static String[][] pilha = new String[10][4];
	public static int indexPilha = -1;

	public static void main(String[] args) {

		String caixa[] = new String[4];
		Scanner teclado = new Scanner(System.in);
		int opcao = 0;
		
		while (opcao != 4) {
			
			System.out.println("Empilhar caixa: 1 | Desempilhar caixa: 2 | Mostrar pilha: 3 | Sair: 4");
			opcao = Integer.parseInt(teclado.nextLine());
			
			if (opcao == 1) {
				
				System.out.println("Altura (cm): ");
				caixa[0] = teclado.nextLine();
				
				System.out.println("Largura (cm): ");
				caixa[1] = teclado.nextLine();
				
				System.out.println("Profundidade (cm): ");
				caixa[2] = teclado.nextLine();
				
				System.out.println("Fragil (cm): ");
				caixa[3] = teclado.nextLine();
				
				empilharCaixa(caixa);
				
			} else if (opcao == 2) {
				
				pilha = desempilharCaixa();
				System.out.println("Caixa removida");
				
			} else if (opcao == 3) {
				
				mostrarPilha(pilha);
				
			} else if (opcao < 1 || opcao > 4) {
				
				System.out.println("Opção inválida");
				
			}
		}
	}

	public static boolean pilhaVazia() {
		
		if (indexPilha == -1) {
			return true;
		}
		
		return false;
	}

	public static void empilharCaixa(String[] caixa) {
		
		if (indexPilha < pilha.length - 1) {
			
			pilha[++indexPilha][0] = caixa[0];
			pilha[indexPilha][1] = caixa[1];
			pilha[indexPilha][2] = caixa[2];
			pilha[indexPilha][3] = caixa[3];
			
		} else {
			
			System.out.println("Número maximo de caixas empilhadas");
			
		}
	}

	public static String[][] desempilharCaixa() {
		
		String[][] novaPilha = new String[pilha.length][4];
		
		if (pilhaVazia()) {
			
			System.out.println("Nenhuma caixa para desempilhar");
			return null;
			
		}
		for (int i = 0; i < pilha.length; i++) {
			
			if (i == indexPilha) {
				break;
				
			}
			
			novaPilha[i] = pilha[i];
			
		}
		
		indexPilha--;
		return novaPilha;
	}

	public static void mostrarPilha(String[][] pilha) {
		
		for (int i = 0; i < pilha.length; i++) {
			
			if (pilhaVazia()) {
				
				System.out.println("Pilha vazia");
				break;
				
			} else if (pilha[i][0] == null) {
				break;
				
			}
			
			System.out.println("Caixa " + (i + 1) + ": Altura: " + pilha[i][0] + "cm; Largura: " + pilha[i][1]
					+ "cm; Profundidade: " + pilha[i][2] + "cm | Fragil: " + pilha[i][3]);
			
		}
	}
}