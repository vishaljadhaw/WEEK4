package annotation.exercise.suppress_Unchecked_Warnings;

import java.util.ArrayList;

public class SuppressUncheckedWarning {


    @SuppressWarnings("unchecked") // Suppresses the unchecked warning
    public static void main(String[] args) {
        ArrayList list = new ArrayList(); // No generics used (raw type)

        list.add("Hello");
        list.add(123); // Mixing types (not recommended)

        System.out.println("ArrayList contents: " + list);
    }
}
