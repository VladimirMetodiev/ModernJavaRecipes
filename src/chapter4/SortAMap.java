package chapter4;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class SortAMap {
    public static void main(String[] args) {
        List<String> expressions = new ArrayList<>();

        try(BufferedReader reader = new BufferedReader(new FileReader("src\\chapter4\\wordList.txt"))) {
            String data;
            while((data = reader.readLine()) != null) {
                expressions.add(data);
            }
        } catch (FileNotFoundException ex) {
            System.err.println("The file not found!");
        } catch (IOException ex) {
            System.err.println("I/O exception: " + ex.getMessage());
        }

        Map<Integer, Long> longerThanTwenty = expressions.stream()
                .filter(str -> str.length() > 20)
                .collect(Collectors.groupingBy(String::length, Collectors.counting()));
        printTheMap(longerThanTwenty);


        longerThanTwenty.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey(Comparator.reverseOrder()))
                .forEach(item -> System.out.printf("%d -> %d%n", item.getKey(), item.getValue()));
        print();


        HashMap<String, Integer> women = new HashMap<>();
        women.put("Emma", 29);
        women.put("Sarah", 25);
        women.put("Marina", 32);
        women.put("Victoria", 33);
        women.put("Diana", 28);
        women.put("Ariana", 25);
        women.put("Valentina", 31);
        women.put("Teodora", 24);
        women.put("Anna", 30);
        women.put("Lora", 27);
        women.put("Sofia", 33);

        women.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(item -> System.out.printf("%s -> %d%n", item.getKey(), item.getValue()));
        print();

        women.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .forEach(item -> System.out.printf("%s -> %d%n", item.getKey(), item.getValue()));
        print();

        women.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().thenComparing(Map.Entry.comparingByKey()))
                .forEach(item -> System.out.printf("%s -> %d%n", item.getKey(), item.getValue()));
        print();
    }

    private static <T, U> void printTheMap(Map<T, U> map) {
        for(Map.Entry<T, U> entry : map.entrySet()) {
            System.out.printf("%s -> %s%n", "" + entry.getKey(), "" + entry.getValue());
        }
        print();
    }

    private static void print() {
        System.out.println("---------------<>---------------");
    }
}
