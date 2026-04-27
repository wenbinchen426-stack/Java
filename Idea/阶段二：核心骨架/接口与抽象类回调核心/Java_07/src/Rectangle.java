import interfaces.Drawable;

class Rectangle implements Drawable {
    @Override
    public void draw() {
        System.out.println("画一个矩形");
    }
}
