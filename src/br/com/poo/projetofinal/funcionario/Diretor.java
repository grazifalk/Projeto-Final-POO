package br.com.poo.projetofinal.funcionario;

public class Diretor extends Funcionario {

	public Diretor() {
		super();
	}

	public Diretor(String eTipoFuncionario, String nome, String cpf, String senha, Integer agencia, Integer numeroConta,
			Double salario) {
		super(eTipoFuncionario, nome, cpf, senha, agencia, numeroConta, salario);
	}

}