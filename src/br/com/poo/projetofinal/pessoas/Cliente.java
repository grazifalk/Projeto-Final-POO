package br.com.poo.projetofinal.pessoas;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Cliente implements Comparable<Cliente> {

	String cliente;
	String conta;
	protected String nome;
	protected String cpf;
	private String senha;
	private Double saldo;
	protected Integer idConta;
	protected Integer idAgencia;

	public static Map<String, Cliente> mapaClientes = new HashMap<>();
	public static TreeMap<String, Cliente> OrdenaClientes = new TreeMap<>();

	public Cliente() {
		super();
	}

	public Cliente(String cliente, String conta, String nome, String cpf, String senha, Double saldo, Integer idConta,
			Integer idAgencia) {
		super();
		this.cliente = cliente;
		this.conta = conta;
		this.nome = nome;
		this.cpf = cpf;
		this.senha = senha;
		this.saldo = saldo;
		this.idConta = idConta;
		this.idAgencia = idAgencia;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public String getConta() {
		return conta;
	}

	public void setConta(String conta) {
		this.conta = conta;
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

	public String getCpf() {
		return cpf;
	}

	public Double getSaldo() {
		return saldo;
	}

	@Override
	public int compareTo(Cliente o) {
		return 0;
	}

	@Override
	public String toString() {
		return "Cliente [Nome: " + nome + ", CPF: " + cpf + ", Agência: " + idAgencia + "]";
	}

}