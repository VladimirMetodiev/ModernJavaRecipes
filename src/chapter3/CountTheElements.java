package chapter3;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CountTheElements {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(3, -4, 6, -7, 9, -10, 12, -13, 15, -16, 18, -19);

        long count1 = list.stream().filter(x -> x > 0).count();
        System.out.println(count1);


        int count2 = list.stream().filter(x -> x > 0).mapToInt(x -> 1).sum();
        System.out.println(count2);


        long count3 = list.stream().filter(x -> x > 0).collect(Collectors.counting());
        System.out.println(count3);
    }
}
