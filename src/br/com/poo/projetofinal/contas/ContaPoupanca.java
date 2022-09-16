package br.com.poo.projetofinal.contas;

import java.util.Date;

import br.com.poo.projetofinal.util.DataUtil;

public class ContaPoupanca extends Conta {

	public ContaPoupanca() {
		super();
	}

	public ContaPoupanca(String tipoConta, String cpf, double saldo, int numeroConta, int idAgencia) {
		super(tipoConta, cpf, saldo, numeroConta, idAgencia);
	}
	@Override
public void imprimirExtrato() {
    
    System.out.println();
    System.out.println("************************************************");
    System.out.println("**************  Extrato Bancario ***************");
    System.out.println("************************************************");
    System.out.println();
    System.out.println("      gerado em : " + DataUtil.converterDateParaDataEHora(new Date()));
    System.out.println();

    // para cada movimentação dentro de movimentações fará
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
