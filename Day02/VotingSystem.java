import java.util.*;

public class VotingSystem {
    private Map<String, Integer> votes = new HashMap<>();
    private LinkedHashMap<String, Integer> voteOrder = new LinkedHashMap<>();

    public void castVote(String candidate) {
        votes.put(candidate, votes.getOrDefault(candidate, 0) + 1);
        voteOrder.put(candidate, votes.get(candidate));
    }

    public void displayResultsSorted() {
        TreeMap<String, Integer> sortedResults = new TreeMap<>(votes);
        System.out.println("Sorted Results: " + sortedResults);
    }

    public void displayVoteOrder() {
        System.out.println("Vote Order: " + voteOrder);
    }

    public static void main(String[] args) {
        VotingSystem system = new VotingSystem();
        system.castVote("Alice");
        system.castVote("Bob");
        system.castVote("Alice");
        system.castVote("Charlie");
        system.castVote("Bob");
        
        system.displayResultsSorted();
        system.displayVoteOrder();
    }
}
