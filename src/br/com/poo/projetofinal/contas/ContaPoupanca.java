package br.com.poo.projetofinal.contas;

public class ContaPoupanca extends Conta {

	public ContaPoupanca() {
		super();
	}

	public ContaPoupanca(String tipoConta, String cpf, double saldo, int numeroConta, int idAgencia) {
		super(tipoConta, cpf, saldo, numeroConta, idAgencia);
	}
	
}
