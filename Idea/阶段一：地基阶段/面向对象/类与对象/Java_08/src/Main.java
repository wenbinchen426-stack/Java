// 文件: ClassAndObjectDemo.java
/**
 * 演示类与对象的概念
 * 类：对象的蓝图/模板
 * 对象：根据类创建的实例
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("========== 类与对象 ==========");

        // 创建对象
        Person p1 = new Person("张三", 20);
        Person p2 = new Person("李四", 22);

        p1.sayHello();
        p2.sayHello();

        // 类变量（静态变量）属于类，所有对象共享
        System.out.println("Person 总数: " + Person.getCount());

        // 基本类型 vs 引用类型
        int num = 10;               // 基本类型，直接存值
        Person p3 = new Person("王五", 25); // 引用类型，p3存地址
        System.out.println("基本类型值: " + num);
        System.out.println("引用类型地址指向: " + p3.getName());
    }
}

