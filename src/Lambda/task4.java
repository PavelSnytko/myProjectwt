package Lambda;

import java.util.ArrayList;

/*	Дан список целых чисел, вывести строку, представляющую собой конкатенацию строковых представлений этих чисел.*/
public class task4 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(8);
        list.add(6);
        list.add(2);
        list.add(4);
        list.add(1);
        StringBuffer sb = new StringBuffer();

        list.forEach(value -> sb.append(value.toString()));
        System.out.println(sb.toString());
    }
}
