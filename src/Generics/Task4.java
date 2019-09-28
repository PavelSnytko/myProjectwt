package Generics;
/*Определить класс, который при инициализации принимает на вход 2
        аргумента целого или вещественного типа. Задать перегруженные методы
        возвращающие результат арифметических операций над заданными полями и полями типа BigDecimal.*/

/* 4 Из задания 5 .3 реализовать класс вычислитель для вещественных и целых типов данных, используя параметризацию классов.*/
public class Task4<T1, T2> {
    public Task4(T1 a ,T2 b){//Vichislitel'
        if((a instanceof Integer || a instanceof Double) && (b instanceof Integer || b instanceof Double) ) {
            if (a instanceof Integer && b instanceof Integer) {
                System.out.println("Sum of 2 Integer elements = " + sumIntInt(a, b));
            }
            if (a instanceof Double && b instanceof Double) {
                System.out.println("Sum of 2 Double elements = " + sumDoubleDouble(a, b));
            }
            if (a instanceof Integer && b instanceof Double) {
                System.out.println("Sum of Int and Double = " + sumIntDouble(a, b));
            }
            if (a instanceof Double && b instanceof Integer) {
                System.out.println("Sum of Double and Int = " + sumDoubleInt(a, b));
            }
        }else{
            System.out.println("Incorrect format");
        }


    }


    private int sumIntInt(T1 a,T2 b){
        return (Integer)a + (Integer) b;
    }
    private Double sumIntDouble(T1 a,T2 b){
        return (Double)((Integer)a + (Double)b);

    }private Double sumDoubleInt(T1 a,T2 b){
        return (Double)((Double)a + (Integer)b);
    }


    private double sumDoubleDouble(T1 a, T2 b){
        return (Double)a + (Double)b;
    }


}

