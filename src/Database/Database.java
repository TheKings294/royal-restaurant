package Database;

import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;

import Classes.Dishes;
import Classes.Employe;
import Classes.Menu;
import Classes.Restaurant;
import java.io.File;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Database {
    private ArrayList<Restaurant> restaurants = new ArrayList<>();
    public Database() {
        File dir = new File(Paths.get("").toAbsolutePath().toString() + "/database/");
        File[] files = dir.listFiles();
        for (File item : files) {
            if (item.isDirectory()) {
                String name = item.getName();
                File menu = new File(dir.getAbsolutePath() + "/" + name + "/menus/");
                File[] menus = menu.listFiles();
                File employs = new File(dir.getAbsolutePath() + "/" + name + "/employe/");
                File[] employes = employs.listFiles();
                ArrayList<Menu> mns = new ArrayList<>();
                ArrayList<Employe> emp = new ArrayList<>();
                for (File menuItem : menus) {
                    if (menuItem.isDirectory()) {
                        File dish = new File(menu.getAbsolutePath() + "/" + menuItem.getName() + "/dishes/");
                        File[] dishes = dish.listFiles();
                        ArrayList<Dishes> dishs = new ArrayList<>();
                        for (File dishItem : dishes) {
                            if (dishItem.isFile()) {
                                StringBuilder content = new StringBuilder();
                                try {
                                    BufferedReader bf = new BufferedReader(new FileReader(dishItem.getAbsolutePath()));

                                    Map<String, String> json = JsonParse(bf.readLine());
                                    String[] ingrediant = json.get("ingrediant").split(";");
                                    dishs.add(new Dishes(json.get("name"), json.get("description"),
                                            Double.parseDouble(json.get("price")),
                                            Integer.parseInt(json.get("calories")),
                                            json.get("category"),
                                            Integer.parseInt(json.get("size")),
                                            LocalDate.parse(json.get("dateOfAdding")),
                                            Boolean.parseBoolean(json.get("status")),
                                            ingrediant, json.get("kitchenType"),
                                            Integer.parseInt(json.get("preparationTime")),
                                            Integer.parseInt(json.get("specialPrice"))));
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                        try {
                            BufferedReader bf = new BufferedReader(new FileReader(menuItem.getAbsolutePath() + "/info.json"));
                            Map<String, String> json = JsonParse(bf.readLine());
                            Menu x = new Menu(json.get("name"), LocalDate.parse(json.get("date")), json.get("menuType"), dishs.get(0));

                            if (dishs.size() > 1) {
                                for (int i = 1; i < dishs.size(); i++) {
                                    x.addDish(dishs.get(i));
                                }
                            }
                            mns.add(x);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
                for (File empl : employes) {
                    if (empl.isFile()) {
                        try {
                            BufferedReader bf = new BufferedReader(new FileReader(empl.getAbsolutePath()));
                            Map<String, String> json = JsonParse(bf.readLine());

                            emp.add(new Employe(json.get("first-name"),
                                    json.get("last-name"),
                                    json.get("role"),
                                    LocalDate.parse(json.get("date")),
                                    Double.parseDouble(json.get("salary"))));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
                try {
                    BufferedReader bf = new BufferedReader(new FileReader(dir.getAbsolutePath() + "/"+ name + "/info.json"));
                    Map<String, String> json = JsonParse(bf.readLine());
                    Restaurant r = new Restaurant(json.get("name"), json.get("address"), mns.get(0), emp.get(0));

                    if(mns.size() > 1) {
                        for (int i = 1; i < mns.size(); i++) {

                        }
                    }
                    if (emp.size() > 1) {
                        for (int i = 1; i < emp.size(); i++) {
                            r.addEmployee(emp.get(i));
                        }
                    }
                    this.restaurants.add(r);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
    private static Map<String, String> JsonParse(String json) {
        Map<String, String> map = new HashMap<>();

        json.trim();
        if (json.startsWith("{") && json.endsWith("}")) {
            json = json.substring(1, json.length() - 1);
        }

        String[] pairs = json.split(",");
        for (String s : pairs) {
            String[] pair = s.split(":");
            String key = pair[0].trim().replaceAll("^\"|\"$","");
            String value = pair[1].trim().replaceAll("^\"|\"$","");

            map.put(key, value);
        }
        return map;
    }
    public ArrayList<Restaurant> getRestaurants() {
        return restaurants;
    }
}