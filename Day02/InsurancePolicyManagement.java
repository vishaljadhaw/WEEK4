import java.time.LocalDate;
import java.util.*;

class InsurancePolicy {
    String policyNumber, policyholder;
    LocalDate expiryDate;

    public InsurancePolicy(String policyNumber, String policyholder, LocalDate expiryDate) {
        this.policyNumber = policyNumber;
        this.policyholder = policyholder;
        this.expiryDate = expiryDate;
    }

    @Override
    public String toString() {
        return policyNumber + " - " + policyholder + " (Expires: " + expiryDate + ")";
    }
}

public class InsurancePolicyManagement {
    private Map<String, InsurancePolicy> policies = new HashMap<>();

    public void addPolicy(InsurancePolicy policy) {
        policies.put(policy.policyNumber, policy);
    }

    public InsurancePolicy getPolicy(String policyNumber) {
        return policies.get(policyNumber);
    }

    public void removeExpiredPolicies() {
        policies.values().removeIf(p -> p.expiryDate.isBefore(LocalDate.now()));
    }

    public static void main(String[] args) {
        InsurancePolicyManagement system = new InsurancePolicyManagement();
        system.addPolicy(new InsurancePolicy("P001", "Alice", LocalDate.now().plusDays(10)));
        system.addPolicy(new InsurancePolicy("P002", "Bob", LocalDate.now().minusDays(1)));

        System.out.println("Policy P001: " + system.getPolicy("P001"));
        system.removeExpiredPolicies();
        System.out.println("Policies after removal: " + system.policies.values());
    }
}
