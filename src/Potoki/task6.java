package Potoki;

import java.io.File;
/*
 Вывести список файлов и каталогов выбранного каталога на
диске с учетом вложенности директориев .
Для этого использовать рекурсию
 */
public class task6 {
    public static void main(String[] args) {
        File file = new File("c:\\Users\\ПашаОкс\\Downloads\\");
        nameInDir(file);




    }

    static void nameInDir(File file){
        for (final File f :file.listFiles()) {
            if(f.isDirectory()){
                System.out.println(f.getParent());
                nameInDir(f);
            }else{
                System.out.println(file.getName());
            }
        }

    }
}

