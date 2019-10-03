package Inner_class;

public abstract class Quadrangle extends Shape implements IQuadrangle {
    private float width;
    private float height;

    public Quadrangle(float x, float y, float wight, float height) {
        super(x, y);
        this.width = wight;
        this.height = height;
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }
}
