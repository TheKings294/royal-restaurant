import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Navigation navigation = new Navigation();

        for (int i = 0; i < navigation.home.length; i++) {
            System.out.println(navigation.home[i]);
        }
    }
}