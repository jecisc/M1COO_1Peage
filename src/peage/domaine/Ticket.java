package peage.domaine;

public class Ticket{

    protected String code;

    public Ticket(String city, Integer number){
	    this.code = city + number.toString();
    }
    
    public String toString(){
    	return this.code;
    }
    
}
