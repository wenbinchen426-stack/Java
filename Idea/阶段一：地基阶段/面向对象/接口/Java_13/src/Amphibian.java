import interfaces.Flyable;
import interfaces.Swimmable;

// 实现多个接口
public class Amphibian implements Flyable, Swimmable {
    @Override
    public void fly() {
        System.out.println("两栖动物尝试飞行（其实不能）");
    }

    @Override
    public void swim() {
        System.out.println("两栖动物在水中游泳");
    }
}
