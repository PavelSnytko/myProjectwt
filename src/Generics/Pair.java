package Generics;

public class Pair<T> {
    private T K;
    private T V;
    public Pair(T K, T V){
        setK(K);
        setV(V);
    }




    public T getK() {
        return K;
    }

    public void setK(T k) {
        K = k;
    }

    public T getV() {
        return V;
    }

    public void setV(T v) {
        V = v;
    }

}
/*2 Создать статический обобщённый метод swap в final
классе PairUtil. Метод должен принимать объект класса
        Pair и возвращать пару, в которой элементы поменяны местами*/
final class PairUtil<T>{
    static Pair swap(Pair pair){

        Object k=pair.getK();

        pair.setK(pair.getV());
        pair.setV(k);

        return pair;
    }

}


