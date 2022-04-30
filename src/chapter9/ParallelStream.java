package chapter9;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ParallelStream {
    public static void main(String[] args) {
        /*
         * Паралелен поток - мога да създам чрез:
         * метода parallelStream на интерфейса Collection
         * метода parallel на интерфейса Stream
         *
         * Интерфейсът Stream има метод sequential, който превръща паралелен поток в последователен
         */

        Optional<Integer> max = Stream.of(20, 15, 30, 25, 40, 35, 50, 45, 60, 55, 70, 65, 80, 75, 90).parallel().max(Integer::compareTo);
        max.ifPresent(System.out::println);
        printLine();

        List<Integer> numbers = Arrays.asList(14, 64, 18, 11, 35, 19, 15, 23, 7, 27);
        Optional<Integer> min = numbers.parallelStream().min(Integer::compareTo);
        min.ifPresent(System.out::println);
        printLine();



        // Метода .isParallel(), на интерфейса BaseStream, връща true ако потока е паралелен и false ако не е паралелен
        boolean isItParallel = Stream.iterate(1, a -> a + 1).limit(15).isParallel();
        System.out.printf(".isParallel() | %s%n", isItParallel);

        isItParallel = Stream.iterate(1, x -> x + 1).limit(30).parallel().isParallel();
        System.out.printf(".isParallel() | %s%n", isItParallel);
        printLine();



        isItParallel = numbers.parallelStream().sequential().isParallel();
        System.out.printf(".sequential() & .isParallel() | %s%n", isItParallel);
        printLine();



        // Операцията сортиране е последователна, потока трябва да бъде преобразуван в последователен
        List<Integer> result = numbers.parallelStream()
                .map(x -> x * 3)
                .peek(y -> System.out.printf("%s | %d%n", Thread.currentThread().getName(), y))
                .sequential()
                .sorted()
                .collect(Collectors.toList());

        System.out.println(result.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        printLine();
    }

    private static void printLine() {
        System.out.println("------------------------------");
    }
}
