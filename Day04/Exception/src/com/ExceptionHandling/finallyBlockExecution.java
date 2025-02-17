package com.ExceptionHandling;
import java.util.*;

public class finallyBlockExecution {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        //try block
        try
        {
            System.out.println("enter the num1");
            int num1=sc.nextInt();

            System.out.println("enter the num2");
            int num2=sc.nextInt();

            int result=num1/num2;
            System.out.println("The result is "+result);
        }

        //catch block
        catch(ArithmeticException e)
        {
            System.out.println("Value should be positive "+e.getMessage());
        }

        //finally block
        finally {
            {
                System.out.println("Operation completed");
            }
        }
    }
}
