import java.util.*;
import java.time.*;

class Policy implements Comparable<Policy> {
    String policyNumber;
    String policyholderName;
    LocalDate expiryDate;
    String coverageType;
    double premiumAmount;

    public Policy(String policyNumber, String policyholderName, LocalDate expiryDate, String coverageType, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.policyholderName = policyholderName;
        this.expiryDate = expiryDate;
        this.coverageType = coverageType;
        this.premiumAmount = premiumAmount;
    }
    
    @Override
    public int compareTo(Policy other) {
        return this.expiryDate.compareTo(other.expiryDate);
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Policy policy = (Policy) obj;
        return Objects.equals(policyNumber, policy.policyNumber);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(policyNumber);
    }
    
    @Override
    public String toString() {
        return policyNumber + " - " + policyholderName + " - " + expiryDate + " - " + coverageType + " - $" + premiumAmount;
    }
}

public class InsurancePolicySystem {
    private Set<Policy> hashSet = new HashSet<>();
    private Set<Policy> linkedHashSet = new LinkedHashSet<>();
    private Set<Policy> treeSet = new TreeSet<>();
    
    public void addPolicy(Policy policy) {
        hashSet.add(policy);
        linkedHashSet.add(policy);
        treeSet.add(policy);
    }
    
    public void displayAllPolicies() {
        System.out.println("All Unique Policies: " + hashSet);
    }
    
    public void displayExpiringSoon() {
        LocalDate now = LocalDate.now();
        System.out.println("Policies expiring in the next 30 days:");
        for (Policy policy : treeSet) {
            if (policy.expiryDate.isBefore(now.plusDays(30))) {
                System.out.println(policy);
            }
        }
    }
    
    public void displayByCoverage(String coverageType) {
        System.out.println("Policies with coverage type: " + coverageType);
        for (Policy policy : hashSet) {
            if (policy.coverageType.equalsIgnoreCase(coverageType)) {
                System.out.println(policy);
            }
        }
    }
    
    public static void main(String[] args) {
        InsurancePolicySystem system = new InsurancePolicySystem();
        system.addPolicy(new Policy("P123", "John Doe", LocalDate.now().plusDays(10), "Health", 500.0));
        system.addPolicy(new Policy("P124", "Jane Smith", LocalDate.now().plusDays(40), "Auto", 700.0));
        system.addPolicy(new Policy("P125", "Alice Brown", LocalDate.now().plusDays(20), "Home", 300.0));
        
        system.displayAllPolicies();
        system.displayExpiringSoon();
        system.displayByCoverage("Health");
    }
}
