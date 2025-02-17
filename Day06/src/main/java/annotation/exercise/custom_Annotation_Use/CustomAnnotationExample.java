package annotation.exercise.custom_Annotation_Use;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME) // Make it available at runtime
@Target(ElementType.METHOD) // Applicable only to methods
@interface TaskInfo {
    String priority();
    String assignedTo();
}

class TaskManager {

    @TaskInfo(priority = "High", assignedTo = "Alice")
    public void completeTask() {
        System.out.println("Task is being completed...");
    }
}
public class CustomAnnotationExample {
    public static void main(String[] args) {
        try {
            // Get class reference
            Class<TaskManager> obj = TaskManager.class;

            // Iterate through methods
            for (Method method : obj.getDeclaredMethods()) {
                // Check if @TaskInfo is present
                if (method.isAnnotationPresent(TaskInfo.class)) {
                    // Retrieve annotation
                    TaskInfo taskInfo = method.getAnnotation(TaskInfo.class);

                    // Display annotation details
                    System.out.println("Method: " + method.getName());
                    System.out.println("Priority: " + taskInfo.priority());
                    System.out.println("Assigned To: " + taskInfo.assignedTo());
                    System.out.println("---------------------------");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
