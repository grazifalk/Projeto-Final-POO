package br.com.projetofinal.IO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;

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
							Integer.parseInt(dados[5]), Double.parseDouble(dados[6]));
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
							Double.parseDouble(dados[5]), Integer.parseInt(dados[6]), Integer.parseInt(dados[7]));
					Cliente.mapaClientes.put(dados[3], cliente);
				}

			} else {
				break;
			}
		}
		buffRead.close();
	}

	public static void comprovanteSaque(Conta conta, double Valor) throws IOException {
		DecimalFormat df = new DecimalFormat("0.00");
		String path = conta.getNome() + "_Comprovante_Saque";
		try (BufferedWriter buffWrite = new BufferedWriter(new FileWriter(PATH_BASICO + path + EXTENSAO, true));) {

			String linha = "********** Saque **********";
			buffWrite.append(linha + "\n");

			linha = "Nome: " + conta.getNome();
			buffWrite.append(linha + "\n");

			linha = "Agencia: " + conta.getIdAgencia();
			buffWrite.append(linha + "\n");

			linha = "Numero da Conta: " + conta.getNumeroConta();
			buffWrite.append(linha + "\n");

			linha = "Valor: R$ " + df.format(Valor);
			buffWrite.append(linha + "\n");

			linha = DataUtil.data();
			buffWrite.append(linha + "\n");

			linha = "********** Fim do Saque **********";
			buffWrite.append(linha + "\n");

			buffWrite.close();

		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void comprovanteDeposito(Conta conta, double Valor) throws IOException {
		DecimalFormat df = new DecimalFormat("0.00");
		String path = conta.getNome() + "_Comprovante_Deposito";
		try (BufferedWriter buffWrite = new BufferedWriter(new FileWriter(PATH_BASICO + path + EXTENSAO, true));) {

			String linha = "********** Depósito **********";
			buffWrite.append(linha + "\n");

			linha = "Nome: " + conta.getNome();
			buffWrite.append(linha + "\n");

			linha = "Agencia: " + conta.getIdAgencia();
			buffWrite.append(linha + "\n");

			linha = "Numero da Conta: " + conta.getNumeroConta();
			buffWrite.append(linha + "\n");

			linha = "Valor: R$ " + df.format(Valor);
			buffWrite.append(linha + "\n");

			linha = DataUtil.data();
			buffWrite.append(linha + "\n");

			linha = "********** Fim do Depósito **********";
			buffWrite.append(linha + "\n");

			buffWrite.close();

		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void comprovanteTransferencia(Conta conta, double Valor, Conta contaDestino) throws IOException {
		DecimalFormat df = new DecimalFormat("0.00");
		String path = conta.getNome() + "_Comprovante_Transferencia";
		try (BufferedWriter buffWrite = new BufferedWriter(new FileWriter(PATH_BASICO + path + EXTENSAO, true));) {

			String linha = "********** Transferência **********";
			buffWrite.append(linha + "\n");

			linha = "********** Remetente: **********";
			buffWrite.append(linha + "\n");

			linha = "Nome: " + conta.getNome();
			buffWrite.append(linha + "\n");

			linha = "CPF: " + conta.getCpf();
			buffWrite.append(linha + "\n");

			linha = "Agencia: " + conta.getIdAgencia();
			buffWrite.append(linha + "\n");

			linha = "Numero da Conta: " + conta.getNumeroConta();
			buffWrite.append(linha + "\n");

			linha = "********** Destinatário: **********";
			buffWrite.append(linha + "\n");

			linha = "Nome: " + contaDestino.getNome();
			buffWrite.append(linha + "\n");

			linha = "CPF: " + contaDestino.getCpf();
			buffWrite.append(linha + "\n");

			linha = "Agencia: " + contaDestino.getIdAgencia();
			buffWrite.append(linha + "\n");

			linha = "Numero da Conta: " + contaDestino.getNumeroConta();
			buffWrite.append(linha + "\n");

			linha = "***********************************";
			buffWrite.append(linha + "\n");

			linha = "Valor: R$ " + df.format(Valor);
			buffWrite.append(linha + "\n");

			linha = "Transferência realizada em: " + DataUtil.data();
			buffWrite.append(linha + "\n");

			linha = "********** Fim da Transferência **********";
			buffWrite.append(linha + "\n");

			buffWrite.close();

		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static int escritorContaAgencia(String path, Integer idAgencia) throws IOException {
		BufferedReader buffRead = new BufferedReader(new FileReader(PATH_BASICO + path + EXTENSAO));
		String linha = "";
		int cont = 0;

		while (true) {
			linha = buffRead.readLine();
			if (linha != null) {
				String[] dados = linha.split(";");
				if (dados[0].equalsIgnoreCase(ETipoPessoa.CLIENTE.getTipoPessoa())) {
					if (Integer.parseInt(dados[7]) == idAgencia) {
						cont++;
					}

				} else {
					break;
				}
			}

		}
		buffRead.close();
		return cont;
	}

	public static void extratoSaldo(Conta conta, double valor) throws IOException {
		DecimalFormat df = new DecimalFormat("0.00");
		String path = conta.getNome() + "_Extrato_Saldo";
		try (BufferedWriter buffWrite = new BufferedWriter(new FileWriter(PATH_BASICO + path + EXTENSAO, true));) {

			String linha = "********** Extrato Saldo **********";
			buffWrite.append(linha + "\n");

			linha = "Nome: " + conta.getNome();
			buffWrite.append(linha + "\n");

			linha = "Agencia: " + conta.getIdAgencia();
			buffWrite.append(linha + "\n");

			linha = "Numero da Conta: " + conta.getNumeroConta();
			buffWrite.append(linha + "\n");

			linha = "Valor: R$ " + df.format(valor);
			buffWrite.append(linha + "\n");

			linha = DataUtil.data();
			buffWrite.append(linha + "\n");

			linha = "********** Fim do Extrato Saldo **********";
			buffWrite.append(linha + "\n");

			buffWrite.close();

		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void relatorioPoupanca(Conta conta, Double quantia, Double rendimento, Double total, int dias)
			throws IOException {
		DecimalFormat df = new DecimalFormat("0.00");
		String path = conta.getNome() + "_Relatorio_Poupanca";
		try (BufferedWriter buffWrite = new BufferedWriter(new FileWriter(PATH_BASICO + path + EXTENSAO, true));) {

			String linha = "********** Relatório de Poupança **********";
			buffWrite.append(linha + "\n");

			linha = "Nome: " + conta.getNome();
			buffWrite.append(linha + "\n");

			linha = "Agencia: " + conta.getIdAgencia();
			buffWrite.append(linha + "\n");

			linha = "Numero da Conta: " + conta.getNumeroConta();
			buffWrite.append(linha + "\n");

			linha = "Valor aplicado: R$ " + df.format(quantia);
			buffWrite.append(linha + "\n");

			linha = "Número de dias: " + dias;
			buffWrite.append(linha + "\n");

			linha = "Valor do rendimento: R$ " + df.format(rendimento);
			buffWrite.append(linha + "\n");

			linha = "Valor total: R$ " + df.format(total);
			buffWrite.append(linha + "\n");

			linha = DataUtil.data();
			buffWrite.append(linha + "\n");

			linha = "********** Fim do Relatório **********";
			buffWrite.append(linha + "\n");

			buffWrite.close();

		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void relatorioPresidente(Funcionario presidente, Double total) throws IOException {
		DecimalFormat df = new DecimalFormat("0.00");
		String path = presidente.getNome() + "_Relatorio_Total_Capital";
		try (BufferedWriter buffWrite = new BufferedWriter(new FileWriter(PATH_BASICO + path + EXTENSAO, true));) {

			String linha = "********** Relatório do Valor Total do Capital **********";
			buffWrite.append(linha + "\n");

			linha = "Nome: " + presidente.getNome();
			buffWrite.append(linha + "\n");

			linha = "Capital total armazenado no banco: R$ " + df.format(total);
			buffWrite.append(linha + "\n");

			linha = DataUtil.data();
			buffWrite.append(linha + "\n");

			linha = "********** Fim do Relatório **********";
			buffWrite.append(linha + "\n");

			buffWrite.close();

		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
//	
//	System.out.println("\n O total de contas na agência " + funcionario.getIdAgencia() + " são: "
//			+ LeituraEscrita.escritorContaAgencia("dados", funcionario.getIdAgencia()));

	public static void relatorioGerente(Funcionario gerente) throws IOException {
		String path = gerente.getNome() + "_Relatorio_Gerente";
		try (BufferedWriter buffWrite = new BufferedWriter(new FileWriter(PATH_BASICO + path + EXTENSAO, true));) {

			String linha = "********** Relatório do Gerente **********";
			buffWrite.append(linha + "\n");

			linha = "Nome: " + gerente.getNome();
			buffWrite.append(linha + "\n");

			linha = "Total de contas na agência " + gerente.getIdAgencia() + ": "
					+ escritorContaAgencia("dados", gerente.getIdAgencia()) + " contas";
			buffWrite.append(linha + "\n");

			linha = DataUtil.data();
			buffWrite.append(linha + "\n");

			linha = "********** Fim do Relatório **********";
			buffWrite.append(linha + "\n");

			buffWrite.close();

		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void relatorioDiretor(Funcionario diretor, List<Cliente> lista) throws IOException {

		String path = diretor.getNome() + "_Relatorio_Clientes";
		try (BufferedWriter buffWrite = new BufferedWriter(new FileWriter(PATH_BASICO + path + EXTENSAO, true));) {

			String linha = "********** Relatório de Clientes **********";
			buffWrite.append(linha + "\n");

			linha = "Nome: " + diretor.getNome();
			buffWrite.append(linha + "\n");

			for (int i = 0; i < lista.size(); i++) {
				buffWrite.append(lista.get(i) + "\n");
			}

			linha = DataUtil.data();
			buffWrite.append(linha + "\n");

			linha = "********** Fim do Relatório **********";
			buffWrite.append(linha + "\n");

			buffWrite.close();

		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}