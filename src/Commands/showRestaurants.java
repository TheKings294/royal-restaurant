package Commands;

import Classes.Restaurant;
import Database.Database;

public class showRestaurants extends Command {
    Database database;
    public showRestaurants(Database bd) {
        this.database = bd;
    }
    @Override
    public String getLabel() {
        return "show restaurants";
    }
    @Override
    public void execute() {
        for (Restaurant r : database.getRestaurants()) {
            System.out.println(r.getInfoRestaurant());
        }
    }
}
