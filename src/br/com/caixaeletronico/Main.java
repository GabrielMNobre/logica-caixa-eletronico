package br.com.caixaeletronico;

import java.util.Scanner;

public class Main {

	public static void main(String args[]) {
		
		// Criacao da instancia
		CaixaEletronico caixaEletronico = new CaixaEletronico();

		// leitor do cartao
		Scanner sc = new Scanner(System.in);

		String numeroDoCartao;
		try {
			System.out.println("Entre com o número do cartão: ");
			numeroDoCartao = sc.nextLine();
			caixaEletronico.setNumeroDoCartao(Integer.parseInt(numeroDoCartao));

			System.out.println("\nO numero do cartão é: " + caixaEletronico.getNumeroDoCartao());
		} catch (Exception e) {
			System.out.println("\nTransação encerrada.");
			System.exit(0);
		}
		// leitor da senha
		int senhaDoCartao;

		for (int i = 0; i < 3; i++) {
			System.out.println("Entre com a senha do cartão: ");

			try {
				senhaDoCartao = sc.nextInt();
				String validacaoSenha = caixaEletronico.setSenhaDoCartao(Integer.toString(senhaDoCartao));
				if (i == 3) {
					System.exit(0);
				} else {
					if (validacaoSenha.equals("Senha válida")) {
						System.out.println("EXECUTA O PROXIMO METODO\n");
						caixaEletronico.menuCaixa(1);
						break;
					}
				}

			} catch (Exception e) {
				System.out.println("Digite somente números, \n Operação ");
				System.exit(0);
			}

		}
		try {
			int operacaoEscolhida;
			System.out.println("Menu de opções: \n 1- Saldo \n 2- Extrato \n 3- Depósito \n 4- Saque \n 5- Sair");

			System.out.println("Entre com a operação que deseja fazer");
			operacaoEscolhida = sc.nextInt();

			caixaEletronico.menuCaixa(operacaoEscolhida);
		} catch (Exception e) {
			caixaEletronico.menuCaixa(5);

		}
		sc.close();
	}
	
}
