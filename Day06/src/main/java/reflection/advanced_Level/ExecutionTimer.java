package reflection.advanced_Level;
import java.lang.reflect.Method;

class SampleMethods {
    public void slowMethod() throws InterruptedException {
        Thread.sleep(1000); // Simulate slow method
    }

    public void fastMethod() {
        // Fast execution
    }
}
public class ExecutionTimer {


    public static void measureExecutionTime(Object obj, String methodName) {
        try {
            Method method = obj.getClass().getMethod(methodName);
            long startTime = System.nanoTime();
            method.invoke(obj);
            long endTime = System.nanoTime();
            System.out.println("Execution time for " + methodName + ": " + (endTime - startTime) / 1_000_000.0 + " ms");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SampleMethods sample = new SampleMethods();
        measureExecutionTime(sample, "slowMethod");
        measureExecutionTime(sample, "fastMethod");
    }
}
