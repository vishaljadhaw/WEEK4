package com.ExceptionHandling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CheckedException {
    public static void main(String[] args) {


                try {
                    BufferedReader reader = new BufferedReader(new FileReader("example.txt"));
                    String line;
                    while ((line = reader.readLine()) != null) {
                        System.out.println(line);
                    }
                    reader.close();
                } catch (IOException e) {
                    System.out.println("File not found \n"+e.getMessage());
                }
        //System.out.println("File not found");
            }
        }
