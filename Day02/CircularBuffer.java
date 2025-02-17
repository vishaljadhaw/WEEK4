import java.util.Arrays;

class CircularBuffer {
    private int[] buffer;
    private int size;
    private int front;
    private int rear;
    private int count;

    public CircularBuffer(int size) {
        this.size = size;
        this.buffer = new int[size];
        this.front = 0;
        this.rear = 0;
        this.count = 0;
    }

    // Insert element into the buffer
    public void insert(int value) {
        buffer[rear] = value;
        rear = (rear + 1) % size;
        
        if (count < size) {
            count++; // Increase count if buffer is not full
        } else {
            front = (front + 1) % size; // Overwrite oldest element
        }
    }

    // Get buffer contents
    public int[] getBuffer() {
        int[] result = new int[count];
        for (int i = 0; i < count; i++) {
            result[i] = buffer[(front + i) % size];
        }
        return result;
    }

    public static void main(String[] args) {
        CircularBuffer cb = new CircularBuffer(3);
        
        cb.insert(1);
        cb.insert(2);
        cb.insert(3);
        System.out.println("Buffer: " + Arrays.toString(cb.getBuffer())); // [1, 2, 3]

        cb.insert(4);
        System.out.println("Buffer after inserting 4: " + Arrays.toString(cb.getBuffer())); // [2, 3, 4]

        cb.insert(5);
        System.out.println("Buffer after inserting 5: " + Arrays.toString(cb.getBuffer())); // [3, 4, 5]
    }
}
