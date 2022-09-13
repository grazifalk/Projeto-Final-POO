package br.com.poo.projetofinal.pessoas;

public class Cliente {
	public String cpf;
	public int senha;
	public String nome;
	
	
	public Cliente(String cpf, int senha, String nome) {
		super();
		this.cpf = cpf;
		this.senha = senha;
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public int getSenha() {
		return senha;
	}
	public void setSenha(int senha) {
		this.senha = senha;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	

	
	
}
