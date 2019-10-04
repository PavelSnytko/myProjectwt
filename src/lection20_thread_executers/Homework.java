package lection20_thread_executers;
import java.util.*;
import java.util.concurrent.*;

public class Homework {
    public static void main(String[] args) {
        task01();
//        task02();
    }


    /*
      1. Написать программу, бесконечно считывающую пользовательские числа из консоли.
     Эти числа представляют собой количество секунд. При каждом вводе числа, должна создаваться задача,
     которая засыпает на введённое число секунд и затем выводит "Я спал N секунд".
      Однако нужно сделать так, чтобы все задачи выполнялись в одном и том же потоке в порядке ввода.
      Т.е. в программе есть 2 потока: главный и поток для выполнения всех задач по очереди.
      При вводе -1 программа должна завершать свою работу.
     */
    public static void task01() {
        String infoText = "Enter an integer (or -2 to exit): ";
        int taskNumber = 1;
        int delay;

        ExecutorService executor = Executors.newSingleThreadExecutor();

        while ((delay = getIntValue(infoText)) != -2) {
            executor.execute(new TaskThread("TaskThread " + taskNumber++, delay));
        }
        System.out.println("\n" + "We complete the work without waiting for all tasks in the queue");
        executor.shutdownNow();
    }

    /*
      Метод считывает с консоли целое число. Если число больше -1 метод вернет его, иначе снова запросит ввод с консоли
     */
    public static int getIntValue(String infoText) {
        System.out.print(infoText);
        Scanner sc = new Scanner(System.in);
        int intValue;
        do {
            while (!sc.hasNextInt()) {
                System.out.print(infoText);
                sc.next();
            }
            intValue = sc.nextInt();
            if (intValue < -1) {
                System.out.print(infoText);
            }
        } while (intValue < -1);

        return intValue;
    }


    /*
      2. Задан массив случайных целых чисел (от 1 до 300) случайной длины (1 млн элементов).
      Найти максимальный элемент в массиве двумя способами: в одном потоке и используя 10 потоков.
      Сравнить затраченное в обоих случаях время.
     */
    public static void task02() {
        int[] intArray = generateIntArray();
        int threadCount = 10;
        if (intArray.length >= threadCount) {
            List<int[]> intArraysList = divineIntArray(intArray, threadCount);

            long timeForSingleThreadExecutor = measureTime(() -> getMaxValueBySingleThreadExecutor(intArray));
            System.out.println(String.format("\n" + "When using one thread spent: %d ns", timeForSingleThreadExecutor));

            long timeForTenThreadExecutor = measureTime(() -> getMaxValueByFixedThreadExecutor(intArraysList, threadCount));
            System.out.println(String.format("\n" + "When using one thread spent: %d ns", timeForTenThreadExecutor));

            if (timeForSingleThreadExecutor < timeForTenThreadExecutor) {
                System.out.println("\n" + "Search using a single thread worked faster");
            } else {
                System.out.println("\n" + "Search using a single thread worked faster");
            }
        }else{
            System.out.println(String.format("Д\n" + "the length of the array is less than %d elements, the experiment makes no sense",threadCount));
        }
    }

    /*
      Метод выполняет поиск максимального элемента в массиве используя один поток
     */
    public static void getMaxValueBySingleThreadExecutor(int[] intArray) {

        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<Integer> future = executor.submit(new MaxFinder(intArray));

        try {
            System.out.println(String.format("max mass: %d", future.get()));
        } catch (InterruptedException e) {
            System.out.println("Thread has been interrupted");
        } catch (ExecutionException e) {
            System.out.println("Thread execution exception");
        }
        executor.shutdownNow();
    }

    /*
      Метод выполняет поиск максимального элемента в массиве используя 10 потоков
     */
    public static void getMaxValueByFixedThreadExecutor(List<int[]> intArraysList, int threadCount) {
        ExecutorService executor = Executors.newFixedThreadPool(threadCount);

        int[] maxIntArray = new int[threadCount];

        for (int i = 0; i < threadCount; i++) {
            Future<Integer> future = executor.submit(new MaxFinder(intArraysList.get(i)));
            try {
                maxIntArray[i] = future.get();
            } catch (InterruptedException e) {
                System.out.println("Thread has been interrupted");
            } catch (ExecutionException e) {
                System.out.println("Thread execution exception");
            }
        }
        System.out.println(String.format("max mass: %d", getMax(maxIntArray)));

        executor.shutdownNow();
    }

    /*
     Метод делит целочисленный массив на указанное количество частей
     */
    public static List<int[]> divineIntArray(int[] intArray, int threadCount) {
        List<int[]> arraysList = new ArrayList<>();

        int delta = intArray.length / threadCount;
        int fromIndex = 0;
        int toIndex = delta;
        for (int i = 0; i < threadCount; i++) {
            arraysList.add(Arrays.copyOfRange(intArray, fromIndex, toIndex));
            fromIndex += delta;
            if (i == threadCount - 2) {
                toIndex += delta + intArray.length % threadCount;
            } else {
                toIndex += delta;
            }
        }

        return arraysList;
    }

    /*
      Метод возвращает значение максимального элемента целочисленного массива
     */
    public static int getMax(int[] array) {
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    /**
     * Метод генерирует массив случайных целых чисел (от 1 до 300) случайной длины (до 1 млн элементов).
     */
    public static int[] generateIntArray() {
        Random rm = new Random();
        int length = rm.nextInt(1000000) + 1;
        System.out.println(String.format("Длина массива: %d", length));
        int[] intArray = new int[29];
        for (int i = 0; i < intArray.length; i++) {
            intArray[i] = rm.nextInt(300) + 1;
        }
        return intArray;
    }

    /*
      Возвращает время выполнения переданной функции
     */
    public static long measureTime(Runnable runnable) {
        long startTime = System.nanoTime();
        runnable.run();
        return System.nanoTime() - startTime;
    }

}
