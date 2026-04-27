public class BankAccount {
    private String accountNo;
    private double balance;

    public BankAccount(String accountNo, double initialBalance) {
        this.accountNo = accountNo;
        if (initialBalance >= 0) {
            this.balance = initialBalance;
        } else {
            this.balance = 0;   // 保证数据有效
        }
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("存入: " + amount);
        } else {
            System.out.println("存款金额必须为正数");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("取出: " + amount);
        } else if (amount > balance) {
            System.out.println("余额不足，当前余额: " + balance);
        } else {
            System.out.println("取款金额必须为正数");
        }
    }

    public double getBalance() {
        return balance;
    }
}
