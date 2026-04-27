public interface MyInterface {
    // 测试接口作为参数
    static void testInterface(Runnable r) {
        r.run();
    }
    // 修改基本类型（无效）
    static void modifyPrimitive(int x) {
        x = 100;
    }
    // 修改引用类型的属性（有效）
    static void modifyReference(Person p) {
        p.setName("小红");
        p.setAge(20);
    }
}
