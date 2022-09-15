package br.com.poo.projetofinal.contas;

public abstract class Conta {
	
	protected String tipoConta;
	protected String cpf;
	protected double saldo;
	protected int numeroConta;
	protected int idAgencia;

	public Conta() {
		super();
	}
	
	public Conta(String tipoConta, String cpf, double saldo, int numeroConta, int idAgencia) {
		this.tipoConta = tipoConta;
		this.cpf = cpf;
		this.saldo = saldo;
		this.numeroConta = numeroConta;
		this.idAgencia = idAgencia;
	}

	public String getTipoConta() {
		return tipoConta;
	}

	public void setTipoConta(String tipoConta) {
		this.tipoConta = tipoConta;
	}

	public int getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(int numeroConta) {
		this.numeroConta = numeroConta;
	}

	public int getIdAgencia() {
		return idAgencia;
	}

	public void setIdAgencia(int idAgencia) {
		this.idAgencia = idAgencia;
	}

	public String getCpf() {
		return cpf;
	}

	public double getSaldo() {
		return saldo;
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
	
	//criar método transferência
}
