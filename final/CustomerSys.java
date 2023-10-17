import java.util.ArrayList;
import java.util.Scanner;

public class CustomerSys {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // instance of the class
        Customer customer = new Customer();
        Table table = new Table(0, null);
        Chef chef = new Chef("112", "Sarawut", null);

        // Menu
        Menu[] menus = new Menu[4];
        menus[0] = new Menu(1, "Egg Fried Rice", 30, "Regular");
        menus[1] = new Menu(2, "Stir-fried Holy Basil", 30, "Regular");
        menus[2] = new Menu(3, "Stir-fried Curry Paste", 30, "Regular");
        menus[3] = new Menu(4, "Stir-fried Garlic", 30, "Regular");

        // Menu Option 1
        MenuOption[] Meats = new MenuOption[5];
        Meats[0] = new MenuOption(1, "Chicken", 10);
        Meats[1] = new MenuOption(2, "Minced Pork", 10);
        Meats[2] = new MenuOption(3, "Beef", 15);
        Meats[3] = new MenuOption(4, "Crispy Pork", 15);
        Meats[4] = new MenuOption(5, "Seafood", 15);

        // Menu Option 2
        MenuOption[] Toppings = new MenuOption[4];
        Toppings[0] = new MenuOption(1, "Fried Egg", 5);
        Toppings[1] = new MenuOption(2, "Omelette", 5);
        Toppings[2] = new MenuOption(3, "Deep-fried Pork Tenderloin", 5);
        Toppings[3] = new MenuOption(4, "Special", 5);

        // Example Chef

        // Example Customer
        customer.addCusID(13);
        customer.addCusName("Patipol kaeomuang");
        customer.addCusPhoneNum("012");
        customer.addPointPointEarned("12");

        int choicePage1;

        do {
            // Menu Page1
            System.out.println("=======================");
            System.out.println("| AomNgoen Restaurant |");
            System.out.println("=======================");
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("0. Exit");
            System.out.println("-----------------------");
            System.out.print("Your option: ");

            
            // Get user choice
            choicePage1 = scanner.nextInt();

            switch (choicePage1) {
                case 1:
                    // Perform a login check
                    System.out.println("=========");
                    System.out.println("| Login |");
                    System.out.println("=========");
                    System.out.print("Please enter your phone number: ");
                    String enteredCusPhoneNum = scanner.next(); // Store as String

                    int index = customer.getCusPhoneNum().indexOf(enteredCusPhoneNum);

                    if (index != -1) {
                        int cusId = customer.getCusID().get(index);
                        System.out.println("=========================");
                        System.out.println("Welcome " + customer.getCusName(cusId));
                        System.out.println("=========================");

                        int choicePage2;

                        do {
                            // Menu Page1
                            System.out.println("1. Add Order");
                            System.out.println("2. Check Order");
                            System.out.println("0. Logout");
                            System.out.println("-----------------------");
                            System.out.print("Your option: ");

                            // Get user choice after login
                            choicePage2 = scanner.nextInt();

                            switch (choicePage2) {
                                case 1:
                                    // Add Order
                                    System.out.println("Adding Order");

                                    int orderPage;

                                    do {
                                        System.out.println("=========================");
                                        System.out.println("Dine in or Take out");
                                        System.out.println("=========================");
                                        System.out.println("1. Dine in");
                                        System.out.println("2. Take out");
                                        System.out.println("0. Back ");
                                        System.out.println("-----------------------");
                                        System.out.print("Your option: ");
                                        orderPage = scanner.nextInt();

                                        switch (orderPage) {
                                            case 1:
                                                System.out.println("========");
                                                System.out.println("Dine in");
                                                System.out.println("========");

                                                // Get table number
                                                System.out.print("Enter table number: ");
                                                int tableNumber = scanner.nextInt();
                                                table.setTableNum(tableNumber);

                                                // Get customer name
                                                System.out.print("Enter your name: ");
                                                String customerName = scanner.next();
                                                table.setTableName(customerName);

                                                // Declare variables for order information
                                                ArrayList<Menu> selectedMenus = new ArrayList<>();
                                                ArrayList<MenuOption> selectedMenuOptions = new ArrayList<>();
                                                ArrayList<MenuOption> selectedMenuOptions2 = new ArrayList<>();

                                                // Menu selection
                                                int menuChoice;

                                                do {
                                                    // Display Menu
                                                    System.out.println("====");
                                                    System.out.println("Menu");
                                                    System.out.println("====");
                                                    for (int i = 0; i < menus.length; i++) {
                                                        System.out.println((i + 1) + ". " + menus[i].getMenuName()
                                                                + " - " + menus[i].getMenuPrice());
                                                    }
                                                    System.out.println("0. Done with ordering");
                                                    System.out.println("------------------------------");
                                                    System.out.print("Select Menu (enter menu number): ");
                                                    menuChoice = scanner.nextInt();

                                                    if (menuChoice >= 1 && menuChoice <= menus.length) {
                                                        selectedMenus.add(menus[menuChoice - 1]);
                                                        System.out
                                                                .println("Added " + menus[menuChoice - 1].getMenuName()
                                                                        + " to your order.");

                                                        // Display Menu Options 1
                                                        int menuOptionChoice;
                                                        System.out.println("================");
                                                        System.out.println("Menu Options 1");
                                                        System.out.println("================");

                                                        // Display the menu options for the selected main menu
                                                        for (int i = 0; i < Meats.length; i++) {
                                                            System.out.println(
                                                                    (i + 1) + ". " + Meats[i].getMenuOptionName()
                                                                            + " - " + Meats[i].getMenuOptionPrice());
                                                        }

                                                        System.out.println("0. Done with menu options");
                                                        System.out.println("------------------------------");
                                                        System.out.print("Select Menu Option (enter option number): ");
                                                        menuOptionChoice = scanner.nextInt();

                                                        if (menuOptionChoice >= 1 && menuOptionChoice <= Meats.length) {
                                                            selectedMenuOptions.add(Meats[menuOptionChoice - 1]);
                                                            System.out.println("Added "
                                                                    + Meats[menuOptionChoice - 1].getMenuOptionName()
                                                                    + " to your order.");
                                                        } else if (menuOptionChoice != 0) {
                                                            System.out.println("Please try again.");
                                                        }

                                                        // Display Menu Options 2
                                                        int menuOptionChoice2;
                                                        System.out.println("================");
                                                        System.out.println("Menu Options 2");
                                                        System.out.println("================");

                                                        // Display the menu options for the selected main menu
                                                        for (int i = 0; i < Toppings.length; i++) {
                                                            System.out.println(
                                                                    (i + 1) + ". " + Toppings[i].getMenuOptionName()
                                                                            + " - " + Toppings[i].getMenuOptionPrice());
                                                        }

                                                        System.out.println("0. Done with menu options");
                                                        System.out.println("------------------------------");
                                                        System.out.print("Select Menu Option (enter option number): ");
                                                        menuOptionChoice2 = scanner.nextInt();

                                                        if (menuOptionChoice2 >= 1
                                                                && menuOptionChoice2 <= Toppings.length) {
                                                            selectedMenuOptions2.add(Toppings[menuOptionChoice2 - 1]);
                                                            System.out
                                                                    .println("Added "
                                                                            + Toppings[menuOptionChoice2 - 1]
                                                                                    .getMenuOptionName()
                                                                            + " to your order.");
                                                        } else if (menuOptionChoice2 != 0) {
                                                            System.out.println("Please try again.");
                                                        }
                                                    } else if (menuChoice != 0) {
                                                        System.out.println("Please try again.");
                                                    }

                                                } while (menuChoice != 0);

                                                // After the menu selections
                                                Order createdOrder = Order.createOrder(selectedMenus,
                                                        selectedMenuOptions, selectedMenuOptions2, table, chef);

                                                // Display the order details
                                                createdOrder.showOrderDetail();
                                                System.out.println("Order created successfully!");
                                                break;

                                            case 2:
                                                // Take out
                                                System.out.println("========");
                                                System.out.println("Take out");
                                                System.out.println("========");

                                                break;
                                            case 0:
                                                // Back to main menu
                                                break;
                                            default:
                                                System.out.println("Please try again.");
                                                break;

                                        }
                                    } while (orderPage != 0);

                                    break;

                                case 2:
                                    // Check Orders
                                    System.out.println("===============");
                                    System.out.println("Checking Orders");
                                    System.out.println("===============");

                                    // Display order details for all orders
                                    if (Order.getOrders().isEmpty()) {
                                        System.out.println("No orders available.");
                                    } else {
                                        for (Order existingOrder : Order.getOrders()) {
                                            existingOrder.showOrderDetail();
                                            System.out.println("------------------------");
                                        }
                                    }

                                    break;

                                case 0:
                                    // Back to page1
                                    System.out.println("back");
                                    break;

                                default:
                                    System.out.println("Please try again.");
                                    break;
                            }

                        } while (choicePage2 != 0);
                    } else {
                        System.out.println("Please check your information");
                    }
                    break;

                case 2:
                    // Register a new customer
                    System.out.println("================");
                    System.out.println("| Registration |");
                    System.out.println("================");

                    System.out.print("Enter your phone number: ");
                    String newCusPhoneNum = scanner.next();

                    System.out.print("Enter your name: ");
                    String newCusName = scanner.next();

                    customer.register(newCusPhoneNum, newCusName);
                    break;

                case 0:
                    System.out.println("=========================");
                    System.out.println("| Thanks for coming ^ ^ |");
                    System.out.println("=========================");
                    break;

                default:
                    System.out.println("Please try again.");
            }

        } 
        
        
        while (choicePage1 != 0);

        scanner.close();
    }
}
