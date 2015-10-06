package peage.domaine;

import java.util.HashMap;
import java.util.Map;


public class BorneSortie extends AbstractBorne {

	protected Map<String, Integer> prix;

	public BorneSortie(String city){
		super(city);
		this.prix=new HashMap<String, Integer>();
	}
	
	public BorneSortie(String city, Map<String, Integer> prix) {
		super(city);
		this.prix = prix;
	}
	
	public void addPrice(String city, Integer price ){
		this.prix.put(city, price);
	}

}
