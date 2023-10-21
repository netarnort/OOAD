import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;
import java.util.Random;

public class StaffSys {

    private static int generateRandomOrderId() {
        Random random = new Random();
        return random.nextInt(100000);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // instance of the class

        Staff staff = new Staff(null, null, null);
        Customer customer = new Customer();
        Chef chef = new Chef(null, null, null, null);
        Manager manager = new Manager(null, null, null);
        Bill bill = new Bill(null, null, customer, staff);
        Table table = new Table(0, null);
        Order order = new Order(0, null, null, null, table, chef, null, null, null);

        // Example Customer
        customer.addCusID(12);
        customer.addCusName("Patipol kaeomuang");
        customer.addCusPhoneNum("012");
        customer.addPointEarned(12);

        // Example Staff
        staff.addID("1");
        staff.addName("nitiphum");
        staff.addPassword("1234");

        // Example Chef
        chef.addChefID("2");
        chef.addChefName("sarawut");
        chef.addChefPassword("1234");
        chef.addExpertise("ThaiFood");

        // Example Manager
        manager.addManagerID("3");
        manager.addManagerName("pasit");
        manager.addManagerPassword("1234");
        manager.addOtPayment(1500);

        // Example Order
        order.addOrderId(generateRandomOrderId());
        table.setTableNum(1);
        table.setTableName("Fill");
        Menu[] menus = new Menu[1];
        menus[0] = new Menu(1, "Egg Fried Rice", 30);
        Detail[] Meats = new Detail[1];
        Meats[0] = new Detail(1, "Chicken", 10);
        Detail[] Toppings = new Detail[1];
        Toppings[0] = new Detail(1, "Fried Egg", 5);
        order.addStatus("Cooking");
        order.addType("cash");

        // Example Order (Points)
        // order.addOrderId(generateRandomOrderId());
        // table.setTableNum(1);
        // table.setTableName("Fill");
        // Menu[] menus = new Menu[1];
        // menus[0] = new Menu(1, "Egg Fried Rice", 30);
        // Detail[] Meats = new Detail[1];
        // Meats[0] = new Detail(1, "Chicken", 10);
        // Detail[] Toppings = new Detail[1];
        // Toppings[0] = new Detail(1, "Fried Egg", 5);
        // order.addStatus("Cooking");
        // order.addType("point");

        // // Example Order 2
        // order.addOrderId(generateRandomOrderId());
        // table.setTableNum(1);
        // table.setTableName("Fill");
        // Menu[] menus = new Menu[2];
        // menus[0] = new Menu(1, "Egg Fried Rice", 30);
        // menus[1] = new Menu(2, "Stir-fried Holy Basil", 30);
        // Detail[] Meats = new Detail[2];
        // Meats[0] = new Detail(1, "Chicken", 10);
        // Meats[1] = new Detail(2, "Minced Pork", 10);
        // Detail[] Toppings = new Detail[2];
        // Toppings[0] = new Detail(1, "Fried Egg", 5);
        // Toppings[1] = new Detail(2, "Omelette", 5);
        // order.addStatus("Cooking");
        // order.addType("cash");

        // Code Login User
        while (true) {
            // Interface Login User
            System.out.println("=============================");
            System.out.println("| AomNgoen Restaurant User  |");
            System.out.println("=============================");
            System.out.println("1. Chef");
            System.out.println("2. Staff");
            System.out.println("3. Manager");
            System.out.println("0. Exit");
            System.out.println("-----------------------------");
            System.out.print("Your option: ");

            // Get user choice type staff
            int choice = scanner.nextInt();

            // Login Chef
            if (choice == 1) {
                System.out.print("Username : ");
                String username = scanner.next();
                System.out.print("Password : ");
                String password = scanner.next();
                System.out.println();

                boolean x = chef.login(username, password);
                if (x == true) {

                    // Interface Chef
                    while (true) {
                        System.out.println("=============================");
                        System.out.println("|   Welcome    " + chef.getChefName() + "      |");
                        System.out.println("=============================");
                        System.out.println("\n1. AcceptOrdering" + "\n0. Logout");
                        System.out.println("-----------------------------");
                        System.out.print("What will you do? ");
                        int chef_do = scanner.nextInt();

                        if (chef_do == 0) {
                            break;
                        } else if (chef_do == 1) {
                            // Show order
                            System.out
                                    .println("--------------------------------------------------------------------\n");
                            System.out.println("Table number " + table.getTableNum());
                            System.out.println("Ordered by " + customer.getCusName(12));
                            for (int i = 0; i < Math.min(Math.min(menus.length, Meats.length), Toppings.length); i++) {
                                System.out.println(
                                        menus[i].getMenuName() + " / " + Meats[i].getMenuOptionName() + " / "
                                                + Toppings[i].getMenuOptionName());

                                if (!"point".equalsIgnoreCase(order.getType())) {
                                    System.out.println(
                                            "Price: " + (menus[i].getMenuPrice() + Meats[i].getMenuOptionPrice()
                                                    + Toppings[i].getMenuOptionPrice()));
                                } else {
                                    System.out.println("Price: Points");
                                }
                            }

                            System.out.println("");
                            System.out
                                    .println("--------------------------------------------------------------------\n");

                            System.out.print("Have you accept this order (Y/N) ? ");
                            String AcceptOrder = scanner.next();

                            if (AcceptOrder.equalsIgnoreCase("y")) {

                                // Show Status Order
                                System.out.println(
                                        "___________________________________________________________________\n");
                                System.out.println("Table number " + table.getTableName());
                                System.out.println("Ordered by " + customer.getCusName(12));

                                for (int i = 0; i < Math.min(Math.min(menus.length, Meats.length),
                                        Toppings.length); i++) {
                                    System.out.println(
                                            menus[i].getMenuName() + " / " + Meats[i].getMenuOptionName() + " / "
                                                    + Toppings[i].getMenuOptionName());

                                    if (!"point".equalsIgnoreCase(order.getType())) {
                                        System.out.println(
                                                "Price: " + (menus[i].getMenuPrice() + Meats[i].getMenuOptionPrice()
                                                        + Toppings[i].getMenuOptionPrice()));
                                    } else {
                                        System.out.println("Price: Points");
                                    }
                                }

                                System.out.println(
                                        "__________________________________________________________________\n");
                                System.out.println(order.getStatus());
                                System.out.println(
                                        "__________________________________________________________________\n");

                                System.out.print("Have you ready for send this order (Y/N) ?");

                                String EndOrder = scanner.next();
                                if (EndOrder.equalsIgnoreCase("y")) {
                                    order.addStatus("Finished cooking");
                                    System.out.println("");
                                    System.out.println("Order sended");
                                    System.out.println();
                                } else {
                                    System.out.println("");
                                    System.out.println("Order not send");
                                    System.out.println();
                                }
                            } else {
                                System.out.println();
                            }
                        }

                    }
                }

                // Login Staff
            } else if (choice == 2) {
                System.out.print("Username : ");
                String username = scanner.next();
                System.out.print("Password : ");
                String password = scanner.next();
                System.out.println();

                boolean x = staff.login(username, password);
                if (x == true) {

                    // Interface Staff
                    while (true) {
                        System.out.println("=============================");
                        System.out.println("|   Welcome    " + staff.getUsername() + "     |");
                        System.out.println("=============================");
                        System.out.println("\n1. AcceptOrdering" + "\n0. Logout");
                        System.out.println("-----------------------------");
                        System.out.print("What will you do? ");
                        int staff_do = scanner.nextInt();

                        if (staff_do == 0) {
                            break;
                        } else if (staff_do == 1) {

                            // ShowOrder

                            System.out
                                    .println("--------------------------------------------------------------------\n");
                            System.out.println("Table number " + table.getTableNum());
                            System.out.println("Ordered by " + customer.getCusName(12));
                            for (int i = 0; i < Math.min(Math.min(menus.length, Meats.length), Toppings.length); i++) {
                                System.out.println(
                                        menus[i].getMenuName() + " / " + Meats[i].getMenuOptionName() + " / "
                                                + Toppings[i].getMenuOptionName());

                                if (!"point".equalsIgnoreCase(order.getType())) {
                                    System.out.println(
                                            "Price: " + (menus[i].getMenuPrice() + Meats[i].getMenuOptionPrice()
                                                    + Toppings[i].getMenuOptionPrice()));
                                } else {
                                    System.out.println("Price: 0");
                                }
                            }

                            System.out.println("Status : " + order.getStatus());
                            System.out.println("");
                            System.out
                                    .println("--------------------------------------------------------------------\n");

                            System.out.print("Have you completed this order (Y/N) ? ");
                            String CheckOrderPreparing = scanner.next();

                            if (CheckOrderPreparing.equalsIgnoreCase("y")) {

                                // ShowBill
                                String timeStamp = new SimpleDateFormat("yyyy/MM/dd  HH:mm:ss")
                                        .format(Calendar.getInstance().getTime());
                                bill.setBillDate(timeStamp);
                                System.out.println(
                                        "\n----------------------------- AomNgoen Restaurant Bill -------------------------");
                                System.out.println(bill.getBillDate()
                                        + "                                            (VAT Include)");
                                System.out.println();

                                int totalPrice = 0;

                                for (int i = 0; i < Math.min(Math.min(menus.length, Meats.length),
                                        Toppings.length); i++) {
                                    System.out.printf("%-60s%10s Bath\n", menus[i].getMenuName(),
                                            menus[i].getMenuPrice());
                                    System.out.printf("%-60s%10s Bath\n", Meats[i].getMenuOptionName(),
                                            Meats[i].getMenuOptionPrice());
                                    System.out.printf("%-60s%10s Bath\n", Toppings[i].getMenuOptionName(),
                                            Toppings[i].getMenuOptionPrice());

                                    totalPrice += menus[i].getMenuPrice() + Meats[i].getMenuOptionPrice()
                                            + Toppings[i].getMenuOptionPrice();
                                }

                                if ("point".equalsIgnoreCase(order.getType())) {
                                    totalPrice = 0;

                                    System.out.println();
                                    System.out.println();

                                    System.out.println(
                                            "________________________________________________________________________________\n");
                                    System.out.printf("%-60s%10s Bath\n", "Total price", totalPrice);
                                    System.out.println(
                                            "________________________________________________________________________________\n");
                                    System.out.println(
                                            "--------------------------------------------------------------------------------\n");
                                } else {
                                    System.out.println();
                                    System.out.println();

                                    System.out.println(
                                            "________________________________________________________________________________\n");
                                    System.out.printf("%-60s%10s Bath\n", "Total price", totalPrice);
                                    System.out.println(
                                            "________________________________________________________________________________\n");
                                    System.out.println(
                                            "--------------------------------------------------------------------------------\n");
                                }

                                System.out.print("You want to print bill ? (Y/N) ? ");
                                String choose = scanner.next();
                                if (choose.equalsIgnoreCase("y")) {
                                    System.out.println("");
                                    System.out.println("Bill printed");
                                    System.out.println();
                                } else if (choose.equalsIgnoreCase("n")) {
                                    System.out.println("");
                                    System.out.println("Bill not print");
                                    System.out.println();
                                } else {
                                    System.out.println();
                                }

                            } else {
                                System.out.println("Please try again");
                            }
                        }
                    }
                }

                // Login Manager
            } else if (choice == 3) {
                System.out.print("Username : ");
                String username = scanner.next();
                System.out.print("Password : ");
                String password = scanner.next();
                System.out.println();

                boolean x = manager.login(username, password);
                if (x == true) {

                    // Interface Manager
                    while (true) {
                        System.out.println("=============================");
                        System.out.println("|   Welcome    " + manager.getManagerName() + "        |");
                        System.out.println("=============================");
                        System.out.println("\n1. ConfirmOrdering" + "\n0. Logout");
                        System.out.println("-----------------------------");
                        System.out.print("What will you do? ");
                        int manager_do = scanner.nextInt();

                        if (manager_do == 0) {
                            break;
                        } else if (manager_do == 1) {

                            System.out.println(
                                    "--------------------------------------------------------------------");
                            System.out.println("");
                            System.out.println("Table number " + table.getTableNum());
                            System.out.println("Ordered by " + customer.getCusName(12));
                            for (int i = 0; i < Math.min(Math.min(menus.length, Meats.length), Toppings.length); i++) {
                                System.out.println(
                                        menus[i].getMenuName() + " / " + Meats[i].getMenuOptionName() + " / "
                                                + Toppings[i].getMenuOptionName());

                                if (!"point".equalsIgnoreCase(order.getType())) {
                                    System.out.println(
                                            "Price: " + (menus[i].getMenuPrice() + Meats[i].getMenuOptionPrice()
                                                    + Toppings[i].getMenuOptionPrice()));
                                } else {
                                    System.out.println("Price: 0");
                                }
                            }

                            System.out.println("");
                            System.out.println(
                                    "--------------------------------------------------------------------\n");

                            System.out.print("Have you success this order (Y/N) ? ");
                            String SuccessOrder = scanner.next();

                            if (SuccessOrder.equalsIgnoreCase("y")) {
                                System.out.println("");
                                System.out.println("Order successfully ");
                                System.out.println();
                            } else {
                                System.out.println("");
                                System.out.println("Order not success");
                                System.out.println();
                            }
                        }
                    }
                }
            } else if (choice == 0) {
                System.out.println("============================");
                System.out.println("| Thanks for your efforts. |");
                System.out.println("============================");
                break;
            }

        }

        scanner.close();

    }
}
