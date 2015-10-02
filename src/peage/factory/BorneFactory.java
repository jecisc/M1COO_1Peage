package peage.factory;

import java.util.HashMap;

import peage.domaine.BorneEntree;
import peage.domaine.BorneSortie;

public class BorneFactory {

	private static BorneFactory INSTANCE = new BorneFactory();

	public static BorneFactory current() {
		return INSTANCE;
	}

	private BorneFactory() {

	}
	
	public BorneEntree createEnterBorne(String city){
		return  new BorneEntree(city);
	}
	
	public BorneSortie createOutputBorne(String city, HashMap<String, Integer> prix){
		return new BorneSortie(city, prix);
	}
}