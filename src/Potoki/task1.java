package Potoki;


import java.io.*;
/*
 Задан файл с многострочным тестом. Прочитать и вывести этот
файл в консоль построчно.
 */
public class task1 {
    public static void main(String[] args) {

        FileInputStream fis= null;
        InputStreamReader isr=null;
        int b = 0;
        File file=new File("D:/1.txt"); //создаю путь нового файла

        try {

            fis= new FileInputStream(file);
            isr=new InputStreamReader(fis, "UTF-8");
           while ((b=isr.read())!=-1){
System.out.println((char)b);
           }
            } catch (IOException e) {
                e.printStackTrace();
            }

    }
}
