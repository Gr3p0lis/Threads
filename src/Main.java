public class Main {
    public static void main(String[] args) {

        BankAccount myBankAccount = new BankAccount(1000);

        Thread thread1 = new Thread(() -> myBankAccount.Deposit(5000));
        Thread thread2 = new Thread(() -> myBankAccount.Withdraw(2000));
        Thread thread3 = new Thread(() -> myBankAccount.Deposit(5000)); //11000


        try {
            thread1.start();
            thread1.join();

            thread2.start();
            thread2.join();
            
            thread3.start();
            thread3.join();

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        myBankAccount.ShowBalance();
    }
}