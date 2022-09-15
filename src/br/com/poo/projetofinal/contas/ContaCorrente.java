package br.com.poo.projetofinal.contas;

public class ContaCorrente extends Conta {

	private int totalSaques = 0;
	private Double totalTributado = 0.0;
	
	public ContaCorrente() {
		super();
	}
	
	public ContaCorrente(String tipoConta, String cpf, double saldo, int numeroConta, int idAgencia) {
		super(tipoConta, cpf, saldo, numeroConta, idAgencia);
	}

	public int getTotalSaques() {
		return this.totalSaques;
	}

	public Double getTotalTributado() {
		return this.totalTributado;
	}
	
	
	
}
