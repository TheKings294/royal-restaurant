import java.io.File;
import java.util.Scanner;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Navigation navigation = new Navigation();
        File database = new File(Paths.get("").toAbsolutePath().toString() + "/database");
        database.mkdir();
        navigation.printTab(navigation.home);

        while (true) {
            int choice = scanner.nextInt();
            if (choice == 100) {
                break;
            }
            navigation.choose(navigation.homeOptions, choice);
        }

        scanner.close();
    }
}