package br.com.poo.projetofinal.util;

import java.io.IOException;

// import br.com.poo.modelo.enums.PessoaEnum;
import br.com.poo.projetofinal.contas.Conta;
import br.com.poo.projetofinal.funcionario.Funcionario;
import br.com.poo.projetofinal.pessoas.Cliente;
import br.com.poo.projetofinal.principal.Principal;
import br.com.projetofinal.IO.LeituraEscrita;

public class MenuPrincipal {

	double inputValor;
	static String inputCpf;
	int operacao;

	public static void menuCliente(Cliente cliente, Conta conta) throws IOException {
		Principal principal = new Principal();

		try {
			System.out.println("[1]\tSaque");
			System.out.println("[2]\tDeposito");
			System.out.println("[3]\tTransferência");
			System.out.println("[4]\tSaldo");
			System.out.println("[5]\tRelatório");
			System.out.println("[6]\tSair");
			// principal.imprimeLinhaHorizontal();
			System.out.print("Digite a opção desejada: ");
			int opcaoOperacao = Principal.sc.nextInt();
			Double inputValor;

			switch (opcaoOperacao) {
			case 1:
				Principal.imprimeLinhaHorizontal();
				System.out.print("Digite o valor que deseja sacar: ");
				inputValor = Double.parseDouble(Principal.sc.next());
				conta.sacar(inputValor);
				// LeituraEscrita.comprovanteSaque(conta, inputValor);
				break;
			case 2:
				Principal.imprimeLinhaHorizontal();
				System.out.print("Digite o valor que deseja depositar: ");
				inputValor = Double.parseDouble(Principal.sc.next());
				conta.depositar(inputValor);
				break;
			case 3:
				Principal.imprimeLinhaHorizontal();
				System.out.print("Digite o valor que deseja transferir: ");
				inputValor = Double.parseDouble(Principal.sc.next());
			//	conta.transferir(inputValor, conta);
				break;
			case 4:
				System.out.println();
				System.out.printf("Seu saldo é: R$%.2f", conta.getSaldo());
				System.out.println();
				System.out.println();
				// LeituraEscrita.comprovanteSaldo(conta);
				break;
			case 5:
				// if
				// (funcionario.getTipoFuncionario().equalsIgnoreCase(PessoaEnum.GERENTE.getTipoPessoa()))
				// {
				// MenuRelatorio.menuRelatorio(PessoaEnum.GERENTE.getIdTipoPessoa(),
				// funcionario, conta);
				// } else if
				// (funcionario.getTipoFuncionario().equalsIgnoreCase(PessoaEnum.DIRETOR.getTipoPessoa()))
				// {
				// MenuRelatorio.menuRelatorio(PessoaEnum.DIRETOR.getIdTipoPessoa(),
				// funcionario, conta);
				// }
				break;
			case 6:
				principal.menuInterativo();
				break;
			default:
				System.out.println("Opção inválida!");
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

		try {
			System.out.println("[1]\tRelatório");
			System.out.println("[2]\tSair");
			// principal.imprimeLinhaHorizontal();
			System.out.print("Digite a opção desejada: ");
			int opcaoOperacao = Principal.sc.nextInt();
			Double inputValor;

			switch (opcaoOperacao) {
			case 1:
				Principal.imprimeLinhaHorizontal();
				System.out.print("Bem vindo aos relatórios!\n");
				// LeituraEscrita.comprovanteSaque(conta, inputValor);
				break;
			case 2:
				Principal.imprimeLinhaHorizontal();
				System.out.print("Agradecemos por utilizar nosso sistema!\n");
				principal.menuInterativo();
				break;
			default:
				System.out.println("Opção inválida!\n");
			}

			menuFuncionario(funcionario, conta);

		} catch (Exception e) {
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
