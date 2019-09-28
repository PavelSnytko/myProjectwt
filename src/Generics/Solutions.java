package Generics;
/*3 Дан класс Solution , параметризированный T . Ограничьте параметр T .
     T должен быть наследником класса ClassForGenerics и одновременно
     реализовывать интерфейс InterfaceForGenerics . Менять можно только класс Solution*/
public class Solutions {
    public static void main(String[] args) {
        Solution solution = new Solution<>();
        solution.setT(new ClassForGenerics(1));
        solution.work(2);


    }

}






class ClassForGenerics implements InterfaceForGenerics {
    public ClassForGenerics(int i){
        System.out.println(i+"Here working ClassForGenerics constructor !");

    }
    @Override
    public void doSMTH(int k) {
        System.out.println(k+"Here we can do SMTH !");

    }

}


interface InterfaceForGenerics<T> {
    void doSMTH(int k);

}

class Solution<T extends ClassForGenerics> {
    private T t;


    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    public void work(int k){
        t.doSMTH(k);
    }
}

