package meth;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

import static java.util.Collections.sort;
import static meth.XStreamMeth.XMLToObj;

public class Meth {

    public static ArrayList<String> readName(File folder) {
        ArrayList<String> out = new ArrayList<>();
        try {
            for (File element : Objects.requireNonNull(folder.listFiles())) {
                String data = element.getName();
                if (!data.equals("universe")) {
                    out.add(data);
                }
            }

        } catch (Exception e) {
            System.out.println("There are no files");
        }
        return out;
    }

    public static String createFilePath(String path, String name, String end) {

        return path + name + end;
    }

    public static String createFileName(String name) {

        if (name.contains(" ")) {
            StringBuilder out = new StringBuilder();

            String[] splitted = name.split(" ", 0);
            for (String str : splitted) {
                out.append(str);
                out.append("_");
            }

            int index = out.length();
            out.delete(index - 1, index);

            return out.toString();

        } else {
            return name;
        }
    }

    public static String convertName(String name) {
        if (name.contains("_")) {
            StringBuilder out = new StringBuilder();

            String[] splitted = name.split("_", 0);
            for (String str : splitted) {
                out.append(str);
                out.append(" ");
            }

            int index = out.length();
            out.delete(index - 1, index);

            return out.toString();

        } else {
            return name;
        }
    }

    public static String[] createList(String path) {
        File file = new File(path);
        ArrayList<String> names = readName(file);
        ArrayList<String> out = new ArrayList<>();
        for (String element : names) {
            out.add(convertName(removeEnding(element)));
        }
        sort(out);
        return out.toArray(new String[0]);
    }

    public static String[] createList(String path, String item) {
        ArrayList<String> out = new ArrayList<>();
        String[] list = createList(path);
        out.add(item);
        Collections.addAll(out, list);
        sort(out);
        return out.toArray(new String[0]);
    }

    public static ArrayList<String> strToList(String str) {
        ArrayList<String> out = new ArrayList<>();

        String[] splitted = str.split(", ", 0);
        Collections.addAll(out, splitted);
        sort(out);
        return out;
    }

    public static String listToStr(ArrayList<String> list) {
        StringBuilder out = new StringBuilder();

        for (String element : list) {
            out.append(element);
            out.append(", ");
        }

        int index = out.length();
        out.delete(index - 2, index);

        return out.toString();
    }

    public static String removeEnding(String str) {
        return removeDot(str)[0];
    }

    public static String[] removeDot(String str) {
        return str.split("[.]", 0);
    }

    public static boolean checkNumber(String str) {
        if (str.contains(" ")) {
            ArrayList<String> list = strToList(str);
            for (String element : list) {
                return checkNumber(element);
            }

        } else if (str.contains(".")) {
            String[] list = removeDot(str);
            for (String element : list) {
                return checkNumber(element);
            }

        } else {
            return str.matches("[0-9]+");
        }
        return false;
    }

    public static boolean checkDate(String date) {
        String[] splitted = date.split("-");
        for (String str :
                splitted) {
            if (!str.equals("XX") && !str.equals("xx")) {
                return checkNumber(str);
            }
        }
        return false;
    }

    public static Object readFile(File folder, String name) {
        Object obj = new Object();
        for (File element : Objects.requireNonNull(folder.listFiles())) {
            String data = element.getName();
            if (data.equals(name)) {
                obj = XMLToObj(element);
            }
        }
        return obj;
    }

    public static String calculateLen(String num, String len) {
        String lenSea = "";
        if (!num.equals("") && !len.equals("")) {
            int intNum = strToInt(num);
            float floatLen = strToFloat(len);
            float floatGes = floatLen * intNum;
            lenSea = String.valueOf(floatGes);
        }
        return lenSea;
    }

    public static int strToInt(String str) {

        return Integer.parseInt(str);
    }

    public static float strToFloat(String str) {
        return Float.parseFloat(str);
    }
}
