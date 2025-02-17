import java.util.LinkedList;

public class NthFromEndSimple {
    public static void main(String[] args) {
        // Create a LinkedList with predefined values
        LinkedList<String> list = new LinkedList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");

        int N = 2; // Find the 2nd element from the end

        // Call the method to find the Nth element from the end
        String result = findNthFromEnd(list, N);

        // Print the result
        System.out.println("The " + N + "th element from the end is: " + result);
    }

    // Method to find Nth node from the end using basic logic
    public static String findNthFromEnd(LinkedList<String> list, int N) {
        int index = list.size() - N; // Find index from the start

        if (index < 0) {
            return "N is larger than the list size";
        }

        return list.get(index); // Return the Nth element from the end
    }
}
