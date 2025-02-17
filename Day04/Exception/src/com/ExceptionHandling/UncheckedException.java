package com.ExceptionHandling;
import java.util.InputMismatchException;
import java.util.Scanner;

public class UncheckedException {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the number first");
        int Number1=sc.nextInt();
        System.out.println("enter the number second");
        int Number2=sc.nextInt();

        int result1 = Number1 / Number2;
        try {
            System.out.println("The result is " + result1);
        }
        catch (ArithmeticException e)
        {
            System.out.println("Cannot divide by zero");
        }
        catch (InputMismatchException e)
        {
            System.out.println("Please enter integer values");
        }

    }

}
