package SetMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/*Написать метод isUnique, который принимает Map<String, String> и возвращает true,
    если два различных ключа не соответствуют двум одинаковым значениям.*/
public class task2 {

    public static void main(String[] args) {
        Map<String, String> elements = new HashMap<>();
        elements.put("Kendrick", "Perkins");
        elements.put("Stuart", "Reges");
        elements.put("Jessica", "Miller");
        elements.put("Bruce", "Reges");
        elements.put("Hal", "Perkins");


        System.out.println("Два различных ключа не соответствуют двум одинаковым значениям ? - " + isUnique(elements));

    }

    static boolean isUnique(Map<String, String> map){
        ArrayList arrayList = new ArrayList(map.values());
        System.out.println(arrayList);


        boolean flag = true;
        for (int i = 0; i < arrayList.size(); i++) {
            for (int j = 0; j < arrayList.size(); j++) {
                if (arrayList.get(i).equals(arrayList.get(j)) && i != j) {
                    flag = false;

                }
            }
        }
        return flag;
    }


/*    boolean isUnique(Map<String, String> map) {
        for (int i = 0; i < map.size(); i++) {
            if( )
            for (int j = 0; j < ; j++) {
            }
        }
        return true;
    }*/


}


