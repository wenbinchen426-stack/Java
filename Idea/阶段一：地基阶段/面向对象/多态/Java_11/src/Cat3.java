public class Cat3 extends Animal3 {
    public Cat3(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println(name + " 喵喵喵～");
    }
}
