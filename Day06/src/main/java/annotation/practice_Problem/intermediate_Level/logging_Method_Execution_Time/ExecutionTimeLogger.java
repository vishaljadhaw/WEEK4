package annotation.practice_Problem.intermediate_Level.logging_Method_Execution_Time;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface LogExecutionTime {
}




class ExecutionTimeProxyHandler implements InvocationHandler {
    private final Object target;

    public ExecutionTimeProxyHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.isAnnotationPresent(LogExecutionTime.class)) {
            long startTime = System.nanoTime(); // Start timer

            Object result = method.invoke(target, args); // Execute method

            long endTime = System.nanoTime(); // End timer
            long executionTime = (endTime - startTime) / 1_000_000; // Convert to milliseconds

            System.out.println("Execution time of " + method.getName() + ": " + executionTime + " ms");

            return result;
        } else {
            return method.invoke(target, args); // Execute normally
        }
    }
}


class TaskService {

    @LogExecutionTime
    public void quickTask() {
        System.out.println("Executing quick task...");
    }

    @LogExecutionTime
    public void slowTask() {
        System.out.println("Executing slow task...");
        try {
            Thread.sleep(1000); // Simulating a long-running task
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class ExecutionTimeLogger {
    public static void main(String[] args) {
        // Create a proxy instance that logs execution time
        TaskService originalService = new TaskService();
        TaskService proxyService = (TaskService) Proxy.newProxyInstance(
                TaskService.class.getClassLoader(),
                new Class[]{TaskService.class},
                new ExecutionTimeProxyHandler(originalService)
        );

        // Execute methods and log their execution time
        proxyService.quickTask();  // Should take very little time
        proxyService.slowTask();   // Should take ~1000ms
    }
}