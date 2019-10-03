package Lection_inner;

public abstract class Shape implements IShape {
    protected float x;
    float y;

    public Shape(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public boolean compareArea(Shape shape){
        return this.getArea() == shape.getArea();
    }

    public abstract float getPerimeter();
}
