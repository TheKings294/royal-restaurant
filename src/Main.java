import java.io.File;
import java.util.Scanner;
import java.nio.file.Paths;
import Commands.*;
import Database.Database;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Database db = new Database();
        File database = new File(Paths.get("").toAbsolutePath().toString() + "/database");
        database.mkdir();

        while (true) {
            System.out.println("Classes.Menu :");

            Command[] commands = {
                    new Commands.AddRestaurant(scanner),
                    new Commands.showRestaurants(db),
                    new Commands.AddEmploye(db),
                    new AddMenus(db),
                    new Commands.Quit()
            };

            for (int i = 0; i < commands.length; i++) {
                System.out.println((i + 1) + ". " + commands[i].getLabel());
            }

            int option = chooseOption(scanner);

            if (option < 0 || option >= commands.length) {
                System.out.println("Option inconnue");
                continue;
            }

            commands[option].execute();
        }

        //scanner.close();
    }

    private static int chooseOption(Scanner scanner) {
        try {
            if (scanner.hasNextInt()) {
                return scanner.nextInt() - 1;
            } else {
                scanner.next();
                return -1;
            }
        } catch (Exception e) {
            return -1;
        }
    }
}