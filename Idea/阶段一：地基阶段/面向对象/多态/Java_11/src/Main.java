// 文件: PolymorphismDemo.java
/**
 * 演示多态（Polymorphism）
 * 编译时多态：方法重载
 * 运行时多态：方法重写 + 父类引用子类对象
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("========== 运行时多态 ==========");

        Animal3 a1 = new Dog3("旺财");
        Animal3 a2 = new Cat3("咪咪");

        a1.makeSound();   // 调用 Dog3 的 makeSound
        a2.makeSound();   // 调用 Cat3 的 makeSound

        // 多态参数：方法可接收任何 Animal3 子类
        System.out.println("\n--- 多态参数示例 ---");
        letAnimalSpeak(a1);
        letAnimalSpeak(a2);

        System.out.println("\n========== 编译时多态（方法重载） ==========");
        Calculator calc = new Calculator();
        System.out.println("add(1, 2) = " + calc.add(1, 2));
        System.out.println("add(1.5, 2.5) = " + calc.add(1.5, 2.5));
        System.out.println("add(1, 2, 3) = " + calc.add(1, 2, 3));
    }

    // 多态参数：方法参数为父类类型，可接收任何子类
    public static void letAnimalSpeak(Animal3 animal) {
        animal.makeSound();
    }
}

