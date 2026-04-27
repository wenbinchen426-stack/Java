package interfaces;

//========================================
// 接口示例
//========================================
public interface Drawable {
    double PI = 3.14159;  // public static final

    void draw();          // public abstract

    // default 方法 (Java 8)
    default void printType() {
        System.out.println("这是一个可绘制对象");
    }

    // static 方法 (Java 8)
    static void printStatic() {
        System.out.println("接口静态方法");
    }
}
