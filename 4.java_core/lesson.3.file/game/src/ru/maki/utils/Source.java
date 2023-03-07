package ru.maki.utils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Source {

    public static final String ROOT = "/";
    private static final Map<String, String[]> allSource = new HashMap<>();

    public static Map<String, String[]> getSource() {
        if (allSource.isEmpty()) {
            allSource.put(ROOT, new String[]{"Games"});

            allSource.put("Games", new String[]{"src", "res", "savegames", "temp"});

            allSource.put("src", new String[]{"main", "test"});

            allSource.put("main", new String[]{"Main.java", "Utils.java"});

            allSource.put("res", new String[]{"drawables", "vectors", "icons"});

            allSource.put("temp", new String[]{"temp.txt"});
        }

        return allSource;
    }

    public static void showSource() {
        for (String s : allSource.keySet()) {
            System.out.println(s + " : " + Arrays.toString(allSource.get(s)));
        }
    }

}
