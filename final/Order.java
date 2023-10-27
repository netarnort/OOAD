import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Order {

    // Attribute
    private int orderId;
    private static List<Order> orders = new ArrayList<>();
    private String status;
    private String type;
    private String orderMode;

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
            String status, String type, String orderMode) {
        this.orderId = orderId;
        this.table = table;
        this.orderMenu = (orderMenu != null) ? new ArrayList<>(orderMenu) : new ArrayList<>();
        this.orderMenuOptions1 = (orderMenuOptions1 != null) ? new ArrayList<>(orderMenuOptions1) : new ArrayList<>();
        this.orderMenuOptions2 = (orderMenuOptions2 != null) ? new ArrayList<>(orderMenuOptions2) : new ArrayList<>();
        this.chef = chef;
        this.status = status;
        this.type = type;
        this.orderMode = orderMode;
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

    public String getOrderMode() {
        return orderMode;
    }

    public void showOrderDetail() {
        System.out.println("");

        // Check the order mode
        if ("Dine-in".equals(orderMode)) {
            System.out.println("Dine-in");
            System.out.println("Table Number: " + table.getTableNum());
        } else if ("Take-out".equals(orderMode)) {
            System.out.println("Take-out");
        } else if ("Dive-in".equals(orderMode) && "point".equals(type)) {
            System.out.println("Dive-in");
        } else if ("Take-out".equals(orderMode) && "point".equals(type)) {
            System.out.println("Take-out");
        } else {
            System.out.println("Invalid order mode.");
            return;
        }

        System.out.println("Customer Name: " + table.getTableName());
        System.out.println("");

        // Display ordered menu, menu options 1, and menu options 2
        for (int i = 0; i < Math.min(Math.min(orderMenu.size(), orderMenuOptions1.size()),
                orderMenuOptions2.size()); i++) {
            Menu menu = orderMenu.get(i);
            Detail menuOption1 = orderMenuOptions1.get(i);
            Detail menuOption2 = orderMenuOptions2.get(i);

            // Check if menuOption1 is "/"
            String menuOption1Name = "/".equals(menuOption1.getMenuOptionName()) ? "" : menuOption1.getMenuOptionName();
            int menuOption1Price = "/".equals(menuOption1.getMenuOptionName()) ? 0
                    : (int) menuOption1.getMenuOptionPrice();

            // Check if menuOption2 is "/"
            String menuOption2Name = "/".equals(menuOption2.getMenuOptionName()) ? "" : menuOption2.getMenuOptionName();
            int menuOption2Price = "/".equals(menuOption2.getMenuOptionName()) ? 0
                    : (int) menuOption2.getMenuOptionPrice();

            int totalPrice = (int) (menu.getMenuPrice() + menuOption1Price + menuOption2Price);

            // Display all prices (cash or points)
            int menuPrice = (int) menu.getMenuPrice();
            int menuOption1PriceAll = (int) menuOption1.getMenuOptionPrice();
            int menuOption2PriceAll = (int) menuOption2.getMenuOptionPrice();

            System.out.println((i + 1) + ". " + menu.getMenuName() +
                    " - " + menuPrice +
                    " / " + menuOption1Name +
                    " - " + menuOption1PriceAll +
                    " / " + menuOption2Name +
                    " - " + menuOption2PriceAll +
                    "  Total Price: " + (totalPrice > 0 ? totalPrice + " bath" : "/"));
        }

        // Calculate and display total order price
        if ("cash".equals(type)) {
            calculateTotalPrice();
        } else if ("point".equals(type)) {
            System.out.println("\nTotal Price for order: Points");
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

    public void addOrderMode(String orderMode) {
        this.orderMode = orderMode;
    }

    // Other methods

    public static Order createOrderDiveIn(List<Menu> orderMenu, List<Detail> orderMenuOptions1,
            List<Detail> orderMenuOptions2, Table table, Chef chef, String customerName) {
        int orderId = generateRandomOrderId();

        Order order = new Order(orderId, orderMenu, orderMenuOptions1, orderMenuOptions2, table, chef, customerName,
                "Cooking", "cash", "Dine-in");
        orders.add(order);

        return order;
    }

    public static Order createOrderTakeOut(List<Menu> orderMenu, List<Detail> orderMenuOptions1,
            List<Detail> orderMenuOptions2, Table table, Chef chef, String customerName) {
        int orderId = generateRandomOrderId();

        Order order = new Order(orderId, orderMenu, orderMenuOptions1, orderMenuOptions2, table, chef, customerName,
                "Cooking", "cash", "Take-out");
        orders.add(order);

        return order;
    }

    public static Order createOrderForPointsDiveIn(List<Menu> orderMenu, List<Detail> orderMenuOptions1,
            List<Detail> orderMenuOptions2, Table table, Chef chef, String customerName) {

        int orderId = generateRandomOrderId();

        Order order = new Order(orderId, orderMenu, orderMenuOptions1, orderMenuOptions2, table, chef, customerName,
                "Cooking", "point", "Take-out");
        orders.add(order);

        return order;
    }

    public static Order createOrderForPointsTakeout(List<Menu> orderMenu, List<Detail> orderMenuOptions1,
            List<Detail> orderMenuOptions2, Table table, Chef chef, String customerName) {

        int orderId = generateRandomOrderId();

        Order order = new Order(orderId, orderMenu, orderMenuOptions1, orderMenuOptions2, table, chef, customerName,
                "Cooking", "point", "Take-out");
        orders.add(order);

        return order;
    }

    public void calculateTotalPrice() {
        if ("point".equals(type)) {
            System.out.println("\nTotal Price for order: Points ");
        } else {
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
