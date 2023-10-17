import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Order {

    // Attribute
    private int orderId;
    private static List<Order> orders = new ArrayList<>();
    private List<MenuOption> orderMenuOptions1;
    private List<MenuOption> orderMenuOptions2;

    // Composition
    private Table table;
    private List<Menu> orderMenu;
    private List<MenuOption> orderMenuOptions;
    private Chef chef;

    // Constructor
    public Order(int orderId, List<Menu> orderMenu, List<MenuOption> orderMenuOptions1,
            List<MenuOption> orderMenuOptions2, Table table, Chef chef) {
        this.orderId = orderId;
        this.table = table;
        this.orderMenu = new ArrayList<>(orderMenu);
        this.orderMenuOptions1 = new ArrayList<>(orderMenuOptions1);
        this.orderMenuOptions2 = new ArrayList<>(orderMenuOptions2);
        this.chef = chef;
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

    public List<MenuOption> getOrderMenuOptions() {
        return new ArrayList<>(orderMenuOptions);
    }

    public static List<Order> getOrders() {
        return new ArrayList<>(orders);
    }

    public Chef getChef() {
        return chef;
    }

    public void showOrderDetail() {
        System.out.println("-----------------------");
        System.out.println("Order ID: " + orderId);
        System.out.println("Table Number: " + table.getTableNum());
        System.out.println("Customer Name: " + table.getTableName());

        // Display ordered menu, menu options 1, and menu options 2
        for (int i = 0; i < Math.min(Math.min(orderMenu.size(), orderMenuOptions1.size()),
                orderMenuOptions2.size()); i++) {
            Menu menu = orderMenu.get(i);
            MenuOption menuOption1 = orderMenuOptions1.get(i);
            MenuOption menuOption2 = orderMenuOptions2.get(i);

            System.out.println((i + 1) + ". " + menu.getMenuName() + " - " + menu.getMenuPrice() +
                    " / " + menuOption1.getMenuOptionName() + " - " + menuOption1.getMenuOptionPrice() +
                    " / " + menuOption2.getMenuOptionName() + " - " + menuOption2.getMenuOptionPrice());
        }

        // Display chef's name
        System.out.println("Chef: " + chef.getChefName());

    }

    // Other methods

    public static Order createOrder(List<Menu> orderMenu, List<MenuOption> orderMenuOptions1,
            List<MenuOption> orderMenuOptions2, Table table, Chef chef) {
        int orderId = generateRandomOrderId();

        System.out.println("Order ID: " + orderId);
        System.out.println("Table Number: " + table.getTableNum());
        System.out.println("Customer Name: " + table.getTableName());

        // Display ordered menu items
        System.out.println("Ordered Menu Items:");
        for (Menu menu : orderMenu) {
            System.out.println("- " + menu.getMenuName() + " - " + menu.getMenuPrice());
        }

        // Display ordered menu options 1
        System.out.println("Ordered Menu Options 1:");
        for (MenuOption menuOption : orderMenuOptions1) {
            System.out.println("- " + menuOption.getMenuOptionName() + " - " + menuOption.getMenuOptionPrice());
        }

        // Display ordered menu options 2
        System.out.println("Ordered Menu Options 2:");
        for (MenuOption menuOption : orderMenuOptions2) {
            System.out.println("- " + menuOption.getMenuOptionName() + " - " + menuOption.getMenuOptionPrice());
        }

        // Display chef's name
        System.out.println("Chef: " + chef.getChefName());

        // Create and return the order
        Order order = new Order(orderId, orderMenu, orderMenuOptions1, orderMenuOptions2, table, chef);
        orders.add(order);

        return order;
    }

    public void calculateTotalPrice() {

    }

    private static int generateRandomOrderId() {
        Random random = new Random();
        return random.nextInt(100000); // You can adjust the range as needed
    }
}
