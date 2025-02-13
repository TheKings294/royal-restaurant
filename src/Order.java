import java.util.ArrayList;
import java.util.Collections;

public class Order {
    public int id;
    public ArrayList<Dishes> dishesList = new ArrayList<Dishes>();
    public double totalPrice;

    public Order(int id, Dishes[] dishes) {
        Collections.addAll(dishesList, dishes);
        this.totalPrice = dishesList.stream()
                .mapToDouble(dish ->Double.parseDouble(dish.getPrice()))
                .sum();
    }
}