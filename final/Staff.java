public class Staff {

    // Attribute
    private String username;
    private String password;

    // Constructor
    Staff(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Other methods
    public boolean login(String enteredUsername, String enteredPassword) {
        return this.username.equals(enteredUsername) && this.password.equals(enteredPassword);
    }
    
}
