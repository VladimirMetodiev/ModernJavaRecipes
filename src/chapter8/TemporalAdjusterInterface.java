package chapter8;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;

public class TemporalAdjusterInterface {
    public static void main(String[] args) {
        /*
         * Интерфейсът TemporalAdjuster предоставя метод, които приема стойност от тип Temporal и връщат резултата от нейната корекция.
         * Класът TemporalAdjusters съдържа набор статични методи изпълняващи ролята на коректори.
         * TemporalAdjuster се използва чрез извикване на метода .with(TemporalAdjuster adjuster) от името на някакъв времеви обект,
         * например LocalDateTime.
         *
         * Методи на класът TemporalAdjusters:
         * static TemporalAdjuster firstDayOfNextMonth()
         * static TemporalAdjuster firstDayOfNextYear()
         * static TemporalAdjuster firstDayOfYear()
         * static TemporalAdjuster firstInMonth(DayOfWeek dayOfWeek)
         *
         * static TemporalAdjuster lastDayOfMonth()
         * static TemporalAdjuster lastDayOfYear()
         * static TemporalAdjuster lastInMonth(DayOfWeek dayOfWeek)
         *
         * static TemporalAdjuster next(DayOfWeek dayOfWeek)
         * static TemporalAdjuster nextOrSame(DayOfWeek dayOfWeek)
         * static TemporalAdjuster previous(DayOfWeek dayOfWeek)
         * static TemporalAdjuster previousOrSame(DayOfWeek dayOfWeek)
         */

        LocalDateTime localDateTime = LocalDateTime.of(2019, Month.JUNE, 10, 11, 30, 2);
        DateTimeFormatter f1 = DateTimeFormatter.ofPattern("dd/MM/YYYY EEEE HH:mm:ss a");
        System.out.println(localDateTime.format(f1));
        printLine();

        System.out.println(localDateTime.with(TemporalAdjusters.next(DayOfWeek.MONDAY)).format(f1));
        printLine();

        System.out.println(localDateTime.with(TemporalAdjusters.next(DayOfWeek.FRIDAY)).format(f1));
        printLine();

        System.out.println(localDateTime.with(TemporalAdjusters.previous(DayOfWeek.MONDAY)).format(f1));
        printLine();

        System.out.println(localDateTime.with(TemporalAdjusters.previous(DayOfWeek.FRIDAY)).format(f1));
        printLine();

        System.out.println(localDateTime.with(TemporalAdjusters.firstDayOfNextMonth()).format(f1));
        printLine();

        System.out.println(localDateTime.with(TemporalAdjusters.firstDayOfNextYear()).format(f1));
        printLine();

        System.out.println(localDateTime.with(TemporalAdjusters.firstDayOfYear()).format(f1));
        printLine();

        System.out.println(localDateTime.with(TemporalAdjusters.firstInMonth(DayOfWeek.TUESDAY)).format(f1));
        printLine();

        System.out.println(localDateTime.with(TemporalAdjusters.lastDayOfMonth()).format(f1));
        printLine();

        System.out.println(localDateTime.with(TemporalAdjusters.lastDayOfYear()).format(f1));
        printLine();

        System.out.println(localDateTime.with(TemporalAdjusters.lastInMonth(DayOfWeek.WEDNESDAY)).format(f1));
        printLine();
    }

    private static void printLine() {
        System.out.println("------------------------------");
    }
}
