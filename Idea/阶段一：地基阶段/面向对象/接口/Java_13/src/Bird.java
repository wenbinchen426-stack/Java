import interfaces.Flyable;

// 实现单个接口
public class Bird implements Flyable {
    @Override
    public void fly() {
        System.out.println("小鸟在天空中飞翔");
    }
}
