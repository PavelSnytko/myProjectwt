package Generics;

public class Gener {
        public static void main(String[] args) {

            Pair<String>  pair= new Pair<>("3", "1");
            System.out.println(pair.getK()+" "+pair.getV());
            PairUtil <Integer> pairUtil=new PairUtil<>();
            pairUtil.swap(pair);
            System.out.println(pair.getK()+" "+pair.getV());

            System.out.println("///////////Task4");
            Task4<String,String>  task4 = new Task4(5.1, 5);//in 2 Double/Integer элементы




        }

    }

