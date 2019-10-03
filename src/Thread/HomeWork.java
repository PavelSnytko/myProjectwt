package Thread;

public class HomeWork {
    public static void main(String[] args) {
        task01();
        task02();
    }


    /*
     1. Создать поток, который будет в цикле итерироваться от 1 до 10 000 000 и суммировать каждый четный элемент кратный 3.
      На каждой итерации, кратной 1 000 000, поток должен заснуть на 10мс.
      Вместе с суммирующим потоком запустить поток демон, который каждую пятую миллисекунду
      выводит в консоль текущее значение просуммированных элементов.
     */
    public static void task01() {
        MyThread myThread = new MyThread();
        final Thread myDaemonThread = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    System.out.println("Thread has been interrupted");
                }
                System.out.println(MyThread.sum);
            }
        });
        myDaemonThread.setDaemon(true);
        myThread.start();
        myDaemonThread.start();
        System.out.println("End");
    }

    /*
     2. Безумный учёный каждую ночь на протяжении 50 суток отправляет своего прислужника на свалку фабрики роботов за деталями.
      Чтобы собрать одного робота нужно:
      Голова, Тело, Левая рука, Правая рука, Левая нога, Правая нога, CPU, RAM, HDD
     В первую ночь на свалке находится 20 случайных деталей. Каждую последующую ночь фабрика выбрасывает на свалку от 1 до 4 случайных деталей.
      В то же самое время прислужник отправляются на свалку и собирает от 1 до 4 случайных деталей.
      Если на свалке деталей нет – прислужник уходит ни с чем.
      Затем он возвращаются домой и отдаёт детали хозяину.
      Учёный пытается собрать робота из деталей, которые есть в наличии.
      Написать программу, симулирующую этот процесс. Для симуляции принять, что каждая ночь наступает через 100мс.
      Фабрика и прислужник действуют в одно и то же время.
      После 50 ночей (около 5 секунд) определить количество собранных роботов.
     */
    public static void task02() {
        RubbishDump rubbishDump = Rubbish_Dump.getInstance();

        Factory factory = new Factory(rubbishDump, 14);
        Minion minion = new Minion(rubbishDump, 14);

        factory.start();
        minion.start();

        try {
            factory.join();
            minion.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(String.format("Created robots: %d", minion.getCreatedRobotsCount()));
    }
}
