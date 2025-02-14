import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;

public class Restaurant {
    public static int numberOfRestaurant = 0;
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
    public ArrayList<Menu> getMenus() {
        return menus;
    }
    public ArrayList<Employe> getEmploys() {
        return employs;
    }
    public void addEmployee(Employe employee) {
        employs.add(employee);
    }
    public void removeEmployee(Employe employee) {
        employs.remove(employee);
    }
    public String createRestaurantDirectory() {
        File dir = new File(Paths.get("").toAbsolutePath().toString() + "/database/" + this.id);
        dir.mkdir();
        return dir.getAbsolutePath();
    }
    public void createFileRestaurant(String path) {
        try {
            FileWriter fw = new FileWriter("info.json");
            fw.write("{"+
                    "\"name\":\"" + name + "\","
                    + "\"address\":" + address
                    + "}");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}