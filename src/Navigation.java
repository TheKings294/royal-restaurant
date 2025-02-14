import java.util.*;
import java.io.File;
import java.time.LocalDate;
import java.util.concurrent.atomic.AtomicInteger;

public class Navigation {
    public String[] home = {
            "1. Ajouter un Restaurant",
            "2. Ajouter un employé à un restaurant",
            "3. Ajouter un plat au menu d'un restaurant",
            "4. Supprimer un employé d'un restaurant",
            "5. Afficher les employés d'un restaurant",
            "6. Prendre une commande pour un restaurant",
            "7. Afficher toutes les commandes d'un restaurant",
            "8. Sauvegarder les commandes d'un restaurant",
            "9. Charger les commandes d'un restaurant",
            "100. Exit"};
    public Map<Integer, Runnable> homeOptions = new HashMap<>() {{
        put(1, () -> createRestaurant());
        put(2, () -> sayHello());
        put(3, () -> sayHello());
        put(4, () -> sayHello());
        put(5, () -> sayHello());
        put(6, () -> sayHello());
        put(7, () -> sayHello());
        put(8, () -> sayHello());
        put(9, () -> sayHello());
    }};

    public void printTab(String[] nav) {
        for (int i = 0; i < nav.length; i++) {
            System.out.println(nav[i]);
        }
    }
    public void choose(Map<Integer, Runnable> options, int option) {
        if (options.containsKey(option)) {
            options.get(option).run();
        } else {
            System.out.println("Veuillez saisir un option");
        }
    }
    private void sayHello() {
        System.out.println("🔭Hello World!🔭");
    }
    private void createRestaurant() {
        Scanner scanner = new Scanner(System.in);

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
        System.out.println("Enter the category: ");
        String category = scanner.nextLine();
        System.out.println("Enter the size of the menu: ");
        int size = scanner.nextInt();
        LocalDate dateOfCreationDish = LocalDate.now();
        boolean status = true;
        System.out.println("Enter the num of ingredients: ");
        int ingredients = scanner.nextInt();

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

        Dishes dishes = new Dishes(dishName, dishDescription, price, calories, category, size, dateOfCreationDish,
                status, ingrediants, kitchenType, preparationTime, specialPrice);

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

        Employe employe = new Employe(employeeFirstName, employeeLastName, employeeRole, dateOfCreationEmployee,
                employeeSalary);

        Menu menu = new Menu(menuName, dateOfCreation, menuType, dishes);

        Restaurant newRestaurant = new Restaurant(name, address, menu, employe);

        String path  = newRestaurant.createRestaurantDirectory();
        newRestaurant.createFileRestaurant(path);
        menu.createDirMenus(path);

        AtomicInteger i = new AtomicInteger(0);
        newRestaurant.getMenus().forEach(menuI -> {
            String menuIName = Integer.toString(i.incrementAndGet());
            String newPath = menuI.createDirPerMenus(path, menuIName);
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
        this.printTab(this.home);
    }
}