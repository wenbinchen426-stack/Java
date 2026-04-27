package interfaces;

// Java 8 接口新特性
public interface Vehicle {
    void drive();   // 抽象方法

    default void horn() {   // 默认方法，实现类可重写也可不重写
        System.out.println("按喇叭：滴滴");
    }

    static void staticMethod() {
        System.out.println("接口的静态方法");
    }
}
