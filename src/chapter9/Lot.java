package chapter9;

import java.time.Duration;
import java.time.Instant;
import java.util.stream.IntStream;

public class Lot {
    public static void main(String[] args) {
        /*
         * Java 8 използва общ пул за паралелизиране на нишките. Размерът на пула е равен на броя на НАЛИЧНИТЕ за JVM процесори (ядра).
         * Този брой може да бъде намерен чрез метода Runtime.getRuntime().availableProcessors().
         * Стойността е възможно да се променя.
         *
         * За да бъде оправдано паралелизирането на поток, трябва да бъдат изпълнени следните условия:
         * Наличие на голямо количество данни;
         * Значително време за обработка на един елемент;
         * Източникът на данни трябва лесно да се "разбива" на части;
         * Операциите трябва да нямат "състояния" и да бъдат "асоциативни" (бел. прев. е мой);
         *     (коментар на горното изречение) Ако по време на изпълнението на операциите, се запазва някакво състояние
         *     или резултатът зависи от реда на изпълнение на операциите, това създава проблеми за паралелизирането.
         */

        System.out.printf("Number of CPU cores: %d%n", Runtime.getRuntime().availableProcessors());

        Instant start = Instant.now();
        int total = IntStream.of(1250, 10, 432, 93, -65, 834, 568, 14, 22596, 639).parallel().map(Lot::doubleIt).sum();
        Instant end = Instant.now();

        Duration duration = Duration.between(start, end);

        System.out.printf("Sum = %d%n", total);
        System.out.printf("Time = %d milliseconds%n", duration.toMillis());
    }

    private static int doubleIt(int number) {
        try {
            Thread.sleep(100);
        }
        catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }

        return number * 2;
    }
}
