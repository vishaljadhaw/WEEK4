package com.ExceptionHandling;

import java.util.*;
public class ExceptionPropagation {

        //method to find interest
        public static double calculateInterest(double amount, double rate, int years) throws IllegalArgumentException
        {
            if(amount<0 || rate<0)
            {
                throw new IllegalArgumentException("amount and rate must be positive");
            }
            else {
                return amount*rate*years;
            }
        }
        public static void main(String[] args) {
            Scanner sc =new Scanner(System.in);

            //try block
            try
            {
                System.out.println("enter the amount");
                double amount=sc.nextDouble();

                System.out.println("enter the rate");
                double rate=sc.nextDouble();

                System.out.println("enter the years");
                int years=sc.nextInt();

                double interest =calculateInterest(amount,rate,years);
                System.out.println(interest);
            }

            //catch block
            catch(IllegalArgumentException e)
            {
                System.out.println("Invalid input: Amount and rate must be positive"+e.getMessage());

            }
    }
}
