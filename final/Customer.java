import java.util.ArrayList;

public class Customer {
    
    // Attributes
    private ArrayList<Integer> cusPhoneNumList = new ArrayList<>();
    private ArrayList<String> cusNameList = new ArrayList<>();
    private ArrayList<Integer> pointEarnedList = new ArrayList<>();

    // Constructor
    public Customer(int cusPhoneNum, String cusName, int pointEarned){
        this.cusPhoneNumList.add(cusPhoneNum);
        this.cusNameList.add(cusName);
        this.pointEarnedList.add(pointEarned);
    }
    // Getter Methods
    public ArrayList<Integer> getCusPhoneNum() {
        return cusPhoneNumList;
    }

    public ArrayList<String> getCusNameList() {
        return cusNameList;
    }

    public ArrayList<Integer> getPointEarnedList() {
        return pointEarnedList;
    }

    // Setter Method
    public void addCusPhoneNum(int newCusPhoneNum) {
        cusPhoneNumList.add(newCusPhoneNum);
    }

    public void addCusName(String newCusName) {
        cusNameList.add(newCusName);
    }


    // Other methods
    public void register(){
        
    }

    public boolean login(int enteredCusPhoneNum) {
        return cusPhoneNumList.contains(enteredCusPhoneNum);
    }
}
