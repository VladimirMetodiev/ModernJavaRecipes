package chapter3;

import java.util.stream.IntStream;

public class AnyMatchAllMatchAndNoneMatch {
    public static void main(String[] args) {
        /*
         * .anyMatch(), .allMatch() и .noneMatch() са методи на интерфейса Stream
         *
         * boolean anyMatch(Predicate<? super T> predicate)
         * boolean allMatch(Predicate<? super T> predicate)
         * boolean noneMatch(Predicate<? super T> predicate)
         *
         * .anyMatch() връща true, ако някои от елементите в потока съвпадне с указаният предикат, в противен случай връща false;
         * .allMatch() връща true, ако всички елементи на потока съвпадат с указаният предикат или ако потокът е празен, в противен случай връща false;
         * .noneMatch() връща true, ако нито един елемент от потока не съответства на указаният предикат, или потокът е празен, в противен случай връща false;
         *
         */

        int number = 79;
        boolean isItPrime = IntStream.range(2, number).noneMatch(x -> number % x == 0);
        System.out.println(isItPrime ? "The number is prime." : "The number isn't prime.");

        int otherNumber = 101;
        isItPrime = isPrime(otherNumber);
        System.out.println(isItPrime ? "The number is prime." : "The number isn't prime.");

        int anotherNumber = 397675211;
        isItPrime = isTheNumberPrime(anotherNumber);
        System.out.println(!isItPrime ? "The number is prime." : "The number isn't prime.");
    }

    private static boolean isPrime(int num) {
        return IntStream.range(2, num).allMatch(divisor -> num % divisor != 0);
    }

    private static boolean isTheNumberPrime(int num) {
        return IntStream.range(2, num).anyMatch(divisor -> num % divisor == 0);
    }
}
