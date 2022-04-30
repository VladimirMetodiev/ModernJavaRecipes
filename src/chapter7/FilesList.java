package chapter7;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FilesList {
    public static void main(String[] args) {
        /*
         * public static Stream<Path> list(Path dir) throws IOException
         *
         * Статичният метод .list() на класа java.nio.file.Files приема аргумент от тип Path и връща поток, обвиващ DirectoryStream;
         * Резултатът, който връща е "списък" с директориите и файловете в указаната директория;
         */

        try (Stream<Path> list = Files.list(Paths.get("src"))) {
            list.forEach(System.out::println);
        } catch (IOException ex) {
            System.err.println("I/O Exception: " + ex.getMessage());
        }

        System.out.println("------------------------------");

        try (Stream<Path> list = Files.list(Paths.get("src\\chapter7"))) {
            list.forEach(System.out::println);
        } catch (IOException ex) {
            System.err.println("I/O Exception: " + ex.getMessage());
        }

        // Бележка: ако в Path укажа файл вместо директория ще бъде хвърлена IOException
    }
}
