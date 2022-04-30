package chapter1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ListOfPeopleLambdaVarTwo {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Vladimir Metodiev", "Vasil Petrov", "Ralitza Todorova", "Nina Ivanova");

        List<Person> peoples = names
                .stream()
                .map(name -> {
                    Person people = new Person();
                    people.setName(name.substring(0, name.indexOf(" ")));
                    people.setSurname(name.substring(name.indexOf(" ") + 1));
                    return people;
                })
                .collect(Collectors.toList());

        peoples.forEach(name -> System.out.println(name.getName()));
        System.out.println("----------");
        peoples.forEach(surname -> System.out.println(surname.getSurname()));
        System.out.println("----------");
        peoples.forEach(System.out::println);
    }
}



//Бележка: това е второто ми решение, на същата задача

//    public static void main(String[] args) {
//        List<String> names = Arrays.asList("Vladimir Metodiev", "Vasil Petrov", "Ralitza Todorova", "Nina Ivanova");
//
//        List<Person> peoples = names.stream()
//                //.map(name -> createPerson(name))
//                .map(ListOfPeopleLambdaVarTwo::createPerson)
//                .collect(Collectors.toList());
//
//        peoples.forEach(name -> System.out.println(name.getName()));
//        System.out.println("----------");
//        peoples.forEach(surname -> System.out.println(surname.getSurname()));
//        System.out.println("----------");
//        peoples.forEach(System.out::println);
//    }
//
//    private static Person createPerson(String data) {
//        return new Person(data.substring(0, data.indexOf(" ")), data.substring(data.indexOf(" ") + 1));
//    }
