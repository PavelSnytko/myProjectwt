package lection20_thread_executers;
import java.util.concurrent.Callable;

/*
   2. Задан массив случайных целых чисел (от 1 до 300) случайной длины (1 млн элементов).
   Найти максимальный элемент в массиве двумя способами: в одном потоке и используя 10 потоков.
   Сравнить затраченное в обоих случаях время.
*/
 public class MaxFinder  implements Callable<Integer> {

        private int[] intArray;

        public MaxFinder(int[] intArray) {
            this.intArray = intArray;
        }

        @Override
        public Integer call() {
            int maxValue = this.intArray[0];
            for (int i = 1; i < this.intArray.length; i++) {
                if(this.intArray[i] > maxValue){
                    maxValue = this.intArray[i];
                }
            }
            return maxValue;
        }
}
