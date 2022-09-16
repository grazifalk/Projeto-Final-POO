package br.com.poo.projetofinal.contas;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.InputMismatchException;

public abstract class Conta {
	
	protected String tipoConta;
	protected String nome;
	protected String cpf;
	protected Integer senha;
	protected double saldo;
	protected Integer numeroConta;
	protected Integer idAgencia;
	protected ArrayList<Movimentacao> movimentacoes;
	
	
	public static Map<String, Conta> mapaContas = new HashMap<>();



	public Conta() {
		super();
		
	}

	public Conta(String tipoConta, String nome, String cpf, Integer senha, double saldo, Integer numeroConta,
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
        Movimentacao movimentacao = new Movimentacao("Abertura de contra", saldo);
        this.movimentacoes.add(movimentacao);
	}
	
	
	public String getTipoConta() {
		return tipoConta;
	}

	public void setTipoConta(String tipoConta) {
		this.tipoConta = tipoConta;
	}

	public int getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(Integer numeroConta) {
		this.numeroConta = numeroConta;
	}

	public int getIdAgencia() {
		return idAgencia;
	}

	public void setIdAgencia(Integer idAgencia) {
		this.idAgencia = idAgencia;
	}

	public String getCpf() {
		return cpf;
	}

	public double getSaldo() {
		return saldo;
	}
//testando sem boolean 
	/*public boolean sacar(double valor) {
		if (this.saldo < valor) {
			System.out.println("Saldo insuficiente!");
			return false;
		} else {
			double novoSaldo = this.saldo - valor;
			this.saldo = novoSaldo;
			return true;
		}
		Movimentacao movimentacao= new Movimentacao("sacar", valor);
    this.movimentacoes.add(movimentacao);
	}*/

	public Double sacar(Double valor){
    
		// verifica se o saldo é menor que o valor retirado
		if(valor>this.saldo){
			// caso seja menor tras a execessão abaixo throw new
			throw new InputMismatchException("Saque indisponivel, por não ter valor em conta!!");
		}else{
			// caso a operação seja valida da o resultado da operação e traz o valor novamente
			this.saldo -=valor;
			
		}
			Movimentacao movimentacao= new Movimentacao("sacar", valor);
			this.movimentacoes.add(movimentacao);
	
			return valor;
			
	
	}
	public void depositar(Double valor){
		if(valor<0){
			
			this.saldo += valor;
		}else{
			throw new InputMismatchException("valor de deposito é muito baixo!! ");
		}
		// extrato
		Movimentacao movimentacao= new Movimentacao("Deposito", valor);
		this.movimentacoes.add(movimentacao);
	}
	//testando sem boolean 
	/*public boolean depositar(double valor) {
		if (valor < 0) {
			System.out.println("Valor inválido!");
			return false;
		} else {
			this.saldo += valor;
		}
		Movimentacao movimentacao= new Movimentacao("Deposito", valor);
        this.movimentacoes.add(movimentacao);
		return true;
	}*/

	public void transferir(Double valor, Conta contaDestino){
		//efetua um saque na conta atual
			this.sacar(valor);
		
		// efetuar um deposito na conta destino
			contaDestino.depositar(valor);
		
		}
	
	/*public boolean transferir(Double valor, Conta contaDestino ) {
		var valorSacado = efetuarSaque(valor);
		contaDestino.depositar(valorSacado);
		var movimentacao = new Movimentacao(ETipoMovimentacao.TRANSFERENCIA, valorSacado, contaDestino);
		this.movimentacoes.add(movimentacao);
	}*/

	public void imprimirExtrato() {
		
		
	}
	
}
