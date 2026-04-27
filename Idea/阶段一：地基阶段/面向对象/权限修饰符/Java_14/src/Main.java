// 文件: AccessModifierDemo.java
/**
 * 演示权限修饰符
 * private < default(无) < protected < public
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("========== 权限修饰符 ==========");

        DemoClass demo = new DemoClass();

        // 访问不同权限的字段/方法
        demo.publicField = 10;
        demo.publicMethod();        // ✅ public 任何地方可访问

        // demo.privateField = 20;   // ❌ private 仅本类内部
        demo.setPrivateField(20);   // 通过公有方法间接访问
        System.out.println("private 字段值: " + demo.getPrivateField());

        demo.protectedField = 30;
        demo.protectedMethod();     // ✅ 同包可访问

        demo.defaultField = 40;
        demo.defaultMethod();       // ✅ 同包可访问

        // 展示访问权限表
        printAccessTable();

        System.out.println("\n--- 子类访问测试（同包）---");
        SubClass sub = new SubClass();
        sub.testAccess();
    }

    private static void printAccessTable() {
        System.out.println("\n+---------------------+------+------+--------+------+");
        System.out.println("| 修饰符               | 本类 | 同包 | 子类(不同包) | 全局 |");
        System.out.println("+---------------------+------+------+--------+------+");
        System.out.println("| private             |  √   |  ×   |    ×   |  ×   |");
        System.out.println("| default (无修饰符)    |  √   |  √   |    ×   |  ×   |");
        System.out.println("| protected           |  √   |  √   |    √   |  ×   |");
        System.out.println("| public              |  √   |  √   |    √   |  √   |");
        System.out.println("+---------------------+------+------+--------+------+");
    }
}

