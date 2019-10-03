package Lection_inner;

public class ShapeUtils {
    public static String getShapeType(Shape shape) {
        if (shape instanceof Quadrangle) {
            return "прямоугольник";
        } else if (shape instanceof Triangle) {
            return "треугольник";
        } else {
            return "Не удалось определить тип фигуры";
        }
    }
}
