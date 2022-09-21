package br.com.poo.projetofinal.principal;

import java.io.IOException;
import java.util.Scanner;

import br.com.poo.projetofinal.contas.Conta;
import br.com.poo.projetofinal.funcionario.Funcionario;
import br.com.poo.projetofinal.pessoas.Cliente;
import br.com.poo.projetofinal.util.MenuPrincipal;
import br.com.projetofinal.IO.LeituraEscrita;

public class Principal {

	public char operacao;
	public double valor;
	public String inputCpf;
	public String inputSenha;
	public static Scanner sc = new Scanner(System.in);
	MenuPrincipal menuPrincipal = new MenuPrincipal();

	public void loopMenu() {
		boolean manterLoop = true;
		do {
			menuInterativo();
		} while (manterLoop == true);
	}

	@SuppressWarnings("null")
	public void menuInterativo() {
		try {
			imprimeLinhaHorizontal();
			System.out.print("Digite seu CPF: ");
			inputCpf = sc.next();
			System.out.print("Digite sua senha: ");
			inputSenha = sc.next();
			Funcionario funcionario = (Funcionario) Funcionario.mapaFuncionarios.get(inputCpf);
			Cliente cliente = (Cliente) Cliente.mapaClientes.get(inputCpf);
			Conta conta = (Conta) Conta.mapaContas.get(inputCpf);

			if (funcionario == null && cliente == null) {
				if (!(funcionario.getSenha().equals(inputSenha)) || !(cliente.getSenha().equals(inputSenha))) {
					System.out.println("CPF e/ou Senha incorreto(s)\n\n");
					System.out.print("Digite seu CPF: ");
					inputCpf = sc.next();
					System.out.print("Digite sua senha: ");
					inputSenha = sc.next();
					funcionario = (Funcionario) Funcionario.mapaFuncionarios.get(inputCpf);
					conta = (Conta) Conta.mapaContas.get(inputCpf);
				}
			}

			if (funcionario == null) {
				if ((cliente.getSenha().equalsIgnoreCase(inputSenha))
						&& (cliente.getCpf().equalsIgnoreCase(inputCpf))) {
					subMenu(cliente, conta);
				}
			} else {
				if ((funcionario.getSenha().equalsIgnoreCase(inputSenha))
						&& (funcionario.getCpf().equalsIgnoreCase(inputCpf))) {
					subMenu(funcionario, conta);
				}

			}

			imprimeLinhaHorizontal();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			System.out.println("CPF e/ou Senha incorreto(s)\n");
			System.out.println("Tente novamente!!!");
			menuInterativo();
		}
		sc.close();
	}

	// SUBMENU
	public void subMenu(Funcionario funcionario, Conta conta) throws IOException {
		try {
			imprimeLinhaHorizontal();
			System.out.println("Bem-vindo(a) ao seu Banco, " + funcionario.getNome() + "!\n");
			MenuPrincipal.menuFuncionario(funcionario, conta);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			subMenu(funcionario, conta);
		}

		MenuPrincipal.menuFuncionario(funcionario, conta);
	}

	public static void imprimeLinhaHorizontal() {
		System.out.println("--------------------------------------------------");
	}

//SUBMENU
	public void subMenu(Cliente cliente, Conta conta) throws IOException {
		try {
			imprimeLinhaHorizontal();
			System.out.println("Bem-vindo(a) ao seu Banco, " + cliente.getNome() + "!\n");
			MenuPrincipal.menuCliente(cliente, conta);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			subMenu(cliente, conta);
		}
		MenuPrincipal.menuCliente(cliente, conta);
	}

	public static void iniciarLeituraFuncionario() throws IOException {
		LeituraEscrita.leitor("dados.txt");
	}

}