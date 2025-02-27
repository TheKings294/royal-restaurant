package Commands;

import Database.Database;

import java.util.Scanner;

public class AddMenus extends Command {
    Database db;
    public AddMenus(Database db) {
        this.db = db;
    }
    @Override
    public String getLabel() {
        return "Add Menu";
    }
    @Override
    public void execute() {
        Scanner sc = new Scanner(System.in);
        db.getRestaurants().forEach(restaurant -> {
            System.out.println(restaurant.getInfoRestaurant());
        });
    }
}
