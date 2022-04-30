package chapter1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Comparing {
    public static void main(String[] args) {
        List<String> bonds = Arrays.asList("Connery", "Lazenby", "Moore", "Dalton", "Brosnan", "Craig");

        List<String> sorted = bonds.stream().sorted(Comparator.naturalOrder()).collect(Collectors.toList());
        print(sorted);

        sorted = bonds.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        print(sorted);

        sorted = bonds.stream().sorted(Comparator.comparing(String::toLowerCase)).collect(Collectors.toList());
        print(sorted);

        sorted = bonds.stream().sorted(Comparator.comparingInt(String::length)).collect(Collectors.toList());
        print(sorted);

        sorted = bonds.stream()
                .sorted(Comparator.comparingInt(String::length)
                .thenComparing(Comparator.naturalOrder()))
                .collect(Collectors.toList());
        print(sorted);
    }

    private static void print(List<String> list) {
        for (int a = 0; a < list.size(); a++) {
            if(a < list.size() - 1) System.out.print(list.get(a) + ", ");
            else System.out.println(list.get(a));
        }
    }
}



// Статични методи на интерфейса java.util.Comparator
// comparing => Comparator.comparing()
// comparingInt => Comparator.comparingInt()
// comparingLong => Comparator.comparingLong()
// comparingDouble => Comparator.comparingDouble()
// naturalOrder => Comparator.naturalOrder()
// reverseOrder => Comparator.reverseOrder()

// Result

// Brosnan, Connery, Craig, Dalton, Lazenby, Moore
// Moore, Lazenby, Dalton, Craig, Connery, Brosnan
// Brosnan, Connery, Craig, Dalton, Lazenby, Moore
// Moore, Craig, Dalton, Connery, Lazenby, Brosnan
// Craig, Moore, Dalton, Brosnan, Connery, Lazenby
