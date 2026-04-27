package abstracts;

//========================================
// 抽象类示例
//========================================
public abstract class Animal {
    protected String name;

    public Animal(String name) {
        this.name = name;
    }

    // 抽象方法：子类必须实现
    public abstract void makeSound();

    // 具体方法：公共行为
    public void sleep() {
        System.out.println(name + " 正在睡觉");
    }

    public String getName() {
        return name;
    }
}
