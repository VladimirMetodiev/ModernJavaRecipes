package chapter2;

import chapter1.Person;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PredicateInterface {
    public static void main(String[] args) {
        /*
         * Интерфейсът java.util.function.Predicate съдържа един единствен абстрактен метод - boolean test(T t).
         * Методът test приема един аргумент от обобщен тип и връща boolean - true или false.
         *
         * Predicate се използва основно за филтриране на потоци. Например методът filter на интерфейса
         * java.util.stream.Stream, приема аргумент от тип Predicate.
         *
         * Методи на интерфейсът java.util.function.Predicate
         * default Predicate<T> and(Predicate<? super T> other)
         * static <T> Predicate<T> isEquals(Object targetRef)
         * default Predicate<T> negate()
         * default Predicate<T> or(Predicate<? super T> other)
         * boolean test(T t)
         *
         * Други методи, в които се използва Predicate
         * Optional.filter(Predicate<? super T> predicate)
         * Collection.removeIf(Predicate<? super E> filter)
         * Stream.allMatch(Predicate<? super T> predicate)
         * Collectors.partitioningBy(Predicate<? super T> predicate)
         */

        IntStream.iterate(1, x -> x + 1).limit(200).filter(x -> x % 7 == 0).forEach(x -> System.out.print(x + " "));
        System.out.println();


        getLine();


        // Само уникални числа
        List<Integer> integers = Arrays.asList(14, 6, 27, -2, 6, 18, 25, 67, 50, 27, -2, 0, 18, 90, 50);
        List<Integer> someNumbers = integers.stream().filter(n -> Collections.frequency(integers, n) == 1).collect(Collectors.toList());
        print(someNumbers);


        getLine();


        List<String> names = Arrays.asList("John", "Adam", "Robert", "Alexander", "Martin", "Anton", "Daniel", "Alfonso", "Theodore", "Constantine");

        List<String> someNames = names.stream().filter(name -> name.startsWith("A")).collect(Collectors.toList());
        print(someNames);

        String result = names.stream().filter(name -> name.startsWith("A")).collect(Collectors.joining(", "));
        System.out.println(result);


        getLine();


        names.stream().filter(name -> name.length() == 6).collect(Collectors.toSet()).forEach(name -> System.out.print(name + " "));
        System.out.println();


        getLine();


        List<Sweater> sweaters = Arrays.asList(new Sweater("L", "blue"),
                new Sweater("L", "red"),
                new Sweater("XL", "white"),
                new Sweater("XL", "blue"),
                new Sweater("L", "black"),
                new Sweater("M", "yellow"),
                new Sweater("M", "red"),
                new Sweater("XL", "green"),
                new Sweater("XL", "red"),
                new Sweater("M", "blue"));

        long count = sweaters.stream().filter(s -> s.getColour().equals("blue")).count();
        System.out.println(count + " sweater(-s)");

        count = sweaters.stream().filter(s -> s.getSize().equals("XL") && s.getColour().equals("red")).count();
        System.out.println(count + " sweater(-s)");


        getLine();


        List<Person> people = Arrays.asList(new Person("Vladimir", "Metodiev", 'm', 43),
                new Person("Alexander", "Dimitrov", 'm', 44),
                new Person("Nicola", "Todorov", 'm', 31),
                new Person("Marina", "Dobromorova", 'f', 29),
                new Person("Peter", "Angelov", 'm', 35),
                new Person("Teodor", "Grancharov", 'm', 26),
                new Person("Ralitza", "Ivanova", 'f', 32),
                new Person("Polina", "Iordanova", 'f', 33),
                new Person("Victor", "Petrov", 'm', 36),
                new Person("Valentina", "Zlatarova", 'f', 24));

        someNames = people.stream().filter(n -> n.getSex() == 'f').map(Person::getName).collect(Collectors.toList());
        someNames.sort(Comparator.naturalOrder());
        print(someNames);


        people.stream().filter(n -> n.getSurname().startsWith("D") && n.getSex() == 'm').forEach(System.out::println);


        String name = people.stream()
                .filter(n -> "Vladimir".equals(n.getName()))
                .map(Person::getName)
                .findAny()
                .orElse("");

        System.out.println("Name: " + name);


        getLine();


        people.stream().filter(n -> STARTS_WITH_V.test(n.getName())).forEach(System.out::println);
        people.stream().filter(n -> LENGTH_SIX.test(n.getName())).forEach(n -> System.out.println(n.getName() + " is " + n.getAge() + " years old."));


    }

    public static final Predicate<String> LENGTH_SIX = s -> s.length() == 6;
    public static final Predicate<String> STARTS_WITH_V = s -> s.startsWith("V");

    private static void getLine() {
        System.out.println("---------------<!>---------------");
    }

    private static <T> void print(List<T> list) {
        for (int a = 0; a < list.size(); a++) {
            if(a < list.size() - 1) {
                System.out.print(list.get(a) + ", ");
            }
            else {
                System.out.println(list.get(a));
            }
        }
    }
}


class Sweater {
    private String size;
    private String colour;

    public Sweater() {
    }

    public Sweater(String size, String colour) {
        this.size = size;
        this.colour = colour;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sweater sweater = (Sweater) o;
        return Objects.equals(size, sweater.size) && Objects.equals(colour, sweater.colour);
    }

    @Override
    public int hashCode() {
        return Objects.hash(size, colour);
    }
}