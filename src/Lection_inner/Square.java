package Lection_inner;

public class Square extends Quadrangle {
    public Square(float x, float y, float width) {
        super(x, y, width, width);
    }

    @Override
    public float getPerimeter() {
        return super.getWidth() * 4;
    }

    @Override
    public float getArea() {
        return super.getWidth() * super.getWidth();
    }

    @Override
    public float getDiagonal() {
        return (float) (Math.sqrt(2) * super.getWidth());
    }

    @Override
    public String toString() {
        return String.format("Это квадрат со стороной %.2f", super.getWidth());
    }
}
