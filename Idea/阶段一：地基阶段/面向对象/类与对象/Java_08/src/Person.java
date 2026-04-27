public class Person {
    private String name;
    private int age;
    private static int count = 0;   // 类变量

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        count++;
    }

    public void sayHello() {
        System.out.println("你好，我是 " + name + "，今年" + age + "岁");
    }

    public static int getCount() {
        return count;
    }

    public String getName() {
        return name;
    }
}
