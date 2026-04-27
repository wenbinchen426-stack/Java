// 同包子类
public class SubClass extends DemoClass {
    public void testAccess() {
        // privateField = 10;   // ❌ private 不可访问
        defaultField = 10;       // ✅ default：同包子类可访问
        protectedField = 10;     // ✅ protected：同包子类可访问
        publicField = 10;        // ✅ public：任何地方可访问

        // privateMethod();       // ❌
        defaultMethod();          // ✅
        protectedMethod();        // ✅
        publicMethod();           // ✅

        System.out.println("子类访问同包父类的 protected/default 成员成功");
    }
}
