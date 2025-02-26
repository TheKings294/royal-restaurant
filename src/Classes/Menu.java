package Classes;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

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
            File file = new File(path + "/"+ name + ".json");
            BufferedWriter buf = new BufferedWriter(new FileWriter(file));
            buf.append("{" +
                    "\"name\":\"" + this.name + "\"," +
                    "\"date\":\"" + this.dateOfCreation.toString() + "\"," +
                    "\"menuType\":\"" + this.menuType + "\"" +
                    "}");
            buf.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}