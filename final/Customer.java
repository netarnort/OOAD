import java.util.ArrayList;

public class Customer {

    private ArrayList<Integer> cusIdList = new ArrayList<>();
    private ArrayList<String> cusPhoneNumList = new ArrayList<>();
    private ArrayList<String> cusNameList = new ArrayList<>();
    private ArrayList<String> pointEarnedList = new ArrayList<>();

    public Customer() {
    }

    // Getter Method
    public ArrayList<Integer> getCusID() {
        return cusIdList;
    }

    public ArrayList<String> getCusPhoneNum() {
        return cusPhoneNumList;
    }

    // Updated Getter Method to return name for a specific ID
    public String getCusName(int cusId) {
        int index = cusIdList.indexOf(cusId);
        return (index != -1) ? cusNameList.get(index) : "Customer ID not found";
    }

    public ArrayList<String> getPointEarnedList() {
        return pointEarnedList;
    }

    // Setter Method
    public void addCusID(int newCusID) {
        this.cusIdList.add(newCusID);
    }

    public void addCusPhoneNum(String newCusPhoneNum) {
        this.cusPhoneNumList.add(newCusPhoneNum);
    }

    public void addCusName(String newCusName) {
        this.cusNameList.add(newCusName);
    }

    public void addPointPointEarned(String newPointEarned) {
        this.pointEarnedList.add(newPointEarned);
    }

    // Other Method
    private int lastAssignedId = 0; // Initialize it outside the method

    public void register(String newCusPhoneNum, String newCusName) {
        // Increment the last assigned ID
        lastAssignedId++;

        cusIdList.add(lastAssignedId);
        cusPhoneNumList.add(newCusPhoneNum);
        cusNameList.add(newCusName);
        // Set default points earned to 0
        pointEarnedList.add("0");

        System.out.println("--------------------------------------" );
        System.out.println("Registration successful for " + newCusName);
        System.out.println("--------------------------------------" );
    }

    public boolean login(String enteredCusPhoneNum) {
        return cusPhoneNumList.contains(enteredCusPhoneNum);
    }
}
