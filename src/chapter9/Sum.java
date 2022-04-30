package chapter9;

import java.time.Duration;
import java.time.Instant;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Sum {
    public static void main(String[] args) {
        System.out.printf("Number of CPU cores: %d%n", Runtime.getRuntime().availableProcessors());
        printLine();

        System.out.println("Iterative sum");
        Instant start = Instant.now();
        long total = iterativeSum();
        Instant end = Instant.now();
        display(start, end, total);

        System.out.println("Sequential Stream sum");
        start = Instant.now();
        total = sequentialStreamSum();
        end = Instant.now();
        display(start, end, total);

        System.out.println("Sequential LongStream sum");
        start = Instant.now();
        total = sequentialLongStreamSum();
        end = Instant.now();
        display(start, end, total);

        System.out.println("Parallel Stream sum");
        start = Instant.now();
        total = parallelStreamSum();
        end = Instant.now();
        display(start, end, total);

        System.out.println("Parallel LongStream sum");
        start = Instant.now();
        total = parallelLongStreamSum();
        end = Instant.now();
        display(start, end, total);
    }

    private static void printLine() {
        System.out.println("------------------------------");
    }

    private static void display(Instant start, Instant end, long total) {
        Duration duration = Duration.between(start, end);
        System.out.printf("Sum = %d%n", total);
        System.out.printf("Time = %d milliseconds%n", duration.toMillis());
        printLine();
    }

    private static long iterativeSum() {
        long result = 0L;
        for(long a = 1L; a <= 1000000; a++) {
            result += a;
        }
        return result;
    }

    private static long sequentialStreamSum() {
        return Stream.iterate(1L, x -> x + 1L).limit(1000000).reduce(0L, Long::sum);
    }

    private static long sequentialLongStreamSum() {
        return LongStream.rangeClosed(1, 1000000).sum();
    }

    private static long parallelStreamSum() {
        return Stream.iterate(1L, x -> x + 1L).limit(1000000).parallel().reduce(0L, Long::sum);
    }

    private static long parallelLongStreamSum() {
        return LongStream.rangeClosed(1, 1000000).parallel().sum();
    }
}
