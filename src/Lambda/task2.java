package Lambda;

import java.util.ArrayList;

/*Дан список строк. Найти количество уникальных строк длиной более 8 символов.*/
public class task2 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("cad");
        list.add("abc");
        list.add("aaaaaaaaaaaaaa");
        list.add("bbbbbbbbbbbbbb");
        list.add("88877788887777");
        list.add("ddddd566334585");

        long result = list.stream().filter(element -> element.length() > 8).distinct().count();
        System.out.println(result);
    }
}
