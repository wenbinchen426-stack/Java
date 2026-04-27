/**
 * =============================================== 注解示例 ===============================================================
 */
class MyClass {
    // @Deprecated 标记方法已过时
    @Deprecated
    public void oldMethod() {
        System.out.println("这是一个过时的方法");
    }

    // @Override 检查是否正确重写
    @Override
    public String toString() {
        return "MyClass实例";
    }

    public void newMethod() {
        System.out.println("这是一个新方法");
    }
}
