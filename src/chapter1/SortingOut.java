package chapter1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SortingOut {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("papaya", "kiwi", "mango", "passion fruit", "pomelo", "mangosteen");
        List<String> sorted = strings.stream().sorted((w1, w2) -> w1.compareTo(w2)).collect(Collectors.toList());
        print(sorted);

        System.out.println("---------->---------->---------->");

        strings = Arrays.asList("volatility", "ambiguity", "uncertainty", "complexity");
        sorted = strings.stream().sorted(String::compareTo).collect(Collectors.toList());
        print(sorted);
    }

    private static void print(List<String> list) {
        for (int a = 0; a < list.size(); a++) {
            if(a < list.size() - 1) System.out.print(list.get(a) + ", ");
            else System.out.println(list.get(a));
        }
    }
}



//Бележка: Методът sorted на класа Stream приема като аргумент обект от тип Comparator<T>, който има абстрактен метод int compare().
//Методът sorted предава двойки символни низове на компаратора, който ги сортира.
