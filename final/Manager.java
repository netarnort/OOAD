public class Manager extends Staff {

    // Attribute
    private int otPayment;
    
    // Constructor
    Manager(String ID, String username, String password) {
        super(ID,username, password);
        
    }

    public String getChefName() {
        return getUsername();  
    }

    public int getOtPayment() {
        return otPayment;
    }
}
    


