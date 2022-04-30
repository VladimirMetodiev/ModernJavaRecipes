package chapter4;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public class MaxAndMin {
    public static void main(String[] args) {
        /*
         * Максимум и минимум могат да бъдат определени с два от статичните методи на интерфейса BinaryOperator:
         * static <T> BinaryOperator<T> maxBy(Comparator<? super T> comparator)
         * static <T> BinaryOperator<T> minBy(Comparator<? super T> comparator)
         */

        List<Billionaire> billionaires = Arrays.asList(
                new Billionaire("Elon", "Musk", 219, 50, "United States"),
                new Billionaire("Jeff", "Bezos", 171, 58, "United States"),
                new Billionaire("Bernard", "Arnault", 158, 73, "France"),
                new Billionaire("Bill", "Gates", 129, 66, "United States"),
                new Billionaire("Warren", "Buffett", 119, 91, "United States"),
                new Billionaire("Larry", "Page", 111, 49, "United States"),
                new Billionaire("Mukesh", "Ambani", 90.7, 64, "India"),
                new Billionaire("Zhong", "Shanshan", 65.7, 67, "China"),
                new Billionaire("Amancio", "Ortega", 59.6, 86, "Spain"),
                new Billionaire("Zhang", "Yiming", 50, 38, "China"),
                new Billionaire("David", "Thomson", 49.2, 64, "Canada"),
                new Billionaire("Ma", "Huateng", 37.2, 50, "China")
        );

        Optional<Billionaire> theWealthy = billionaires.stream().reduce(BinaryOperator.maxBy(Comparator.comparingDouble(Billionaire::getNetWorth)));

        if(theWealthy.isPresent()) {
            System.out.printf("%s %s %.1f B%n", theWealthy.get().getName(), theWealthy.get().getSurname(), theWealthy.get().getNetWorth());
        }

        Optional<Billionaire> youngAndRich = billionaires.stream().reduce(BinaryOperator.minBy(Comparator.comparingInt(Billionaire::getAge)));

        youngAndRich.ifPresent(person -> System.out.printf("%s %s %d years old%n", person.getName(), person.getSurname(), person.getAge()));
        printLine();



        /*
         * Максимум и минимум също така могат да бъдат определени с методите на интерфейс Stream
         * Optional<T> min(Comparator<? super T> comparator);
         * Optional<T> max(Comparator<? super T> comparator);
         */

        Optional<Billionaire> theEldest = billionaires.stream().max(Comparator.comparingInt(Billionaire::getAge));

        theEldest.ifPresent(person -> System.out.printf("%s %s %d years old%n", person.getName(), person.getSurname(), person.getAge()));

        Optional<Billionaire> theLast = billionaires.stream().min(Comparator.comparingDouble(Billionaire::getNetWorth));

        theLast.ifPresent(person -> System.out.printf("%s %s %.1f B%n", person.getName(), person.getSurname(), person.getNetWorth()));
        printLine();



        OptionalDouble maxWealth = billionaires.stream().mapToDouble(Billionaire::getNetWorth).max();

        maxWealth.ifPresent(System.out::println);

        OptionalDouble minWealth = billionaires.stream().mapToDouble(Billionaire::getNetWorth).min();

        minWealth.ifPresent(System.out::println);
        printLine();



        /*
         * Максимум и минимум също така могат да бъдат определени с методите на интерфейс Stream
         * public static <T> Collector<T, ?, Optional<T>> minBy(Comparator<? super T> comparator)
         * public static <T> Collector<T, ?, Optional<T>> maxBy(Comparator<? super T> comparator)
         */

        Optional<Billionaire> max = billionaires.stream().collect(Collectors.maxBy(Comparator.comparingInt(Billionaire::getAge)));

        max.ifPresent(person -> System.out.printf("%s %s %d years old%n", person.getName(), person.getSurname(), person.getAge()));

        Optional<Billionaire> min = billionaires.stream().collect(Collectors.minBy(Comparator.comparingInt(Billionaire::getAge)));

        min.ifPresent(person -> System.out.printf("%s %s %d years old%n", person.getName(), person.getSurname(), person.getAge()));
        printLine();



        // Най-богатият човек по държави
        Map<String, Optional<Billionaire>> mapOfTheRich = billionaires.stream()
                .collect(Collectors.groupingBy(Billionaire::getCountry, Collectors.maxBy(Comparator.comparingDouble(Billionaire::getNetWorth))));

        mapOfTheRich
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(el -> System.out.printf("%14s | %s %s%n", el.getKey(), el.getValue().get().getName(), el.getValue().get().getSurname()));
        printLine();
    }

    private static void printLine() {
        System.out.println("------------------------------");
    }
}
