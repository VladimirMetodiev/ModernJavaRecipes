package chapter4;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class InterfaceComparator {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("this", "is", "a", "list", "of", "strings");

        words.forEach(w -> System.out.print(w + " "));
        getNewLine();

        words.stream().sorted(Comparator.naturalOrder()).forEach(w -> System.out.print(w + " "));
        getNewLine();

        words.stream().sorted(Comparator.reverseOrder()).forEach(w -> System.out.print(w + " "));
        getNewLine();
        printLine();


        // Изразът
        words.stream().sorted((w1, w2) -> w1.length() - w2.length()).forEach(w -> System.out.print(w + " "));
        getNewLine();
        // съответства на:
        words.stream().sorted(Comparator.comparing(String::length)).forEach(w -> System.out.print(w + " "));
        // също така съответства на:
        //Collections.sort(words, Comparator.comparing(String::length));
        getNewLine();
        printLine();


        // Изразът
        words.stream().sorted((w1, w2) -> w2.length() - w1.length()).forEach(w -> System.out.print(w + " "));
        getNewLine();
        // съответства на:
        words.stream().sorted(Comparator.comparingInt(String::length).reversed()).forEach(w -> System.out.print(w + " "));
        getNewLine();
        printLine();


        List<Runner> runners = Arrays.asList(
                new Runner("Alexander", "Dimitrov", 29),
                new Runner("Nicola", "Petrov", 24),
                new Runner("Teodor", "Konstantinov", 32),
                new Runner("Albena", "Petrova", 26),
                new Runner("Lora", "Atanasova", 24),
                new Runner("Teodor", "Dragomirov", 30),
                new Runner("Lora", "Ivanova", 34),
                new Runner("Nina", "Hadjinikolova", 30)
        );

        runners.stream().sorted(Comparator.comparing(Runner::getName).thenComparing(Runner::getSurname)).forEach(System.out::println);
        printLine();

        runners.stream().sorted(Comparator.comparing(Runner::getAge).thenComparing(Runner::getName)).forEach(System.out::println);
        printLine();

        runners.stream().sorted(Comparator.comparing(Runner::getAge).reversed().thenComparing(Runner::getName)).forEach(System.out::println);
        printLine();
    }

    private static void printLine() {
        System.out.println("--------------------------------------------------");
    }

    private static void getNewLine() {
        System.out.println();
    }
}

class Runner {
    private String name;
    private String surname;
    private int age;

    public Runner(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return String.format("%s %s is %d years old.", name, surname, age);
    }
}
