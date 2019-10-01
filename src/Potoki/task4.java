package Potoki;

import java.io.*;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*Задан файл с текстом. В каждой строке найти и
        вывести наибольшее число цифр, идущих подряд

 3322 555687 4654444444 67666666666666
4444 55555 67666675
        */
public class task4 {
    public static void main(String[] args) {
        File file4=new File("D:/23.txt");
        int b = 0;
        StringBuffer stringBuffer = new StringBuffer();

        try(
                FileInputStream fis = new FileInputStream(file4);
                InputStreamReader isr = new InputStreamReader(fis, "UTF-8");) {
            while((b=isr.read()) != -1){
                stringBuffer.append((char) b);
            }

        }catch (IOException e){
            e.printStackTrace();
        }
        String text = stringBuffer.toString();
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(text);


        LinkedList<String> numbers = new LinkedList<>();

        while(matcher.find()){
            numbers.add(matcher.group());
        }


        int q=0;
        for (int i = 0; i < numbers.size()-1; i++) {
            if(numbers.get(i).length()>numbers.get(i+1).length()){q=i;}
        }

        System.out.println(numbers);
        System.out.println(numbers.get(q));

    }
}