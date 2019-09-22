package lection_collection;

import java.util.ArrayList;
import java.util.Iterator;

public class mark {

    /* 1. Создать список оценок учеников с помощью ListIterator,
    заполнить случайными оценками. Удалить неудовлетворительные оценки из списка*/


    public static void main(String[] args) {
        int element = 10;
        int negative = 4;
        ArrayList<Integer> mark = new ArrayList<Integer>();
        for (int i = 0; i < element; i++) {
            mark.add(i, (int) (Math.random() * 10 + 1));
        }
        System.out.println(mark);
        mark.removeIf(score -> score <= negative);
        System.out.println(mark);
    }
}




