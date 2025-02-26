package Database;

import java.nio.file.Paths;
import java.util.ArrayList;
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
                for (File menuItem : menus) {
                    if (menuItem.isDirectory()) {
                        File dish = new File(menu.getAbsolutePath() + "/" + menuItem.getName() + "/dishes/");
                        File[] dishes = dish.listFiles();
                        for (File dishItem : dishes) {
                            if (dishItem.isFile()) {
                                StringBuilder content = new StringBuilder();

                                try {
                                    BufferedReader bf = new BufferedReader(new FileReader(dishItem.getAbsolutePath()));

                                    Map<String, String> json = JsonParse(bf.readLine());
                                    System.out.println(json.get("name") + "\n");
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }
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
            String key = pair[0].trim();
            String value = pair[1].trim();

            map.put(key, value);
        }
        return map;
    }
}

//.replaceAll("^\"|\"$","")