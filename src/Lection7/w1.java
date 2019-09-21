package Lection7;


        import java.util.Scanner;

class Lection7_String {
    public static void main(String[] args) {
        //task1();
        //task2();
        //Сканер и метод для упражнения3
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите строку");
        String string = sc.nextLine();
        System.out.println("Введите проверочное слово");
        String word = sc.next();
        sc.close();
        System.out.println(task3(string, word));

        //task4();
        //task5();
        //Exercise6();
        //task7_1();
        //task7_2();
        //task7_v3();
    }
    /*
    Написать два цикла, выполняющих многократное сложение строк, один с
    помощью оператора сложения и String,
    второй с помощью StringBuilder и метода append. Сравнить скорость их
    выполнения
     */
    public static void task1() {
        StringTime();
        StringTimeConcat();
        StringTimeAppEnd();
    }

    public static void StringTime() {
        long startTime = System.nanoTime();
        for (int i = 0, b = 0; i < 1000000; i++) {
            String string = String.valueOf(i) + b;
        }
        long stopTime = System.nanoTime();
        long startTime2 = System.nanoTime();
        for (int i = 0, b = 0, c = 0; i < 1000000; i++, b++) {
            String string = String.valueOf(i) + b + c;
        }
        long stopTime2 = System.nanoTime();
        System.out.println("Время 2 аргументов с + : " + (stopTime - startTime));
        System.out.println("Время 3 аргументов с + : " + (stopTime2 - startTime2));
    }

    public static void StringTimeConcat() {
        long startTime = System.nanoTime();
        for (int i = 0, b = 0; i < 1000000; i++) {
            String string = String.valueOf(i).concat(String.valueOf(b));
        }
        long stopTime = System.nanoTime();
        long startTime2 = System.nanoTime();
        for (int i = 0, b = 0, c = 0; i < 1000000; i++, b++) {
            String string = String.valueOf(i).concat(String.valueOf(b)).concat(String.valueOf(c));
        }
        long stopTime2 = System.nanoTime();
        System.out.println("Время 2 аргументов с методом concat: " + (stopTime - startTime));
        System.out.println("Время 3 аргументов с методом concat: " + (stopTime2 - startTime2));
    }

    public static void StringTimeAppEnd() {
        long startTime = System.nanoTime();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0, b = 0; i < 1000000; i++) {
            stringBuilder.append(i).append(b);
        }
        long stopTime = System.nanoTime();
        long startTime2 = System.nanoTime();
        for (int i = 0, b = 0, c = 0; i < 1000000; i++) {
            stringBuilder.append(i).append(b).append(c);
        }
        long stopTime2 = System.nanoTime();
        System.out.println("Время 2 аргументов с методом StringBuilder.append: " + (stopTime - startTime));
        System.out.println("Время 3 аргументов с методом StringBuilder.append: " + (stopTime2 - startTime2));
    }
    /*
    Заменить все грустные смайлы:(в строке на весёлые:)
     */
    public static void task2() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите строку с грустными смайлами :( ");
        String string = sc.nextLine();
        sc.close();
        System.out.println(string.replace(":(", ":)"));
    }
/* Написать функцию, принимающую 2 параметра: строку и слово-и
возвращающую true, если строка начинается и заканчивается этим словом.
*/

    public static boolean task3(String string, String word) {
        return string.startsWith(word) & string.endsWith(word);
    }
    /*Написать функцию, принимающую в качестве параметров имя, фамилию и
    отчество и возвращающую
    инициалы*/
    public static void task4() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите фамилию, имя, отчество : ");
        String string = sc.nextLine();
        sc.close();
        String[] stringParts = string.split(" ");
        char surname = stringParts[0].charAt(0);
        char name = stringParts[1].charAt(0);
        char last_name = stringParts[2].charAt(0);
        StringBuilder stringBuilder = new StringBuilder();
        System.out.println(stringBuilder.append(String.valueOf(surname).toUpperCase()).
                append(String.valueOf(name).toUpperCase()).
                append(String.valueOf(last_name).toUpperCase()));
    }

    public static void task5() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите строку для подсчета слов :");
        String string = sc.nextLine();
        sc.close();
        String[] stringWords = string.split(" ");
        int words = 0;
        for (String stringWord : stringWords) {
            if (stringWord.equals("") | stringWord.equals(".") | stringWord.equals(",") | stringWord.equals("-")) {
                //doNothing
            } else words++;
        }
        System.out.println("Кол-во слов в строке : = " + words);
    }

    public static void task6() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите строку для проверка, например aaabbcdeeff:");
        String string = sc.nextLine();
        sc.close();
        char[] charString = string.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < charString.length; i++) {
            if (i == charString.length - 1) {
                stringBuilder.append(String.valueOf(charString[i]));
                break;
            } else if (charString[i] == charString[i + 1]) {

            } else stringBuilder.append(String.valueOf(charString[i]));
        }
        System.out.println(stringBuilder);
    }

    public static void task7_1() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите число");
        long numb = sc.nextLong();
        sc.close();
        long startTime = System.nanoTime();
        String string = Long.toString(numb);
        char[] charString = string.toCharArray();
        char[] backString = new char[10];
        if (charString.length > 10) {
            for (int i = 0; i < backString.length; i++) {
                backString[i] = '0';
            }
        } else {
            for (int i = 0; i < backString.length; i++) {
                if (i < 10 - charString.length) {
                    backString[i] = '0';
                } else {
                    backString[i] = charString[i - (10 - charString.length)];
                }
            }
        }
        for (int i = 0; i <= backString.length - 1; i++) {
            System.out.print(String.valueOf(backString[i]));
        }
        long endTime = System.nanoTime();
        System.out.println();
        System.out.println("Время выполнения ".concat(String.valueOf(endTime - startTime)));
    }

    public static void task7_2() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите число");
        long numb = sc.nextLong();
        sc.close();
        long startTime = System.nanoTime();
        String string = Long.toString(numb);
        String stringZero = "0";
        if (string.length() > 10) {
            System.out.println("0000000000");
        } else {
            for (int i = 1; i < 10 - string.length(); i++) {
                stringZero += "0";
            }
            System.out.println(stringZero + string);
        }
        long endTime = System.nanoTime();
        System.out.println("Время выполнения ".concat(String.valueOf(endTime - startTime)));
    }

    public static void task7_3() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите число");
        long numb = sc.nextLong();
        sc.close();
        long startTime = System.nanoTime();
        String string = Long.toString(numb);
        StringBuilder stringBuilder = new StringBuilder("0000000000");
        if (string.length() > 10) {
            //doNothing
        } else {
            stringBuilder.insert(10 - string.length(), string);
            stringBuilder.setLength(10);
        }
        System.out.println(stringBuilder);
        long endTime = System.nanoTime();
        System.out.println("Время выполнения ".concat(String.valueOf(endTime - startTime)));
    }

}