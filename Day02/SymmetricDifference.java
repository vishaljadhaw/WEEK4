import java.util.HashSet;
import java.util.Set;

public class SymmetricDifference {
    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);

        Set<Integer> set2 = new HashSet<>();
        set2.add(3);
        set2.add(4);
        set2.add(5);

        Set<Integer> symmetricDiff = findSymmetricDifference(set1, set2);

        System.out.println("Symmetric Difference: " + symmetricDiff);
    }

    public static Set<Integer> findSymmetricDifference(Set<Integer> set1, Set<Integer> set2) {
        Set<Integer> result = new HashSet<>(set1);
        result.addAll(set2); // Union of both sets

        Set<Integer> intersection = new HashSet<>(set1);
        intersection.retainAll(set2); // Common elements

        result.removeAll(intersection); // Remove common elements from union
        return result;
    }
}
