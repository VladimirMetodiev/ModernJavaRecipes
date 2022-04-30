package chapter8;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class Timing {
    public static void main(String[] args) {
        printLine();
        System.out.println("ArrayList");
        printLine();

        ArrayList<Integer> arrayList = new ArrayList<>();

        Instant start = Instant.now();
        for (int a = 0; a < 1000000; a++) {
            arrayList.add(a + 1);
        }
        Instant end = Instant.now();

        System.out.printf("Operation Add | time: %.1f second(s)%n", getTiming(start, end));
        printLine();

        start = Instant.now();
        for (int a = 0; a < 1000000; a++) {
            arrayList.get(new Random().nextInt(1000000));
        }
        end = Instant.now();

        System.out.printf("Operation Get | time: %.1f second(s)%n", getTiming(start, end));
        printLine();


        System.out.println("LinkedList");
        printLine();

        LinkedList<Integer> linkedList = new LinkedList<>();

        start = Instant.now();
        for (int a = 0; a < 1000000; a++) {
            linkedList.add(a + 1);
        }
        end = Instant.now();

        System.out.printf("Operation Add | time: %.1f second(s)%n", getTiming(start, end));
        printLine();

        start = Instant.now();
        for (int a = 0; a < 1000000; a++) {
            linkedList.get(new Random().nextInt(1000000));
        }
        end = Instant.now();

        System.out.printf("Operation Get | time: %.1f second(s)%n", getTiming(start, end));
        printLine();
    }

    private static void printLine() {
        System.out.println("--------------------------------------------------");
    }

    private static double getTiming(Instant start, Instant end) {
        return Duration.between(start, end).toMillis() / 1000.0;
    }
}



//Result

//--------------------------------------------------
//ArrayList
//--------------------------------------------------
//Operation Add | time: 0,1 second(s)
//--------------------------------------------------
//Operation Get | time: 0,2 second(s)
//--------------------------------------------------
//LinkedList
//--------------------------------------------------
//Operation Add | time: 0,1 second(s)
//--------------------------------------------------
//Operation Get | time: 3989,5 second(s)
//--------------------------------------------------
