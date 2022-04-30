package chapter3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class ConvertAListToAnArray {
    public static void main(String[] args) {
        int[] firstArray = IntStream.rangeClosed(1, 10).toArray();
        System.out.println(Arrays.toString(firstArray));


        // Методите mapToInt, mapToLong и mapToDouble преобразуват потоци от обекти в потоци от съответните примитивни типове.

        ArrayList<Long> longNumbers = new ArrayList<>(Arrays.asList(11L, 12L, 13L, 14L, 15L, 16L, 17L, 18L, 19L, 20L));
        long[] secondArray = longNumbers.stream().mapToLong(Long::longValue).toArray();
        System.out.println(Arrays.toString(secondArray));


        List<Integer> intNumbers = Arrays.asList(2, 4, 6, 8, 10, 12, 14, 16, 18, 20);
        int[] thirdArray = intNumbers.stream().mapToInt(Integer::intValue).toArray();
        System.out.println(Arrays.toString(thirdArray));


        List<Double> doubleNumbers = Arrays.asList(2.5, 6.4, 11.8, 3.6, 19.2, -2.5, 4.8, 20.1, 16.5, 8.9);
        double[] fourthArray = doubleNumbers.stream().mapToDouble(Double::doubleValue).toArray();
        System.out.println(Arrays.toString(fourthArray));


        List<String> strList = Arrays.asList("Cape Town", "Harare", "Lusaka", "Kinshasa", "Kampala", "Nairobi");
        String[] fifthArray = strList.stream().toArray(String[]::new);
        System.out.println(Arrays.toString(fifthArray));
    }
}
