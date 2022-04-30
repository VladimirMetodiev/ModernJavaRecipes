package chapter6;

import chapter4.Billionaire;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class CreateAnOptionalInstance {
    public static void main(String[] arguments) {
        Billionaire billionaire = new Billionaire("Vladimir", "Metodiev", 0.0);
        Optional<Billionaire> richGuy = Optional.of(billionaire);
        System.out.printf("%s %s wealth: $ %.1f ;)%n", richGuy.get().getName(), richGuy.get().getSurname(), richGuy.get().getNetWorth());
        printLine();


        Optional<String> someStr = Optional.ofNullable(null);
        System.out.println(someStr);
        // Ако взема стойността someStr.get() ще получа java.util.NoSuchElementException
        printLine();


        Optional<Integer> someNumber = Optional.empty();
        System.out.println(someNumber);
        printLine();


        OptionalInt theSmallest = IntStream.generate(() -> new Random().nextInt(101)).limit(10).sorted().findFirst();
        System.out.println(theSmallest);
        printLine();


        OptionalLong randomButAnotherTime = LongStream.rangeClosed(1000000L, 1001000L).parallel().findAny();
        System.out.println(randomButAnotherTime);
        printLine();

        OptionalDouble realNumber = new Random().doubles(10, 0, 1000).reduce(Double::sum);
        System.out.println(realNumber);
    }

    private static void printLine() {
        System.out.println("------------------------------");
    }
}
