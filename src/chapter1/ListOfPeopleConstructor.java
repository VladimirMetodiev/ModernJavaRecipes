package chapter1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ListOfPeopleConstructor {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alexander", "Diana", "Anton", "Nina");

        List<Person> people = names.stream().map(Person::new).collect(Collectors.toList());

        people.forEach(name -> System.out.println(name.getName()));

        System.out.println("------------------------------");

        List<String> anotherNames = people.stream().map(Person::getName).collect(Collectors.toList());

        anotherNames.forEach(System.out::println);
    }
}
