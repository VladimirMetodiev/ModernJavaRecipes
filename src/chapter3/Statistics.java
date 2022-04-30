package chapter3;

import java.util.*;
import java.util.stream.DoubleStream;

public class Statistics {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(2, 13, 11, 18, 15, 12, 8, 17, 21, 27));

        /*
         * Интерфейсите IntStream, DoubleStream и LongStream разполагат с метод summaryStatistics.
         */

        IntSummaryStatistics intStatistics = list.stream().mapToInt(x -> x).summaryStatistics();

        System.out.println("Count = " + intStatistics.getCount());
        System.out.println("Min = " + intStatistics.getMin());
        System.out.println("Max = " + intStatistics.getMax());
        System.out.println("Sum = " + intStatistics.getSum());
        System.out.println("Average = " + intStatistics.getAverage());
        printSmallLine();
        System.out.println(intStatistics);


        printLine();


        DoubleSummaryStatistics dStatistics = DoubleStream
                .generate(() -> new Random().nextInt(100001))
                .limit(1000000)
                .summaryStatistics();

        System.out.println("Count = " + dStatistics.getCount());
        System.out.println("Min = " + dStatistics.getMin());
        System.out.println("Max = " + dStatistics.getMax());
        System.out.println("Sum = " + dStatistics.getSum());
        System.out.println("Average = " + dStatistics.getAverage());
        printSmallLine();
        System.out.println(dStatistics);
        printLine();

        /*
         * DoubleSummaryStatistics - други методи:
         * void accept(double value)
         * void combine(DoubleSummaryStatistics other)
         *
         * Методът accept добавя нова стойност към множеството от числа, използвани за изчисляване на обобщената статистика,
         * а методът combine комбинира два обекта от тип DoubleSummaryStatistics в един. Те се използват, когато към екземпляр
         * на класа DoubleSummaryStatistics се добавят данни, преди да бъдат изчислени резултатите.
         *
         */
    }

    private static void printLine() {
        System.out.println("<>---------------<>---------------<>");
    }

    private static void printSmallLine() {
        System.out.println("<>-----<>-----<>");
    }
}
