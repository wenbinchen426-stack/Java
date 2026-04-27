// 文件: InheritanceDemo.java
/**
 * 演示继承（Inheritance）
 * 子类继承父类，复用代码，形成体系结构
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("========== 继承 ==========");

        Dog dog = new Dog("旺财", 3);
        dog.eat();      // 继承自 Animal
        dog.bark();     // 子类特有方法

        Cat cat = new Cat("咪咪", 2);
        cat.eat();
        cat.meow();

        // 向上转型：父类引用指向子类对象
        Animal animal = new Dog("大黄", 4);
        animal.eat();       // 调用的是 Dog 的 eat()（如果重写）
        // animal.bark();    // 编译错误，父类引用不能调用子类特有方法

        System.out.println("\n--- 继承层次 ---");
        System.out.println("Dog 是 Animal 的子类");
        System.out.println("Animal 是 Object 的子类");
    }
}

