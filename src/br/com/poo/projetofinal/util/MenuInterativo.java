package br.com.poo.projetofinal.util;

import java.util.Scanner;

public class MenuInterativo {
	static Scanner sc = new Scanner(System.in);
	
	public static void menuCliente() {
		int opcao;
		
		System.out.println("Informe a operação que deseja realizar: ");
		System.out.println("[1] Movimentações da conta");
		System.out.println("[2] Relatórios");
		System.out.println("[3] Sair");
		
		opcao = sc.nextInt();
		
		switch(opcao) {
		case 1:
		//	movimentacao(); //puxar método movimentacao
			System.out.println("Estou entrando na movimentação");
			break;
		case 2:
		//	relatorios(); //puxar método relatórios
			System.out.println("Estou realizando extratos.");
			break;
		case 3:
			Menu.menuInicial();
			break;
	}
	
	}
}
