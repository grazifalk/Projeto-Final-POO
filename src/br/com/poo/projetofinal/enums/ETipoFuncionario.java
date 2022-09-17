package br.com.poo.projetofinal.enums;

public enum ETipoFuncionario {
	DIRETOR("Diretor", 1), GERENTE("Gerente", 2), OPERADOR_CAIXA("Operador", 3), PRESIDENTE("Presidente", 4);

	private final String tipoFuncionario;
	private final int idFuncionario;

	private ETipoFuncionario(String tipoFuncionario, int idFuncionario) {
		this.tipoFuncionario = tipoFuncionario;
		this.idFuncionario = idFuncionario;
	}

	public String getTipoFuncionario() {
		return tipoFuncionario;
	}

	public int getIdFuncionario() {
		return idFuncionario;
	}

}