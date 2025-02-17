import java.util.*;

public class ReverseList {

    // Method to reverse an ArrayList
    public static void reverseArrayList(ArrayList<Integer> list) {
        int left = 0, right = list.size() - 1;
        while (left < right) {
            int temp = list.get(left);
            list.set(left, list.get(right));
            list.set(right, temp);
            left++;
            right--;
        }
    }

    // Method to reverse a LinkedList
    public static void reverseLinkedList(LinkedList<Integer> list) {
        int left = 0, right = list.size() - 1;
        while (left < right) {
            int temp = list.get(left);
            list.set(left, list.get(right));
            list.set(right, temp);
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        // Predefined input list
        List<Integer> inputList = Arrays.asList(1, 2, 3, 4, 5);

        // Create an ArrayList and LinkedList with predefined values
        ArrayList<Integer> arrayList = new ArrayList<>(inputList);
        LinkedList<Integer> linkedList = new LinkedList<>(inputList);

        // Print and reverse ArrayList
        System.out.println("Original ArrayList: " + arrayList);
        reverseArrayList(arrayList);
        System.out.println("Reversed ArrayList: " + arrayList);

        System.out.println();

        // Print and reverse LinkedList
        System.out.println("Original LinkedList: " + linkedList);
        reverseLinkedList(linkedList);
        System.out.println("Reversed LinkedList: " + linkedList);
    }
}
