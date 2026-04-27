public class Dog3 extends Animal3 {
    public Dog3(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println(name + " 汪汪汪！");
    }
}
