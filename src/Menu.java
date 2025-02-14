import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class Menu {
    public static int number = 0;
    public String name;
    public LocalDate dateOfCreation;
    public String menuType;
    public ArrayList<Dishes> dishes = new ArrayList<Dishes>();

    public Menu(String name, LocalDate dateOfCreation, String menuType, Dishes dish) {
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
    public void createDirMenus(String path) {
        File dir = new File(path + "/menus");
        dir.mkdir();
    }
    public String createDirPerMenus(String path, String name) {
        File dir = new File(path + "/menus/" + name);
        dir.mkdir();
        return dir.getAbsolutePath();
    }
    public void createFileMenu(String path, String name) {
        try {
            FileWriter file = new FileWriter(path + "/menus/" + name + ".json");
            file.write("{"+
                    "\"name\":\"" + name + "\","
                    + "\"date\":" + dateOfCreation.toString() + "," + "\""
                    + "\"menuType\":\"" + menuType + "\","
                    + "}");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
