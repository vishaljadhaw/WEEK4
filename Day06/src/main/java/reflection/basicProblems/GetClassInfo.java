package reflection.basicProblems;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Scanner;

public class GetClassInfo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the class name (including package if applicable): ");
        String className = scanner.nextLine();

        try {
            Class<?> cls = Class.forName(className);
            System.out.println("Class: " + cls.getName());

            // Display constructors
            System.out.println("\nConstructors:");
            Constructor<?>[] constructors = cls.getDeclaredConstructors();
            for (Constructor<?> constructor : constructors) {
                System.out.println(constructor);
            }

            // Display fields
            System.out.println("\nFields:");
            Field[] fields = cls.getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);  // Ensure private fields are accessible
                System.out.println(field);
            }

            // Display methods
            System.out.println("\nMethods:");
            Method[] methods = cls.getDeclaredMethods();
            for (Method method : methods) {
                method.setAccessible(true);  // Ensure private methods are accessible
                System.out.println(method);
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Error: Class not found! Please enter a valid class name.");
        }

        scanner.close();
    }
}
