import java.util.ArrayList;

public class Restaurant {
    public static int number = 0;
    private int id;
    private String name;
    private String address;
    private ArrayList<Menu> menus = new ArrayList<>();
    private ArrayList<Order> orders = new ArrayList<>();
    private ArrayList<Employe> employs = new ArrayList<>();

    public Restaurant(String name, String address, Menu menu, Employe employ) {
        this.name = name;
        this.address = address;

        menus.add(menu);
        employs.add(employ);
    }
    public void addOrder(Order order) {
        orders.add(order);
    }
    public ArrayList<Order> getOrders() {
        return orders;
    }
    public void addEmployee(Employe employee) {
        employs.add(employee);
    }
    public void removeEmployee(Employe employee) {
        employs.remove(employee);
    }

}
