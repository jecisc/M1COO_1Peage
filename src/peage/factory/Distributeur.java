package peage.factory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import peage.domaine.Ticket;

public class Distributeur{

    protected Map<String, Integer> compters;
    
    protected ArrayList<Ticket> tickets;
    //I don't like this dark magic ! Singleton are bad :(
    
    /*
    private static Distributeur INSTANCE = new Distributeur();
 
    public static Distributeur current()
    {
        return INSTANCE;
    }
    
    
    private*/ public Distributeur(){
        this.compters = new HashMap<String, Integer>();
        this.tickets = new ArrayList<Ticket>(); 
    }
    
    public Ticket generateTicketFor(String city){
    	if(!this.compters.containsKey(city)){
    		this.compters.put(city, 1);	
    	}
    	
    	Ticket ticket = new Ticket(city, this.compters.get(city));
    	this.compters.put(city, this.compters.get(city) + 1);
    	this.tickets.add(ticket);
    	return ticket;
    }
}
