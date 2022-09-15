package br.com.poo.projetofinal.taxas;

public interface Taxas {
	double SAQUE = 0.1, DEPOSITO = 0.1, TRANSFERENCIA = 0.2;
	
	double taxarSaque(double valor);
	
	double taxarDeposito(double valor);
	
	double taxarTransferencia(double valor);

}
