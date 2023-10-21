import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Order {

    // Attribute
    private int orderId;
    private static List<Order> orders = new ArrayList<>();
    private String status;
    private String type;

    // Composition
    private Chef chef;
    private Table table;
    private List<Menu> orderMenu;
    private List<Detail> orderMenuOptions;
    private List<Detail> orderMenuOptions1;
    private List<Detail> orderMenuOptions2;

    // Constructor
    public Order(int orderId, List<Menu> orderMenu, List<Detail> orderMenuOptions1,
            List<Detail> orderMenuOptions2, Table table, Chef chef, String customerName,
            String status, String type) {
        this.orderId = orderId;
        this.table = table;
        this.orderMenu = (orderMenu != null) ? new ArrayList<>(orderMenu) : new ArrayList<>();
        this.orderMenuOptions1 = (orderMenuOptions1 != null) ? new ArrayList<>(orderMenuOptions1) : new ArrayList<>();
        this.orderMenuOptions2 = (orderMenuOptions2 != null) ? new ArrayList<>(orderMenuOptions2) : new ArrayList<>();
        this.chef = chef;
        this.status = status;
        this.type = type;
    }

    // Getter Methods
    public int getOrderId() {
        return orderId;
    }

    public int getTableNum() {
        return table.getTableNum();
    }

    public String getTableName() {
        return table.getTableName();
    }

    public List<Menu> getOrderMenu() {
        return new ArrayList<>(orderMenu);
    }

    public List<Detail> getOrderMenuOptions() {
        return new ArrayList<>(orderMenuOptions);
    }

    public static List<Order> getOrders() {
        return new ArrayList<>(orders);
    }

    public Chef getChef() {
        return chef;
    }

    public String getStatus() {
        return status;
    }

    public String getType() {
        return type;
    }

    public void showOrderDetail() {
        if ("cash".equals(type)) {
            System.out.println("-----------------------");
            System.out.println("");
            System.out.println("Order ID: " + orderId);

            // Check if the order is for dine-in or takeout
            if (table.getTableNum() == 0 || table.getTableName().isEmpty()) {
                System.out.println("");
                System.out.println("Take out");
                System.out.println("Customer Name: " + table.getTableName());
                System.out.println("");
            } else {
                System.out.println("");
                System.out.println("Table Number: " + table.getTableNum());
                System.out.println("Customer Name: " + table.getTableName());
                System.out.println("");
            }

            // Display ordered menu, menu options 1, and menu options 2
            for (int i = 0; i < Math.min(Math.min(orderMenu.size(), orderMenuOptions1.size()),
                    orderMenuOptions2.size()); i++) {
                Menu menu = orderMenu.get(i);
                Detail menuOption1 = orderMenuOptions1.get(i);
                Detail menuOption2 = orderMenuOptions2.get(i);

                int totalPrice = (int) (menu.getMenuPrice() + menuOption1.getMenuOptionPrice()
                        + menuOption2.getMenuOptionPrice());

                System.out.println((i + 1) + ". " + menu.getMenuName() +
                        " - " + (int) menu.getMenuPrice() +
                        " / " + menuOption1.getMenuOptionName() +
                        " - " + (int) menuOption1.getMenuOptionPrice() +
                        " / " + menuOption2.getMenuOptionName() +
                        " - " + (int) menuOption2.getMenuOptionPrice() +
                        "  Total Price: " + totalPrice + " bath");
            }

            // Display chef's name
            // System.out.println("Chef: " + chef.getChefName());

            // Calculate and display total order price
            calculateTotalPrice();

        } else if ("point".equals(type)) {
            System.out.println("-----------------------");
            System.out.println("");
            System.out.println("Order ID: " + orderId);

            // Check if the order is for dine-in or takeout
            if (table.getTableNum() == 0 || table.getTableName().isEmpty()) {
                System.out.println("");
                System.out.println("Take out");
                System.out.println("Customer Name: " + table.getTableName());
                System.out.println("");
            } else {
                System.out.println("");
                System.out.println("Table Number: " + table.getTableNum());
                System.out.println("Customer Name: " + table.getTableName());
                System.out.println("");
            }

            // Display ordered menu, menu options 1, and menu options 2
            for (int i = 0; i < Math.min(Math.min(orderMenu.size(), orderMenuOptions1.size()),
                    orderMenuOptions2.size()); i++) {
                Menu menu = orderMenu.get(i);
                Detail menuOption1 = orderMenuOptions1.get(i);
                Detail menuOption2 = orderMenuOptions2.get(i);

                System.out.println((i + 1) + ". " + menu.getMenuName() +
                        " - " + "0" +
                        " / " + menuOption1.getMenuOptionName() +
                        " - " + "0" +
                        " / " + menuOption2.getMenuOptionName() +
                        " - " + "0" +
                        "  Total Price: 0 bath");
            }

            // Display chef's name
            // System.out.println("Chef: " + chef.getChefName());

            // Calculate and display total order price
            calculateTotalPriceForPoints();
        } else {
            System.out.println("Invalid order status.");
        }
    }

    // Setter Method

    public void addOrderId(int orderId) {
        this.orderId = orderId;
    }

    public void addTable(Table table) {
        this.table = table;
    }

    public void addOrderMenu(List<Menu> orderMenu) {
        this.orderMenu = new ArrayList<>(orderMenu);
    }

    public void addOrderMenuOptions(List<Detail> orderMenuOptions) {
        this.orderMenuOptions = new ArrayList<>(orderMenuOptions);
    }

    public void addChef(Chef chef) {
        this.chef = chef;
    }

    public void addStatus(String status) {
        this.status = status;
    }

    public void addType(String type) {
        this.type = type;
    }

    // Other methods

    public static Order createOrder(List<Menu> orderMenu, List<Detail> orderMenuOptions1,
            List<Detail> orderMenuOptions2, Table table, Chef chef, String customerName) {
        int orderId = generateRandomOrderId();

        // System.out.println("Order ID: " + orderId);
        // System.out.println("");
        // System.out.println("Table Number: " + table.getTableNum());
        // System.out.println("");
        // System.out.println("Customer Name: " + table.getTableName());
        // System.out.println("");

        // // Display ordered menu items
        // System.out.println("Ordered Menu Items:");
        // for (Menu menu : orderMenu) {
        // System.out.println("- " + menu.getMenuName() + " - " + menu.getMenuPrice());
        // }

        // // Display ordered menu options 1
        // System.out.println("Ordered Menu Options 1:");
        // for (MenuOption menuOption : orderMenuOptions1) {
        // System.out.println("- " + menuOption.getMenuOptionName() + " - " +
        // menuOption.getMenuOptionPrice());
        // }

        // // Display ordered menu options 2
        // System.out.println("Ordered Menu Options 2:");
        // for (MenuOption menuOption : orderMenuOptions2) {
        // System.out.println("- " + menuOption.getMenuOptionName() + " - " +
        // menuOption.getMenuOptionPrice());
        // }

        // // Display chef's name
        // System.out.println("Chef: " + chef.getChefName());

        Order order = new Order(orderId, orderMenu, orderMenuOptions1, orderMenuOptions2, table, chef, customerName,
                "Cooking", "cash");
        orders.add(order);

        return order;
    }

    public static Order createOrderForPoints(List<Menu> orderMenu, List<Detail> orderMenuOptions1,
            List<Detail> orderMenuOptions2, Table table, Chef chef, String customerName) {

        int orderId = generateRandomOrderId();

        Order order = new Order(orderId, orderMenu, orderMenuOptions1, orderMenuOptions2, table, chef, customerName,
                "Cooking", "cash");
        orders.add(order);

        return order;
    }

    public void calculateTotalPrice() {
        int total = 0;

        // Calculate total order price
        for (int i = 0; i < Math.min(Math.min(orderMenu.size(), orderMenuOptions1.size()),
                orderMenuOptions2.size()); i++) {
            Menu menu = orderMenu.get(i);
            Detail menuOption1 = orderMenuOptions1.get(i);
            Detail menuOption2 = orderMenuOptions2.get(i);

            int totalPrice = menu.getMenuPrice() + menuOption1.getMenuOptionPrice()
                    + menuOption2.getMenuOptionPrice();

            total += totalPrice;
        }

        // Display total order price
        System.out.println("\nTotal Price for order: " + (int) total + " bath");
    }

    public void calculateTotalPriceForPoints() {

        // Display total order price
        System.out.println("\nTotal Price for order: Points ");
    }

    private static int generateRandomOrderId() {
        Random random = new Random();
        return random.nextInt(100000); // You can adjust the range as needed
    }

   
}
