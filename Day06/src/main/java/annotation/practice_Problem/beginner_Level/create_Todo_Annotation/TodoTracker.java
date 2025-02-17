package annotation.practice_Problem.beginner_Level.create_Todo_Annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Todo {
    String task();         // Task description
    String assignedTo();   // Developer responsible
    String priority() default "MEDIUM";  // Priority (default: MEDIUM)
}

class ProjectTasks {

    @Todo(task = "Implement user authentication", assignedTo = "Alice", priority = "HIGH")
    public void implementAuth() {
        // Authentication logic (To be implemented)
    }

    @Todo(task = "Optimize database queries", assignedTo = "Bob")
    public void optimizeDB() {
        // Query optimization logic (To be implemented)
    }

    @Todo(task = "Refactor code structure", assignedTo = "Charlie", priority = "LOW")
    public void refactorCode() {
        // Code refactoring logic (To be implemented)
    }
}
public class TodoTracker {
    public static void main(String[] args) {
        Class<ProjectTasks> clazz = ProjectTasks.class;
        Method[] methods = clazz.getDeclaredMethods();

        System.out.println(" Pending Tasks:");
        for (Method method : methods) {
            if (method.isAnnotationPresent(Todo.class)) {
                Todo todo = method.getAnnotation(Todo.class);
                System.out.println(" Method: " + method.getName());
                System.out.println("    Task: " + todo.task());
                System.out.println("   Assigned To: " + todo.assignedTo());
                System.out.println("    Priority: " + todo.priority());
                System.out.println("------------------------------------");
            }
        }
    }
}
