public class BankAccount {

    private /* volatile */ float balance; //Critical section

    public BankAccount(float balance) {
        this.balance = balance;
        System.out.println("New balance is: " + this.balance);
    }

    // I metodi Deposit(), Withdraw(), ShowBalance() accedono tutti alla variabile balance per questo
    // devono essere sicnronizzati cosi da diventare thread safe.
    public synchronized void Deposit(float amount) {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        this.balance += amount;
        System.out.println("Deposit amount is: " + amount);
    }

    public synchronized void Withdraw(float amount) {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        this.balance -= amount;
        System.out.println("Withdraw amount is: " + amount);
    }

    public synchronized void ShowBalance() {
        System.out.println("Balance is: " + this.balance);
    }
}
