package chapter3;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ConcatenationOfStreams {
    public static void main(String[] args) {
        Stream<Integer> theFirst = Stream.of(0, 1, 2, 3, 4, 5);
        Stream<Integer> theSecond = Stream.of(6, 7, 8, 9);

        ArrayList<Integer> numbers = Stream.concat(theFirst, theSecond).collect(Collectors.toCollection(ArrayList::new));
        numbers.forEach(x -> System.out.print(x + " "));
        print();


        Stream<Character> theThird = Stream.of('A', 'B', 'C');
        Stream<Character> theFourth = Stream.of('D', 'E', 'F', 'G', 'H');
        Stream<Character> theFifth = Stream.of('I', 'J', 'K', 'L');

        List<Character> letters = Stream.concat(Stream.concat(theThird, theFourth), theFifth).collect(Collectors.toList());
        letters.forEach(letter -> System.out.print(letter + " "));
        print();
    }

    private static void print() {
        System.out.println("\n------------------------------");
    }
}
