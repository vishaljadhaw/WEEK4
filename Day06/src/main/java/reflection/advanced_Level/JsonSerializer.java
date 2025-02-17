package reflection.advanced_Level;

import java.lang.reflect.Field;

public class JsonSerializer {
    public static String toJson(Object obj) {
        if (obj == null) {
            return "null";
        }

        StringBuilder json = new StringBuilder();
        json.append("{");

        Field[] fields = obj.getClass().getDeclaredFields();

        for (int i = 0; i < fields.length; i++) {
            fields[i].setAccessible(true);
            try {
                json.append("\"").append(fields[i].getName()).append("\":");
                Object value = fields[i].get(obj);
                json.append(formatValue(value));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            if (i < fields.length - 1) {
                json.append(", ");
            }
        }

        json.append("}");
        return json.toString();
    }

    private static String formatValue(Object value) {
        if (value == null) {
            return "null";
        } else if (value instanceof String) {
            return "\"" + value + "\"";
        } else if (value instanceof Number || value instanceof Boolean) {
            return value.toString();
        } else {
            return toJson(value); // Recursively convert objects
        }
    }

    public static void main(String[] args) {
        class Person {
            String name = "Alice";
            int age = 30;
            boolean isStudent = false;
        }

        Person person = new Person();
        System.out.println(toJson(person));
    }
}

