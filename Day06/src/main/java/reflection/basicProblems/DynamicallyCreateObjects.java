package reflection.basicProblems;


import java.lang.reflect.Constructor;

class Student {
    private String name;
    private int age;

    //Default constructor
    public Student(){
        this.name = "Unknown";
        this.age = 0;
    }

    //Parameterized constructor
    public Student(String name, int age){
        this.name = name;
        this.age = age;
    }

    public void display(){
        System.out.println("Student name : " + name + ", Age : " + age);
    }
}

public class DynamicallyCreateObjects {
    public static void main(String[] args) {
        try{
            //Load class dynamically
            Class<?> cls = Class.forName("Day06.reflection.basicProblems.Student");

            //create an object using default constructor
            Object obj1 = cls.getDeclaredConstructor().newInstance();
            ((Student) obj1).display();

            //create an object using parameterized constructor(can be multiple hence we use generic type to hold unknown types)
            Constructor<?> constructor = cls.getDeclaredConstructor(String.class, int.class);
            Object obj2 = constructor.newInstance("Vishal", 20);
            ((Student) obj2).display();

        } catch (Exception e){
            System.out.println("General Exception: " + e.getMessage());
        }
    }

}
