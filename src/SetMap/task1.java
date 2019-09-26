package SetMap;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

public class task1 {
    /*
       Написать метод countUnique, который принимает целочисленный список в качестве параметра и возвращает количество уникальных целых чисел в этом списке.
   При получении пустого списка метод должен возвращать 0.
    Пример [3, 7, 3, -1, 2, 3, 7, 2, 15, 15] вернёт 5.
     */

    public static void main(String[] args) {
        ArrayList mass = new ArrayList();
        mass.add(2);
        mass.add(5);
        mass.add(2);
        mass.add(4);
        mass.add(3);
        mass.add(7);
        mass.add(8);
        mass.add(5);
        mass.add(12);
        mass.add(-1);
        System.out.println(mass+ " " + "Колчисетво уникальных элементов : " + countUnique(mass));
    }


    private static int countUnique(ArrayList list) {
        if (list.size() == 0) {
            return 0;
        } else {
            Set set = new LinkedHashSet(list);
            return set.size();
        }
    }
}

