package Familia51;

public class ContaEspecial extends ContaCorrente{
	public ContaEspecial(){
		
	}
	
	public ContaEspecial(int numero, String nome) {
		numeroDaConta = numero;
		nomeDoTitular = nome;
	}
	public void sacar(double saque) {
		if (this.saldoDisponivel < saque) {
	    	System.out.println("Saldo insuficiente, o saldo atual é: " + getSaldoDisponivel());
		} else {
			this.saldoDisponivel = this.saldoDisponivel - saque-4.5;
			System.out.println("Saque de: R$" + saque + " realizado com sucesso");
		}
	}

	public void depositar(double deposito) {
		this.saldoDisponivel += deposito;
		System.out.println("Deposito de: R$" + deposito + " realizado com sucesso");

	}

	public void resgatar(double valor, ContaCorrente destino) {
	    if (this.getSaldoDisponivel() >= valor) {
	       	this.saldoDisponivel -= valor;
	    	destino.depositar(valor);

	    } else {
	    	System.out.println("Saldo insuficiente, o saldo atual é: " + getSaldoDisponivel());
	    }
	 }


	@Override
	public void mostrarSaldo() {
		System.out.println("Saldo atual da Conta Especial: " + this.getSaldoDisponivel());
	}


	@Override
	public void dadosDaConta() {
		System.out.println("+-------------------------------+");
		System.out.println("| Titular Conta Especial: " + this.getNomeDoTitular());
		System.out.println("| Numero da Conta: " + this.getNumeroDaConta() + "-3");
		System.out.println("| Saldo atual: " + this.getSaldoDisponivel());
		System.out.println("+-------------------------------+\n");
	}
}