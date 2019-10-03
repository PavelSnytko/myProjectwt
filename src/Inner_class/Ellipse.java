package Inner_class;

public class Ellipse extends Shape {
    private float firstRadius;
    private float secondRadius;

    public Ellipse(float x, float y, float firstRadius, float secondRadius) {
        super(x, y);
        this.firstRadius = firstRadius;
        this.secondRadius = secondRadius;
    }

    public float getFirstRadius() {
        return firstRadius;
    }

    public float getSecondRadius() {
        return secondRadius;
    }


    @Override
    public float getPerimeter() {
        return (float) (Math.PI * (this.firstRadius + this.secondRadius));
    }

    @Override
    public float getArea() {
        return (float) (Math.PI * firstRadius * secondRadius);
    }

    @Override
    public String toString() {
        return String.format(" эллипс имеет радиусы %.2f и %.2f", this.firstRadius, this.secondRadius);
    }
}
