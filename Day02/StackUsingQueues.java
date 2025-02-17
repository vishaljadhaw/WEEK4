import java.util.LinkedList;
import java.util.Queue;

class StackUsingQueues {
    private Queue<Integer> q1 = new LinkedList<>();
    private Queue<Integer> q2 = new LinkedList<>();

    // Push element onto stack
    public void push(int x) {
        q1.add(x);
    }

    // Removes and returns the top element of the stack
    public int pop() {
        if (q1.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }

        // Move elements except last to q2
        while (q1.size() > 1) {
            q2.add(q1.poll());
        }

        // Last element is the top of the stack
        int topElement = q1.poll();

        // Swap queues
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;

        return topElement;
    }

    // Get the top element without removing it
    public int top() {
        if (q1.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }

        while (q1.size() > 1) {
            q2.add(q1.poll());
        }

        int topElement = q1.peek(); // Peek at the last element

        q2.add(q1.poll()); // Move it to q2

        // Swap queues
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;

        return topElement;
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return q1.isEmpty();
    }

    public static void main(String[] args) {
        StackUsingQueues stack = new StackUsingQueues();
        
        stack.push(1);
        stack.push(2);
        stack.push(3);
        
        System.out.println("Top Element: " + stack.top()); // Output: 3
        System.out.println("Popped: " + stack.pop()); // Output: 3
        System.out.println("Popped: " + stack.pop()); // Output: 2
        System.out.println("Is stack empty? " + stack.isEmpty()); // Output: false
    }
}
