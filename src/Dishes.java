import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;

public class Dishes {
    private String name;
    private String description;
    private double price;
    private int calories;
    private String category;
    private int size;
    private LocalDate dateOfAdding;
    private boolean status;
    private String[] ingredients;
    private String kitchenType;
    private int preparationTime;
    private int specialPrice;

    public Dishes(String name, String description, double price, int calories, String category, int size, LocalDate dateOfAdding, boolean status,
                  String[] ingredients, String kitchenType, int preparationTime, int specialPrice) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.calories = calories;
        this.category = category;
        this.size = size;
        this.dateOfAdding = dateOfAdding;
        this.status = status;
        this.ingredients = ingredients;
        this.kitchenType = kitchenType;
        this.preparationTime = preparationTime;
        this.specialPrice = specialPrice;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getPrice() {
        return Double.toString(this.price);
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public String getCalories() {
        return Integer.toString(this.calories);
    }
    public void setCalories(int calories) {
        this.calories = calories;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public String getSize() {
        return Integer.toString(this.size);
    }
    public void setSize(int size) {
        this.size = size;
    }
    public LocalDate getDateOfAdding() {
        return dateOfAdding;
    }
    public void setDateOfAdding(LocalDate dateOfAdding) {
        this.dateOfAdding = dateOfAdding;
    }
    public String isStatus() {
        return Boolean.toString(this.status);
    }
    public void setStatus(boolean status) {
        this.status = status;
    }
    public String[] getIngredients() {
        return ingredients;
    }
    public void setIngredients(String[] ingredients) {
        this.ingredients = ingredients;
    }
    public String getKitchenType() {
        return kitchenType;
    }
    public void setKitchenType(String kitchenType) {
        this.kitchenType = kitchenType;
    }
    public String getPreparationTime() {
        return Integer.toString(this.preparationTime);
    }
    public void setPreparationTime(int preparationTime) {
        this.preparationTime = preparationTime;
    }
    public String getSpecialPrice() {
        return Integer.toString(this.specialPrice);
    }
    public void setSpecialPrice(int specialPrice) {
        this.specialPrice = specialPrice;
    }
    public static String createDir(String path) {
        File dir = new File(path + "/dishes");
        dir.mkdir();
        return dir.getAbsolutePath();
    }
    public void createFileDishes(String path, String name) {
        String ingrediant = "{";
        for (int i = 0; i < this.ingredients.length; i++) {
            ingrediant += this.ingredients[i];
            ingrediant += ",";
        }
        ingrediant += "}";
        try {
            FileWriter fw = new FileWriter(path + "/" + name + ".json");
            fw.write("{"+
                    "\"name\":\"" + this.name + "\","
                    + "\"description\":" + this.description+ "," + "\""
                    + "\"price\":\"" + this.price + "\","
                    + "\"calories\":\"" + this.calories + "\","
                    + "\"category\":\"" + this.category + "\","
                    + "\"size\":\"" + this.size + "\","
                    + "\"dateOfAdding\":\"" + this.dateOfAdding + "\","
                    + "\"status\":\"" + this.status + "\","
                    + "\"kitchenType\":\"" + this.kitchenType + "\","
                    + "\"preparationTime\":\"" + this.preparationTime + "\","
                    + "\"specialPrice\":\"" + this.specialPrice + "\""
                    + "\"ingrediant\":\"" + this.ingredients.toString() + "\""
                    + "}");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}