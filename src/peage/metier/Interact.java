package peage.metier;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

public class Interact implements PeageAction {

	protected Map<String, String> commandes;

	protected final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public Interact() {

	}

	public void action() throws IOException {
		//TODO This string should be generated from the content of the HashMap.
		System.out.print("--> entrée (e) ou sortie (s) ou quitter (q) :");
		String commande = this.br.readLine().trim();

		try {
			PeageAction action = (PeageAction) Class.forName(this.commandes.get(commande)).newInstance();
			action.action();
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			this.action();
		}

	}

	public void setCommandeWith(Map<String, String> map) {
		map.put("e", "peage.metier.Entrer");
		map.put("s", "peage.metier.Sortir");
		map.put("q", "peage.metier.Quitter");
		this.commandes = map;
	}
}
