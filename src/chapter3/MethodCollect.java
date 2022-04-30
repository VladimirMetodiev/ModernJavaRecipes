package chapter3;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MethodCollect {
    public static void main(String[] args) {
        /*
         * Метод collect(Supplier<R> supplier, ObjIntConsumer<R> accumulator, BiConsumer<R, R> combiner) тип на връщаното значение R
         */

        String someText = Stream
                .of("I ", "am ", "a ", "Java ", "developer.")
                .collect(() -> new StringBuilder(), (sb, str) -> sb.append(str), (sb1, sb2) -> sb1.append(sb2))
                .toString();
        System.out.println(someText);


        someText = Stream.of("I ", "am ", "a ", "Java ", "developer.")
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                .toString();
        System.out.println(someText);


        // Свързване на символните низове от списък с помоща на метода .joining() на класа Collectors
        someText = Stream.of("I ", "am ", "a ", "Java ", "developer.").collect(Collectors.joining());
        System.out.println(someText);


        someText = Stream.of("I", "am", "a", "Java", "developer.").collect(Collectors.joining(" "));
        System.out.println(someText);


        System.out.println("------------------------------");


        String data = "1, 5, 14, 0, 9,  16, 14, 8, 8, 9";

        List<Integer> list = Arrays.stream(data.split(",\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        System.out.println(list);


        Set<Integer> set = Arrays.stream(data.split(",\\s+")).map(Integer::parseInt).collect(Collectors.toSet());
        System.out.println(set);


        System.out.println("------------------------------");


        // Сортиране на символните низове по тяхната дължина
        List<String> fruits = Arrays.asList("mango", "kiwi", "strawberry", "orange", "fig", "pineapple");
        List<String> sorted = fruits.stream().sorted(Comparator.comparingInt(String::length)).collect(Collectors.toList());
        sorted.forEach(s -> System.out.print(s + " "));


        System.out.println("\n------------------------------");


        List<Book> books = new ArrayList<>();
        books.add(new Book("9780134686097", "Effective Java"));
        books.add(new Book("9781260463422", "Java: The Complete Reference"));
        books.add(new Book("9781484271353", "More Java 17 : An In-Depth Exploration of the Java Language and Its Features"));

        Map<String, String> bookMap = books.stream().collect(Collectors.toMap(Book::getIsbn, Book::getTitle));
        bookMap.forEach((k, v) -> System.out.println("[" + k + "]: " + v));



        Stream<String[]> anotherBooks = Stream
                .of(new String[][] { {"9781492037255", "Java in a Nutshell"},
                        {"9781617293566", "Modern Java in Action"},
                        {"9781284089103", "Object-Oriented Data Structures Using"}
                });

        Map<String, String> map = anotherBooks.collect(Collectors.toMap(ibsn -> ibsn[0], title -> title[1]));
        map.forEach((k, v) -> System.out.println("[" + k + "]: " + v));
    }
}
