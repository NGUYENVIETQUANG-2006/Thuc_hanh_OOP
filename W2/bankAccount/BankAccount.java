public class BankAccount {
    public String accountNumber;
    public String ownerName;
    public double balance = 0.0;
    public BankAccount(String accountNumber, String ownerName, double balance) {
        if (balance < 0) {
            throw new IllegalArgumentException("Balance cannot be negative");
        }
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = balance;
    }
    public boolean deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Deposit amount must be positive");
            return false;
        }
        balance += amount;
        System.out.println("Deposit successful");
        return true;
    }
    public boolean withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdraw amount must be positive");
            return false;
        }
        if (amount > balance) {
            System.out.println("Withdraw amount cannot be higher than balance");
            return false;
        }
        balance -= amount;
        System.out.println("Withdraw successful");
        return true;
    }
    public double getBalance() {
        return balance;
    }
    public static void main(String[] args) {
        BankAccount temp = new BankAccount("123456", "QUANG" , 156423.0);
        //Case 1 : Deposit < 0
        temp.deposit(-1234.0);
        //Case 2 : Withdraw > Balance
        temp.withdraw(123456789.0);
        //Case 3 : Withdraw success
        temp.withdraw(12345.0);
    }
}
