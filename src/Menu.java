import java.util.ArrayList;
import java.util.Date;

public class Menu {
    public static int number = 0;
    public String name;
    public Date dateOfCreation;
    public String menuType;
    public ArrayList<Dishes> dishes = new ArrayList<Dishes>();

    public Menu(String name, Date dateOfCreation, String menuType, Dishes dish) {
        this.name = name;
        this.dateOfCreation = dateOfCreation;
        this.menuType = menuType;

        dishes.add(dish);
    }
    public void addDish(Dishes dish) {
        dishes.add(dish);
    }
    public void deleteDish(Dishes dish) {
        dishes.remove(dish);
    }
    public ArrayList<Dishes> getDishes() {
        return dishes;
    }
}
