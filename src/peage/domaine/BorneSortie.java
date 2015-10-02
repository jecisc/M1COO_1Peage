package peage.domaine;

import java.util.Map;


public class BorneSortie extends AbstractBorne {

	protected Map<String, Integer> prix;

	public BorneSortie(String city, Map<String, Integer> prix) {
		super(city);
		this.prix = prix;
	}

}
