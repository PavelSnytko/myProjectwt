package lection_collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

//Определить множество на основе множества целых чисел. Создать методы для определения пересечения и объединения множеств.
public class task5 {
    public static void main(String[] args) {

        Collection list1 = new ArrayList();
        Collection list2 = new ArrayList();

        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        list1.add(5);

        list2.add(4);
        list2.add(5);
        list2.add(6);
        list2.add(7);
        list2.add(8);

        Object allRes = combine(list1, list2);

        System.out.println(allRes);

        list1.retainAll(list2);
        System.out.println(list1);

    }

    static Object combine(Object a, Object b) {
        ArrayList allRes = new ArrayList();
        allRes.addAll((Collection) a);
        allRes.addAll((Collection) b);
        return allRes;
    }
}





