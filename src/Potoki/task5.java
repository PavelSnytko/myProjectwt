package Potoki;

import java.io.*;
import java.util.Random;

/*Записать в двоичный файл 20 случайных чисел типа int со значением больше 255.
Прочитать записанный файл, распечатать числа и их среднее арифметическое*/
public class task5 {
    public static void main(String[] args) {
        File file = new File("D:/255.txt");
        Random random = new Random();
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("D:/255.txt"));
             BufferedReader bufferedReader = new BufferedReader(new FileReader("D:/255.txt"));) {

            for (int i = 0; i < 20; i++) {
                bufferedWriter.write(Integer.toBinaryString(random.nextInt(100) + 255));
                bufferedWriter.newLine();
            }
            bufferedWriter.close();

            double result = 0;
            int l = 0;
            while (bufferedReader.ready()) {
                result += Integer.valueOf(bufferedReader.readLine(), 2);
                l++;
            }
            result /= l;
            System.out.println(result);


        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
