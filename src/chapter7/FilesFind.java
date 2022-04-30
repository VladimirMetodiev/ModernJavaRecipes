package chapter7;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FilesFind {
    public static void main(String[] args) {
        /*
         * public static Stream<Path> find(Path start, int maxDepth, BiPredicate<Path, BasicFileAttributes> matcher, FileVisitOption... options) throws IOException
         *
         * За да обходя файловата система и да открия файл или файлове по зададени характеристики, мога да използвам статичният метод
         * .find() на класа java.nio.file.Files.
         *
         * Той приема следните аргументи:
         * аргумент от тип Path;
         * int maxDepth - това са броят на обходените нива във файловата система, 0 означава само базовото ниво, а Integer.MAX_VALUE - означава всички нива;
         * BiPredicate<Path, BasicFileAttributes> matcher - всеки посещаван път се проверява за съответствие с този BiPredicate;
         * FileVisitOption - от него зависи дали да се мине по даденото направление (може да има 0 или повече стойности);
         */

        try (Stream<Path> directoriesAndFiles = Files.find(Paths.get("src"), Integer.MAX_VALUE, (path, attributes) -> !attributes.isDirectory())) {
            directoriesAndFiles.forEach(System.out::println);
        } catch (IOException ex) {
            System.err.printf("I/O Exception: %s%n", ex.getMessage());
        }

        System.out.println("------------------------------");

        try (Stream<Path> directoriesAndFiles = Files.find(Paths.get("src"), Integer.MAX_VALUE, (path, attributes) -> !attributes.isDirectory() && path.toString().contains("myInterface"))) {
            directoriesAndFiles.forEach(System.out::println);
        } catch (IOException ex) {
            System.err.printf("I/O Exception: %s%n", ex.getMessage());
        }
    }
}
