package br.com.poo.projetofinal.funcionario;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import br.com.poo.projetofinal.pessoas.Cliente;

public class Gerente extends Funcionario {

	List<Cliente> clientes = new ArrayList<>();

	public static Map<String, Gerente> mapaGerentes = new HashMap<>();
	public static TreeMap<String, Gerente> OrdenaGerentes = new TreeMap<>();

	public Gerente() {
		super();
	}

	public Gerente(String eTipoFuncionario, String nome, String cpf, String senha, Integer idAgencia,
			Integer numeroConta, Double salario) {
		super(eTipoFuncionario, nome, cpf, senha, idAgencia, numeroConta, salario);
	}

	public Integer getIdAgencia() {
		return idAgencia;
	}

	public void setIdAgencia(Integer idAgencia) {
		this.idAgencia = idAgencia;
	}

}