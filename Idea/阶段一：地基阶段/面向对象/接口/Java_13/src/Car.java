import interfaces.Vehicle;

public class Car implements Vehicle {
    @Override
    public void drive() {
        System.out.println("汽车在行驶");
    }

    // 可以选择重写默认方法
    @Override
    public void horn() {
        System.out.println("汽车喇叭：嘟嘟");
    }
}
