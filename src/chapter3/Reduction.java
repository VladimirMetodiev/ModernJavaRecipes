package chapter3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;

public class Reduction {
    public static void main(String[] args) {
        /*
         * Интерфейсите IntStream, LongStream и DoubleStream имат редуциращи операции.
         *
         * Например в интерфейсът IntStream те са:
         * метод count тип на връщаното значение Long
         * метод max тип на връщаното значение OptionalInt
         * метод min тип на връщаното значение OptionalInt
         * метод sum тип на връщаното значение Int
         * метод average тип на връщаното значение OptionalDouble
         * метод summaryStatistics тип на връщаното значение IntSummaryStatistics
         * метод collect(Supplier<R> supplier, ObjIntConsumer<R> accumulator, BiConsumer<R, R> combiner) тип на връщаното значение R
         * метод reduce тип на връщаните значения int, OptionalInt
         */

        List<String> fruits = Arrays.asList("papaya", "tamarind", "mangosteen", "date", "mango", "fig", "lychee", "durian", "pomegranate", "pomelo");


        long count = fruits.stream().map(el -> el.length()).count();
        System.out.println("Count = " + count);

        int max = fruits.stream().map(el -> el.length()).max(Comparator.naturalOrder()).orElse(0);
        System.out.println("Max = " + max);

        int min = fruits.stream().map(String::length).min(Comparator.naturalOrder()).orElse(0);
        System.out.println("Min = " + min);

        int sum = fruits.stream().mapToInt(String::length).sum();
        System.out.println("Sum = " + sum);

        double average = fruits.stream().mapToInt(String::length).average().orElse(0);
        System.out.println("Average = " + average);

        IntSummaryStatistics statistics = fruits.stream().mapToInt(String::length).summaryStatistics();
        System.out.println(statistics);


        System.out.println("---------->---------->---------->---------->---------->");


        String[] anotherFruits = fruits.stream().toArray(String[]::new);
        System.out.println(Arrays.toString(anotherFruits));


        System.out.println("---------->---------->---------->---------->---------->");


        count = Arrays.stream(anotherFruits).map(String::length).count();
        System.out.println("Count = " + count);

        max = Arrays.stream(anotherFruits).mapToInt(String::length).max().orElse(0);
        System.out.println("Max = " + max);

        min = Arrays.stream(anotherFruits).mapToInt(String::length).min().orElse(0);
        System.out.println("Min = " + min);

        sum = Arrays.stream(anotherFruits).mapToInt(String::length).sum();
        System.out.println("Sum = " + sum);

        average = Arrays.stream(anotherFruits).mapToInt(String::length).average().orElse(0);
        System.out.println("Average = " + average);

        statistics = Arrays.stream(anotherFruits).mapToInt(String::length).summaryStatistics();
        System.out.println(statistics);
    }
}
