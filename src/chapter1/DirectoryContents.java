package chapter1;

import java.io.File;
import java.io.FilenameFilter;

public class DirectoryContents {
    public static void main(String[] args) {
        try {
            File directory = new File("text\\philosophy");

            String[] names = directory.list(new FilenameFilter() {
                @Override
                public boolean accept(File dir, String name) {
                    return name.endsWith(".txt");
                }
            });

            for(String str : names) System.out.println(str);


            System.out.println("---------->---------->---------->");


            String[] anotherNames = directory.list((dir, name) -> name.endsWith(".txt"));
            for(String str : anotherNames) System.out.println(str);
        }
        catch (NullPointerException ex) {
            System.err.println("There is not such directory.");
        }
    }
}



//Бележка 1: мога изрично да укажа типът на аргументите;
//String[] anotherNames = directory.list((File dir, String name) -> name.endsWith(".txt"));

//Бележка 2: ако тялото на ламбда изразът заема няколко реда, задължително трябва да го поставя във фигуративни скоби
//и да използвам ключовата дума return (това се нарича блоков ламбда израз);
//String[] anotherNames = directory.list((File dir, String name) -> {
//    return name.endsWith(".txt");
//});
