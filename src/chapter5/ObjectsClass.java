package chapter5;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ObjectsClass {
    public static void main(String[] args) {
        /*
         * Класът java.util.Objects е добавен в Java 7. Той съдържа следните статични методи:
         *
         * static boolean deepEquals(Object a, Object b) Извършва "дълбоко" сравнение на равенството, което е полезно при сравняване на масиви;
         *
         * static boolean equals(Object a, Object b) Извиква метода equals от първият аргумент, но е безопасен, когато този аргумент е null;
         *
         * static int hash(Object... values) Генерира хеш код за входящата последователност от стойности;
         *
         * static String toString(Object obj) Връща символен низ, ако стойността на аргумента не е null, и null в противоположния случай;
         *
         * static String toString(Object obj, String nullDefault) Връща символен низ, ако стойността на първият аргумент не е null, ако е null тогава връща втория аргумент;
         *
         * static <T> T requireNotNull(T obj) Връща obj, ако аргументът не е null, в противоположния случай хвърля NullPointerException;
         *
         * static <T> T requireNotNull(T obj, String message) Връща obj, ако аргументът не е null, в противоположния случай хвърля NullPointerException като изключението съдържа указаното съобщение;
         *
         * static <T> T requireNotNull(T obj, Supplier<String> messageSupplier) Връща obj, ако аргументът не е null, но ако генерира NullPointerException, указаният Supplier<String> генерира съобщението;
         *
         * static boolean isNull(Object obj) Връща true, ако предадената референция е null, или false в противоположния случай;
         *
         * static boolean nonNull(Object obj) Връща true, ако предадената референция не е null, или false в противоположният случай;
         */

        List<String> strings = Arrays.asList("analysis", "appear", "assign", null, null, "calculation", "change", "condition", "exceed", null);

        // Взимам само елементите за които nonNull връща true
        List<String> nonNullStrings = strings.stream().filter(Objects::nonNull).collect(Collectors.toList());
        System.out.println(nonNullStrings.stream().collect(Collectors.joining(", ")));
        print();


        List<String> testArray = Arrays.asList("analysis", "appear", "assign", "calculation", "change", "condition", "exceed");
        System.out.println(Objects.deepEquals(testArray, nonNullStrings));
        print();


        int hashCode = Objects.hashCode(Arrays.asList("analysis", "appear", "assign", "calculation", "change", "condition", "exceed"));
        System.out.println(hashCode);
        print();
    }

    private static void print() {
        System.out.println("--------------------------------------------------");
    }
}
