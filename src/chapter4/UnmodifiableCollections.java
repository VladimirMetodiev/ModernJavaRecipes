package chapter4;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class UnmodifiableCollections {
    public static void main(String[] args) {
        /*
         * Класът Collections притежава методи, които могат да направят дадена колекция неизменяема.
         * static <T> List<T> unmodifiableList(List<? extends T> list)
         * static <T> Set<T> unmodifiableSet(Set<? extends T> s)
         * static <K,V> Map<K,V> unmodifiableMap(Map<? extends K,? extends V> m)
         *
         * Върху колекция, която е неизменяема, не може да се прилагат методи водещи до нейното изменение, защото ще бъде
         * хвърлена UnsupportedOperationException.
         */

        List<Integer> numbers = IntStream.generate(() -> new Random().nextInt(101)).limit(5).boxed().collect(Collectors.toList());
        List<Integer> unmodifiableList = Collections.unmodifiableList(numbers);

        try {
            unmodifiableList.add(3);
        } catch (UnsupportedOperationException ex) {
            System.out.println("UnsupportedOperationException !");
        }
        print();


        Billionaire[] billionaires = {
                new Billionaire("Elon", "Musk", 219, 50, "United States"),
                new Billionaire("Jeff", "Bezos", 171, 58, "United States"),
                new Billionaire("Bernard", "Arnault", 158, 73, "France"),
                new Billionaire("Bill", "Gates", 129, 66, "United States"),
                new Billionaire("Warren", "Buffett", 119, 91, "United States"),
                new Billionaire("Larry", "Page", 111, 49, "United States"),
                new Billionaire("Mukesh", "Ambani", 90.7, 64, "India"),
                new Billionaire("Zhong", "Shanshan", 65.7, 67, "China"),
                new Billionaire("Amancio", "Ortega", 59.6, 86, "Spain"),
                new Billionaire("Zhang", "Yiming", 50, 38, "China"),
                new Billionaire("David", "Thomson", 49.2, 64, "Canada"),
                new Billionaire("Ma", "Huateng", 37.2, 50, "China")
        };


        List<Billionaire> richPeople = createImmutableList(billionaires);
        richPeople.forEach(el -> System.out.printf("%s %s is %d years old.%n", el.getName(), el.getSurname(), el.getAge()));
        print();


        String[] data = Arrays.stream(billionaires).map(Billionaire::getSurname).toArray(String[]:: new);
        Set<String> surnames = createImmutableSet(data);
        surnames.forEach(System.out::println);
        print();


        Map<String, Double> theWealthy = Collections
                .unmodifiableMap(Arrays.stream(billionaires).collect(Collectors.toMap(Billionaire::getSurname, Billionaire::getNetWorth)));
        theWealthy.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
                .forEach(el -> System.out.printf("%-8s | %.1f B%n", el.getKey(), el.getValue()));
        print();


        theWealthy = Collections.unmodifiableMap(Arrays.stream(billionaires)
                .collect(Collectors.toMap(p -> p.getName() + " " + p.getSurname(), Billionaire::getNetWorth)));
        theWealthy.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(el -> System.out.printf("%15s | %.1f B%n", el.getKey(), el.getValue()));
        print();


        /*
         * Неизменяема колекция, също така може да се създаде, със статичния метод .collectingAndThen() от клас Collectors.
         */

        List<Billionaire> wealth = Arrays.stream(billionaires)
                .collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));
        wealth.stream()
                .sorted(Comparator.comparing(Billionaire::getSurname))
                .forEach(el -> System.out.printf("%s %s has %.1f B.%n", el.getName(), el.getSurname(), el.getNetWorth()));
        print();


        Set<String> country = Arrays.stream(billionaires)
                .map(Billionaire::getCountry)
                .collect(Collectors.collectingAndThen(Collectors.toSet(), Collections::unmodifiableSet));
        country.stream()
                .sorted(Comparator.naturalOrder())
                .forEach(System.out::println);
        print();

    }

    private static void print() {
        System.out.println("------------------------------");
    }

    @SafeVarargs
    private static <T> List<T> createImmutableList(T... elements) {
        return Collections.unmodifiableList(Arrays.asList(elements));
    }

    @SafeVarargs
    private static <T> Set<T> createImmutableSet(T... elements) {
        return Collections.unmodifiableSet(new TreeSet<>(Arrays.asList(elements)));
    }
}
