import java.util.*;
public class BankingSystem {
    private Map<String, Double> accounts = new HashMap<>();
    private Queue<String> withdrawalQueue = new LinkedList<>();

    public void addAccount(String accountNumber, double balance) {
        accounts.put(accountNumber, balance);
    }

    public void withdraw(String accountNumber, double amount) {
        if (accounts.containsKey(accountNumber) && accounts.get(accountNumber) >= amount) {
            withdrawalQueue.add(accountNumber + " - " + amount);
        } else {
            System.out.println("Insufficient funds or account not found.");
        }
    }

    public void processWithdrawals() {
        while (!withdrawalQueue.isEmpty()) {
            String request = withdrawalQueue.poll();
            String[] parts = request.split(" - ");
            String accountNumber = parts[0];
            double amount = Double.parseDouble(parts[1]);
            accounts.put(accountNumber, accounts.get(accountNumber) - amount);
            System.out.println("Processed withdrawal: " + amount + " from " + accountNumber);
        }
    }

    public void displaySortedAccounts() {
        TreeMap<Double, String> sortedAccounts = new TreeMap<>();
        for (Map.Entry<String, Double> entry : accounts.entrySet()) {
            sortedAccounts.put(entry.getValue(), entry.getKey());
        }
        System.out.println("Accounts sorted by balance: " + sortedAccounts);
    }

    public static void main(String[] args) {
        BankingSystem system = new BankingSystem();
        system.addAccount("12345", 5000);
        system.addAccount("67890", 3000);
        system.addAccount("54321", 7000);
        
        system.withdraw("12345", 1000);
        system.withdraw("67890", 500);
        
        system.processWithdrawals();
        system.displaySortedAccounts();
    }
}
