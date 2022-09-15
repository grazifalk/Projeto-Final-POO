package br.com.poo.projetofinal.pessoas;

import br.com.poo.projetofinal.enums.ETipoConta;
import br.com.poo.projetofinal.enums.ETipoPessoa;

public class Cliente {
	ETipoPessoa cliente;
	ETipoConta conta;
	public String nome;
	public String cpf;
	public int senha;
	private double saldo;
	
	public Cliente() {
		super();
	}

	public Cliente(ETipoPessoa cliente, ETipoConta conta, String nome, String cpf, int senha, double saldo) {
		super();
		this.cliente = cliente;
		this.conta = conta;
		this.nome = nome;
		this.cpf = cpf;
		this.senha = senha;
		this.saldo = saldo;
	}

	public ETipoPessoa getCliente() {
		return cliente;
	}

	public void setCliente(ETipoPessoa cliente) {
		this.cliente = cliente;
	}

	public ETipoConta getConta() {
		return conta;
	}

	public void setConta(ETipoConta conta) {
		this.conta = conta;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getSenha() {
		return senha;
	}

	public void setSenha(int senha) {
		this.senha = senha;
	}

	public String getCpf() {
		return cpf;
	}

	public double getSaldo() {
		return saldo;
	}
	
}
