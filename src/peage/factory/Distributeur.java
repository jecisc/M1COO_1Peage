package peage.factory;

public class Distributeur{

    protected int numTicket;

    private static Distributeur INSTANCE = new Distributeur();
 
    public static Distributeur current()
    {
        return INSTANCE;
    }
    
    private Distributeur(){
        this.numTicket = 0;
    }
}
