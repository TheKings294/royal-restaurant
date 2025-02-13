import java.util.HashMap;
import java.util.Map;

public class Navigation {
    public String[] home = {"1. Ajouter un Restaurant", "2. Afficher un Restaurant", "100. Exit"};
    public Map<Integer, Runnable> homeOptions = new HashMap<>() {{
        put(1, () -> sayHello());
        put(2, () -> sayHello());
        put(3, () -> sayHello());
        put(4, () -> sayHello());
        put(5, () -> sayHello());
        put(6, () -> sayHello());
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
}