
public class BankAccount {
    private String accountNumber;
    private String ownerName;
    private int balance;

    public BankAccount(String accountNumber, String ownerName, int initialBalance) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        if (initialBalance >= 0) {
            this.balance = initialBalance;
        } else {
            this.balance = 0;
        }
    }

    public String getAccountNumber() {
        return this.accountNumber;
    }

    public String getOwnerName() {
        return this.ownerName;
    }

    public int getBalance() {
        return this.balance;
    }

    public boolean deposit(int amount) {
        if (amount <= 0) {
            return false;
        }
        this.balance += amount;
        return true;
    }

    public boolean withdraw(int amount) {
        if (amount <= 0 || amount > this.balance) {
            return false;
        }
        this.balance -= amount;
        return true;
    }

    public boolean transferTo(BankAccount target, int amount) {
        if (target == null || amount <= 0 || amount > this.balance) {
            return false;
        }
        this.balance -= amount;
        target.balance += amount;
        return true;
    }

    @Override
    public String toString() {
        return "BankAccount[Account=" + this.accountNumber + ", Owner=" + this.ownerName + ", Balance=" + this.balance + "]";
    }
}