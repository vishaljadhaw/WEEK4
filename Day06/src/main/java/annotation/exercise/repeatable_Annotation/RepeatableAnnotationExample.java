package annotation.exercise.repeatable_Annotation;

import java.lang.annotation.*;
import java.lang.reflect.Method;
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface BugReports {
    BugReport[] value();
}

// Define @BugReport annotation, making it repeatable
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Repeatable(BugReports.class) // Links to the container annotation
@interface BugReport {
    String description();
    String reportedBy();
}


class SoftwareModule {

    @BugReport(description = "Null pointer exception occurs on invalid input", reportedBy = "Alice")
    @BugReport(description = "Performance issue in data processing", reportedBy = "Bob")
    public void processData() {
        System.out.println("Processing data...");
    }
}


public class RepeatableAnnotationExample {

    public static void main(String[] args) {
        try {
            // Get class reference
            Class<SoftwareModule> obj = SoftwareModule.class;

            // Iterate through methods
            for (Method method : obj.getDeclaredMethods()) {
                // Check if the method has multiple @BugReport annotations
                if (method.isAnnotationPresent(BugReports.class)) {
                    BugReports bugReports = method.getAnnotation(BugReports.class);

                    // Print each bug report
                    System.out.println("Method: " + method.getName());
                    for (BugReport bug : bugReports.value()) {
                        System.out.println("Bug Description: " + bug.description());
                        System.out.println("Reported By: " + bug.reportedBy());
                        System.out.println("---------------------------");
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
