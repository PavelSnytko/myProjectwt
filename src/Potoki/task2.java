package Potoki;

import java.io.*;
import java.util.LinkedList;

/*
Задан файл с текстом, найти и вывести в консоль все слова,
начинающиеся с гласной буквы
 */
public class task2 {
    public static void main(String[] args) {
        File file1 = new File("D:/21.txt");
        FileInputStream fis = null;
        InputStreamReader isr = null;
        int b = 0;
        LinkedList<String> linkedList = new LinkedList<>();
        try {
            fis = new FileInputStream(file1);
            isr = new InputStreamReader(fis, "UTF-8");
            while ((b = isr.read()) != -1) {
                if (Character.isSpaceChar((char) b)) {
                    b = isr.read();
                    if (isVocalic((char) b)) {
                        while (true) {
                            if ((char) b == ' ' || (char) b == '\n') {
                                System.out.print(" ");
                                break;

                            } else {
                                System.out.print((char) b);
                                b = isr.read();

                            }
                        }
                    }
                }

            }
            isr.close();
            fis.close();


        } catch (IOException e) {
            e.printStackTrace();

        }
    }

     static boolean isVocalic(char a) {

        String z = Character.toString(Character.toLowerCase(a));

        return z.matches("e|a|i|u|o|а|у|е|ы|а|о|э|ю|я|и");
    }
}
