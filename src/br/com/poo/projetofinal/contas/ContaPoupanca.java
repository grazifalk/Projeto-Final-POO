package br.com.poo.projetofinal.contas;

import java.util.ArrayList;
import java.util.Date;
import br.com.poo.projetofinal.util.DataUtil;

public class ContaPoupanca extends Conta {

	public ContaPoupanca() {
		super();

	}

	public ContaPoupanca(String tipoConta, String nome, String cpf, String senha, Double saldo, Integer numeroConta,
			Integer idAgencia, ArrayList<Movimentacao> movimentacoes) {
		super(tipoConta, nome, cpf, senha, saldo, numeroConta, idAgencia, movimentacoes);

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