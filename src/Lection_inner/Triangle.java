package Lection_inner;

public class Triangle extends Shape implements ITriangle {
    private float sideA;
    private float sideB;
    private float sideC;

    public Triangle(float x, float y, float sideA, float sideB, float sideC) {
        super(x, y);
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    public float getSideA() {
        return sideA;
    }

    public float getSideB() {
        return sideB;
    }

    public float getSideC() {
        return sideC;
    }

    @Override
    public float getPerimeter() {
        return this.sideA + this.sideB + this.sideC;
    }

    @Override
    public float getArea() {
        float p = this.getPerimeter() / 2;
        return (float) Math.sqrt(p * (p - this.sideA) * (p - this.sideB) * (p - this.sideC));
    }

    @Override
    public float getHeight() {
        float p = this.getPerimeter() / 2;
        return 2 * this.getArea() / this.sideA;
    }

    @Override
    public float getBisector() {
        float p = this.getPerimeter() / 2;
        return (float) ((2 * Math.sqrt(this.sideA * this.sideB * p * (p - this.sideC))) / (this.sideA + this.sideB));
    }

    @Override
    public String toString() {
        return String.format("Это треугольник со сторонами %.2f, %.2f и %.2f", this.sideA, this.sideB, this.sideC);
    }

}
