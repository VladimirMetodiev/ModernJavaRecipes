package chapter8;

import java.time.*;

public class CreateAnInstance {
    public static void main(String[] arguments) {
        /*
         * Всички класове на пакета java.time създават неизменни екземпляри, затова те са потокобезопасни. Нито един от тях не притежава
         * конструктори, така че екземплярите се създават с фабрични методи.
         *
         * За създаването на нова инстанция, често се използват методите: .now() и .of()
         *
         * Тъй като класовете в пакета java.time са неизменни, всеки метод на екземпляр, който модифицира обект, като plus, minus или with,
         * всъщност създава нов обект.
         */
        System.out.printf("%-20s | %s%n", "Instant.now():", Instant.now());
        System.out.printf("%-20s | %s%n", "LocalDate.now():", LocalDate.now());
        System.out.printf("%-20s | %s%n", "LocalTime.now():", LocalTime.now());
        System.out.printf("%-20s | %s%n", "LocalDateTime.now():", LocalDateTime.now());
        System.out.printf("%-20s | %s%n", "ZonedDateTime.now():", ZonedDateTime.now());
        printLine();


        // Други класове, които имат метода .now()
        System.out.printf("%-16s | %s%n", "Year.now():", Year.now());
        System.out.printf("%-16s | %s%n", "YearMonth.now():", YearMonth.now());
        printLine();


        LocalDate localDate = LocalDate.of(1969, Month.JULY, 20);
        LocalTime localTime = LocalTime.of(20, 18);
        System.out.printf("%-4s | %s%n", "Date:", localDate);
        System.out.printf("%-4s | %s%n", "Time:", localTime);
        printLine();


        LocalDateTime localDateTime = LocalDateTime.of(1978, 5, 14, 11, 50, 24, 129000000);
        System.out.println(localDateTime);
        printLine();


        System.out.printf("%21s | %s%n", "Year:", localDateTime.getYear());
        System.out.printf("%21s | %s%n", "Month:", localDateTime.getMonth());
        System.out.printf("%21s | %s%n", "Month:", localDateTime.getMonthValue());
        System.out.printf("%21s | %s%n", "The day of the month:", localDateTime.getDayOfMonth());
        System.out.printf("%21s | %s%n", "The day of the year:", localDateTime.getDayOfYear());
        System.out.printf("%21s | %s%n", "The day of the week:", localDateTime.getDayOfWeek());
        System.out.printf("%21s | %s%n", "Hour:", localDateTime.getHour());
        System.out.printf("%21s | %s%n", "Minutes:", localDateTime.getMinute());
        System.out.printf("%21s | %s%n", "Seconds:", localDateTime.getSecond());
        System.out.printf("%21s | %s%n", "Nanoseconds:", localDateTime.getNano());
        printLine();
    }

    private static void printLine() {
        System.out.println("------------------------------");
    }
}
