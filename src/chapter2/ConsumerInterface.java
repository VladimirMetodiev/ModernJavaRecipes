package chapter2;

import java.util.*;
import java.util.function.Consumer;

public class ConsumerInterface {
    public static void main(String[] args) {
        /*
         * Интерфейсът java.util.function.Consumer съдържа един единствен абстрактен метод - void accept(T t).
         * Методът accept приема един аргумент от обобщен тип и връща void (т.е. нищо).
         *
         * Consumer притежава и default методи:
         * default Consumer<T> andThen(Consumer<? super T> after)
         *
         * Приложение:
         * default void forEach(Consumer<? super T> action)
         * Optional.ifPresent(Consumer<? super T> consumer)
         * Stream.peek(Consumer<? super T> action)
         *
         * Други интерфейси от тип Consumer:
         * IntConsumer => абстрактен метод void accept(int x)
         * DoubleConsumer => абстрактен метод void accept(double x)
         * LongConsumer => абстрактен метод void accept(long x)
         * BiConsumer => абстрактен метод void accept(T t, U u)
         *
         */

        Consumer<String> print = text -> System.out.println(text);
        print.accept("Hi, everybody");


        getLine();


        List<String> names = Arrays.asList("Albena", "Boriana", "Victoria", "Diana");
        // Анонимен вътрешен клас
        names.forEach(new Consumer<String>() {
            @Override
            public void accept(String name) {
                System.out.println(name);
            }
        });
        getLine();
        // Ламбда израз
        names.forEach(name -> System.out.println(name));
        getLine();
        // Връзка на метод
        names.forEach(System.out::println);


        getLine();


        List<Integer> numbers = Arrays.asList(2, 4, 6, 8, 10);
        Consumer<List<Integer>> modify = list -> {
            for (int a = 0; a < list.size(); a++) {
                list.set(a, list.get(a) * list.get(a));
            }
        };
        modify.accept(numbers);
        numbers.forEach(num -> System.out.print(num + " "));
        System.out.println();


        getLine();


        Consumer<List<Integer>> displayList = list -> list.stream().forEach(num -> System.out.print(num + " "));
        displayList.accept(numbers);
        System.out.println();


        getLine();


        numbers = Arrays.asList(3, 6, 9, 12, 15);
        modify.andThen(displayList).accept(numbers);
        System.out.println();


        getLine();


        TreeMap<String, Integer> ages = new TreeMap<>();
        ages.put("Albena", 25);
        ages.put("Boriana", 24);
        ages.put("Victoria", 19);
        ages.put("Diana", 27);

        ages.forEach((name, age) -> System.out.println(name + " is " + age + " years old."));


        getLine();


        // .peek() - е междинна операция
        List<Hero> heroes = Arrays.asList(new Hero("George Washington"), new Hero("Thomas Jefferson"), new Hero("Alexander Hamilton"));
        heroes.stream().peek(rev -> rev.setName(rev.getName().toUpperCase())).forEach(System.out::println);

    }

    private static void getLine() {
        System.out.println("---------->---------->---------->");
    }
}

class Hero {
    String name;

    Hero(String name) {
        this.name = name;
    }

    void setName(String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format("%s", name);
    }
}