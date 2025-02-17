package com.ExceptionHandling;

import java.util.Scanner;

public class NestedTryCatch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Taking user input for array size
            System.out.print("Enter the number of elements: ");
            int size = scanner.nextInt();
            int[] arr = new int[size];

            // Taking array elements input
            System.out.println("Enter " + size + " elements:");
            for (int i = 0; i < size; i++) {
                arr[i] = scanner.nextInt();
            }

            // Taking index and divisor input
            System.out.print("Enter index to access: ");
            int index = scanner.nextInt();

            System.out.print("Enter divisor: ");
            int divisor = scanner.nextInt();

            // Nested try-catch block
            try {
                int element = arr[index]; // May throw ArrayIndexOutOfBoundsException
                try {
                    int result = element / divisor; // May throw ArithmeticException
                    System.out.println("Result: " + result);
                } catch (ArithmeticException e) {
                    System.out.println("Error: Division by zero is not allowed!");
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Error: Invalid array index!");
            }
        } catch (Exception e) {
            System.out.println("Error: Invalid input.");
        } finally {
            scanner.close();
        }
    }
}
