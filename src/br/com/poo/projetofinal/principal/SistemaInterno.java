package br.com.poo.projetofinal.principal;

import java.io.IOException;

import br.com.poo.projetofinal.util.MenuPrincipal;
import br.com.projetofinal.IO.LeituraEscrita;

public class SistemaInterno {

	/*public static void main(String[] args) throws IOException {
		
		LeituraEscrita.leitor("dados");
		
		Menu.apresentacao();
		Menu.menuInicial();
		Menu.limTela();
	}*/

	public static void main(String[] args) throws IOException {
		MenuPrincipal.apresentacao();
		LeituraEscrita.leitor("dados");

		Principal principal = new Principal();
		principal.menuInterativo();
}

}


