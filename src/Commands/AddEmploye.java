package Commands;

import Classes.Employe;
import Classes.Restaurant;
import Database.Database;

import java.io.File;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.Scanner;

public class AddEmploye extends Command {
    Database db;
    public AddEmploye(Database db) {
        this.db = db;
    }
    @Override
    public String getLabel() {
        return "Add Employee";
    }
    @Override
    public void execute() {
        Scanner sc = new Scanner(System.in);
        db.getRestaurants().forEach(restaurant -> {
            System.out.println(restaurant.getInfoRestaurant());
        });
        System.out.println("Choissisez le restaurant");
        int id = sc.nextInt();
        sc.skip("\n");

        System.out.println("=========Employe creation========");
        System.out.println("Prenom de l'emplyer :");
        String name = sc.nextLine();
        System.out.println("Nom de l'emplyer :");
        String lastName = sc.nextLine();
        System.out.println("Role de l'emplyer :");
        String role = sc.nextLine();
        System.out.println("Salaire de l'emplyer :");
        double salary = sc.nextDouble();

        Employe emp = new Employe(name, lastName, role, LocalDate.now(), salary);
        File dir = new File(Paths.get("").toAbsolutePath().toString() + "/database/restaurant_" + id + "/employe");
        File[] files = dir.listFiles();
        emp.createFileEmploye(Paths.get("").toAbsolutePath().toString() + "/database/restaurant_" + id + "/employe", Integer.toString(files.length + 1));
        Restaurant r = db.getRestaurant(id);
        r.addEmployee(emp);
    }
}