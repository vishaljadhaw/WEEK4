import java.util.LinkedList;
import java.util.Queue;

public class BinaryNumbersQueue {
    public static void main(String[] args) {
        int N = 5; // Number of binary numbers to generate

        Queue<String> queue = new LinkedList<>();
        queue.add("1"); // Start with "1"

        System.out.println("First " + N + " binary numbers:");

        for (int i = 0; i < N; i++) {
            String binary = queue.remove(); // Remove and get the front element
            System.out.print(binary + " "); // Print the binary number
            
            queue.add(binary + "0"); // Add next binary numbers
            queue.add(binary + "1");
        }
    }
}
