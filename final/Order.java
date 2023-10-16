import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Order {

    // Attribute
    private int orderId;
    private static List<Order> orders = new ArrayList<>();

    // Composition
    private Table table;
    private List<Menu> orderMenu;
    private List<MenuOption> orderMenuOptions;
    private Chef chef;

    // Constructor
    public Order(List<Menu> orderMenu, List<MenuOption> orderMenuOptions, Table table, Chef chef) {
        this.orderId = generateRandomOrderId();
        this.table = table;
        this.orderMenu = new ArrayList<>(orderMenu);
        this.orderMenuOptions = new ArrayList<>(orderMenuOptions);
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
        return new ArrayList<>(orderMenu);  // Return a copy to prevent external modification
    }

    public List<MenuOption> getOrderMenuOptions() {
        return new ArrayList<>(orderMenuOptions);  // Return a copy to prevent external modification
    }

    public Chef getChef() {
        return chef;
    }
    public void showOrderDetail() {
        System.out.println("-----------------------");
        System.out.println("Order ID: " + orderId);
        System.out.println("Table Number: " + table.getTableNum());
        System.out.println("Customer Name: " + table.getTableName());

        // Display ordered menu 
        System.out.println("Ordered Menu Items:");
        for (Menu menu : orderMenu) {
            System.out.println("- " + menu.getMenuName() + " - " + menu.getMenuPrice());
        }
        
        // Display ordered menu options
        System.out.println("Ordered Menu Options:");
        for (MenuOption menuOption : orderMenuOptions) {
            System.out.println("- " + menuOption.getMenuOptionName() + " - " + menuOption.getMenuOptionPrice());
        }
        
        // Display chef's name
        System.out.println("Chef: " + chef.getChefName());
    }

    public static List<Order> getOrders() {
        return new ArrayList<>(orders);  // Return a copy to prevent external modification
    }

    // Other methods

    public static Order createOrder(List<Menu> orderMenu, List<MenuOption> orderMenuOptions, Table table, Chef chef) {
        int orderId = generateRandomOrderId();
    
        System.out.println("Order ID: " + orderId);  // Display the generated order ID
        System.out.println("Table Number: " + table.getTableNum());
        System.out.println("Customer Name: " + table.getTableName());
    
        // Display ordered menu items
        System.out.println("Ordered Menu Items:");
        for (Menu menu : orderMenu) {
            System.out.println("- " + menu.getMenuName() + " - " + menu.getMenuPrice());
        }
    
        // Display ordered menu options
        System.out.println("Ordered Menu Options:");
        for (MenuOption menuOption : orderMenuOptions) {
            System.out.println("- " + menuOption.getMenuOptionName() + " - " + menuOption.getMenuOptionPrice());
        }
    
        // Display chef's name
        System.out.println("Chef: " + chef.getChefName());
    
        // Create and return the order
        Order order = new Order(orderMenu, orderMenuOptions, table, chef);
        orders.add(order);
    
        return order;
    }
    

    public void calculateTotalPrice() {
        // Implement the logic to calculate the total price
    }

    private static int generateRandomOrderId() {
        Random random = new Random();
        return random.nextInt(100000); // You can adjust the range as needed
    }
}
