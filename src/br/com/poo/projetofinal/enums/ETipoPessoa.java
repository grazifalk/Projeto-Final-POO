package br.com.poo.projetofinal.enums;

public enum ETipoPessoa {
	CLIENTE("Cliente", 1),
	FUNCIONARIO("Funcionario", 2);

	private final int idTipoPessoa;
	private final String tipoPessoa;
	
	private ETipoPessoa(String tipoPessoa, int idTipoPessoa) {
		this.idTipoPessoa = idTipoPessoa;
		this.tipoPessoa = tipoPessoa;
	}

	public int getIdTipoPessoa() {
		return idTipoPessoa;
	}

	public String getTipoPessoa() {
		return tipoPessoa;
	}

}
