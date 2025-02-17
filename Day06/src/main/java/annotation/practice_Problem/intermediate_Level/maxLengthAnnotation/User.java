package annotation.practice_Problem.intermediate_Level.maxLengthAnnotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// Step 1: Define the @MaxLength annotation
@Target(ElementType.FIELD)  // Applies only to fields
@Retention(RetentionPolicy.RUNTIME)  // Retained at runtime for reflection
@interface MaxLength {
    int value();  // This specifies the maximum length value
}

// Step 2: Define the User class with a username field and constructor validation
public class User {
    @MaxLength(10)  // Username should not exceed 10 characters
    private String username;

    public User(String username) {
        // Validate the length of the username based on the annotation
        validateMaxLength(username);
        this.username = username;
    }

    private void validateMaxLength(String username) {
        // Check if the username field has the @MaxLength annotation
        try {
            MaxLength maxLengthAnnotation = this.getClass().getDeclaredField("username").getAnnotation(MaxLength.class);
            if (maxLengthAnnotation != null) {
                int maxLength = maxLengthAnnotation.value();
                if (username.length() > maxLength) {
                    throw new IllegalArgumentException("Username exceeds maximum length of " + maxLength);
                }
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();  // Handle the exception if the field is not found (unlikely in this case)
        }
    }

    public String getUsername() {
        return username;
    }

    // Step 3: Main method to test validation
    public static void main(String[] args) {
        try {
            User user = new User("vishal02023");  // This should throw an exception since the username is too long
            System.out.println("Username: " + user.getUsername());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());  // Handle validation failure
        }

        try {
            User validUser = new User("vishal_jadhav");  // This should succeed since it's within the length limit
            System.out.println("Username: " + validUser.getUsername());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
