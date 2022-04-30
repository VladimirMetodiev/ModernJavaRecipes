package chapter5;

import java.util.*;
import java.util.stream.Collectors;

public class RandomNumbers {
    public static void main(String[] args) {
        Random random = new Random();

        random.ints(10).sorted().forEach(el -> System.out.print(el + " "));
        getNewLine();

        random.ints(25, 76).limit(10).sorted().forEach(el -> System.out.print(el + " "));
        getNewLine();

        random.ints(10, -100, 101).sorted().forEach(el -> System.out.print(el + " "));
        getNewLine();

        random.longs(5).boxed().sorted(Comparator.reverseOrder()).forEach(el -> System.out.print(el + " "));
        getNewLine();

        random.longs(3000000L, 5000001L)
                .limit(10)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .forEach(el -> System.out.print(el + " "));
        getNewLine();

        random.longs(10, -1000000L, 1000001L)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .forEach(el -> System.out.print(el + " "));
        getNewLine();

        random.doubles(5).sorted().forEach(el -> System.out.print(el + " "));
        getNewLine();

        random.doubles(-1000.0, 1001.0).limit(5).sorted().forEach(el -> System.out.print(el + " "));
        getNewLine();

        random.doubles(5,3.33, 6.67).sorted().forEach(el -> System.out.print(el + " "));
        getNewLine();

        List<Integer> numbers = random.ints(10, 1500, 1601)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        numbers.forEach(el -> System.out.print(el + " "));
        getNewLine();

        Set<Integer> set = random.ints(10, 53, 73)
                .boxed()
                .collect(TreeSet::new, TreeSet::add, TreeSet::addAll);
        set.forEach(el -> System.out.print(el + " "));
        getNewLine();
    }

    private static void getNewLine() {
        System.out.println("\n--------------------------------------------------");
    }
}
