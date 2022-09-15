package br.com.poo.projetofinal.util;
import java.lang.Thread;
import java.util.Scanner;

public class Menu {
	static Scanner sc = new Scanner(System.in);

	public static void menuInicial() {
		int opcao;
		System.out.println("Bem vindo ao G4 Bank!");
		
		System.out.println("Selecione a opção desejada:\n[1] - Login \n[2] - Sair");
		opcao = sc.nextInt();
		
		switch(opcao) {
		case 1:
			autenticar(); //puxar método login
			if (autenticar() == true) {
				System.out.println("Login realizado com sucesso!");
				break;
			} else {
				menuInicial();
			}
				
		case 2:
			//colocar método de saída
			System.out.println("Agradecemos por utilizar nosso app =)");
		//	apresentacao(); //volta para a apresentação do app
			break;
		}
	}	
		public static boolean autenticar() {
			String cpf;
			String senha;
			
			System.out.println("Informe seu CPF: ");
			cpf = sc.next();
			System.out.println("Informe sua senha: ");
			senha = sc.next();
			
			if(cpf.equals("12345") && senha.equals("1234")) {
				System.out.println("Bem vindo, Cliente!");
				MenuInterativo.menuCliente();
				return true;
			} else if (cpf.equals("123456") && senha.equals("1234")) {
				System.out.println("Bem vindo, Gerente!");
				return true;
				//menu gerente
			} else if (cpf.equals("1234567") && senha.equals("1234")) {
				System.out.println("Bem vindo, Diretor!");
				return true;
				//menu diretor
			} else if (cpf.equals("12345678") && senha.equals("1234")) {
				System.out.println("Bem vindo, Presidente");
				return true;
				//menu presidente
			} else if (cpf.equals("123456789") && senha.equals("1234")) {
				System.out.println("Bem vindo, Operador de Caixa");
				return true;
				//menu operador
			} else {
				System.out.println("Usuário não cadastrado!");
				return false;
			//	menuInicial();
			}
		}

		public static void apresentação(){

			try{ 
				System.out.println("************************************");
				Thread.sleep(500);
				System.out.println("*************   Bem Vindo  *********"); 
				Thread.sleep(500);
				System.out.println("***************  G4 bank  **********"); 
				Thread.sleep(500);
				System.out.println("************************************");
				Thread.sleep(500);
				System.out.println("************************************");  
				Thread.sleep(2000);
				limTela();  
			}
			catch (Exception e) {//
					
				// catching the exception
				System.out.println(e);
			}

		}





		public static void limTela() {
            for (int i = 0; i<15;i++){
                System.out.println();
            }
    }

	}



	

