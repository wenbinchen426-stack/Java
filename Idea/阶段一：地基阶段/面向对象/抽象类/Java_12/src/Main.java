// 文件: AbstractClassDemo.java
/**
 * 演示抽象类（Abstract Class）
 * 不能实例化，可包含抽象方法和具体方法
 * 用于定义模板，子类必须实现抽象方法
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("========== 抽象类 ==========");

        // Shape shape = new Shape();  // ❌ 抽象类不能实例化

        Shape circle = new Circle(5.0);
        Shape rectangle = new Rectangle(4, 6);

        circle.draw();
        rectangle.draw();

        // 调用抽象类中的具体方法
        circle.display();
        rectangle.display();

        System.out.println("\n--- 模板方法模式示例 ---");
        Game game1 = new Football();
        Game game2 = new Basketball();
        game1.play();   // 模板方法，定义了算法骨架
        game2.play();
    }
}

