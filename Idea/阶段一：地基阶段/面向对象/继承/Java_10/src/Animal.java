public class Animal {
    protected String name;
    protected int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println("Animal 构造器被调用");
    }

    public void eat() {
        System.out.println(name + " 正在吃东西");
    }
}
