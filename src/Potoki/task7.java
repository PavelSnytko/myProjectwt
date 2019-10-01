package Potoki;

import java.io.*;
import java.util.LinkedList;
import java.util.ListIterator;

/* Задан файл с java-кодом.
Прочитать текст программы из файла и
записать в другой файл в обратном порядке символы каждой
строки.
 */
public class task7 {

    public static void main(String[] args) {

            LinkedList<Character> linkedList = new LinkedList<>();

            try(
                    BufferedReader bufferedReader = new BufferedReader(new FileReader("D:/task7.txt"));
                    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("D:/task7.1.txt"));
            ){
                while(bufferedReader.ready()){
                    linkedList.add((char)bufferedReader.read());
                }

                ListIterator iterator = linkedList.listIterator();
                while(iterator.hasNext()){
                    iterator.next();
                }
                while(iterator.hasPrevious()){
                    bufferedWriter.write((char)iterator.previous());
                }


            }catch (IOException e){
                e.printStackTrace();
            }


        }
    }

