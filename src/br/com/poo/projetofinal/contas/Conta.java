package br.com.poo.projetofinal.contas;

import java.util.HashMap;
import java.util.Map;

import br.com.poo.projetofinal.principal.Principal;

import java.util.ArrayList;
import java.util.InputMismatchException;

public abstract class Conta {

	protected String tipoConta;
	protected String nome;
	protected String cpf;
	protected String senha;
	protected Double saldo;
	protected Integer numeroConta;
	protected Integer idAgencia;
	protected ArrayList<Movimentacao> movimentacoes;

	public static Map<String, Conta> mapaContas = new HashMap<>();

	public Conta() {
		super();

	}

	public Conta(String tipoConta, String nome, String cpf, String senha, Double saldo, Integer numeroConta,
			Integer idAgencia, ArrayList<Movimentacao> movimentacoes) {
		super();
		this.tipoConta = tipoConta;
		this.nome = nome;
		this.cpf = cpf;
		this.senha = senha;
		this.saldo = saldo;
		this.numeroConta = numeroConta;
		this.idAgencia = idAgencia;
		this.movimentacoes = new ArrayList<Movimentacao>();
		Movimentacao movimentacao = new Movimentacao("Abertura de conta", saldo);
		this.movimentacoes.add(movimentacao);
	}

	public String getNome() {
		return nome;
	}

	public String getTipoConta() {
		return tipoConta;
	}

	public void setTipoConta(String tipoConta) {
		this.tipoConta = tipoConta;
	}

	public Integer getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(Integer numeroConta) {
		this.numeroConta = numeroConta;
	}

	public Integer getIdAgencia() {
		return idAgencia;
	}

	public void setIdAgencia(Integer idAgencia) {
		this.idAgencia = idAgencia;
	}

	public String getCpf() {
		return cpf;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public double getSaldo() {
		return saldo;
	}

	public void sacar(Double valor) {

		if (valor > this.saldo) {
			throw new InputMismatchException("Saque indisponível, valor insuficiente!\n");
		} else {
			this.saldo -= valor;
			Principal.imprimeLinhaHorizontal();
			System.out.println("Saque efetuado com sucesso!");

		}
		Movimentacao movimentacao = new Movimentacao("Retirada: ", valor);
		this.movimentacoes.add(movimentacao);

	}

	public void depositar(Double valor) {
		if (valor > 0) {
			this.saldo += valor;
			Principal.imprimeLinhaHorizontal();
			System.out.println("Depósito efetuado com sucesso!");
		} else {
			throw new InputMismatchException("Valor inválido!");
		}
		Movimentacao movimentacao = new Movimentacao("Depósito: ", valor);
		this.movimentacoes.add(movimentacao);

	}

	public void transferir(Double valor, Conta contaDestino) {
		if (valor > this.saldo) {
			throw new InputMismatchException("Saque indisponível, valor insuficiente!\n");
		} else if (valor > 0) {
			this.saldo -= valor;
			Principal.imprimeLinhaHorizontal();
			System.out.println("Transferência realizada com sucesso!");
		} else {
			throw new InputMismatchException("Valor inválido!");
		}
		Movimentacao movimentacao = new Movimentacao("Transferência: ", valor);
		this.movimentacoes.add(movimentacao);

	}

	public void imprimirExtrato() {
	}

	public Double taxarSaque(Double valor) {
		return null;
	}

	public Double taxarDeposito(Double valor) {
		return null;
	}

	public Double taxarTransferencia(Double valor) {
		return null;
	}

}