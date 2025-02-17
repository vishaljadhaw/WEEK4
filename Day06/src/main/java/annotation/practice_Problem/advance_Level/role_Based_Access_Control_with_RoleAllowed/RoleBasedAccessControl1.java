package annotation.practice_Problem.advance_Level.role_Based_Access_Control_with_RoleAllowed;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

// Step 1: Define the RoleAllowed Annotation
@Target(ElementType.METHOD)  // This annotation will be used on methods
@Retention(RetentionPolicy.RUNTIME)  // Make it accessible at runtime
@interface RoleAllowed {
    String value();  // The role required for access
}

// Step 2: Create a User class to represent user roles
class User {
    private String name;
    private String role;

    public User(String name, String role) {
        this.name = name;
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public String getName() {
        return name;
    }
}

// Step 3: Define the Service class with Role-Restricted Methods
class SomeService {
    User user;

    public SomeService(User user) {
        this.user = user;
    }

    @RoleAllowed("ADMIN")  // This method is only accessible by ADMIN
    public void someAdminMethod() {
        System.out.println("Method accessed by " + user.getName() + " with role " + user.getRole());
    }
}

// Step 4: Implement Role Validation with Reflection
class RoleBasedAccessControl {

    public static void checkAccess(Object object, String methodName) throws Exception {
        Method method = object.getClass().getMethod(methodName);
        if (method.isAnnotationPresent(RoleAllowed.class)) {
            RoleAllowed roleAllowed = method.getAnnotation(RoleAllowed.class);
            String requiredRole = roleAllowed.value();

            // Check if the user has the required role
            if (object instanceof SomeService) {
                SomeService service = (SomeService) object;
                if (service.user.getRole().equals(requiredRole)) {
                    method.invoke(object);  // Invoke the method if access is allowed
                } else {
                    System.out.println("Access Denied!");  // Deny access if roles don't match
                }
            }
        }
    }
}

// Step 5: Main Class to Test the Solution
public class RoleBasedAccessControl1 {
    public static void main(String[] args) throws Exception {
        // Simulate users with different roles
        User adminUser = new User("Alice", "ADMIN");
        User nonAdminUser = new User("Bob", "USER");

        // Service with an ADMIN user
        SomeService serviceWithAdmin = new SomeService(adminUser);
        RoleBasedAccessControl.checkAccess(serviceWithAdmin, "someAdminMethod"); // Should be allowed

        // Service with a non-ADMIN user
        SomeService serviceWithNonAdmin = new SomeService(nonAdminUser);
        RoleBasedAccessControl.checkAccess(serviceWithNonAdmin, "someAdminMethod"); // Should deny access
    }
}
