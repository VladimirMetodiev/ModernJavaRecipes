package chapter4;

import java.util.*;
import java.util.stream.*;

public class ConvertAStreamToACollection {
    public static void main(String[] args) {
        /*
         * Методът collect на интерфейса Stream<T> има два варианта:
         * <R, A> R collect(Collector<? super T, A, R> collector)
         * <R> R collect(Supplier<R> supplier, BiConsumer<R,? super T> accumulator, BiConsumer<R, R> combiner)
         *
         */

        List<Integer> numbers = IntStream.rangeClosed(1, 10).boxed().collect(Collectors.toList());
        numbers.forEach(x -> System.out.print(x + " "));
        getNewLine();


        Random someNumber = new Random();
        Set<Integer> set = IntStream.generate(() -> someNumber.nextInt(10)).limit(20).boxed().collect(Collectors.toSet());
        set.forEach(x -> System.out.print(x + " "));
        getNewLine();


        List<Actor> actors = Arrays.asList(
                new Actor("Patrick Stewart", "Jean-Luc Picard"),
                new Actor("Jonathan Frakes", "William T. Riker"),
                new Actor("Levardis Robert Martyn Burton",  "Geordi La Forge"),
                new Actor("Denise Crosby", "Tasha Yar"),
                new Actor("Michael Dorn", "Worf"),
                new Actor("Gates McFadden", "Beverly Crusher"),
                new Actor("Diana Muldaur", "Katherine Pulaski"),
                new Actor("Marina Sirtis", "Deanna Troi"),
                new Actor("Brent Spiner", "Data")
        );

        Map<String, String> starTrek = actors.stream().collect(Collectors.toMap(Actor::getName, Actor::getRole));
        starTrek.forEach((key, value) -> System.out.printf("%s played %s%n", key, value));
        printLine();


        List<String> names = Arrays.asList("Peter", "Nina", "Alexander", "Nicola", "Teodor");
        String[] nameArray = names.stream().toArray(String[]::new);
        Arrays.stream(nameArray).sorted(Comparator.naturalOrder()).forEach(name -> System.out.print(name +" "));
        getNewLine();


        ArrayList<Long> bigNumbers = LongStream
                .iterate(1000000L, x -> x * 100L)
                .limit(5)
                .boxed()
                .collect(Collectors.toCollection(ArrayList::new));
        bigNumbers.forEach(x -> System.out.print(x + " "));
        getNewLine();


        TreeSet<Double> realNumbers = DoubleStream
                .generate(() -> someNumber.nextInt(101) * 6.66)
                .limit(5)
                .boxed()
                .collect(Collectors.toCollection(TreeSet::new));
        realNumbers.stream().forEach(num -> System.out.print( num + " "));
        getNewLine();
    }

    private static void printLine() {
        System.out.println("--------------------------------------------------");
    }

    private static void getNewLine() {
        System.out.println("\n--------------------------------------------------");
    }
}

class Actor {
    private String name;
    private String role;

    public Actor(String name, String role) {
        this.name = name;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }
}
