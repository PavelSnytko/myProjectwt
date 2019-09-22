package lection_collection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

 class task7 {
    /*7.	Использовать Алгоритмы. Не используя вспомогательных объектов, переставить
    отрицательные элементы сгенерированного списка в конец, а положительные – в начало этого списка.*/
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(3);// задаю положительные значения
        linkedList.add(-3);// задаю отрицательные значения
        linkedList.add(7);
        linkedList.add(-1);
        linkedList.add(5);
        linkedList.add(-4);
        linkedList.add(7);
        linkedList.add(-4);
        linkedList.add(6);
        Iterator iterator = linkedList.listIterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next()+ " ");
        }

        for (int i = 0; i < linkedList.size(); i++) {
            if ((int) linkedList.get(i) < 0) {
                linkedList.addLast(linkedList.get(i));
                linkedList.remove(i);
            }
        }

        System.out.println("\n");

        for (Object value : linkedList) {
            System.out.print(value + " ");

        }
    }
}
