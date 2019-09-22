package lection_collection;

import java.util.*;


/* 4.	Ввести с консоли число, занести его цифры в стек. Стек – самостоятельно спроектированный класс, поддерживающий 3 операции:
             •	Задать размер стека.
             •	Внести цифру в стек.
             •	Извлечь цифру из стека.
             Вывести число, у которого цифры идут в обратном порядке.
*/
public class task4Stack {
    public static void main(String[] args) {


    Scanner in = new Scanner(System.in);


        System.out.print("Задайте размер стека : ");
    int size = in.nextInt();
    Stack stack = new Stack(size);
        System.out.printf("Добавьте %d элемент(а) в стек :\n", size);

        for (int i = 0; i < size; i++) {
        System.out.printf("(%d) ", i);
        stack.setNumer(in.nextInt());
    }

        System.out.println("Какую элемент стека желаете извлечь ? - ");
        System.out.println("Ваш элемент : " + stack.getNumer((in.nextInt())));
        System.out.println("Ваш стек в обратном порядке " + stack.numerFromEnd());


}


}


class Stack {

    private List stack = new ArrayList();


    public Stack() {
        System.out.println("Создан безразмерный стек !");

    }


    public Stack(int size) {
        stack = new ArrayList(size);
        System.out.println("Создан стек размером " + size);
    }


    public Object getNumer(int i) {
        ;
        return stack.get(i);

    }


    public void setNumer(Object numer) {

        stack.add(numer);
    }

    public String numerFromEnd() {


        List stackFromEnd = new ArrayList();
        for (int i = stack.size() - 1; i >= 0; --i) {
            stackFromEnd.add(stack.get(i));
        }

        String ans = "";
        Iterator iterator = stackFromEnd.listIterator();
        while (iterator.hasNext()) {
            ans+= iterator.next().toString();

        }


        return ans;
    }


}