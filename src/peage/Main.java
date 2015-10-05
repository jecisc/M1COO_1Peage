package peage;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import peage.metier.Interact;

public class Main {

	public Map<String, Integer> placesPricesAssociation(String finishPlace) {
		Map<String, Integer> placesPrices = new HashMap<String, Integer>();
		String ligne, startPlace;
		int price;

		try {
			String fichier = "/home/m1mfafc/rousseaua/workspace/TP1/src/fic/prices.txt";
			InputStream ips = new FileInputStream(fichier);
			InputStreamReader ipsr = new InputStreamReader(ips);
			BufferedReader br = new BufferedReader(ipsr);
			while ((ligne = br.readLine()) != null) {
				if (ligne.split(" ")[1].equals(finishPlace)) {
					startPlace = ligne.split(" ")[0];
					price = Integer.parseInt(ligne.split(" ")[2]);
					placesPrices.put(startPlace, price);
				}
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return placesPrices;
	}

	public static void main(String[] args) throws IOException {
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
