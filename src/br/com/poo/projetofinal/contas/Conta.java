package br.com.poo.projetofinal.contas;

import br.com.poo.projetofinal.enums.ETipoConta;

public abstract class Conta {
	String cpf;
	double saldo;
	int idAgencia;
	ETipoConta tipoConta;
		
	public Conta() {
		super();
	}
	
		public Conta(String cpf, double saldo, int idAgencia) {
		super();
		this.cpf = cpf;
		this.saldo = saldo;
		this.idAgencia = idAgencia;
	}

	public String getCpf() {
		return cpf;
	}
	public double getSaldo() {
		return saldo;
	}
	public int getIdAgencia() {
		return idAgencia;
	}
	
	
}
