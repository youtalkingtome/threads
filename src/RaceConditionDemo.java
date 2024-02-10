public class RaceConditionDemo {
    public static void main(String[] args) {
        BankAccount account = new BankAccount();
        int atmNumber = 1000;

        Thread[] atms = new Thread[atmNumber];
        for (int i = 0; i < atmNumber; i++) {
            atms[i] = new ATM(account);
            atms[i].start();
        }

        for (int i = 0; i < atmNumber; i++) {
            try {
                atms[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Balance of unsynced account after concurrent transactions:");
        System.out.println("Actual: " + account.getBalance() + "\nExpected: 0");
    }
}
