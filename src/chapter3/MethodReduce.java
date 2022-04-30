package chapter3;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.*;

public class MethodReduce {
    public static void main(String[] args) {
        /*
         * OptionalInt reduce(IntBinaryOperator op)
         * int reduce(int identity, IntBinaryOperator op)
         */

        /*
         * .reduce((x, y) -> x + y)
         * Първият аргумент на ламбда израза може да се разглежда като акумулатор (т.е. в него се добавя всяко следващо значение),
         * а вторият аргумент се използва за предаване на стойностите на елементите на потока.
         */
        int sum = IntStream.rangeClosed(1, 10).reduce((x, y) -> x + y).orElse(0);
        System.out.println("Sum = " + sum);
        getLine();


        sum = IntStream
                .rangeClosed(1, 10)
                .reduce((x, y) -> {
                    System.out.printf("x = %d, y = %d%n", x, y);
                    return x + y;
                })
                .orElse(0);
        System.out.println("Sum = " + sum);
        getLine();


        /*
         * Втори вариант на метода, който има първоначално значение (identity) на акумулатора (в случая 0): .reduce(0, (x, y) -> x + 2 * y)
         * По този начин първата стойност от потока, не е първа стойност на акумулатора и може да бъде трансформирана,
         * x отново изпълнява ролята на акумулатор, а y се използва за добавяне на значения.
         */

        sum = IntStream.rangeClosed(1, 10).reduce(0, (x, y) -> x + 2 * y);
        System.out.println("Sum = " + sum);
        getLine();


        sum = IntStream
                .rangeClosed(1, 10)
                .reduce(0, (x, y) -> {
                    System.out.printf("x = %d, y = %d%n", x, y);
                    return x + 2 * y;
                });
        System.out.println("Sum = " + sum);
        getLine();


        /*
         * OptionalDouble reduce​(DoubleBinaryOperator op)
         * double reduce​(double identity, DoubleBinaryOperator op)
         */

        double dSum = DoubleStream.iterate(1.0, x -> x * 2.0).limit(10).reduce((x, y) -> x + y).orElse(0);
        System.out.println("Sum = " + dSum);
        getLine();


        dSum = DoubleStream
                .iterate(1.0, x -> x * 2.0)
                .limit(10)
                .reduce(0.0, (x, y) -> {
                    System.out.printf("x = %.0f, y = %.0f%n", x, y);
                    return x + Math.pow(y, 2);
                });
        System.out.println("Sum = " + dSum);
        getLine();


        List<String> expression = Arrays.asList("I ", "am ", "a ", "Java ", "developer.");
        String printResult = expression.stream().reduce("", (exp, word) -> exp + word);
        System.out.println(printResult);
        getLine();


        sum = IntStream.rangeClosed(1, 10).reduce(0, (x, y) -> Integer.sum(x, y));
        System.out.println("Sum = " + sum);
        getLine();


        sum = IntStream.rangeClosed(1, 10).reduce(0, Integer::sum);
        System.out.println("Sum = " + sum);
        getLine();


        BigDecimal total = Stream.iterate(BigDecimal.ONE, n -> n.multiply(BigDecimal.TEN))
                .limit(10)
                .reduce(BigDecimal.ZERO, (acc, val) -> acc.add(val));
                //.reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println("Sum = " + total);
        getLine();


        // Намиране на максимум с помоща на метода reduce
        int max = IntStream.rangeClosed(1, 10).reduce(Integer.MIN_VALUE, Integer::max);
        System.out.println("Max = " + max);
        getLine();


        // Намиране на минимум с помоща на метода reduce
        int min = IntStream.rangeClosed(1, 10).reduce(Integer.MAX_VALUE, Integer::min);
        System.out.println("Min = " + min);
        getLine();
    }

    private static void getLine() {
        System.out.println("---------->---------->---------->");
    }
}

