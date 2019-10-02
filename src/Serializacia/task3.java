package Serializacia;

import java.io.*;
import java.util.ArrayList;

public class task3 implements Serializable{
    public static void main(String[] args) {

        File file=new File("D:/Notebook.txt");
        ArrayList<Notebook> notebooks = new ArrayList<Notebook>();
        Notebook notebook1 = new Notebook("COMPUTER1", 128, 2.5, 1000, "T4G435");
        Notebook notebook2 = new Notebook("COMPUTER2", 256, 1.3, 1900, "T4H100");
        notebooks.add(notebook1);
        notebooks.add(notebook2);

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));) {

            oos.writeObject(notebooks);



        } catch (IOException e) {
            e.printStackTrace();
        }


        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));) {

            ArrayList<Notebook> newNotebooks = new ArrayList<Notebook>();
            newNotebooks = (ArrayList<Notebook>) ois.readObject();

            for (Notebook notebook : newNotebooks) {
                System.out.printf("This is Notebook, name = %s memory = %d weigft = %.2f model = %s   ",
                       notebook.getName(), notebook.getMemory(), notebook.getWeight(), notebook.getModel());
                System.out.println("Price (this is not serializable! ) = " + notebook.getPrice());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

