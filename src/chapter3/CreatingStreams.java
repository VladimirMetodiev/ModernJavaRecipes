package chapter3;

import java.io.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class CreatingStreams {
    public static void main(String[] args) {
        /*
         * @SafeVarargs
         * public static<T> Stream<T> of(T... values) {
         *     return Arrays.stream(values);
         * }
         */

        System.out.println("Stream.of()");

        Stream.of(2, 4, 6, 8, 10).forEach(el -> System.out.print(el + " "));
        getNewLine();

        String names = Stream.of("Vladimir", "Anna", "Alexander", "Nina", "Nicola").collect(Collectors.joining(", "));
        System.out.println(names);



        printLine();



        /*
         * static <T> Stream<T> iterate(T seed, UnaryOperator<T> f)
         */

        System.out.println("Stream.iterate()");

        Stream.iterate(1, x -> x * 2).limit(5).forEach(el -> System.out.print(el + " "));
        getNewLine();

        List<BigDecimal> bigNumbers = Stream.iterate(BigDecimal.TEN, x -> x.multiply(BigDecimal.TEN)).limit(5).collect(Collectors.toList());
        System.out.println(bigNumbers);

        Stream.iterate(LocalDate.now(), date -> date.plusDays(1L)).limit(5).forEach(date -> System.out.print(date + " "));
        getNewLine();



        printLine();



        /*
         * static <T> Stream<T> generate(Supplier<T> s)
         */

        System.out.println("Stream.generate()");

        Stream.generate(() -> new Random().nextInt(101)).limit(5).forEach(el -> System.out.print(el + " "));
        getNewLine();

        try(Scanner input = new Scanner(new FileInputStream("text\\SomeIntegers.txt"))) {
            IntStream.generate(input::nextInt).limit(5).forEach(el -> System.out.print(el + " "));
            getNewLine();
        }
        catch (FileNotFoundException ex) {
            System.err.println("Exception: " + ex.getMessage());
        }



        printLine();



        System.out.println("Arrays.stream()");

        double[] someRealNumbers = {7.5, 8.3, 11.4, 9.8, 14.5};
        Arrays.stream(someRealNumbers).forEach(el -> System.out.print(el + " "));
        getNewLine();



        printLine();



        System.out.println("Collection.stream()");

        ArrayList<Character> letters = new ArrayList<>(Arrays.asList('a', 'b', 'c', 'd', 'e'));
        letters.stream().map(letter -> letter.toString().toUpperCase()).forEach(el -> System.out.print(el + " "));
        getNewLine();

        List<String> someNames = Arrays.asList("Vladimir", "Anna", "Alexander", "Nina", "Nicola");
        names = someNames.stream().collect(Collectors.joining(", "));
        System.out.println(names);



        printLine();



        /*
         * За работа с примитивни типове, има още три родствени интерфейса : IntStream, LongStream и DoubleStream.
         * Интерфейсите IntStream и LongStream имат по два допълнителни фабрични метода за създаване на потоци.
         *
         * static IntStream range(int startInclusive, int endExclusive)
         * static IntStream rangeClosed(int startInclusive, int endInclusive)
         * static LongStream range(long startInclusive, long endExclusive)
         * static LongStream rangeClosed(long startInclusive, long endInclusive)
         *
         * .rangeClosed() - взима и крайното значение
         * .range() - не взима крайното значение
         *
         * Тези методи връщат последователен, подреден поток, който започва със стойността на първия аргумент, а всеки
         * следващ елемент е с 1 по-голям от предишния.
         */

        System.out.println("The methods: .range() and .rangeClosed()");
        IntStream.range(10, 21).forEach(el -> System.out.print(el + " "));
        getNewLine();

        List<Long> longs = LongStream.rangeClosed(10L, 20L).boxed().collect(Collectors.toList());
        longs.forEach(el -> System.out.print(el + " "));
        getNewLine();
    }

    private static void getNewLine() {
        System.out.println();
    }

    private static void printLine() {
        System.out.println("==================================================");
    }
}
