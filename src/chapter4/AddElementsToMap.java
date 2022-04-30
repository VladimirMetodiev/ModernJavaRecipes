package chapter4;

import chapter3.Book;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AddElementsToMap {
    public static void main(String[] args) {
        List<Book> books = Arrays.asList(
                new Book("9780134686097", "Effective Java"),
                new Book("9781484271353", "More Java 17 : An In-Depth Exploration of the Java Language and Its Features"),
                new Book("9781492037255", "Java in a Nutshell"),
                new Book("9781617293566", "Modern Java in Action"),
                new Book("9781284089103", "Object-Oriented Data Structures Using"),
                new Book("9781260463422", "Java: The Complete Reference")
        );

        Map<String, String> bookMap = books.stream().collect(Collectors.toMap(b -> b.getIsbn(), b -> b.getTitle()));
        bookMap.forEach((key, value) -> System.out.printf("%s %s%n", key, value));
        printLine();

        Map<String, String> otherBookMap = books.stream().collect(Collectors.toMap(Book::getIsbn, Book::getTitle));
        otherBookMap.forEach((key, value) -> System.out.printf("%s %s%n", key, value));
        printLine();

        Map<String, Book> anotherBookMap = books.stream().collect(Collectors.toMap(Book::getIsbn, Function.identity()));
        anotherBookMap.forEach((key, value) -> System.out.printf("%s %s%n", key, value.getTitle()));
        printLine();

        Map<Book, Book> thisWorks = books.stream().collect(Collectors.toMap(Function.identity(), Function.identity()));
        thisWorks.forEach((key, value) -> System.out.printf("%s %s%n", key.getIsbn(), value.getTitle()));
        printLine();


    }

    private static void printLine() {
        System.out.println("--------------------------------------------------");
    }

    private static void getNewLine() {
        System.out.println("\n--------------------------------------------------");
    }
}
