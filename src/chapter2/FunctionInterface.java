package chapter2;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FunctionInterface {
    public static void main(String[] args) {
        /*
         * Интерфейсът java.util.function.Function съдържа един единствен абстрактен метод - R apply(T t).
         * Методът apply се извиква, за да преобразува входният параметър от обобщен тип T, в изходна стойност от обобщен тип R.
         *
         * Методи на интерфейсът java.util.function.Function
         * R apply(T t)
         * default <V> Function<T, V> andThen(Function<? super R,? extends V> after)
         * default <V> Function<V, R> compose(Function<? super V,? extends T> before)
         * static <T> Function<T,T> identity() { return t -> t; }
         *
         * Едно от най-честите приложения на интерфейса Function, е като аргумент на метода Stream.map.
         *
         * Други интерфейси от тип Function
         * IntFunction => абстрактен метод R apply(int value)
         * DoubleFunction => абстрактен метод R apply(double value)
         * LongFunction => абстрактен метод R apply(long value)
         * ToIntFunction => абстрактен метод int applyAsInt(T value)
         * ToDoubleFunction => абстрактен метод double applyAsDouble(T value)
         * ToLongFunction => абстрактен метод long applyAsLong(T value)
         * DoubleToIntFunction => абстрактен метод int applyAsInt(double value)
         * DoubleToLongFunction => абстрактен метод long applyAsLong(double value)
         * IntToDoubleFunction => абстрактен метод double applyAsDouble(int value)
         * IntToLongFunction => абстрактен метод long applyAsLong(int value)
         * LongToDoubleFunction => абстрактен метод double applyAsDouble(long value)
         * LongToIntFunction => абстрактен метод int applyAsInt(long value)
         * BiFunction => абстрактен метод R apply(T t, U u)
         * ToIntBiFunction => абстрактен метод int applyAsInt(T t, U u)
         * ToDoubleBiFunction => абстрактен метод double applyAsDouble(T t, U u)
         * ToLongBiFunction => абстрактен метод long applyAsLong(T t, U u)
         */

        List<String> names = Arrays.asList("Eva", "Sarah", "Jose", "Peter", "Joshua", "Anna", "Vladimir", "Andrew", "Nina", "Matthew");

        // В анонимен клас
        List<Integer> nameLengths = names.stream()
                .map(new Function<String, Integer>() {
                    @Override
                    public Integer apply(String str) {
                        return str.length();
                    }
                })
                .collect(Collectors.toList());
        print(nameLengths);

        // С ламбда израд
        nameLengths = names.stream().map(str -> str.length()).collect(Collectors.toList());
        print(nameLengths);

        //С препратка към метод
        nameLengths = names.stream().map(String::length).collect(Collectors.toList());
        print(nameLengths);


        getLine();


        List<Integer> integers = Arrays.asList(52, 18, 3, -34, 15, 6, 30, 14, -16, 9, 21, 56);
        integers.stream()
                .filter(num -> num > 0)
                .sorted(Comparator.naturalOrder())
                .map(num -> num * 100)
                .forEach(num -> System.out.print(num + " "));
        System.out.println();


        getLine();


        // Функцията Function.identity винаги връща своят входен аргумент.
        Function<Integer, Integer> identityFunction = Function.identity();
        System.out.println("Function.identity() => " + identityFunction.apply(36));
        names.stream().map(Function.identity()).forEach(el -> System.out.print(el + " "));
        System.out.println();


        getLine();


        names = Arrays.asList("Emma", "Andrew", "Anna", "Irina", "Peter", "Anna", "Mario", "Andrew", "Emma", "Peter", "Anna", "Ekaterina");
        Set<String> namesSet = new HashSet<>(names);

        // names.size() != namesSet.size();
        // If there are duplicates => true
        names.stream()
                .map(getFunction(names, names.size() != namesSet.size()))
                .collect(Collectors.toSet())
                .forEach(System.out::println);
    }

    private static Function<String, String> getFunction(List<String> names, boolean hasDuplicates){
        return hasDuplicates ? name -> name + " (" + Collections.frequency(names, name) + ")" : Function.identity();
    }

    private static void getLine() {
        System.out.println("---------->---------->----------");
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
