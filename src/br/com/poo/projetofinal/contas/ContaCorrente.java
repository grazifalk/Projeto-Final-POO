package br.com.poo.projetofinal.contas;

import java.util.ArrayList;
import java.util.Date;

import br.com.poo.projetofinal.util.DataUtil;

public class ContaCorrente extends Conta {

	private Integer totalSaques = 0;
	private Double totalTributado = 0.0;

	public ContaCorrente() {
		super();

	}

	public ContaCorrente(String tipoConta, String nome, String cpf, String senha, Double saldo, Integer numeroConta,
			Integer idAgencia, ArrayList<Movimentacao> movimentacoes) {
		super(tipoConta, nome, cpf, senha, saldo, numeroConta, idAgencia, movimentacoes);

	}

	public ContaCorrente(Integer totalSaques, Double totalTributado) {
		super();
		this.totalSaques = totalSaques;
		this.totalTributado = totalTributado;
	}

	@Override
	public void imprimirExtrato() {

		System.out.println();
		System.out.println("************************************************");
		System.out.println("**************  Extrato Bancario  **************");
		System.out.println("************************************************");
		System.out.println();
		System.out.println("      gerado em : " + DataUtil.converterDateParaDataEHora(new Date()));
		System.out.println();

		// para cada movimentacao dentro de movimentacoes fara
		for (Movimentacao movimentacao : this.movimentacoes) {
			System.out.println(movimentacao);
			System.out.println();
		}
		System.out.println();
		System.out.println("************************************************");
		System.out.println("************************************************");
		System.out.println("************************************************");
		System.out.println();
	}

}