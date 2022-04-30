package chapter1;

import java.util.ArrayList;
import java.util.Arrays;

public class DefaultMethods {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(-8, -4, -2, 0, 2, 4, 6, 8, 10));

        boolean removed = numbers.removeIf(n -> n <= 0);
        System.out.printf("Elements %s removed.%n", removed ? "were" : "were not");

        numbers.forEach(num -> System.out.print(num + " "));
    }
}



// Метод .removeIf() на интерфейс Collection е default
// Метод .forEach() на интерфейс Iterator е default

// Методът Collection.removeIf() работи, като прилага условието, предоставено в Predicate инстанцията за всички елементи
// на колекцията, от която е извикан. Елементите, които отговарят на условието, се запазват, докато останалите се премахват.
