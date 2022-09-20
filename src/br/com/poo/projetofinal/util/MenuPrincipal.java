package br.com.poo.projetofinal.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import br.com.poo.projetofinal.contas.Conta;
import br.com.poo.projetofinal.enums.ETipoConta;
import br.com.poo.projetofinal.enums.ETipoFuncionario;
import br.com.poo.projetofinal.funcionario.Funcionario;
import br.com.poo.projetofinal.funcionario.Gerente;
import br.com.poo.projetofinal.pessoas.Cliente;
import br.com.poo.projetofinal.principal.Principal;
import br.com.projetofinal.IO.LeituraEscrita;

public class MenuPrincipal {

	double inputValor;
	static String inputCpf;
	String operacao;

	public static void menuCliente(Cliente cliente, Conta conta) throws IOException {
		Principal principal = new Principal();
		Scanner sc = new Scanner(System.in);

		try {
			System.out.println("[1]\tSaque");
			System.out.println("[2]\tDeposito");
			System.out.println("[3]\tTransferência");
			System.out.println("[4]\tSaldo");
			System.out.println("[5]\tExtrato");
			System.out.println("[6]\tSimulação de Rendimentos");
			System.out.println("[7]\tSair");
			// principal.imprimeLinhaHorizontal();
			System.out.print("Digite a opção desejada: ");
			String opcaoOperacao = Principal.sc.next();
			Double inputValor;

			switch (opcaoOperacao) {
			case "1":
				Principal.imprimeLinhaHorizontal();
				System.out.print("Digite o valor que deseja sacar: ");
				inputValor = Double.parseDouble(Principal.sc.next());
				conta.sacar(inputValor);
				LeituraEscrita.comprovanteSaque(conta, inputValor);
				break;
			case "2":
				Principal.imprimeLinhaHorizontal();
				System.out.print("Digite o valor que deseja depositar: ");
				inputValor = Double.parseDouble(Principal.sc.next());
				conta.depositar(inputValor);
				LeituraEscrita.comprovanteDeposito(conta, inputValor);
				break;
			case "3":
				Principal.imprimeLinhaHorizontal();
				System.out.println("Informe para qual CPF deseja realizar a transferência: ");
				String cpf = sc.nextLine();
				System.out.print("Digite o valor que deseja transferir: ");
				inputValor = Double.parseDouble(Principal.sc.next());
				Conta contaDestino = (Conta) Conta.mapaContas.get(cpf);
				conta.transferir(inputValor, contaDestino);
				LeituraEscrita.comprovanteTransferencia(conta, inputValor);
				break;
			case "4":
				System.out.println();
				System.out.printf("Seu saldo é: R$%.2f", conta.getSaldo());
				System.out.println();
				System.out.println();
				double valor = conta.getSaldo();
				LeituraEscrita.extratoSaldo(conta, valor);
				break;
			case "5":
				conta.imprimirExtrato();
				break;
			case "6":
				if(conta.getTipoConta().equalsIgnoreCase(ETipoConta.POUPANCA.getTipoConta())) {
					System.out.println("Informe a quantia em dinheiro: ");
					Double quantia = sc.nextDouble();
					System.out.println("Informe quantos dias de rendimento: ");
					int dias = sc.nextInt();
					Double rendimento = dias * 0.5;
					Double total = quantia + rendimento;
					System.out.printf("O rendimento de " + dias + " dias é: R$%.2f ", rendimento , "!");
					System.out.println();
					System.out.printf("O rendimento total é: R$%.2f ", total, "!");
					System.out.println();
					Principal.imprimeLinhaHorizontal();
					LeituraEscrita.relatorioPoupanca(conta, quantia, rendimento, total, dias);
				}else {
					System.out.println("A sua conta não possui rendimento!");
					System.out.println();
					Principal.imprimeLinhaHorizontal();
				}
				break;	
			case "7":
				principal.menuInterativo();
				break;
			default:
				System.out.println("Opção inválida!");

				sc.close();
			}
			
			menuCliente(cliente, conta);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			menuCliente(cliente, conta);
		}
	}

	public static void menuFuncionario(Funcionario funcionario, Conta conta) throws IOException {
		Principal principal = new Principal();
		Scanner sc = new Scanner(System.in);

		try {
			if (funcionario.getETipoFuncionario().equals("gerente")) {
				Principal.imprimeLinhaHorizontal();
                System.out.println("\t[1]- Relatório Gerente");
                System.out.println("\t[2]- Sair");
                Principal.imprimeLinhaHorizontal();
                System.out.print("\nDigite a opção desejada: ");
                String opOperacao = sc.next();
                switch (opOperacao) {
                    case "1":
                        String cpf = funcionario.getCpf();
                        Gerente gerente = (Gerente) Gerente.mapaGerentes.get(cpf);
                        limTela();
                        Principal.imprimeLinhaHorizontal();
                        System.out.println("\n O total de contas na agência " + gerente.getIdAgencia()
                                + " são: " + LeituraEscrita.escritorContaAgencia("dados", gerente.getIdAgencia()));
                        menuFuncionario(funcionario, conta);
                        break;
                    case "2":
                        if (conta == null) {
                        	principal.menuInterativo();
                        } else {
                            menuFuncionario(funcionario, conta);
                        }
                        break;
                    default:
                        System.out.println("\nOpção inválida!");
                        menuFuncionario(funcionario, conta);

                }
            } else if (funcionario.getETipoFuncionario().equals("diretor")) {
            	Principal.imprimeLinhaHorizontal();
                System.out.println("\t[1]- Relatório Gerente");
                System.out.println("\t[2]- Relatório  Diretor");
                System.out.println("\t[3]- Sair");
                Principal.imprimeLinhaHorizontal();
                System.out.print("\nDigite a opção desejada: ");
                String opOperacao = sc.next();
                switch (opOperacao) {
                    case "1":
                        System.out.println("Em manutenção");
                        menuFuncionario(funcionario, conta);
                        break;
                    case "2":
                    	limTela();
                        System.out.println("Contas cadastradas no banco");
                        List<Cliente> listaCliente = new ArrayList<Cliente>(Cliente.mapaClientes.values());
                        listaCliente.sort(Comparator.comparing(Cliente::getNome));
                        for (int i = 0; i < listaCliente.size(); i++) {
                            listaCliente.get(i);

                            System.out.println(listaCliente.get(i));
                        }
                        menuFuncionario(funcionario, conta);
                        break;
                    case "3":
                        if (conta == null) {
                        	principal.menuInterativo();
                        } else {
                            menuFuncionario(funcionario, conta);
                        }
                        break;
                    default:
                        System.out.println("\nOpção inválida!");
                        menuFuncionario(funcionario, conta);
                }
            } else if (funcionario.getETipoFuncionario().equals("presidente")) {
            	Principal.imprimeLinhaHorizontal();
                System.out.println("\t[1]- Relatório Gerente");
                System.out.println("\t[2]- Relatório  Diretor");
                System.out.println("\t[3]- Relatório Presidente");
                System.out.println("\t[4]- Sair");
                Principal.imprimeLinhaHorizontal();
                System.out.print("\nDigite a opção desejada: ");
                String opOperacao = sc.next();
                switch (opOperacao) {
                    case "1":
                        System.out.println("Em manutenção");
                        menuFuncionario(funcionario, conta);
                        break;
                    case "2":
                    	limTela();
                        System.out.println("Contas cadastradas no banco: ");
                        List<Cliente> listaCliente = new ArrayList<Cliente>(Cliente.mapaClientes.values());
                        listaCliente.sort(Comparator.comparing(Cliente::getNome));
                        for (int i = 0; i < listaCliente.size(); i++) {
                            listaCliente.get(i);

                            System.out.println(listaCliente.get(i));
                        }
                        menuFuncionario(funcionario, conta);
                        break;
                    case "3":
                    	limTela();
                        double total = 0;
                        for (Conta c : Conta.mapaContas.values()) {
                            total = total + c.getSaldo();
                        }

                        System.out.printf("Capital total armazenado no banco: R$ %.2f", total);
                        System.out.println();
                        menuFuncionario(funcionario, conta);
                        break;
                    case "4":
                        if (conta == null) {
                        	principal.menuInterativo();
                        } else {
                            menuFuncionario(funcionario, conta);
                        }
                        break;
                    default:
                        System.out.println("\nOpção inválida!");
                        menuFuncionario(funcionario, conta);
                        
                        sc.close();
                }
            }
		}
             catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			menuFuncionario(funcionario, conta);
		}
	}

	public static void apresentacao() {

		try {
			System.out.println("************************************");
			Thread.sleep(500);
			System.out.println("***********   Bem Vindo   **********");
			Thread.sleep(500);
			System.out.println("***********    G4 Bank    **********");
			Thread.sleep(500);
			System.out.println("************************************");
			Thread.sleep(500);
			System.out.println("****  Iluminando o Seu Futuro!  ****");
			Thread.sleep(500);
			System.out.println("************************************");
			Thread.sleep(2000);
			limTela();
		} catch (Exception e) {//

			// catching the exception
			System.out.println(e);
		}

	}

	public static void limTela() {
		for (int i = 0; i < 15; i++) {
			System.out.println();
		}
	}

}