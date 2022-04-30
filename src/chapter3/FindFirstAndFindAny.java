package chapter3;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class FindFirstAndFindAny {
    public static void main(String[] args) {
        /*
         * Методите .findFirst() и .findAny() на интерфейса java.util.stream.Stream, връщат обект от тип Optional, който "описва"
         * първия елемент от потока. Нито .findFirst() нито .findAny() не приемат аргументи.
         *
         * Методът .findFirst() може да даде различни резултати за "неподредени" потоци.
         * Методът .findAny() може да върне, който и да било елемент, така че е по-подходящ за паралелни операции.
         */

        List<Integer> list = Arrays.asList(3, 1, 4, 1, 5, 9, 2, 6, 5);

        Optional<Integer> firstEven = list.stream().filter(n -> n % 2 == 0).findFirst();

        System.out.println(firstEven);

        if(firstEven.isPresent()) {
            System.out.println(firstEven.get());
        }
        else {
            System.out.println("There is not any number.");
        }


        printLine();


        firstEven = list.stream().filter(n -> n > 10 && n % 2 == 0).findFirst();

        System.out.println(firstEven);

        if(firstEven.isPresent()) {
            System.out.println(firstEven.get());
        }
        else {
            System.out.println("There is not any number.");
        }


        printLine();


        // Използване на метода .findAny() с последователен поток - връща една и съща стойност
        Optional<Integer> any = list.stream().unordered().map(FindFirstAndFindAny::delay).findAny();
        System.out.println("Any: " + any);

        // Използване на метода .findAny() с паралелен поток - връща различни стойности
        any = list.stream().unordered().parallel().map(FindFirstAndFindAny::delay).findAny();
        System.out.println("Any: " + any);
    }

    private static void printLine() {
        System.out.println("------------------------------");
    }

    private static Integer delay(Integer num) {
        try {
            Thread.sleep((long)(Math.random() * 100));
        }
        catch (InterruptedException ignored) {
        }
        return num;
    }
}
