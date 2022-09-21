package br.com.poo.projetofinal.contas;

import java.util.Date;
import java.text.DecimalFormat;

import br.com.poo.projetofinal.enums.ETipoMovimentacao;
import br.com.poo.projetofinal.util.DataUtil;

public class Movimentacao {
	DecimalFormat df = new DecimalFormat("0.00");
	private String descricao;
	private Date data;
	private Double valor;

	public Movimentacao(String descricao, Double valor) {
		this.descricao = descricao;
		this.data = new Date();
		this.valor = valor;
	}

	public Movimentacao(ETipoMovimentacao transferencia, Double valorSacado, Conta contaDestino) {
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getData() {
		return data;
	}

	public Double getValor() {
		return valor;
	}

	@Override
	public String toString() {
		String dataFormatada = DataUtil.converterDateParaDataEHora(this.getData());
		return this.getDescricao() + df.format(valor) + " - " + dataFormatada + " - R$ " + df.format(this.getValor());
	}

}