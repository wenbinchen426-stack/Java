public class Dog extends Animal {
    public Dog(String name, int age) {
        super(name, age);   // 调用父类构造器
    }

    @Override
    public void eat() {
        System.out.println(name + " 正在吃骨头");
    }

    public void bark() {
        System.out.println(name + " 汪汪叫");
    }
}
