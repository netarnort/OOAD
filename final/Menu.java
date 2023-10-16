
public class Menu {

    // Attribute
    private int menu_id;
    private String menu_name;
    private int menu_price;
    private String menu_size;

    // Constructor
    public Menu(int menu_id, String menu_name, int menu_price, String menu_size) {
        this.menu_id = menu_id;
        this.menu_name = menu_name;
        this.menu_price = menu_price;
        this.menu_size = menu_size;
    }

    // Getter Method
    public int getMenuId() {
        return menu_id;
    }

    public String getMenuName() {
        return menu_name;
    }

    public double getMenuPrice() {
        return menu_price;
    }

    public String getMenuSize() {
        return menu_size;
    }

    // Setter Method
    public void setMenuId(int menu_id) {
        this.menu_id = menu_id;
    }

    public void setMenuName(String menu_name) {
        this.menu_name = menu_name;
    }

    public void setMenuPrice(int menu_price) {
        this.menu_price = menu_price;
    }

    public void setMenuSize(String menu_size) {
        this.menu_size = menu_size;
    }

}
