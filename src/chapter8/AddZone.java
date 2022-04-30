package chapter8;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class AddZone {
    public static void main(String[] args) {

        // С методът .atZone() добавям часова зона към обект от тип LocalDateTime
        LocalDateTime dateTime = LocalDateTime.of(2006, Month.JUNE, 12, 8, 25, 18);
        ZonedDateTime sofia = dateTime.atZone(ZoneId.of("Europe/Sofia"));
        System.out.println(sofia);
        printLine();

        // С методът .withZoneSameInstant() променям часовата зона на обект от тип ZonedDateTime
        ZonedDateTime greenwich = sofia.withZoneSameInstant(ZoneId.of("Greenwich"));
        System.out.println(greenwich);
        printLine();

        ZonedDateTime newYork = sofia.withZoneSameInstant(ZoneId.of("America/New_York"));
        System.out.println(newYork);
        printLine();
    }

    private static void printLine() {
        System.out.println("------------------------------");
    }
}
