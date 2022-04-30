package chapter2;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.DoubleSupplier;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class SupplierInterface {
    public static void main(String[] args) {
        /*
         * Интерфейсът java.util.function.Supplier съдържа един единствен абстрактен метод - T get().
         * Методът T get() не приема аргументи и връща стойност от обобщен тип.
         *
         * Други интерфейси от тип Supplier:
         * IntSupplier => абстрактен метод int getAsInt()
         * DoubleSupplier => абстрактен метод double getAsDouble()
         * LongSupplier => абстрактен метод long getAsLong()
         * BooleanSupplier => абстрактен метод boolean getAsBoolean()
         *
         */

        Supplier<Double> value = () -> 1000.0;
        double getValue = value.get();
        System.out.println(getValue);


        getLine();


        DoubleSupplier randomSupplier = new DoubleSupplier() {
            @Override
            public double getAsDouble() {
                return Math.random();
            }
        };
        System.out.println(randomSupplier.getAsDouble());


        getLine();


        Supplier<LocalDateTime> timeSupplier = () -> LocalDateTime.now();
        LocalDateTime time = timeSupplier.get();
        System.out.println(time);


        getLine();


        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        Supplier<String> dateAndTime = () -> dtf.format(LocalDateTime.now());
        String getTime = dateAndTime.get();
        System.out.println(getTime);


        getLine();


        // Supplier се използва в методите orElse и orElseGet() на класа Optional
        List<String> names = Arrays.asList("Alexander", "James", "Peter", "Thomas", "Benjamin", "Andrew", "Simon", "Anton", "Victor", "William");
        Optional<String> first = names.stream()
                .filter(name -> name.startsWith("C"))
                .findFirst();

        // Принтира Optional.empty
        System.out.println(first);
        // Принтира None
        System.out.println(first.orElse("None"));
        // Принтира се цялата колекция, с разделител запетая, дори ако името е намерено
        System.out.println(first.orElse(String.format("Nothing found in %s", names.stream().collect(Collectors.joining(", ")))));
        // Само ако Optional е празно, принтира колекцията
        System.out.println(first.orElseGet(() -> String.format("Nothing found in %s", names.stream().collect(Collectors.joining(", ")))));
    }

    private static void getLine() {
        System.out.println("-----<>----------<>----------<>-----");
    }
}
