package Lection3;


        import java.util.Arrays;
        import java.util.Objects;
        import java.util.Scanner;
        import java.util.logging.Logger;


class task4_1dop {
    public  static void main(String[] args) {
        int[] addArray = {1}; //то, что запишем в начале массива
        int offset = addArray.length;
        int a[] = {2, 3, 4, 5, 6, 7, 8, 9, 10}; //Массив, который будем сдвигать
        int b[] = new int[a.length + offset];
        System.out.print("Массив  до   сдвига: ");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
            b[i + offset] = a[i];
            a[i] = b[i];
        }
        System.out.println();
        for (int i = 0; i < offset; i++) {
            a[i] = addArray[i];
        }
        System.out.print("Массив после сдвига: ");
        for (int i : a) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
/*
Написать программу, удаляющую все повторяющиеся целые
числа из массива и печатающую результат
 */
class task4_2_dop {
    public    static void main(String[] args) {
        int[] a = {1, 1, 1, 2, 1, 3, 3};
        int n = a.length;
        for (int i = 0, m = 0; i != n; i++, n = m) {
            for (int j = m = i + 1; j != n; j++) {
                if (a[j] != a[i]) {
                    if (m != j) a[m] = a[j];
                    m++;
                }
            }
        }
        if (n != a.length) {
            int[] b = new int[n];
            for (int i = 0; i < n; i++) b[i] = a[i];

            a = b;
        }
        for (int x : a) System.out.print(x + " ");
        System.out.println();
    }
}

/*
Написать программу, создающую третий массив,
представляющий собой слияние 2-х заданных
 */

class task4_3dop {
    public  static void main(String[] args) {
        int[] a = {2, 3, 10, 12};
        int[] b = {1, 5, 8, 9};
        int[] c = new int[a.length + b.length];
//Объединеие двух массивов int C
        for (int i = 0; i < c.length / 2; i++) {
            if (a[i] > b[i]) {
                c[i + i] = b[i];
                c[i + i + 1] = a[i];
            } else {
                c[i + i] = a[i];
                c[i + i + 1] = b[i];

            }


        }

///элемент 1-го массива меньше предыдущего элемента

        for (int i = 0; i < c.length - 1; i++) {
            int t = c[i];
            if (c[i] > c[i + 1]) {
                c[i] = c[i + 1];
                c[i + 1] = t;
            }
        }
        System.out.println(Arrays.toString(c));
    }
}


/*
Напишите программу, которая печатает массив сначала в
обычном порядке, затем в обратном.
 */
class task4_1 {
    public  static void main(String[] args) {
        String[] a = {" новый ", " комп ", " работает ", " лучше "};//массив
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]);
        }
        System.out.println();
        int n = a.length;
        //переменная для обменя элементами

        String temp;

        for (int i = 0; i < n / 2; i++) {
            temp = a[n - i - 1];
            a[n - i - 1] = a[i];
            a[i] = temp;
            for (int i1 = 0; i < a.length; i++) {
                System.out.print(a[i]);
            }

            System.out.println();
        }
    }
}


/*
Напишите программу, заносящую в массив
первые 100 натуральных чисел, делящихся на 13 или на 17, и печатающую его
 */
class task4_2 {
    public static void main(String[] args) {
        int n = 100;

        int[] a = new int[n];
        int j = 0;
        int i;
        for (i = 1; i < n; i++) {
            if (i % 17 == 0 || i % 13 == 0) {
                a[i] = i;
                System.out.println(a[i]);
                //  i++;

            }
      /*  for (i=1; i<n; i++)
        {
            if(i%10==0)
                cout<<end1;
            cout<<a[i]<<'\t';
        }*/
        }
    }
}

/*
Определить сумму элементов целочисленного массива, расположенных между ближайшими минимальным и
максимальным значениями, не включая минимальное и максимальное значение
 */
class task4_3 {
    public static void main(String[] args) {
        int[] a = new int[]{0, 2, 3, 9};
        int[] b = new int[]{0, 2, 3, 9, 1, 1, 1, 0, 1, 2, 9};
        int[] c = new int[]{0, 2, 9, 8, 0, 4, 9};
        int max = 0;
        int[] sum = new int[a.length];
        int suma = 0;
        int min = 0;

        int maxb = 0;
        int sumab = 0;
        int minb = 0;
        int[] sumb = new int[b.length];

        int maxc = 0;
        int sumac = 0;
        int minc = 0;
        int[] sumc = new int[b.length];

        for (int i = 0; i < a.length; i++) {
            if (min > a[i]) {

                min = a[i];
            }

            // for (int i = 0; i < a.length; i++) {

            if (max < a[i]) {
                max = a[i];
            }
        }

        // System.out.println(min+""+max);


        for (int i = 0; i < a.length; i++) {

            if (a[i] == min) {
                while (a[i + 1] != max) {

                    sum[i] = a[i + 1];
                    i++;
                }
            }
        }

        for (int i = 0; i < a.length; i++) {
            suma += sum[i];
        }
        System.out.println("сумма чисел в первом массиве " + suma);
        //  System.out.println(a[i++]);}
//----------------

        for (int i = 0; i < b.length; i++) {
            if (minb > b[i]) {

                minb = b[i];
            }

            // for (int i = 0; i < a.length; i++) {

            if (maxb < b[i]) {
                maxb = b[i];
            }
        }

        //  System.out.println(minb+""+maxb);


        for (int i = 0; i < b.length; i++) {

            if (b[i] == minb) {
                while (b[i + 1] != maxb) {

                    sumb[i] = b[i + 1];
                    i++;
                }
            }
        }

        for (int i = 0; i < b.length; i++) {
            sumab += sumb[i];
        }
        System.out.println("сумма чисел во втором массиве " + sumab);

////--------------
        for (int i = 0; i < c.length; i++) {
            if (minc > c[i]) {

                minc = c[i];
            }

            // for (int i = 0; i < a.length; i++) {

            if (maxc < c[i]) {
                maxc = c[i];
            }
        }

        // System.out.println(minc+""+maxc);


        for (int i = 0; i < c.length; i++) {

            if (c[i] == minc) {
                while (c[i + 1] != maxc) {

                    sumc[i] = c[i + 1];
                    i++;
                }
            }
        }

        for (int i = 0; i < c.length; i++) {
            sumac += sumc[i];
        }
        System.out.println("сумма чисел в третьем массиве " + sumac);


    }
}

/*
Определить сумму элементов целочисленного массива,расположенных между ближайшимиминимальным и
максимальным значениями, не включая минимальное и максимальное значение
*/
  /* Определить и вывести на экран сообщение о том, является ли
        массив строго возрастающей последовательностью

   */
class task4_4{

    public static void main(String[] args) {
        int result=0; //result = "Прогрессия возрастающая";
        int[] Mas = new int[3];
        for (int i = 0; i < Mas.length; i++) {
            Mas[i] = (int) (Math.random() * 90 +10 );
            System.out.print(Mas[i] + " ");
        }

        for (int i=0;i<Mas.length;i++){

            if (i>0){
                if (Mas[i-1]>=Mas[i]){
                    System.out.println("Прогрессия не возврастающая");
                    break;
                }
            }
            if (i==Mas.length-1)
                System.out.println("прогрессия строго возврастающая");
        }
    }
}



/*
Создать двухмерный квадратный массив, и заполнить его "бабочкой"
 */
class task4_5ReplaceSymvol {

    public static void main(String[] args) {

        System.out.print ("Введите размер массива");
        Scanner sc = new Scanner(System.in);
        int run1 = sc.nextInt();
        char arr[][]=new char[run1][run1];
        int i,j;

        System.out.println("получился массив ");
        for (i=0;i<arr.length/2+1;i++){
            for (j=0;j<arr[i].length;j++){
                if ((j<i) || (j>=(arr[i].length-i)))
                    arr[i][j]=' ';
                else
                    arr[i][j]='*';

            }

        }
        for (i=arr.length-1; i>=arr.length/2; i--){
            for (j=0; j<arr[i].length; j++){
                if ((j<(arr[i].length-1-i)) || (j>i))
                    arr[i][j]=' ';
                else
                    arr[i][j]='*';}
        }
        for (i=0;i<arr.length;i++){
            for(j=0;j<arr[i].length;j++){
                System.out.print(arr[i][j]);
            }
            System.out.println(" ");
        }
    }
}

/*
 Написать метод equals, который определяет, равны ли между
собой соответствующие элементы
 */
class task4_6 {

    public static void main(String[] args) {

        int[][] Masss = new int[5][5];
        int[][] Masss1 = new int[5][5];

        System.out.println("первый массив ");
        for (int i = 0; i < Masss.length; i++) {
            for (int j = 0; j < Masss.length; j++) {

                Masss[i][j] = (int) (Math.random() * 90 + 10);

            }

        }

        for (int i = 0; i < Masss.length; i++,System.out.println()) {
            for (int j = 0; j < Masss[i].length; j++) {

                System.out.print(Masss[i][j]+" " );

            }

        }

        System.out.println("второй массив ");
        for (int i = 0; i < Masss1.length; i++) {
            for (int j = 0; j < Masss1.length; j++) {

                Masss1[i][j] = (int) (Math.random() * 90 + 10);

            }

        }

        for (int i = 0; i < Masss1.length; i++,System.out.println()) {
            for (int j = 0; j < Masss1[i].length; j++) {

                System.out.print(Masss1[i][j]+" " );

            }

        }

        // System.out.print("введите позицию чисел, которые нужно сравнить ");
        Scanner sc = new Scanner(System.in);
        System.out.print("введите номер строки 1 массива ");
        int pos1 = sc.nextInt();
        System.out.print("введите номер столбца 1 массива ");
        int pos2 = sc.nextInt();

        System.out.print("введите номер строки 2 массива ");
        int poss1 = sc.nextInt();
        System.out.print("введите номер столбца 2 массива ");
        int poss2 = sc.nextInt();

        int eq1=Masss[pos1][pos2],eq2=Masss1[poss1][poss2];


        System.out.println("выбранные элементы"+" "+eq1+" "+eq2);

        if (Objects.equals(eq1, eq2)){
            System.out.println("Отлично! Элементы одинаковы");}
        else  System.out.println(" Элементы  не одинаковы");
    }
}

/* Написать программу, эмулирующую выдачу случайной карты из
 *колоды в 52 карты.*/
class task4_7 {
    public static void main(String[] args) {
        String[] cards = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen","king", "Ace"};
        String[] suit = {"Hearts", "Spades", "Clubs", "Diamonds"};
        int card = getRandomNumberInRange(1, 52);
        int num1 = card - Math.floorDiv(card, 4) * 4 - 1;
        System.out.print("Вам выдана карта - ");
        System.out.println(cards[num1] + " " + suit[card % 4]);
    }

    public static int getRandomNumberInRange(int min, int max) {
        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");

        }
        return (int) (Math.random() * ((max - min) + 1));
    }
}

/*Написать программу, перемешивающую и печатающую список
 *карт в колоде.*/

class task4_8 {
    public static void main(String[] args) {
        String[] Cards = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen","King", "Ace"};
        String[] Suit = {"Hearts", "Spades", "Clubs", "Diamonds"};
        int n = Cards.length * Suit.length;//количество карт в колоде
        //  System.out.println(n);
        //далее, создаю калоду карт
        String[] deck = new String[n];

        for (int i = 0; i < Cards.length; i++) { // по картам
            for (int j = 0; j < Suit.length; j++) { // по масти
                deck[Suit.length*i+j] = Cards[i] + " " + Suit[j];
            }

        }
      /*  for (int i = 0; i < n; i++) {
        System.out.println(i+" " + deck[i]);}*/

// тасование колоды


        for (int i = 0; i < n; i++) {
            int f = task4_7.getRandomNumberInRange(1, 52);//выбор карты по ссылке предыдущего задания
            String temp = deck[f];
            deck[f] = deck[i];
            deck[i] = temp;
        }
//итог
        for (int i = 0; i < n; i++) {
            System.out.println(i + 1 + " " + deck[i]);
        }
    }
}


/*Имеется целое число, определить является ли это число простым,
т.е. делится без остатка только на 1 и себя
 */



class task4_9 {
    public static void main(String[] args) {
        int temp;
        boolean primeNumber = true;

        Scanner sc = new Scanner(System.in);
        System.out.println("Введите целое число больше 0:");

        int num = sc.nextInt(); // считывает число

        for (int i = 2; i <= num / 2; i++) { // проверка простое ли число
            temp = num % i;
            if (temp == 0) {
                primeNumber = false;
                break;
            }
        }
        if (primeNumber) {
            System.out.println("Введенное вами число " + num + " является простым");
        } else {
            System.out.println("Введенное вами число " + num + " не является простым");
        }

        sc.close();
    }
}




/*
 Написать алгоритм расчета факториала , используя циклы (for и while)
 */
// n!=1*2*3*...=n



class task4_10{
    public static void main(String[] args) {
        long n;
        do
        {
            Scanner scan = new Scanner(System.in);
            System.out.print("Введите натуральноe число для вычисления факториала: ");
            n = scan.nextInt();
            if(n < 0)
                System.out.println("Вы ввели отрицательный факториал");
            else
            {

                long result = 1;

                if (n == 0 || n == 1)
                    System.out.println(n+"!  = "+result);

                for (int i = 2; i <= n; i++)
                {
                    result = result * i;
                    if (i >= n)
                    {
                        System.out.println(n+"!  = "+result);
                    }
                }
            }
        } while (n < 0);
        System.out.println();

    }
}

