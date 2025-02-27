package Commands;

import java.util.Scanner;
import java.time.LocalDate;
import java.util.concurrent.atomic.AtomicInteger;
import Classes.*;

public class AddRestaurant extends Command {
    private Scanner scanner;

    public AddRestaurant(Scanner scanner) {
        this.scanner = scanner;
    }
    @Override
    public String getLabel() {
        return "Ajouter un Restaurant";
    }
    @Override
    public void execute() {
        scanner.skip("\n");
        System.out.println("=======Restaurant Creation========");
        System.out.println("Enter restaurant name: ");
        String name = scanner.nextLine();
        System.out.println("Enter restaurant address: ");
        String address = scanner.nextLine();

        System.out.println("=======Menu Creation========");
        System.out.println("Enter the menu name");
        String menuName = scanner.nextLine();

        LocalDate dateOfCreation = LocalDate.now();
        System.out.println("Enter the menu type :");
        String menuType = scanner.nextLine();



        System.out.println("=======Dishe Creation========");
        System.out.println("Enter the dishe name: ");
        String dishName = scanner.nextLine();
        System.out.println("Enter an description: ");
        String dishDescription = scanner.nextLine();
        System.out.println("Enter the price of the dish: ");
        double price = scanner.nextDouble();
        System.out.println("Enter the calories of the dish: ");
        int calories = scanner.nextInt();
        scanner.skip("\n");
        System.out.println("Enter the category: ");
        String category = scanner.nextLine();
        System.out.println("Enter the size of the menu: ");
        int size = scanner.nextInt();
        LocalDate dateOfCreationDish = LocalDate.now();
        boolean status = true;
        System.out.println("Enter the num of ingredients: ");
        int ingredients = scanner.nextInt();
        scanner.skip("\n");

        String[] ingrediants = new String[ingredients];

        for (int i = 0; i < ingredients; i++) {
            System.out.println("Ingredient " + (i + 1) + ": ");
            ingrediants[i] = scanner.nextLine();
        }
        System.out.println("Enter the kitchen type: ");
        String kitchenType = scanner.nextLine();
        System.out.println("Enter the preparation time: ");
        int preparationTime = scanner.nextInt();
        System.out.println("Enter the special price: ");
        int specialPrice = scanner.nextInt();
        scanner.skip("\n");

        System.out.println("========Employe Creation========");
        System.out.println("Enter the employee first name: ");
        String employeeFirstName = scanner.nextLine();
        System.out.println("Enter the employee last name: ");
        String employeeLastName = scanner.nextLine();
        System.out.println("Enter the employee role :");
        String employeeRole = scanner.nextLine();
        System.out.println("Enter the employee salary: ");
        double employeeSalary = scanner.nextDouble();
        LocalDate dateOfCreationEmployee = LocalDate.now();

        Dishes dish = new Dishes(dishName, dishDescription, price, calories, category, size, dateOfCreationDish,
                status, ingrediants, kitchenType, preparationTime, specialPrice);
        Menu menu = new Menu(menuName, dateOfCreation, menuType, dish);
        Employe employe = new Employe(employeeFirstName, employeeLastName, employeeRole, dateOfCreationEmployee,
                employeeSalary);
        Restaurant newRestaurant = new Restaurant(name, address, menu, employe);
        String path = newRestaurant.createRestaurantDirectory();
        newRestaurant.createFileRestaurant(path);
        menu.createDirMenus(path);

        AtomicInteger i = new AtomicInteger(0);
        newRestaurant.getMenus().forEach(menuI -> {
            String menuIName = Integer.toString(i.get());
            String newPath = menuI.createDirPerMenus(path, menuIName);
            System.out.println(path);
            menuI.createFileMenu(newPath, "info");
            String dirDishes = Dishes.createDir(newPath);
            menuI.getDishes().forEach(d -> {
                d.createFileDishes(dirDishes, Integer.toString(i.incrementAndGet()));
            });
        });

        String pathemployee = Employe.createDir(path);
        AtomicInteger j = new AtomicInteger(0);

        newRestaurant.getEmploys().forEach(e -> {
            e.createFileEmploye(pathemployee, Integer.toString(j.incrementAndGet()));
        });

        System.out.println("🎇 you create a restaurant: 🎇");
    }
}