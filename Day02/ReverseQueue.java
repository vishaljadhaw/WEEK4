import java.util.LinkedList;
import java.util.Queue;

public class ReverseQueue {
    public static void reverseQueue(Queue<Integer> queue) {
        if (queue.isEmpty()) {
            return;
        }
        
        // Step 1: Remove front element
        int front = queue.poll();
        
        // Step 2: Recursively reverse remaining queue
        reverseQueue(queue);
        
        // Step 3: Add removed element back
        queue.add(front);
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(10);
        queue.add(20);
        queue.add(30);

        System.out.println("Original Queue: " + queue);
        reverseQueue(queue);
        System.out.println("Reversed Queue: " + queue);
    }
}
