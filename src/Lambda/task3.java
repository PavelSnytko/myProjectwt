package Lambda;
/*Дана Map<String, Integer>. Найти сумму всех значений, длина ключей которых меньше 7 символов.*/

import java.util.HashMap;
import java.util.Map;

public class task3 {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("aaaaaaaaaaa", 400);
        map.put("aaaaaaa", 50);
        map.put("aaaaaa", 6);
        map.put("aaaaa", 5);
        map.put("aaaa", 4);

        long result = map.entrySet().stream().filter(k -> k.getKey().length()<7).mapToInt((value)->value.getValue()).sum();
        System.out.println("sum" +result);
    }
}
