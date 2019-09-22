package lection_collection;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class task3 {
    /* Вывести учеников из списка в обратном порядке. (2 варианта решения).*/
    public static void main(String[] args) {
        List pupils = new LinkedList();
        pupils.add("Burbon");
        pupils.add("Pol");
        pupils.add("Timon");
        pupils.add("Djeck");
        pupils.add("Vandam");
        pupils.add("Bob");
        pupils.add("Anton");
        for (int i = pupils.size() - 1; i >= 0; --i) {
            System.out.print(pupils.get(i) + " ");

        }
        System.out.println("\n");
        ListIterator iterator = pupils.listIterator();

        while (iterator.hasNext()) {
            iterator.next();
        }
        while (iterator.hasPrevious()) {
            System.out.print(iterator.previous() + " ");
        }

    }
}



