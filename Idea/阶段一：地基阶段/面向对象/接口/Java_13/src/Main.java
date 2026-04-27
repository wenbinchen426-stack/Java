// 文件: InterfaceDemo.java

import interfaces.Flyable;
import interfaces.Swimmable;
import interfaces.Vehicle;

/**
 * 演示接口（Interface）
 * 完全抽象的契约，支持多实现
 * 定义“能做什么”(can-do)
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("========== 接口 ==========");

        // 通过接口引用实现类对象
        Flyable bird = new Bird();
        bird.fly();

        Swimmable fish = new Fish();
        fish.swim();

        // 多接口实现
        Amphibian frog = new Amphibian();
        frog.fly();   // 青蛙尝试飞（演示效果）
        frog.swim();

        System.out.println("\n--- 接口常量 ---");
        System.out.println("Flyable.WINGS = " + Flyable.WINGS);

        System.out.println("\n--- Java 8 默认方法 ---");
        Vehicle car = new Car();
        car.drive();           // 实现类重写的方法
        car.horn();            // 接口默认方法
        Vehicle.staticMethod(); // 接口静态方法
    }
}

