import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {
    private double balance;
    private final Lock lock = new ReentrantLock();

    public BankAccount() {
        this.balance = 0;
    }
    public BankAccount(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount) {
        lock.lock();
        try {
            if (amount > 0) {
                this.balance += amount;
            } else {
                throw new IllegalArgumentException("You can't deposit a negative amount of money");
            }
        } finally {
            lock.unlock();
        }
    }

    public void withdraw(double amount) {
        lock.lock();
        try {
            if (0 < amount && amount <= this.balance) {
                this.balance -= amount;
            } else {
                throw new IllegalArgumentException("Account does not have sufficient funds");
            }
        } finally {
            lock.unlock();
        }
    }

    public double getBalance() {
        lock.lock();
        try {
            return balance;
        } finally {
            lock.unlock();
        }
    }
}
