public class Chef extends Staff {

    // Attribute
    private String expert;

    // Constructor
    Chef(String ID, String username, String password) {
        super(ID, username, password);
    }

    public String getChefName() {
        return getUsername();  
    }

    public String getExpertise() {
        return expert;
    }
}
