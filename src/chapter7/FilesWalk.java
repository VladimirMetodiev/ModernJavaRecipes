package chapter7;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FilesWalk {
    public static void main(String[] args) {
        /*
         * public static Stream<Path> walk(Path start, FileVisitOption... options) throws IOException
         *
         * За да обходя файловата система в дълбочина, мога да използвам статичният метод .walk() на класа java.nio.file.Files.
         * Той приема аргумент от тип Path и списък с 0 или повече стойности от тип FileVisitOption.
         * Връща поток от тип DirectoryStream.
         */

        try (Stream<Path> allDirectoriesAndFiles = Files.walk(Paths.get("src"))) {
            allDirectoriesAndFiles.forEach(System.out::println);
        } catch (IOException ex) {
            System.err.printf("I/O Exception: %s%n", ex.getMessage());
        }
    }
}
