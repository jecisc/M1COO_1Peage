package peage.domaine;

import java.util.HashMap;


public class BorneSortie extends AbstractBorne {

	protected HashMap<String, Integer> prix;

	public BorneSortie(String city, HashMap<String, Integer> prix) {
		super(city);
		this.prix = prix;
	}

}
