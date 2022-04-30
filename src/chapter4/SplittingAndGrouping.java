package chapter4;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SplittingAndGrouping {
    public static void main(String[] args) {

        // Имаме колекция цели числа и искаме да ги разделим на две части - четни и нечетни. За да направим това,
        // може да използваме Collectors.partitioningBy

        List<String> strings = Arrays.asList("this", "is", "a", "long", "list", "of", "strings", "to", "use", "as", "a", "demo");

        Map<Boolean, List<String>> lengthMap = strings.stream().collect(Collectors.partitioningBy(s -> s.length() % 2 == 0));
        lengthMap.forEach((key, value) -> System.out.printf("%6s: %s%n", key, value));
        printLine();


        Map<Boolean, Long> numberLengthMap = strings
                .stream()
                .collect(Collectors.partitioningBy(s -> s.length() % 2 == 0, Collectors.counting()));
        numberLengthMap.forEach((key, value) -> System.out.printf("%6s: %s%n", key, value));
        printLine();


        Random random = new Random();
        Map<Boolean, List<Integer>> evenOrOdd = IntStream
                .generate(() -> random.nextInt(101))
                .limit(10)
                .boxed()
                .collect(Collectors.partitioningBy(num -> num % 2 == 0));
        evenOrOdd.forEach((key, value) -> System.out.printf("%6s: %s%n", key, value));
        printLine();


        Map<Integer, List<String>> otherLengthMap = strings.stream().collect(Collectors.groupingBy(String::length));
        otherLengthMap.forEach((key, value) -> System.out.printf("%2d : %s%n", key, value));
        printLine();


    }

    private static void printLine() {
        System.out.println("<>-------------------------<>-------------------------<>");
    }
}
