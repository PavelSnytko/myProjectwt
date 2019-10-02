package Serializacia;

import java.io.*;

/*Сравнить скорость чтения и записи 5 МБ символов
 при использовании классов буфиризированого и
  не буфиризированого символьного ввода вывода.*/
class task1 {
    public static void main(String[] args) {



        File file = new File("D:/notbuffer5mb.txt");

        try (OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream("D:/notbuffer5mb.txt"));
             InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(file));
        ) {
            long a = System.nanoTime();
            for (int i = 0; i < 5000000; i++) {
                outputStreamWriter.write('a');
            }
            long b = System.nanoTime();

            while (inputStreamReader.ready()) {
                inputStreamReader.read();
            }
            long c = System.nanoTime();

            System.out.printf("OutputStreamWrite %d     InputStramRead %d\n",b-a,c-b);


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void task1_2() {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("D:/buffer5mb.txt"));
             BufferedReader bufferedReader = new BufferedReader(new FileReader("D:/buffer5mb.txt"));
        ) {
            long a = System.nanoTime();

            for (int i = 0; i < 5000000; i++) {
                bufferedWriter.write('a');
            }

            long b = System.nanoTime();

            while (bufferedReader.ready()) {
                bufferedReader.read();
            }

            long c = System.nanoTime();

            System.out.printf("BufferWriter %d     BufferReader %d\n",b-a,c-b);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
