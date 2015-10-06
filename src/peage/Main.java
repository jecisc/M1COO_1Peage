package peage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

import peage.domaine.Autoroute;
import peage.metier.Interact;

public class Main {

	public static void main(String[] args) throws IOException {
		Autoroute.current();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Interact interaction = (new Interact());
		interaction.setCommandeWith(new HashMap<String, String>());
		interaction.action(br);
		/*
		 * System.out.print( "    --> votre ticket : "); System.out.print(
		 * "    --> le prix à payer est de "); System.out.print(
		 * "    --> votre ticket est ");
		 */
	}

}
