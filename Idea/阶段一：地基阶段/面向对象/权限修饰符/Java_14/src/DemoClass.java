public class DemoClass {
    private int privateField = 0;
    int defaultField = 1;           // 无修饰符 = default（包级私有）
    protected int protectedField = 2;
    public int publicField = 3;

    private void privateMethod() {
        System.out.println("private 方法");
    }

    void defaultMethod() {
        System.out.println("default 方法（包级私有）");
    }

    protected void protectedMethod() {
        System.out.println("protected 方法");
    }

    public void publicMethod() {
        System.out.println("public 方法");
    }

    // 通过公有方法访问私有成员
    public void setPrivateField(int value) {
        this.privateField = value;
    }

    public int getPrivateField() {
        return privateField;
    }
}
