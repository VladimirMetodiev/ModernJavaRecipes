package chapter1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ListOfPeopleLambda {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Vladimir", "Emilia", "Peter", "Lora", "Boris", "Antonia");

        List<Person> people = names.stream().map(name -> new Person(name)).collect(Collectors.toList());

        people.forEach(name -> System.out.println(name.getName()));

        System.out.println("------------------------------");

        List<String> anotherNames = people.stream().map(person -> person.getName()).collect(Collectors.toList());

        anotherNames.forEach(name -> System.out.println(name));
    }
}
