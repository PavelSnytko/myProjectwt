package Inner_class;

public class ShapeUtils {
    public static String getShapeType(Shape shape) {
        if (shape instanceof Quadrangle) {
            return " прямоугольник";
        } else if (shape instanceof Triangle) {
            return " треугольник";
        } else {
            return "Не определенный тип фигуры";
        }
    }
}
