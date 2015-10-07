package peage.domaine;

public class Ticket{

    protected String code;
    
    protected static final String DELIMITER = "::";

    public Ticket(String city, Integer number){
	    this.code = city + Ticket.DELIMITER + number.toString();
    }
    
    public String toString(){
    	return this.code;
    }
    
    public static String delimiter(){
    	return Ticket.DELIMITER;
    }
    
}
