import java.util.Scanner;

public class CustomerSys {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // instance of the class
        Customer customer = new Customer();

        // Example
        customer.addCusID(12);
        customer.addCusName("Mark Khomsan");
        customer.addCusPhoneNum("0616768126");
        customer.addPointPointEarned("12");

        // Example 2
        customer.addCusID(13);
        customer.addCusName("Jame");
        customer.addCusPhoneNum("061");
        customer.addPointPointEarned("12");

        int choice;

        do {
            // Menu
            System.out.println("\nAomNgoen Restaurant:");
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("0. Exit");
            System.out.print("Your option: ");

            // Get user choice
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Perform a login check
                    System.out.println("\nLogin:");
                    System.out.print("Please enter your phone number: ");
                    String enteredCusPhoneNum = scanner.next(); // Store as String

                    int index = customer.getCusPhoneNum().indexOf(enteredCusPhoneNum);

                    if (index != -1) {
                        int cusId = customer.getCusID().get(index);
                        System.out.println("Welcome " + customer.getCusName(cusId));
                    } else {
                        System.out.println("Please check your information");
                    }
                    break;

                case 2:
                    // Register a new customer
                    System.out.println("\nRegistration:");

                    System.out.print("Enter your phone number: ");
                    String newCusPhoneNum = scanner.next(); // Store as String

                    System.out.print("Enter your name: ");
                    String newCusName = scanner.next();

                    // Call the register method with the new customer information
                    customer.register(newCusPhoneNum, newCusName);
                    break;

                case 0:
                    System.out.println("Thanks for coming ^ ^");
                    break;
            }

        } while (choice != 0);

        scanner.close();
    }
}
