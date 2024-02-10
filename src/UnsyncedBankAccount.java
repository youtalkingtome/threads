public class UnsyncedBankAccount extends BankAccount {

    private double balance;
    public UnsyncedBankAccount(double initialBalance) {
        super(initialBalance);
    }

    public void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
        } else {
            throw new IllegalArgumentException("You can't deposit a negative amount of money");
        }
    }

    public void withdraw(double amount) {
        if (0 < amount && amount <= this.balance) {
            this.balance -= amount;
        } else {
            throw new IllegalArgumentException("Account does not have sufficient funds");
        }
    }
}
