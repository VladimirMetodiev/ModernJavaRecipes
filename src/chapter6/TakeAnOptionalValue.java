package chapter6;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TakeAnOptionalValue {
    public static void main(String[] args) {
        Optional<Integer> max = IntStream.generate(() -> new Random().nextInt(101)).limit(5).boxed().max(Integer::compareTo);

        if(max.isPresent()) {
            System.out.println(max.get());
        }

        max.ifPresent(System.out::println);
        printLine();



        OptionalInt evenNumber = IntStream.of(1, 3, 5, 7, 9).filter(x -> x % 2 == 0).findFirst();

        try {
            System.out.println(evenNumber.getAsInt());
        } catch (NoSuchElementException ex) {
            System.out.println("There isn't any element!");
        }

        System.out.println(evenNumber.orElseGet(() -> 0));
        printLine();



        Optional<String> someNumber = Stream.of("one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten")
                .filter(x -> x.length() % 2 == 0)
                .findFirst();
        System.out.println(someNumber.isPresent() ? someNumber.get() : "There isn't any number!");



        String source = "Exception Handling in Java is one of the effective means to handle the runtime errors so that the regular flow of the application can be preserved.";

        Optional<String> someWord = Arrays.stream(source.split("\\s+"))
                .map(String::toLowerCase)
                .sorted()
                .findAny();
        System.out.println(someWord.orElse("There isn't any word!"));
        printLine();



        OptionalInt randomNumber = IntStream.generate(() -> new Random().nextInt(101)).limit(10).max();

        System.out.println(randomNumber.orElseThrow(NoSuchElementException::new));
        printLine();
    }

    private static void printLine() {
        System.out.println("------------------------------");
    }
}
