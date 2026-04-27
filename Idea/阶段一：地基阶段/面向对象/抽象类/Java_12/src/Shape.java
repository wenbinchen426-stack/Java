// 抽象类
public abstract class Shape {
    protected String color = "红色";

    public Shape() {
        System.out.println("Shape 构造器被调用");
    }

    // 抽象方法：子类必须实现
    public abstract void draw();

    // 具体方法：子类可直接使用或重写
    public void display() {
        System.out.println("这是一个" + color + "的图形");
    }
}
