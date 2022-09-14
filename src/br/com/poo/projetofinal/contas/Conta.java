package br.com.poo.projetofinal.contas;

import br.com.poo.projetofinal.enums.ETipoConta;
import br.com.poo.projetofinal.enums.ETipoFuncionario;

public abstract class Conta {
	protected String cpf;
	protected double saldo;
	protected int idAgencia;
	ETipoConta corrente = ETipoConta.CORRENTE;
	ETipoConta poupanca = ETipoConta.POUPANCA;
		
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
	
	public boolean sacar(double valor) {
		if (this.saldo < valor) {
			System.out.println("Saldo insuficiente!");
			return false;
		} else {
			double novoSaldo = this.saldo - valor;
			this.saldo = novoSaldo;

			return true;
		}
	}
	
	public boolean depositar(double valor) {
		if (valor < 0) {
			System.out.println("Valor inválido!");
			return false;
		} else {
			this.saldo += valor;
			return true;
		}
	}
}
