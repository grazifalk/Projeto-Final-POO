package br.com.poo.projetofinal.funcionario;

public class Gerente extends Funcionario {
	private int idAgencia;

	public Gerente() {
		super();
	}

	public Gerente(String eTipoFuncionario, String nome, String cpf, String senha, Integer agencia, Integer numeroConta,
			Double salario, int idAgencia) {
		super(eTipoFuncionario, nome, cpf, senha, agencia, numeroConta, salario);
		this.idAgencia = idAgencia;
	}

	public int getIdAgencia() {
		return this.idAgencia;
	}

	public void setIdAgencia(int idAgencia) {
		this.idAgencia = idAgencia;
	}

}