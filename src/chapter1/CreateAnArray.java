package chapter1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CreateAnArray {
    public static void main(String[] args) {
        List<Double> numbers = new ArrayList<>(Arrays.asList(1.2, 2.3, 3.4, 4.5, 5.6));

        Double[] array = numbers.stream().toArray(Double[]::new);

        for(double db : array) System.out.print(db + " ");
    }
}
