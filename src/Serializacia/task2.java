package Serializacia;

import java.io.*;

/*
Создать класс Computer. Добавить ему несколько полей,создать объект этого класса, сериализовать в файл.
Десериализовать объект из того же файла, вывести значенияполей в консоль
 */
class task2 implements Serializable {
    public static void main(String[] args) throws ClassNotFoundException {
        File file = new File("D:/computer.txt");
        task2 task2 = new task2();

        try (ObjectOutputStream oos = new ObjectOutputStream((new FileOutputStream(file)))) {
            oos.writeObject(task2);

        } catch (IOException e) {
            e.printStackTrace();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {

            task2 Computer  = (task2) ois.readObject();
            System.out.printf("This is new Coumputer, name = %s memory = %d weigft = %.2f\n", "newComputer.getName(), newComputer.getMemory(), newComputer.getWeight()");
        } catch (Exception e) {
            e.printStackTrace();
        }


    }


}






