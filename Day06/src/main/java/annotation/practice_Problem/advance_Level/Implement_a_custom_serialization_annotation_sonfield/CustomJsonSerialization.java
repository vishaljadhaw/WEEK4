package annotation.practice_Problem.advance_Level.Implement_a_custom_serialization_annotation_sonfield;

import com.google.gson.Gson;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface JsonField {
    String name();
}
class User {
    @JsonField(name = "user_name")
    private String name;

    @JsonField(name = "user_age")
    private int age;

    @JsonField(name = "user_email")
    private String email;

    public User(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }
}

class JsonSerializer {
    public static String serialize(Object obj) {
        Map<String, Object> jsonMap = new HashMap<>();

        // Get all fields from the class
        Field[] fields = obj.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true); // Allow access to private fields

            // Check if the field has @JsonField annotation
            if (field.isAnnotationPresent(JsonField.class)) {
                JsonField annotation = field.getAnnotation(JsonField.class);
                String jsonKey = annotation.name(); // Custom key from annotation

                try {
                    Object value = field.get(obj);
                    jsonMap.put(jsonKey, value);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }

        // Convert Map to JSON String (Using Gson for formatting)
        return new Gson().toJson(jsonMap);
    }
}
public class CustomJsonSerialization {
    public static void main(String[] args) {
        User user = new User("Alice", 25, "alice@example.com");

        // Serialize the user object to JSON
        String jsonString = JsonSerializer.serialize(user);
        System.out.println(jsonString);
    }
}
