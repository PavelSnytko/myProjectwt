package lection19_threadSynchronized;
import Thread.Factory;
import Thread.RubbishDump;
import Thread.Minion;
import Thread.Rubbish_Dump;

import java.math.BigDecimal;
import java.util.*;
public class Homework {
    public static void main(String[] args) {
        task01();
        task02();
    }

    /*
      1. Двое безумных учёных устроили соревнование, кто из них соберёт больше роботов за 100 ночей.
      Для этого каждую ночь каждый из них отправляет своего прислужника на свалку фабрики роботов за деталями.
      Чтобы собрать одного робота им нужно:
      Голова, Тело, Левая рука, Правая рука, Левая нога, Правая нога, CPU, RAM, HDD
      В первую ночь на свалке находится 20 случайных деталей. Каждую последующую ночь фабрика выбрасывает на свалку от 1 до 4 случайных деталей.
      В то же самое время прислужники обоих учёных отправляются на свалку, и каждый собирает от 1 до 4 случайных деталей.
      Если на свалке деталей нет – прислужник уходит ни с чем.
      Затем они возвращаются домой и отдают детали хозяевам.
      Учёные пытаются собрать как можно больше роботов из деталей, которые они получили.
      Написать программу, симулирующую этот процесс. Для симуляции принять, что каждая ночь наступает через 100мс.
      Фабрика и два прислужника действуют в одно и то же время.
      После 100 ночей (около 10 секунд) определить победителя соревнования.
     */
    public static void task01() {
        Rubbish_Dump rubbishDump = Rubbish_Dump.getInstance();

        Factory factory = new Factory(rubbishDump, 100);
        Minion fstMinion = new Minion(rubbishDump, 100);
        Minion sndMinion = new Minion(rubbishDump, 100);

        factory.start();
        fstMinion.start();
        sndMinion.start();

        try {
            factory.join();
            fstMinion.join();
            sndMinion.join();
        } catch (InterruptedException e) {
            System.out.println("Thread has been interrupted");
        }
        System.out.println(String.format("First minion create %d robots", fstMinion.getCreatedRobotsCount()));
        System.out.println(String.format("Second minion create %d robots", sndMinion.getCreatedRobotsCount()));

        if (fstMinion.getCreatedRobotsCount() > sndMinion.getCreatedRobotsCount()){
            System.out.println("First minion win!");
        }else {
            System.out.println("Second minion win!");
        }
    }

    /*
      Замечание: Создать многопоточное приложение, корректно работающее с разделяемыми ресурсами и избегающие ситуации взаимной блокировки.
      Любая сущность, желающая получить доступ к разделяемому ресурсу, должна быть потоком
    Магазин имеет перечень товаров (класс Good со свойствами: id, name, price, discount (0-0.89))
      {Пиво, Водка, чипсы, хлеб, молоко, селедка, кефир, батон, гречка, колбаски, йогурт и булочка из печки}.
     Поток "Покупатель" логирует свои действия в магазине
      (Например: Покупатель n зашел в магазин. Покупатель n выбрал товар M в количестве 2 и т.д.).
      Покупатель может положить в корзину от 0 до к товаром разным количеством (для каждого потока покупателя определяется случайным образом).
      Если покупатель ничего не выбрал, то он логирует это и покидает магазин.
     Если корзина (ShoppingBasket) не пуста, то покупатель становится в единую очередь, которую обслуживают несколько касс от 1-3.
     Первая, освободившаяся касса, обслуживает первого из очереди покупателя.
      Время обслуживания пропорционально равно количеству покупок в корзине покупателя.
      Касса логирует все действия с товарами покупателя и формирует сумму покупки.
      Поток покупатель выдает случайным образом сумму больше или равную запрашиваемой.
      После этого Касса выдает чек, формирует объект Receipt (id, date, casseNo, List<Item>, totalSum, change).
      Где Item, класс идентифицирующий товарную позицию в чеке (Item: No -порядковый номер позиции, Good, quantity, cost, discount, discountAmount).
      Печатается текст чека Покупатель выходит из магазина и сообщает об этом.
     */
    public static void task02(){
        Map<Good, Integer> goodsForStore = prepareGoods();
        Cashier fstCashier = new Cashier(1);
        Cashier sndCashier = new Cashier(2);
        Cashier thdCashier = new Cashier(3);

        Store store = new Store(goodsForStore, fstCashier, sndCashier, thdCashier);

        Customer customerJohn = new Customer("John", store);
        Customer customerJim = new Customer("Jim", store);
        Customer customerBob = new Customer("Bob", store);
        Customer customerLiza = new Customer("Liza", store);
        Customer customerMary = new Customer("Mary", store);
        Customer customerJill = new Customer("Jill", store);

        new Thread(customerJohn).start();
        new Thread(customerJim).start();
        new Thread(customerBob).start();
        new Thread(customerLiza).start();
        new Thread(customerMary).start();
        new Thread(customerJill).start();
    }

    private static Map<Good, Integer> prepareGoods() {
        Map<Good, Integer> goodsForStore = new HashMap<>();
        goodsForStore.put(new Good("Beer", new BigDecimal(2.98), 0.89), 1000);
        goodsForStore.put(new Good("Vodka", new BigDecimal(5.6), 0), 1000);
        goodsForStore.put(new Good("Chips", new BigDecimal(1.98), 0.5), 1000);
        goodsForStore.put(new Good("Bread", new BigDecimal(1.5), 0.25), 1000);
        goodsForStore.put(new Good("Milk", new BigDecimal(1.34), 0.1), 1000);
        goodsForStore.put(new Good("Fish", new BigDecimal(3.34), 0.16), 1000);
        goodsForStore.put(new Good("Kefir", new BigDecimal(1.8), 0), 1000);
        goodsForStore.put(new Good("Loaf", new BigDecimal(1), 0), 1000);
        goodsForStore.put(new Good("Buckwheat", new BigDecimal(3.1), 0.7), 1000);
        goodsForStore.put(new Good("Sausages", new BigDecimal(2.1), 0.7), 1000);
        goodsForStore.put(new Good("Yogurt", new BigDecimal(1.12), 0.31), 1000);
        goodsForStore.put(new Good("Bun from the stove", new BigDecimal(1.55), 0), 1000);
        return goodsForStore;
    }
}
