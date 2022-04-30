package chapter1.myInterface;

@FunctionalInterface
public interface MyInterface {
    int myMethod();

    default String sayHi() {
        return "Hi, everybody!";
    }

    static void print(String text) {
        System.out.println(text);
    }
}
