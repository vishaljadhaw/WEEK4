package reflection.basicProblems;
import java.lang.reflect.Field;



public class AccessPrivateField {
    public static void main(String[] args) {
            try {
                // Person class with a private field 'age'
                class Person {
                    private int age;

                    // Constructor to set the age
                    public Person(int age) {
                        this.age = age;
                    }

                    // Method to display the age (for demonstration purposes)
                    public void display() {
                        System.out.println("Age: " + age);
                    }
                }

                // Create an instance of the Person class
                Person person = new Person(25);

                // Display initial value of age using the display method
                System.out.println("Before modification:");
                person.display();

                // Get the Class object for the Person class
                Class<?> cls = person.getClass();

                // Access the private field 'age' using reflection
                Field ageField = cls.getDeclaredField("age");

                // Make the private field accessible
                ageField.setAccessible(true);

                // Retrieve the current value of the private 'age' field
                int currentAge = (int) ageField.get(person);
                System.out.println("Current age (using reflection): " + currentAge);

                // Modify the private 'age' field using reflection
                ageField.set(person, 30);

                // Display the modified value of age
                System.out.println("\nAfter modification:");
                person.display();

                // Retrieve the modified value of 'age' using reflection
                currentAge = (int) ageField.get(person);
                System.out.println("Modified age (using reflection): " + currentAge);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }