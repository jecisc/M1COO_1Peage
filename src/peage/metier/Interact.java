package peage.metier;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Map;

public class Interact implements PeageAction {

	protected Map<String, String> commandes;

	public Interact() {

	}

	public void action(BufferedReader br) throws IOException {
		//TODO This string should be generated from the content of the HashMap to be able to plug new commands.
		System.out.print("--> entrée (e) ou sortie (s) ou quitter (q) :");
		String commande = br.readLine().trim();
		try {
			PeageAction action = (PeageAction) Class.forName(this.commandes.get(commande)).newInstance();
			action.action(br);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			this.action(br);
		}

	}

	public void setCommandeWith(Map<String, String> map) {
		map.put("e", "peage.metier.Entrer");
		map.put("s", "peage.metier.Sortir");
		map.put("q", "peage.metier.Quitter");
		this.commandes = map;
	}
}
