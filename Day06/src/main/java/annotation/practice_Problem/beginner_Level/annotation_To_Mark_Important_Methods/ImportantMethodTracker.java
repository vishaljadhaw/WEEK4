package annotation.practice_Problem.beginner_Level.annotation_To_Mark_Important_Methods;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface ImportantMethod {
    String level() default "HIGH";  // Default level: HIGH
}


class SystemOperations {

    @ImportantMethod
    public void processCriticalData() {
        System.out.println("Processing critical data...");
    }

    @ImportantMethod(level = "MEDIUM")
    public void generateReport() {
        System.out.println("Generating report...");
    }

    @ImportantMethod(level = "LOW")
    public void logActivity() {
        System.out.println("Logging system activity...");
    }
}
public class ImportantMethodTracker {

    public static void main(String[] args) {
        Class<SystemOperations> clazz = SystemOperations.class;
        Method[] methods = clazz.getDeclaredMethods();

        System.out.println(" Important Methods:");
        for (Method method : methods) {
            if (method.isAnnotationPresent(ImportantMethod.class)) {
                ImportantMethod annotation = method.getAnnotation(ImportantMethod.class);
                System.out.println(" Method: " + method.getName());
                System.out.println("   Importance Level: " + annotation.level());
                System.out.println("------------------------------------");
            }
        }
    }
}
