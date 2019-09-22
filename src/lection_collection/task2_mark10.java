package lection_collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

/*2	Задание. Создать список оценок учеников с помощью ListIterator,
   заполнить случайными оценками. Найти самую высокую оценку с использованием итератора.*/
public class task2_mark10 {
    public static void main(String[] args) {
        Random random = new Random();
        ArrayList marks = new ArrayList();
        for (int i = 0; i < 10; i++) {
            marks.add(random.nextInt(10) + 1);
        }


        int maxMark = 0;
        for (int i = 0; i < marks.size(); i++) {
            if ((int) marks.get(i) > maxMark) maxMark = (int) marks.get(i);

        }
        System.out.println("Самая высокая оценка из " + marks + " вывод " + maxMark);

    }
}
