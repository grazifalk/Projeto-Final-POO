package br.com.poo.projetofinal.funcionario;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public abstract class Funcionario implements Comparable<Funcionario> {

	protected String ETipoFuncionario;
	protected String nome;
	protected String cpf;
	protected String senha;
	protected Integer agencia;
	protected Integer numeroConta;
	protected Double salario;

	public static Map<String, Funcionario> mapaFuncionarios = new HashMap<>();
	public static TreeMap<String, Funcionario> OrdenaFuncionarios = new TreeMap<>();

	public Funcionario() {
	}

	public Funcionario(String eTipoFuncionario, String nome, String cpf, String senha, Integer agencia,
			Integer numeroConta, Double salario) {
		ETipoFuncionario = eTipoFuncionario;
		this.nome = nome;
		this.cpf = cpf;
		this.senha = senha;
		this.agencia = agencia;
		this.numeroConta = numeroConta;
		this.salario = salario;
	}

	public String getETipoFuncionario() {
		return ETipoFuncionario;
	}

	public void setETipoFuncionario(String eTipoFuncionario) {
		ETipoFuncionario = eTipoFuncionario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Integer getAgencia() {
		return agencia;
	}

	public void setAgencia(Integer agencia) {
		this.agencia = agencia;
	}

	public Integer getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(Integer numeroConta) {
		this.numeroConta = numeroConta;
	}

	public String getCpf() {
		return cpf;
	}

	public Double getSalario() {
		return salario;
	}

	@Override
	public int compareTo(Funcionario outroFuncionario) {
		return this.nome.compareTo(outroFuncionario.getNome());
	}

	public String relatorios() {
		return "Nome: " + this.nome + "\t CPF: " + this.cpf + "\tAgencia: " + this.agencia;
	}
}