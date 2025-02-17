package reflection.intermediate_Level;

import java.lang.reflect.Method;
import java.util.Scanner;


class MathOperations {
    public int num1;
    public int num2;

    public MathOperations(int num1, int num2){
        this.num1 = num1;
        this.num2 = num2;
    }

    public int add(int num1, int num2){
        return num1+num2;
    }

    public int subtract(int num1, int num2){
        return num1-num2;
    }

    public int multiply(int num1, int num2){
        return num1*num2;
    }

}
public class DynamicMethodInvocation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter operation to perform(add, multiply, subtract): ");
        String methodName = scanner.nextLine();

        System.out.print("\nEnter number 1: ");
        int num1 = scanner.nextInt();
        System.out.print("\nEnter number 2: ");
        int num2 = scanner.nextInt();
        MathOperations operation = new MathOperations(num1, num2);
        try{
            Class<?> cls = operation.getClass();
            Method method = cls.getMethod(methodName.trim(), int.class, int.class);
            int result = (int) method.invoke(operation, num1, num2);
            System.out.println("Result of " + methodName.trim() + " -> " + result);
        } catch (NoSuchMethodException e) {
            System.out.println("Error: Method '" + methodName + "' not found.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally{
            scanner.close();
        }
    }
}
