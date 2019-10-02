package Lambda;
/*	Дан список целых чисел. Найти среднее всех нечётных чисел, делящихся на 5.*/

import java.util.ArrayList;
import java.util.Random;

public class task1 {
    public static void main(String[] args) {
        Random random = new Random();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add(random.nextInt(100) + 1);
        }
        int result = list.stream().filter(element -> element % 2 != 0 && element % 5 == 0).mapToInt(element -> element).sum();
        System.out.println(result);
    }
}



