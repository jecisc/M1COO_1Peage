package peage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import peage.metier.PeageAction;

public class Main {
/*
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
*/
	public static Map<String, String> commandHandler(Map<String, String> map) {
		map.put("e", "Entrer");
		map.put("s", "Sortir");
		map.put("q", "Quitter");
		return map;
	}
	
	public static void waitAction(Map<String, String> commandes, BufferedReader br) throws IOException, InstantiationException, IllegalAccessException{
		System.out.print("--> entrée (e) ou sortie (s) ou quitter (q) :");
		String classe = commandes.get(br.readLine().trim());
		try {
			((PeageAction) Class.forName(classe).newInstance()).action();
		} catch (ClassNotFoundException e) {
			Main.waitAction(commandes, br);
		}
	}

	public static void main(String[] args) throws IOException, InstantiationException, IllegalAccessException {
		Map<String, String> commandes = Main.commandHandler(new HashMap<String, String>());
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Main.waitAction(commandes, br);
		/*
		System.out.print("    --> nom de l'entrée : ");
		System.out.print("    --> nom de la sortie : ");
		System.out.print("    --> votre ticket : ");
		System.out.print("    --> le prix à payer est de ");
		System.out.print("    --> votre ticket est ");
*/
	}

}
