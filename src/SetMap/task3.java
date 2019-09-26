package SetMap;

import java.util.HashMap;
import java.util.Map;

/*Сложить два многочлена заданной степени, если коэффициенты многочленов хранятся в двух объектах HashMap в виде:
    Ключ: номер степени
    Значение: значение множителя
    Вывести результирующий многочлен в виде строки: ax^6 + bx^4 + cx^3 + dx + 8
*/
public class task3 {
    public static void main(String[] args) {
        Map<Integer, String> values = new HashMap<>();
        values.put(6,"a");
        values.put(4,"b");
        values.put(3,"c");
        values.put(1,"d");
        values.put(0,"8");


        String res = values.get(6)+"x^6 + "+values.get(4)+"x^4 + "+values.get(3)+"x^3 + "+values.get(1)+"x + "+values.get(0);
        System.out.println(res);
    }
}
