package br.com.projetofinal.IO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import br.com.poo.projetofinal.contas.ContaCorrente;
import br.com.poo.projetofinal.enums.ETipoConta;

public class LeituraEscrita {
	
	static final String PATH_BASICO = "./temp/";
	static final String EXTENSAO = ".txt";
	
	public static void leitor(String path) throws IOException {
		BufferedReader buffRead = new BufferedReader(new FileReader(PATH_BASICO + path + EXTENSAO));
		
		String linha = "";
		
		while (true) {
			linha = buffRead.readLine();
			if (linha != null) {
				String[] dados = linha.split(";");
				if (dados[0].equalsIgnoreCase(ETipoConta.CORRENTE.getTipoConta())) {
					ContaCorrente cc = new ContaCorrente(dados[0], int(dados[1]) ),
							int(dados[2]), Double.parseDouble(dados[3]), dados[4]
				}
			}
		}
	}

}
