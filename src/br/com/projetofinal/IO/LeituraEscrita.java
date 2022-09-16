package br.com.projetofinal.IO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import br.com.poo.projetofinal.contas.Conta;
import br.com.poo.projetofinal.contas.ContaCorrente;
import br.com.poo.projetofinal.enums.ETipoConta;
import br.com.poo.projetofinal.enums.ETipoFuncionario;
import br.com.poo.projetofinal.funcionario.Funcionario;
import br.com.poo.projetofinal.funcionario.Gerente;

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
				if (dados[0].equalsIgnoreCase(ETipoFuncionario.GERENTE.getTipoFuncionario())) {
					Gerente gerente = new Gerente(dados[0], dados[1], dados[2], dados[3],
							Integer.parseInt(dados[4]), Integer.parseInt(dados[5]), Double.parseDouble(dados[6]),
							Integer.parseInt(dados[7]));
					Funcionario.mapaFuncionarios.put(dados[2], gerente);
					Funcionario.OrdenaFuncionarios.put(dados[0], gerente);

				}
			} else {
			break;
		}
	}
	buffRead.close();
}
}