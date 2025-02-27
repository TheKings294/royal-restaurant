package Commands;

import Database.Database;

import java.time.LocalDate;
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
        System.out.println("Choissisez le restaurant");
        int id = sc.nextInt();

        System.out.println("======Menus Creation======");
        System.out.println("Nom du menus : ");
        String menu = sc.nextLine();
        System.out.println("Type du menu : ");
        String type = sc.nextLine();

        System.out.println("=======Dishe Creation========");
        System.out.println("Enter the dishe name: ");
        String dishName = sc.nextLine();
        System.out.println("Enter an description: ");
        String dishDescription = sc.nextLine();
        System.out.println("Enter the price of the dish: ");
        double price = sc.nextDouble();
        System.out.println("Enter the calories of the dish: ");
        int calories = sc.nextInt();
        sc.skip("\n");
        System.out.println("Enter the category: ");
        String category = sc.nextLine();
        System.out.println("Enter the size of the menu: ");
        int size = sc.nextInt();
        LocalDate dateOfCreationDish = LocalDate.now();
        boolean status = true;
        System.out.println("Enter the num of ingredients: ");
        int ingredients = sc.nextInt();
        sc.skip("\n");

        String[] ingrediants = new String[ingredients];

        for (int i = 0; i < ingredients; i++) {
            System.out.println("Ingredient " + (i + 1) + ": ");
            ingrediants[i] = sc.nextLine();
        }
        System.out.println("Enter the kitchen type: ");
        String kitchenType = sc.nextLine();
        System.out.println("Enter the preparation time: ");
        int preparationTime = sc.nextInt();
        System.out.println("Enter the special price: ");
        int specialPrice = sc.nextInt();
        sc.skip("\n");

    }
}