// 文件: EncapsulationDemo.java
/**
 * 演示封装（Encapsulation）
 * 隐藏数据，通过公有方法访问，保护数据完整性
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("========== 封装 ==========");

        BankAccount account = new BankAccount("123456", 1000);

        // account.balance = 5000;  // 错误：balance 是 private，不能直接访问

        account.deposit(500);
        account.withdraw(200);
        account.withdraw(2000);   // 余额不足

        System.out.println("当前余额: " + account.getBalance());

        // 封装的优势：可以在方法内添加校验逻辑
        System.out.println("\n--- 展示数据校验 ---");
        BankAccount invalid = new BankAccount("999", -100); // 初始负数会被纠正
        System.out.println("无效初始值被纠正为: " + invalid.getBalance());
    }
}

