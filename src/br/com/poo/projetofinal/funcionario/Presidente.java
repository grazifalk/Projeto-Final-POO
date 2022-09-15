package br.com.poo.projetofinal.funcionario;

public class Presidente extends Funcionario {

	public Presidente() {
		super();
	}

	public Presidente(String eTipoFuncionario, String nome, String cpf, String senha, Integer agencia,
			Integer numeroConta, Double salario) {
		super(eTipoFuncionario, nome, cpf, senha, agencia, numeroConta, salario);
	}
	
}
