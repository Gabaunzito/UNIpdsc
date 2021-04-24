
//Importações
import java.util.Scanner;

public class prova_A1 { // Inicio

//	III - Regras de negócio Específicas (Cada regra deverá ser um subprograma ou método separado):
	public static double G(double valor) {
		valor = (valor + (valor * 0.18));
		return valor;
	}

	public static int A(int anoNascimento) {
		int idade = 2021 - anoNascimento;
		return idade;
	}

	public static double B(double valor) {
		valor = (valor + (valor * 0.30));
		return valor;
	}

	public static int R(int meses) {
		meses = 10;
		return meses;
	}

	public static int E(int meses) {
		meses = 6;
		return meses;
	}

	public static int L(int meses) {
		meses = 6;
		return meses;
	}

	public static void main(String[] args) throws Exception {

		Scanner teclado = new Scanner(System.in);

		boolean ehNovoBeneficiario = true;
		int totUsers = 0;
		int totBeneficiarios = 0;
		double totBeneficioConcedido = 0;
		double num1 = 0, num2 = 0, temp1 = 0, temp2 = 0;
		String maiorBeneficiario = "Usuarios insuficientes", segundoMaiorBeneficiario = "Usuarios insuficientes";
		String maisTempoBeneficiario = "Usuarios insuficientes", segundoMaisTempoBeneficiario = "Usuarios insuficientes";

		do {
			boolean useG = false;
			boolean useA = false;
			boolean useB = false;
			boolean useR = false;
			boolean useE = false;
			boolean useL = false;

			int mesesBeneficio = 2;

//			I - Dados de Entrada do programa:
//
//				Nome Completo;
//				Data de Nascimento;
//				Categoria (Empregado, Empregador ou Desempregado)
//				Empregado
//				Solicitar se é aposentado
//				Empregador
//				Solicitar quantos funcionários
//				Desempregado
//				Há quantos meses está desempregado
//				Estado (UF)
//				+Valor beneficio

			// Nome do beneficiario
			System.out.println("Informe seu nome completo: ");
			String nome = teclado.nextLine();

			// Estado
			System.out.println("Estado: ");
			String uf = teclado.nextLine();

			// Ano de nascimento
			System.out.println("Digite seu ano de nascimento:");
			int nascimento = Integer.parseInt(teclado.nextLine());
			int idade = A(nascimento);

			// Verificar idade invalidos do beneficio (Regra de negocio especifica - A)
			while (idade < 18) {
				System.out.println("Valor invalido, você deve ter pelo menos 18 anos para receber o beneficio");
				System.out.println("Digite um valor valido para o beneficio: ");
				nascimento = Integer.parseInt(teclado.nextLine());
				idade = A(nascimento);
				useA = true;
			}

			totBeneficiarios++;

			// Categoria
			System.out.println("Você é Empregador, Empregado ou Desempregado: ");
			String categoria = teclado.nextLine();

			// Valor do beneficio
			System.out.println("Digite o valor do seu beneficio: ");
			double valorBeneficio = Double.parseDouble(teclado.nextLine());

			// Verifica a categoria e executa as regras G, B, R, E e L

			// Empregado (B e E)
			if (categoria.equals("Empregado")) {
				// II - Regras de negócio Gerais 1 (Empregados receberão entre R$ 1.000 e R$
				// 1.800)
				// Verificar valores invalidos do beneficio (empregado)
				while (valorBeneficio < 1000 || valorBeneficio > 1800) {
					System.out.println("Valor invalido, Empregado devem receber entre R$ 1.000  e R$ 1.800!");
					System.out.println("Digite um valor valido para o beneficio: ");
					valorBeneficio = Double.parseDouble(teclado.nextLine());
				}

				System.out.println("Você é aposentado(a) (S ou N): ");
				String aposentado = teclado.nextLine();

				if (aposentado.equals("S")) {
					valorBeneficio = B(valorBeneficio); // B
					useB = true;
					mesesBeneficio = E(mesesBeneficio); // E
					useE = true;
				} 

				// Empregador (G e R)
			} else if (categoria.equals("Empregador")) {

				System.out.println("Digite quantos funcionarios você tem:");
				int numFuncionarios = Integer.parseInt(teclado.nextLine());
				// II - Regras de negócio Gerais 2 (Empregadores receberão R$ 200,00 por
				// funcionário)
				valorBeneficio = numFuncionarios * 200;

				if (numFuncionarios <= 10) {
					valorBeneficio = G(valorBeneficio); // G
					useG = true;
					mesesBeneficio = R(mesesBeneficio); // R
					useR = true;
				}

				// Desempregado (L)
			} else if (categoria.equals("Desempregado")) {
				// II - Regras de negócio Gerais 3 (Desempregados receberão entre R$ 1.500 e R$
				// 2.300)
				// Verificar valores invalidos do beneficio (desempregado)
				while (valorBeneficio < 1500 || valorBeneficio > 2300) {
					System.out.println("Valor invalido, Desempregados  devem receber entre R$ 1.500  e R$ 2.300!");
					System.out.println("Digite um valor valido para o beneficio: ");
					valorBeneficio = Double.parseDouble(teclado.nextLine());
				}

				mesesBeneficio = L(mesesBeneficio); // L
				useL = true;

				System.out.println("Há quantos meses você esta desempregado:");
				int mesesDesempregado = Integer.parseInt(teclado.nextLine());
			}

//		IV - Ao final de cada execução deverá ser impresso os seguintes dados:
//			 Nome Completo, Data de Nascimento, Categoria, Quais regras foram atendidas (Ex: Usuário é maior de idade, usuário é aposentado então terá um acréscimo de X), por quanto tempo o usuário receberá o benefício e valor do benefício.

			// Saida dos dados
			System.out.println("Nome: " + nome);
			System.out.println("Ano nascimento: " + nascimento);
			System.out.println("Categoria: " + categoria);
			System.out.println("As seguintes regras foram ultilizadas: ");
			if (useG == true) {
				System.out.println(
						"Regra G: Para empregadores que tenham até 10 funcionários haverá um acréscimo de 18% sobre o valor total.");
			}
			if (useA == true) {
				System.out.println("Regra A: O benefício só será concedido para maiores de 18 anos.");
			}
			if (useB == true) {
				System.out.println("Regra B: Para aposentados o valor do benefício terá um acréscimo de 30%.");
			}
			if (useR == true) {
				System.out.println("Regra R: O Benefício será de 10 meses para empregadores com até 10 funcionários.");
			}
			if (useE == true) {
				System.out.println("Regra E: O benefício será de 6 meses para aposentados.");
			}
			if (useL == true) {
				System.out.println("Regra L: O benefício será de 6 meses para desempregados");
			}
			System.out.println("Tempo em meses do beneficio: " + mesesBeneficio); // II - Regras de negócio Gerais 4 (O benefício será de no máximo 12  meses e mínimo 2 meses;) - Todas as categorias recebem uma quantidade de mêses pelas Regras de negócio Específicas (R, E e L).
			System.out.println("Valor do beneficio: " + valorBeneficio);

			totUsers++;
			totBeneficioConcedido = totBeneficioConcedido + valorBeneficio;

			// Compara os valores e armazena os nomes dos 2 Beneficiados que receberão mais dinheiro.
			// O que recebera mais			
			if ((valorBeneficio > num1 && valorBeneficio > num2)) {
				num1 = valorBeneficio;
				maiorBeneficiario = nome;
			}

			// O segundo que recebera mais			
			if ((valorBeneficio < num1 && valorBeneficio > num2)) {
				num2 = valorBeneficio;
				segundoMaiorBeneficiario = nome;
			}

			// Compara os valores e armazena os nomes dos 2 Beneficiados que receberão por mais meses.
			// O com mais meses
			if ((mesesBeneficio > temp1 && mesesBeneficio > temp2)) {
				temp1 = mesesBeneficio;
				maisTempoBeneficiario = nome;
			}
			
			// O segundo com mais meses
			if ((mesesBeneficio < temp1 && mesesBeneficio > temp2)) {
				temp2 = mesesBeneficio;
				segundoMaisTempoBeneficiario = nome;
			}

			// II - Regras de negócio Gerais 5 (Ao final de cada execução o programa deverá
			// perguntar se o usuário deseja informar um novo beneficiário ou não)
			System.out.println("Você deseja informar um novo(a) beneficiário(a) (S ou N): ");
			String novoBeneficiario = teclado.nextLine();

			if (novoBeneficiario.equals("N")) {
				ehNovoBeneficiario = false;
			}

			teclado.reset();
		} while (ehNovoBeneficiario);

//		V - Ao final da execução do programa (Regra de negócio geral 5):
//
//			Total de usuários lidos;
//			Total de beneficiários;
//			Total de valor que será concedido;
//			O nome dos 2 beneficiários que irão receber os maiores valor de todos;
//			O nome dos 2 beneficiários que irão receber os benefícios por mais tempo.

		System.out.println("Total de usuarios lidos: " + totUsers);
		System.out.println("Total de beneficiarios: " + totBeneficiarios);
		System.out.println("Valor total concedido: " + totBeneficioConcedido);
		System.out.println("Nomes dos 2 beneficiários que receberão os maiores valores: " + "\r\n" + "Primeiro: "
				+ maiorBeneficiario + "\r\n" + "Segundo: " + segundoMaiorBeneficiario);
		System.out.println("Nomes dos 2 beneficiários que receberão o benefício por mais tempo: " + "\r\n"
				+ "Primeiro: " + maisTempoBeneficiario + "\r\n" + "Segundo: " + segundoMaisTempoBeneficiario);

	}
} // FIM
