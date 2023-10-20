
public class Menu {

    // Attribute
    private int menu_id;
    private String menu_name;
    private int menu_price;
    

    // Constructor
    public Menu(int menu_id, String menu_name, int menu_price) {
        this.menu_id = menu_id;
        this.menu_name = menu_name;
        this.menu_price = menu_price;
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

   
}
