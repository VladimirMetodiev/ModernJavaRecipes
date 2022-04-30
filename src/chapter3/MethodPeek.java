package chapter3;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MethodPeek {
    public static void main(String[] arguments) {
        /*
         * Методът peek на интерфейса Stream, се използва, за да видим случващото се с потока (респективно с неговите елементи),
         * между отделните междинни операции.
         */

        List<Integer> list = Arrays.asList(49, -9, 35, 37, 56, 8, 17, -6, 28, 51, 0, 105, 82, 7, 14, 21, 18, -20, 42, 84);

        StringBuilder sb = new StringBuilder();

        list = list.stream()
                .peek(x -> System.out.print(x + " "))
                .sorted()
                //.peek(x -> System.out.print(x + " "))
                .filter(x -> x > 0)
                //.peek(x -> System.out.print(x + " "))
                .filter(x -> x % 7 == 0)
                //.peek(x -> System.out.print(x + " "))
                .limit(7)
                .collect(Collectors.toList());

        System.out.println();

        list.forEach(x -> System.out.print(x + " "));
    }
}
