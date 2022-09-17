package br.com.poo.projetofinal.funcionario;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import br.com.poo.projetofinal.pessoas.Cliente;

public class Gerente extends Funcionario {
	private int idAgencia;

	List<Cliente> clientes = new ArrayList<>();

	public static Map<String, Gerente> mapaGerentes = new HashMap<>();
	public static TreeMap<String, Gerente> OrdenaGerentes = new TreeMap<>();

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