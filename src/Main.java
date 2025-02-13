import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Navigation navigation = new Navigation();
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