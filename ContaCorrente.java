package Familia51;

public class ContaCorrente {


		protected int numeroDaConta;
		protected String nomeDoTitular;
		protected double saldoDisponivel;

		public ContaCorrente() {

		}

		public ContaCorrente(int numDaConta, String nome, double depositoInicial) {
			nomeDoTitular = nome;
			numeroDaConta = numDaConta;
			depositar(depositoInicial);
		}

		public ContaCorrente(int numDaConta, String nome) {
		}

		public double getSaldoDisponivel() {
			return saldoDisponivel;
		}

		public void setSaldoDisponivel(double saldoDisponivel) {
			this.saldoDisponivel = saldoDisponivel;
		}

		public int getNumeroDaConta() {
			return numeroDaConta;
		}

		public void setNumeroDaConta(int numeroDaConta) {
			this.numeroDaConta = numeroDaConta;
		}

		public String getNomeDoTitular() {
			return nomeDoTitular;
		}

		public void setNomeDoTitular(String nomeDoTitular) {
			this.nomeDoTitular = nomeDoTitular;
		}

		public void sacar(double saque) {
			if (this.saldoDisponivel < saque) {
	        	System.out.println("Saldo insuficiente, o saldo atual é: " + getSaldoDisponivel());
			} else {
				this.saldoDisponivel = this.saldoDisponivel - saque;
				System.out.println("Saque de: R$" + saque + " realizado com sucesso");
			}
		}

		public void depositar(double deposito) {
			this.saldoDisponivel += deposito;
			System.out.println("Deposito de: R$" + deposito + " realizado com sucesso");

		}

		public void aplicarNaPoupança(double valor, ContaPoupanca destino) {
			if (this.saldoDisponivel >= valor) {
				this.saldoDisponivel = this.saldoDisponivel - valor;
				destino.depositar(valor);
			} else {
	        	System.out.println("Saldo insuficiente, o saldo atual é: " + getSaldoDisponivel());
			}
		}

		public void dadosDaConta() {
			System.out.println("+-------------------------------+");
			System.out.println("|          DADOS DA CONTA        ");
			System.out.println("| Titular Conta Corrente: " + this.getNomeDoTitular());
			System.out.println("| Numero da Conta: " + this.getNumeroDaConta()+ "-1");
			System.out.println("| Saldo atual: " + this.getSaldoDisponivel());
			System.out.println("+-------------------------------+");
		}

		@Override
		public String toString() {
			return "Numero Conta Corrente: " + numeroDaConta + ", Titular: " + nomeDoTitular + ", Saldo: "
					+ String.format("%.2f", saldoDisponivel);
		}

		public void mostrarSaldo() {
			System.out.printf("Saldo Atual Conta Corrente: %.2f\n", this.getSaldoDisponivel());

		}
	}