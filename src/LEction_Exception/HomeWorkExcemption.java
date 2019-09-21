package LEction_Exception;

import java.util.Random;


public class HomeWorkExcemption {
    public static void main(String[] args) {
//        task1()-task7()
    }

    /**
     * 1 Объявите переменную со значением null. Вызовите метод у этой переменной.
     * Отловите возникшее исключение.
     */
    public static void task1() {
        try {
            String str = null;
            str.length();
        } catch (Exception e) {
            System.out.println(String.format("We catch a mistake in the block catch: %s", e.getClass()));
        }
    }

    /*
      3Создать собственный класс-исключение - наследник класса Exception.
      Создать метод, выбрасывающий это исключение.
      Вызвать этот метод и отловить исключение. Вывести stacktrace в консоль.
     */
    public static void task3() {
        try {
            myExceptionMethod(12);
        } catch (MyException e) {
            e.printStackTrace();
        }
    }

    public static void myExceptionMethod(int number) throws MyException {
        if (number >= 0) {
            throw new MyException();
        }
    }

    /*
     4Повторить предыдущее упражнение, но наследуя свой класс от класса RuntimeException.
     Добавить вконструктор своего класса возможность указания сообщения.
     */
    public static void task4() {
        try {
            myRuntimeExceptionMethod(12);//вызываем метод
        } catch (MyRuntimeException e) { //ловим ошибку
            e.printStackTrace(); //выводим стектрейс в консоль
            System.out.println(e.getMessage());
        }
    }

    public static void myRuntimeExceptionMethod(int number) throws MyRuntimeException {
        if (number >= 0) {
            throw new MyRuntimeException("caught an  MyRuntimeException");
        }
    }

    /*
      5Бросить одно из существующих в JDK исключений, отловить его и выбросить своё собственное, указав в качестве причины отловленное.
     */
    public static void task5() throws MyRuntimeException {
        try {
            String str = null;
            str.length();
        } catch (Exception e) {
            throw new MyRuntimeException(String.format("caught an exception: %s", e.getCause()));

        }
    }

    /*
     6Создать метод случайным образом выбрасывающий одно из 3-х видов исключений.
     Вызвать этот метод в блоке try-catch, отлавливающем любое из 3-х.
     */
    public static void task6() {
        try {
            getRuntimeException();
        } catch (RuntimeException e) {
            System.out.println(String.format("catch the exception: %s", e.getClass()));
        }
    }

    public static void getRuntimeException() {
        Random random = new Random();
        int number = random.nextInt(3);
        System.out.println(number);
        if (number == 1) {
            throw new NullPointerException();
        } else if (number == 2) {
            throw new ArithmeticException();
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    /*
      7Написать метод, который в 50% случаев бросает исключение.
      Вызвать этот метод в конструкции try-catch-finally. Протестировать работу блока finally.
     */
    public static void task7() {
        try{
            getException();
        } catch (MyException e) {
            System.out.println(String.format("Catching a mistake: %s", e.getClass()));
            e.printStackTrace();
        }finally {
            System.out.println("Block finally");
        }
    }

    public static void getException() throws MyException {
        Random random = new Random();
        boolean flag = random.nextBoolean();
        System.out.println(flag);
        if (flag) {
            throw new MyException();
        }
    }
}


