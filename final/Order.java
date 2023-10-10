import java.util.ArrayList;

public class Order {

    // Attribute
    private int order_id;

    // Composition

    // ถ้าใช้เป็น array list แบบนี้จะมีได้หลายเมนู
    private Table table;
    private ArrayList<Menu> orderMenu;
    private Chef chef;

    // Constructor
    public Order(int order_id, Table table, Chef chef) {
        this.order_id = order_id;
        this.table = table;
        this.orderMenu = new ArrayList<>();
        this.chef = chef;
    }

    // Getter Method
    public int getOrderId() {
        return order_id;
    }

    public int getTableNum() {
        return table.getTableNum();
    }

    public String getTableName() {
        return table.getTableName();
    }

    public ArrayList<Menu> getOrderMenu() {
        return orderMenu;
    }

    public Chef getChef() {
        return chef;
    }

    // Other methods
    public void ShowOrderDetail() {

    }

    public void CalculateTotalprice() {

    }

}
