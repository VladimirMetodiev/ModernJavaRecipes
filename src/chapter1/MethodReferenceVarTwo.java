package chapter1;

import java.util.stream.Stream;

public class MethodReferenceVarTwo {
    public static void main(String[] args) {
        // Методът generate на интерфейса Stream, приема като аргумент, екземпляр на функционалният интерфейс Supplier.
        // Stream.generate създава безкраен поток, затова използваме метода limit, за да го ограничим.

        Stream.generate(Math::random).map(x -> Math.round(x * 100)).limit(10).forEach(System.out::println);
    }
}
