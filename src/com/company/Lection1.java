import java.util.Scanner;

class task1{

    public static void main(String args[]) {
        System.out.print("Введите два слова");
        Scanner sc = new Scanner(System.in);
        String text1 = sc.next();
        String text2 = sc.next();

        int len1=text1.length();
        int len2=text2.length();
        // rez=text1.equals(text2);

        if (text1.equals(text2)){
            System.out.println("Отлично! Слова одинаковы");}
        else if ((text1.equalsIgnoreCase(text2))){
            {System.out.println("Хорошо. Почти одинаковы");}}
        else if (len1==len2)
        {System.out.println("Ну, хотя бы они одной длины");}
        else {System.out.println("Слова разной длины");}
        //  System.out.println(text1+" "+text2);
        sc.close();
    }
}



class task2{
    public static void main(String args[]) {
        System.out.print("Введите число");
        Scanner sc = new Scanner(System.in);
        int run1 = sc.nextInt();


        int last = run1%10;//ПОСЛЕДНЯЯ ЦИФРА ЧИСЛА
        if (last==1)
        {System.out.println(run1+"рубль");}
        else if ((last==2)|(last==3)|(last==4))
        {System.out.println(run1+"рубля");}
        else if ((last==5)|(last==6)|(last==7)|(last==8)|(last==9)|(last==0))
        {System.out.println(run1+"рублей");}

    }


}


class task3{
    public static void main(String args[]) {
        System.out.print("Введите ГОД");
        Scanner sc = new Scanner(System.in);
        int run2 = sc.nextInt();


        // int last = run1%10;//ПОСЛЕДНЯЯ ЦИФРА ЧИСЛА
        if ((run2%4==0)& (run2%100!=0|run2%400==0))
        {System.out.println("год високосный");}
        else
        {System.out.println("год не високосный");}
        /*else if ((last==2)|(last==3)|(last==4))
        {System.out.println(run1+"рубля");}
        else if ((last==5)|(last==6)|(last==7)|(last==8)|(last==9)|(last==0))
        {System.out.println(run1+"рублей");}*/

    }


}

class task4{
    public static void main(String args[]) {
        System.out.print("Введите число месяц ГОД");
        Scanner sc = new Scanner(System.in);
        int run3 = sc.nextInt();//дата
        int run4 = sc.nextInt();//месяц
        int run5 = sc.nextInt();//год





        if ((run5%4==0)& (run5%100!=0|run5%400==0))
        {System.out.println("год високосный");}
        else
        {System.out.println("год не високосный");}

    }


}