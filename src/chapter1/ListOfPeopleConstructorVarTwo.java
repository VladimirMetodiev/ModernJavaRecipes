package chapter1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ListOfPeopleConstructorVarTwo {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Vladimir Metodiev", "Vasil Petrov", "Ralitza Todorova", "Nina Ivanova");

        List<Human> people = names
                .stream()
                .map(twoNames -> twoNames.split("\\s+"))
                .map(Human::new)
                .collect(Collectors.toList());

        people.forEach(System.out::println);
    }
}

class Human {
    private String name;

    public Human(String name) {
        this.name = name;
    }

    public Human(String ... names) {
        this.name = Arrays.stream(names).collect(Collectors.joining(" "));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}

