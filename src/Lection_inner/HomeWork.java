package Lection_inner;

public class HomeWork {
    public static void main(String[] args) {
        ellipse ellipse = new ellipse(12,12,12,12);
        System.out.println(ellipse.toString());
        System.out.println(ellipse.getArea());
        System.out.println(ellipse.getPerimeter());
        System.out.println(ellipse.compareArea(ellipse));

        Rectangle rectangle = new Rectangle(12, 12, 4,5);
        System.out.println(rectangle.toString());
        System.out.println(rectangle.getArea());
        System.out.println(rectangle.getPerimeter());
        System.out.println(rectangle.getDiagonal());
        System.out.println(rectangle.compareArea(ellipse));

        Shape shape = new Square(12,12,4);
        System.out.println(shape.toString());
        System.out.println(shape.getArea());
        System.out.println(shape.getPerimeter());
        System.out.println(shape.compareArea(shape));

        Triangle triangle = new Triangle(12, 12, 5,5,5);
        System.out.println(triangle.toString());
        System.out.println(triangle.getPerimeter());
        System.out.println(triangle.getArea());
        System.out.println(triangle.getHeight());
        System.out.println(triangle.getBisector());
        System.out.println(triangle.compareArea(shape));
    }
}
