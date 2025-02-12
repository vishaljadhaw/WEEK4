import java.util.*;

public class FrequencyCounter {
    public static void main(String[] args) {
        
        List<String> fruits = Arrays.asList("apple", "banana", "apple", "orange", "banana", "apple");

        
        Map<String, Integer> frequencyMap = new HashMap<>();

        // Count occurrences of each element
        for (String fruit : fruits) {
            if (frequencyMap.containsKey(fruit)) {
                frequencyMap.put(fruit, frequencyMap.get(fruit) + 1);
            } else {
                frequencyMap.put(fruit, 1);
            }
        }

        // Print the frequency map
        System.out.println("Frequency of elements: " + frequencyMap);
    }
}
