public class ATM extends Thread {
    private final BankAccount bankAccount;

    public ATM(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public void run() {
        transaction();
    }

    private void transaction() {
        bankAccount.deposit(10);
        try {
            Thread.sleep(1); // Sleep for 1 millisecond
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        bankAccount.withdraw(10);
    }
}
