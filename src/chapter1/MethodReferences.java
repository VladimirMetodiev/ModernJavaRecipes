package chapter1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class MethodReferences {
    public static void main(String[] args) {
        List<String> islands = new ArrayList<>(Arrays.asList("Sumatra", "Kalimantan", "Sulawesi", "Java", "New Guinea"));

        islands.forEach(el -> System.out.println(el)); // ламбда израз

        System.out.println("----------");

        islands.forEach(System.out::println); // връзка на метод

        System.out.println("----------");

        Consumer<String> printer = System.out::println; // функционален интерфейс
        islands.forEach(printer);
    }
}



//Бележка: методът forEach на интерфейса Iterable, приема като аргумент обект от тип Consumer;



//Има три синтактични варианта за референция към метод:

//object::instanceMethod
//Референция към метод, използваща съществуваща препратка към обект;
//Ex. System.out::println

//Class::staticMethod
//Референция към статичен метод;
//Ex. Math :: max

//Class::instanceMethod
//Извикване на екземпляр на метод от името на референция към обект, предоставен от съответният контекст;
//Ex. String::length