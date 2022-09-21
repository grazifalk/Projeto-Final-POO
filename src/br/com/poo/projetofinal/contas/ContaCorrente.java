package br.com.poo.projetofinal.contas;

import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.text.DecimalFormat;

import br.com.poo.projetofinal.principal.Principal;
import br.com.poo.projetofinal.taxas.Taxas;
import br.com.poo.projetofinal.util.DataUtil;

public class ContaCorrente extends Conta {
	DecimalFormat df = new DecimalFormat("0.00");
	private Integer totalSaques = 0, totalDepositos = 0, totalTransferencias = 0;
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
		System.out.println("******************************************************************************");
		System.out.println("*****************************  Extrato Bancário  *****************************");
		System.out.println("******************************************************************************");
		System.out.println();
		System.out.println("                Gerado em: " + DataUtil.converterDateParaDataEHora(new Date()));
		System.out.println();

		for (Movimentacao movimentacao : this.movimentacoes) {
			System.out.println(movimentacao);
			System.out.println();
		}
		System.out.println();
		System.out.println("******************************************************************************");
		System.out.println("******************************************************************************");
		System.out.println("******************************************************************************");
		System.out.println();
	}

	@Override
	public void sacar(Double valor) {
		if (valor > this.saldo) {
			throw new InputMismatchException("Saque indisponível, valor insuficiente!");
		} else {
			Double valorTaxado = taxarSaque(valor);
			if (this.saldo - valorTaxado >= 0.1) {
				this.saldo -= valorTaxado;
				this.totalTributado += Taxas.SAQUE;
				Principal.imprimeLinhaHorizontal();
				System.out.println("Saque efetuado com sucesso!");
				++totalSaques;
			}
			Movimentacao movimentacao = new Movimentacao(
					"Retirada: R$ " + df.format(valor) + " - Taxa de R$ " + df.format(Taxas.SAQUE), valorTaxado);
			this.movimentacoes.add(movimentacao);

		}
	}

	@Override
	public Double taxarSaque(Double valor) {
		return valor + Taxas.SAQUE;
	}

	@Override
	public void depositar(Double valor) {
		if (valor < 0) {
			throw new InputMismatchException("Depósito indisponível, valor insuficiente!\n");
		} else {
			Double valorTaxado = taxarDeposito(valor);
			if (this.saldo - valorTaxado >= 0.1) {
				this.saldo += valorTaxado;
				this.totalTributado += Taxas.DEPOSITO;
				Principal.imprimeLinhaHorizontal();
				System.out.println("Depósito efetuado com sucesso!");
				++totalDepositos;
			}
			Movimentacao movimentacao = new Movimentacao(
					"Depósito: R$ " + df.format(valor) + " - Taxa de R$ " + df.format(Taxas.DEPOSITO), valorTaxado);
			this.movimentacoes.add(movimentacao);

		}
	}

	@Override
	public Double taxarDeposito(Double valor) {
		return valor - Taxas.DEPOSITO;
	}

	@Override
	public void transferir(Double valor, Conta contaDestino) {
		if (valor > this.saldo) {
			throw new InputMismatchException("Transferência indisponível, saldo insuficiente!\n");
		} else {
			Double valorTaxado = taxarTransferencia(valor);
			if (this.saldo - valorTaxado >= 0.2) {
				this.saldo -= valorTaxado;
				contaDestino.saldo += valor;
				this.totalTributado += Taxas.TRANSFERENCIA;
				Principal.imprimeLinhaHorizontal();
				System.out.println("Transferência efetuada com sucesso!");
				++totalTransferencias;

			}
			Movimentacao movimentacao = new Movimentacao(
					"Transferência: R$ " + df.format(valor) + " - Taxa de R$ " + df.format(Taxas.TRANSFERENCIA),
					valorTaxado);
			this.movimentacoes.add(movimentacao);
		}
	}

	@Override
	public Double taxarTransferencia(Double valor) {
		return valor + Taxas.TRANSFERENCIA;
	}

}