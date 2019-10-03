package Inner_class;

public class Rectangle extends Quadrangle {
    public Rectangle(float x, float y, float wight, float height) {
        super(x, y, wight, height);
    }

    @Override
    public float getPerimeter() {
        return super.getWidth() * 2 + super.getHeight() * 2;
    }

    @Override
    public float getArea() {
        return super.getWidth() * super.getHeight();
    }

    @Override
    public float getDiagonal() {
        return (float) Math.sqrt(Math.pow(super.getWidth(), 2) + Math.pow(super.getHeight(), 2));
    }

    @Override
    public String toString() {
        return String.format(" прямоугольник имеет стороны %.2f и %.2f", super.getWidth(), super.getHeight());
    }
}
