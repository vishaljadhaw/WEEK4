package com.ExceptionHandling;

import java.util.Scanner;

public class MultipleCatchBlocks{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Accept array size
            System.out.print("Enter the number of elements: ");
            int size = scanner.nextInt();

            int[] arr;
            if (size > 0) {
                arr = new int[size];
            } else {
                arr = null;
            }

            // Taking input for array elements if not null
            if (arr != null) {
                System.out.println("Enter " + size + " elements:");
                for (int i = 0; i < size; i++) {
                    arr[i] = scanner.nextInt();
                }
            }

            // Accept index to retrieve value
            System.out.print("Enter index to retrieve: ");
            int index = scanner.nextInt();

            // Print the value at the given index
            System.out.println("Value at index " + index + ": " + arr[index]);

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invaild index ");
        } catch (NullPointerException e) {
            System.out.println("Array is not initialized! ");
        }
        }
    }

