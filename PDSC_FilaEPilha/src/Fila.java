import java.util.Scanner;

public class Fila {

//	Exercícios com Vetores (Fila e Pilha)
//	1) Um posto de saúde está organizando os atendimentos e precisa de um sistema para gerenciar os seus
//	pacientes. Os pacientes serão atendidos obrigatoriamente pela ordem de chegada. Você deverá criar um
//	sistema onde será possível inserir os dados do paciente e organizar os atendimento, de acordo com as
//	seguintes regras:

//	● O programa deverá armazenar o nome, idade e descrição breve do atendimento para o usuário
//	● Deverá ser apresentado um menu a cada iteração:
//	○ 1 - Incluir Paciente, 2 - Atender Paciente, 3 - Sair
//	● O programa poderá armazenar até 20 pacientes
//	● Deverá haver uma opção para o usuário solicitar qual será o paciente atendido
//	○ Quando essa opção for selecionada então o paciente deverá ser removido da fila de
//	atendimento
//	○ A fila deverá ser reorganizada

	public static void main(String[] args) {
		String[][] pacientes = new String[20][3];
		String nome, idade, descricao;
		int indice;

		Scanner teclado = new Scanner(System.in);

		int opcao = 0;
		while (opcao != 4) {
			System.out.println("Incluir Paciente: 1 | Atender Paciente: 2 | Mostrar fila: 3 | Sair: 4");
			opcao = Integer.parseInt(teclado.nextLine());
			if (opcao == 1) {

				System.out.println("Nome: ");
				nome = teclado.nextLine();

				System.out.println("Idade: ");
				idade = teclado.nextLine();

				System.out.println("Descrição breve: ");
				descricao = teclado.nextLine();

				pacientes = adicionarPaciente(pacientes, nome, idade, descricao);

			} else if (opcao == 2) {

				System.out.println("Qual será o paciente atendido? ");
				indice = Integer.parseInt(teclado.nextLine()) - 1;

				pacientes = removerPaciente(pacientes, indice);

			} else if (opcao == 3) {

				mostrarFila(pacientes);

			} else if (opcao < 1 || opcao > 4) {

				System.out.println("Opção inválida");

			}
		}
	}

	public static String[][] adicionarPaciente(String[][] pacientes, String nome, String idade, String descricao) {
		for (int i = 0; i < pacientes.length; i++) {
			
			if (pacientes[i][0] == null) {
				
				pacientes[i][0] = nome;
				pacientes[i][1] = idade;
				pacientes[i][2] = descricao;
				return pacientes;
			}
		}
		System.out.println("Número máximo de pesssoas na fila");
		return pacientes;
	}

	public static String[][] removerPaciente(String[][] pacientes, int indice) {
		
		String[][] pacientesAtualizados = new String[pacientes.length][3];
		int cont = 0;
		
		if (indice > pacientes.length || indice < 0) {
			
			System.out.println("Paciente não encontrado");
			return pacientes;
			
		}
		
		for (int i = 0; i < pacientes.length; i++) {
			
			if (i == indice) {
				
				cont++;
				continue;
				
			}
			
			pacientesAtualizados[i - cont] = pacientes[i];
		}
		
		System.out.println("O paciente " + (indice + 1) + " foi atendido");
		return pacientesAtualizados;
		
	}

	public static void mostrarFila(String[][] pacientes) {
		
		for (int i = 0; i < pacientes.length; i++) {
			
			if (pacientes[i][0] == null) {
				
				continue;
				
			}
			
			System.out.println("Posicçao na fila: " + (i + 1) + "º | Nome do pasciente: " + pacientes[i][0] + " | Idade: " + pacientes[i][1]);
			
		}
	}
}
