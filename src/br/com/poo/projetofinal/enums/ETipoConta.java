package br.com.poo.projetofinal.enums;

public enum ETipoConta {
	CORRENTE("Corrente", 1),
	POUPANCA("Poupanca", 2);
	
	private final String tipoConta;
	private final int idTipoConta;
	
	ETipoConta(String tipoConta, int idTipoConta) {
		this.tipoConta = tipoConta;
		this.idTipoConta = idTipoConta;
	}

	public String getTipoConta() {
		return tipoConta;
	}

	public int getIdTipoConta() {
		return idTipoConta;
	}
	
}
