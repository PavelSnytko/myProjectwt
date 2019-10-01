package Potoki;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*Задан файл с текстом, найти и вывести в консоль все слова,
для которых последняя буква одного слова совпадает с первой буквой следующего слова.*/
public class task3 {
    public static void main(String[] args) {
        File file2=new File("D:/22.txt");
        ArrayList<Character> textFromFile = new ArrayList();
        StringBuffer result = new StringBuffer();


        try (FileInputStream fis = new FileInputStream(file2);
             InputStreamReader isr = new InputStreamReader(fis, "UTF-8");) {


            int b = 0;
            while ((b = isr.read()) != -1) {
                textFromFile.add((char) b);
            }


            char buffer = '0';

            for (int i = 0; i < textFromFile.size(); i++) {
                if (textFromFile.get(i) == ' ') {
                    continue;
                }
                if (textFromFile.get(i) == buffer) {
                    while (textFromFile.get(i) != ' ') {
                        result.append(textFromFile.get(i));
                        i++;
                    }
                    result.append(' ');
                }
                if (!Character.isDigit(textFromFile.get(i))) {
                    buffer = textFromFile.get(i);
                }

            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.print(result);
    }
}

