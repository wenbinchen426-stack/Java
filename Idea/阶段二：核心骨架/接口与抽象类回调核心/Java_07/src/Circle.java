import interfaces.Drawable;

class Circle implements Drawable {
    @Override
    public void draw() {
        System.out.println("画一个圆形");
    }
}
