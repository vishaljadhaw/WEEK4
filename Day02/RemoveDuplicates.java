import java.util.*;

public class RemoveDuplicates {
    public static void main(String[] args) {
        // Predefined list with duplicate elements
        List<Integer> numbers = Arrays.asList(3, 1, 2, 2, 3, 4);

        // Create a new list to store unique elements
        List<Integer> uniqueList = new ArrayList<>();

        // Loop through the original list
        for (Integer num : numbers) {
            // Check manually if the number is already in the uniqueList
            boolean isDuplicate = false;
            for (Integer uniqueNum : uniqueList) {
                if (num.equals(uniqueNum)) {
                    isDuplicate = true;
                    break; // Exit loop once duplicate is found
                }
            }
            // If not found in uniqueList, add it
            if (!isDuplicate) {
                uniqueList.add(num);
            }
        }

        // Print the original and unique lists
        System.out.println("Original List: " + numbers);
        System.out.println("List after Removing Duplicates: " + uniqueList);
    }
}
