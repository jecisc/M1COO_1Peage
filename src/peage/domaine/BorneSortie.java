package peage.domaine;

import java.util.HashMap;
import java.util.Map;

import peage.factory.Distributeur;


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
	
	public Distributeur distributeur(){
		return Autoroute.current().distributeur;
	}
	
	public void addPrice(String city, Integer price ){
		this.prix.put(city, price);
	}
	
	public Boolean checkTicket(String ticket){
		return this.distributeur().isValidTicket(ticket);
	}
	
	public void removeTicket(String ticket){
		this.distributeur().removeTicket(ticket);
	}
	
	public Integer priceFor(String city){
		return this.prix.get(city);
	}

}
