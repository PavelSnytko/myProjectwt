package Thread;
/*
 Создать поток, который будет в цикле итерироваться от 1 до 10 000 000 и суммировать каждый четный элемент кратный 3.
  На каждой итерации, кратной 1 000 000, поток должен заснуть на 10мс.
  Вместе с суммирующим потоком запустить поток демон, который каждую пятую миллисекунду
  выводит в консоль текущее значение просуммированных элементов.
 */
public class MyThread extends Thread{
    static long sum = 0;

    public void run() {
        for (int i = 1; i < 10000000; i++) {
            if (i % 2 == 0 && i % 3 == 0) {
                sum += i;
            }
            if (i % 1000000 == 0) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    System.out.println("Thread has been interrupted");
                }
            }
        }
    }
}
