package br.com.projetofinal.IO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import br.com.poo.projetofinal.contas.Conta;
import br.com.poo.projetofinal.contas.ContaCorrente;
import br.com.poo.projetofinal.contas.ContaPoupanca;
import br.com.poo.projetofinal.enums.ETipoConta;
import br.com.poo.projetofinal.enums.ETipoFuncionario;
import br.com.poo.projetofinal.enums.ETipoPessoa;
import br.com.poo.projetofinal.funcionario.Diretor;
import br.com.poo.projetofinal.funcionario.Funcionario;
import br.com.poo.projetofinal.funcionario.Gerente;
import br.com.poo.projetofinal.funcionario.Presidente;
import br.com.poo.projetofinal.pessoas.Cliente;
import br.com.poo.projetofinal.util.DataUtil;

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
					Gerente gerente = new Gerente(dados[0], dados[1], dados[2], dados[3], Integer.parseInt(dados[4]),
							Integer.parseInt(dados[5]), Double.parseDouble(dados[6]), Integer.parseInt(dados[7]));
					Funcionario.mapaFuncionarios.put(dados[2], gerente);
					Funcionario.OrdenaFuncionarios.put(dados[0], gerente);

				} else if (dados[0].equalsIgnoreCase(ETipoFuncionario.DIRETOR.getTipoFuncionario())) {
					Diretor diretor = new Diretor(dados[0], dados[1], dados[2], dados[3], Integer.parseInt(dados[4]),
							Integer.parseInt(dados[5]), Double.parseDouble(dados[6]));
					Funcionario.mapaFuncionarios.put(dados[2], diretor);
					Funcionario.OrdenaFuncionarios.put(dados[1], diretor);

				} else if (dados[0].equalsIgnoreCase(ETipoFuncionario.PRESIDENTE.getTipoFuncionario())) {
					Presidente presidente = new Presidente(dados[0], dados[1], dados[2], dados[3],
							Integer.parseInt(dados[4]), Integer.parseInt(dados[5]), Double.parseDouble(dados[6]));
					Funcionario.mapaFuncionarios.put(dados[2], presidente);
					Funcionario.OrdenaFuncionarios.put(dados[1], presidente);

				} else if (dados[0].equalsIgnoreCase(ETipoConta.POUPANCA.getTipoConta())) {
					ContaPoupanca cp = new ContaPoupanca(dados[0], dados[1], dados[2], dados[3],
							Double.parseDouble(dados[4]), Integer.parseInt(dados[5]), Integer.parseInt(dados[6]), null);
					Conta.mapaContas.put(dados[2], cp);

				} else if (dados[0].equalsIgnoreCase(ETipoConta.CORRENTE.getTipoConta())) {
					ContaCorrente cc = new ContaCorrente(dados[0], dados[1], dados[2], dados[3],
							Double.parseDouble(dados[4]), Integer.parseInt(dados[5]), Integer.parseInt(dados[6]), null);
					Conta.mapaContas.put(dados[2], cc);
				} else if (dados[0].equalsIgnoreCase(ETipoPessoa.CLIENTE.getTipoPessoa())) {
					Cliente cliente = new Cliente(dados[0], dados[1], dados[2], dados[3], dados[4],
							Double.parseDouble(dados[5]));
					Cliente.mapaClientes.put(dados[3], cliente);
				}

			} else {
				break;
			}
		}
		buffRead.close();
	}
	
	public static void comprovanteSaque(Conta conta, double Valor) throws IOException {

	    String arq = conta.getNome() + "_Comprovante_Saque";
	    try (BufferedWriter buffWrite = new BufferedWriter(new FileWriter(PATH_BASICO + arq + EXTENSAO, true));) {

	      String linha = "============ saque ============";
	      buffWrite.append(linha + "\n");

	      linha = "Nome: " + conta.getNome();
	      buffWrite.append(linha + "\n");

	      linha = "Agencia: " + conta.getIdAgencia();
	      buffWrite.append(linha + "\n");
	      
	      linha = "Numero da Conta: " + conta.getNumeroConta();
	      buffWrite.append(linha + "\n");

	      linha = "Valor: R$ " + Valor;
	      buffWrite.append(linha + "\n");

	      linha = DataUtil.data();
	      buffWrite.append(linha + "\n");

	      linha = "============= fim do saque =============";
	      buffWrite.append(linha + "\n");

	      buffWrite.close();

	    } catch (IOException e) {
	      e.printStackTrace();
	    } catch (Exception e) {
	      e.printStackTrace();
	    }

	  }
}