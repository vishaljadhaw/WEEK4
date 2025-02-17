import java.util.PriorityQueue;
import java.util.Comparator;

class Patient {
    String name;
    int severity;

    public Patient(String name, int severity) {
        this.name = name;
        this.severity = severity;
    }

    @Override
    public String toString() {
        return name + " (Severity: " + severity + ")";
    }
}

public class HospitalTriage {
    public static void main(String[] args) {
        // Define a PriorityQueue with a custom comparator for severity (higher severity = higher priority)
        PriorityQueue<Patient> triageQueue = new PriorityQueue<>(Comparator.comparingInt((Patient p) -> -p.severity));

        // Add patients
        triageQueue.add(new Patient("John", 3));
        triageQueue.add(new Patient("Alice", 5));
        triageQueue.add(new Patient("Bob", 2));

        // Process patients in order of severity
        System.out.println("Order of treatment:");
        while (!triageQueue.isEmpty()) {
            System.out.println(triageQueue.poll());
        }
    }
}
