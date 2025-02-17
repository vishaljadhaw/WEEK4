package annotation.exercise.use_override;



    class Animal {
        void makeSound() {
            System.out.println("Animal makes a sound");
        }
    }
class Dog extends Animal {
    @Override
    void makeSound() {
        System.out.println("Dog barks");
    }
}
public class OverrideExample {
    public static void main(String[] args) {
        Dog dog = new Dog(); // Create an instance of Dog
        dog.makeSound(); // Call the overridden method
    }
}
