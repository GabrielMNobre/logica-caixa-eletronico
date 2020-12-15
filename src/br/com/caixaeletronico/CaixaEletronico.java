package br.com.caixaeletronico;

import java.util.ArrayList;
import java.util.Scanner;

public class CaixaEletronico {

	private String numeroDoCartao;
	private int senhaDoCartao;
	private float saldo;
	ArrayList<String> extrato = new ArrayList<String>();

	public int getNumeroDoCartao() {
		return Integer.parseInt(numeroDoCartao);
	}

	public void setNumeroDoCartao(int numeroDoCartao) {
		String aux = Integer.toString(numeroDoCartao);
		if (aux.length() == 10) {
			this.numeroDoCartao = aux;
		} else {
			System.out.println("O número do cartão precisa ter 10 digitos \ne você inseriu apenas : " + aux.length());
		}

	}

	public int getSenhaDoCartao() {
		return senhaDoCartao;
	}

	public String setSenhaDoCartao(String senhaDoCartao) {
		String str = "";
		if (senhaDoCartao.length() == 6) {
			this.senhaDoCartao = Integer.parseInt(senhaDoCartao);
			str = validarSenha(getSenhaDoCartao());
		} else {
			System.out.println("Após três tentativas encerraremos o programa.");
		}

		return str;
	}

	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}

	public void sacar(int valorSacado) {

		if (valorSacado > getSaldo()) {
			extrato.add("O valor não pode ser sacado, \nvalor em conta: " + getSaldo());
		} else {
			extrato.add("Valor sacado: " + valorSacado);
			float aux2;
			aux2 = getSaldo() - valorSacado;
			setSaldo(aux2);
		}
	}

	public void depositar(float valorDepositado) {
		extrato.add("Valor depositado: " + valorDepositado);
		float aux;
		aux = getSaldo() + valorDepositado;
		setSaldo(aux);
	}

	public void extrato(String registroDoMovimento) {
		extrato.add(registroDoMovimento);
	}

	public void imprimirExtrato() {
		System.out.println("################## EXTRATO DOS MOVIMENTOS #######################");
		for (int i = 0; i < extrato.size(); i++) {
			System.out.println("Movimentação => " + extrato.get(i));
		}
	}

	public void consultarSaldo() {
		System.out.println("Seu saldo atual é: R$ " + getSaldo());
		extrato.add("Seu saldo atual é: R$ " + getSaldo());
	}

	public void lerCartao(int numeroDoCartao, int senhaDoCartao) {
		this.setNumeroDoCartao(numeroDoCartao);
		this.setSenhaDoCartao(Integer.toString(senhaDoCartao));

		// extrato.add("Numero do cartao é: "+ getNumeroDoCartao()+" e a senha é: "
		// +getSenhaDoCartao());

		String retorno = validarSenha(getSenhaDoCartao());
		System.out.println(retorno);
	}

	public String validarSenha(int senhaDigitada) {
		int senhaCorreta = 123456;
		String mensagem = "Senha Inválida";

		if (senhaCorreta == senhaDigitada) {
			mensagem = "Senha válida";
		} else {
			System.exit(0);
		}

		return mensagem;
	}

	public void menuCaixa(int operacaoEscolhida) {
		System.out.println(operacaoEscolhida);

		Scanner sc = new Scanner(System.in);
		int opcao;

		try {
			switch (operacaoEscolhida) {
			case 1:
				System.out.println("############### SALDO ATUAL ############### ");
				consultarSaldo();

				System.out
						.println("\n\nMenu de opções: \n 1- Saldo \n 2- Extrato \n 3- Depósito \n 4- Saque \n 5- Sair");
				opcao = sc.nextInt();

				if (opcao >= 1 && opcao < 6) {
					menuCaixa(opcao);
				} else {
					menuCaixa(5);
				}

				break;
			case 2:
				imprimirExtrato();
				System.out
						.println("\n\nMenu de opções: \n 1- Saldo \n 2- Extrato \n 3- Depósito \n 4- Saque \n 5- Sair");
				System.out.println("Entre com a operação que deseja fazer");
				opcao = sc.nextInt();

				if (opcao >= 1 && opcao < 6) {
					menuCaixa(opcao);
				} else {
					menuCaixa(5);
				}

				break;
			case 3:
				float operacaoDeposito;

				System.out.println("Insira o valor do depósito: ");
				operacaoDeposito = sc.nextInt();

				depositar(operacaoDeposito);

				System.out
						.println("\n\nMenu de opções: \n 1- Saldo \n 2- Extrato \n 3- Depósito \n 4- Saque \n 5- Sair");
				opcao = sc.nextInt();

				if (opcao >= 1 && opcao < 6) {
					menuCaixa(opcao);
				} else {
					menuCaixa(5);
				}

				break;
			case 4:

				int operacaoSaque = 0;

				System.out.println("Insira o valor do saque: ");
				operacaoSaque = sc.nextInt();

				sacar(operacaoSaque);

				System.out
						.println("\n\nMenu de opções: \n 1- Saldo \n 2- Extrato \n 3- Depósito \n 4- Saque \n 5- Sair");
				System.out.println("Entre com a operação que deseja fazer");
				opcao = sc.nextInt();

				if (opcao >= 1 && opcao < 6) {
					menuCaixa(opcao);
				} else {
					menuCaixa(5);
				}

				break;
			case 5:
				System.out.println("Encerrando o programa.");
				System.exit(0);
			}
		} catch (Exception e) {
			System.exit(0);
		}
		sc.close();
	}
	
}
