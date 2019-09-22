package lection_collection;

import java.util.LinkedList;

class task6 {
    /* 6.	Имеется текст. Следует составить для него частотный словарь.*/


    public static void main(String[] args) {


        String text = "Кот дома.дома он отдыхает на ковре дома в этом смысл его жизни ";
        System.out.println("Text : " + text);


        String[] textMass = text.split("\\s|\\.\\s|\\.");

        LinkedList<String> textList = new LinkedList<>();
        for (int i = 0; i < textMass.length; i++) {
            int k = 0;
            for (int j = 0; j < textMass.length; j++) {
                if (textMass[i].equals(textMass[j])) {
                    k++;
                }
                if (j == textMass.length - 1) {
                    textList.add(k + " " + textMass[i]);
                }
            }
        }
        System.out.println(textList);
        for (int i = 0; i < textList.size(); i++) {
            for (int j = 0; j < textList.size(); j++) {
                if (textList.get(i).equals(textList.get(j)) && i != j) {
                    textList.remove(j);
                }

            }
        }
        System.out.println(textList);
    }
}



