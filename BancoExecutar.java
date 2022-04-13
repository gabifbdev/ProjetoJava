package Familia51;


import java.util.Scanner;

public class BancoExecutar {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		Scanner ent = new Scanner(System.in);

		String nomeDoTitular = null;
		int numDaConta = 0;
		int saldoDisponivel = 0;
		double valor = 0;
		double depositoInicial = 0;

		ContaCorrente cc = new ContaCorrente(saldoDisponivel, nomeDoTitular);
		ContaPoupanca cp = new ContaPoupanca(saldoDisponivel, nomeDoTitular);
		ContaEspecial ce = new ContaEspecial(saldoDisponivel, nomeDoTitular);
		System.out.println("\n\n*Bem vindo ao GenBank!*\n\n");
		int opcao = 0;
		do {
			System.out.println("+-------------------------+");
			System.out.println("|    ------ MENU ------   |");
			System.out.println("|   1- Inserir Dados      |");
			System.out.println("|   2- Mostrar Dados      |");
			System.out.println("|   3- Depositar Valor    |");
			System.out.println("|   4- Sacar Valor        |");
			System.out.println("|   5- Aplicar            |");
			System.out.println("|   6- Resgatar           |");
			System.out.println("|   7- Mostrar Saldo      |");
			System.out.println("|   0- Sair               |");
			System.out.println("+-------------------------+");

			opcao = input.nextInt();

			switch (opcao) {
			case 1:

				System.out.println("Insira o nome do Titular da Conta:");
				String nome = ent.nextLine();
				System.out.println("Insira o numéro da Conta:");
				numDaConta = input.nextInt();
				if (depositoInicial <= 0)
					System.out.println("Seu saldo é: R$" + depositoInicial);
				System.out.println("Deseja fazer um deposito inicial? 1-SIM / 2-NÃO");
				int resposta = input.nextInt();

				if (resposta == 1) {
					System.out.println("Digite o valor que deseja depositar:");
					depositoInicial = input.nextInt();
					cc = new ContaCorrente(numDaConta, nome, depositoInicial);
					cp = new ContaPoupanca(numDaConta, nome);
					ce = new ContaEspecial (numDaConta, nome);
					System.out.println("Conta Criada com sucesso!");
				} else {
					cc = new ContaCorrente(numDaConta, nome);
					cp = new ContaPoupanca(numDaConta, nome);
				}

				break;

			case 2:
				cc.dadosDaConta();
				cp.dadosDaConta();
				ce.dadosDaConta();
				break;

			case 3:
				System.out.println("Em qual conta deseja realizar um depósto? 1- Conta Corrente / 2- Conta Especial");
				int deposito = input.nextInt();
				if (deposito == 1) {						
				System.out.println("Entre com o valor a ser depositado: ");
				valor = input.nextDouble();
				cc.depositar(valor);
				} else if (deposito == 2) { System.out.println("Entre com o valor a ser depositado: ");
				valor = input.nextDouble();
				ce.depositar(valor); 
				} else { System.out.println("Erro");}
				break;

			case 4:
				System.out.println("+-------------------------+");
				cc.mostrarSaldo();
				cp.mostrarSaldo();
				ce.mostrarSaldo();
				System.out.println("+-------------------------+");
				System.out.println("Em qual conta deseja realizar o saque ? 1- Corrente / 2- Especial / 3 - Poupança.");
				int saque = input.nextInt();
				if (saque == 1) {
					System.out.println("Entre com o valor a ser sacado: ");
					valor = input.nextDouble();
					cc.sacar(valor);
				} else if (saque == 2) {
					System.out.println("Entre com o valor a ser sacado: ");
					valor = input.nextDouble();
					ce.sacar(valor);
				}else if( saque ==3) {
					System.out.println("Entre com o valor a ser sacado: ");
					valor = input.nextDouble();
					cp.sacar(valor);

				} else { System.out.println("Erro");}
				break;

			case 5:
				System.out.println("Insira um valor para transferir para Poupança: ");
				valor = input.nextDouble();
				cc.aplicarNaPoupança(valor, cp);
				break;

			case 6: 
				System.out.println("Deseja fazer o resgate de qual conta? 1- Poupança / 2- Especial");
				int resgate = input.nextInt();
				if (resgate == 1) {
					System.out.println("Insira um valor para resgatar da conta poupança: ");
					valor = input.nextDouble();
					cp.resgatar(valor, cc);
				} else  if (resgate == 2){
					System.out.println("Insira um valor para resgatar da conta especial: ");
					valor = input.nextDouble();
					ce.resgatar(valor, cc);
				} else { System.out.println("Erro");}

				break;

			case 7:
				System.out.println("============================================");
				cc.mostrarSaldo();
				System.out.println("+-------------------------+");
				cp.mostrarSaldo();
				System.out.println("+-------------------------+");
				ce.mostrarSaldo();
				System.out.println("============================================");
				break;

			default:
				if(opcao<0 || opcao>7) {
					System.out.println("\nOpção inválida. Por favor, digite uma opção novamente:");
				}else {
				System.out.println("Fim da operação...");
				System.out.println("\nObrigado por ultizar os nossos serviços!");
				System.out.println("\nGenBank facilitando a sua vida!");
				}
			}

		} while (opcao != 0);

	}

}