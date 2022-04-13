package Familia51;

	
public class ContaPoupanca extends ContaCorrente {
	public ContaPoupanca(int numDaConta, String nome) {
		super(numDaConta, nome);
		numeroDaConta = numDaConta;
		nomeDoTitular = nome;
	}

	public void resgatar(double valor, ContaCorrente destino) {
		if (this.getSaldoDisponivel() >= valor) {
			this.saldoDisponivel = this.saldoDisponivel - valor;
			destino.depositar(valor);
		} else {
        	System.out.println("Saldo insuficiente, o saldo atual é: " + getSaldoDisponivel());
		}
	}

	public void mostrarSaldo() {
		System.out.println("Saldo atual da Poupança: " + this.getSaldoDisponivel());
	}

	@Override
	public void dadosDaConta() {
		System.out.println("+-------------------------------+");
		System.out.println("|          DADOS DA CONTA        ");
		System.out.println("| Titular da Conta Poupança: " + this.getNomeDoTitular());
		System.out.println("| Numero da Conta: " + this.getNumeroDaConta()+ "-2");
		System.out.println("| Saldo atual: " + this.getSaldoDisponivel());
		System.out.println("+-------------------------------+\n");
	}

}