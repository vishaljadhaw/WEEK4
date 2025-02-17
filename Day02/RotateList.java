import java.util.*;

public class RotateList {
    public static void main(String[] args) {
        // list of numbers
        List<Integer> numbers = Arrays.asList(10, 20, 30, 40, 50);
        int rotateBy = 2; // Number of positions to rotate

        // Create a new list to store rotated elements
        List<Integer> rotatedList = new ArrayList<>();

        // First, add elements from rotateBy index to the end
        for (int i = rotateBy; i < numbers.size(); i++) {
            rotatedList.add(numbers.get(i));
        }

        // Then, add elements from start to rotateBy index
        for (int i = 0; i < rotateBy; i++) {
            rotatedList.add(numbers.get(i));
        }

        // Print the rotated list
        System.out.println("Original List: " + numbers);
        System.out.println("Rotated List: " + rotatedList);
    }
}
