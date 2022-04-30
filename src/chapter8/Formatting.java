package chapter8;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class Formatting {
    public static void main(String[] args) {
        LocalDateTime localDateTime = LocalDateTime.of(1999, 12, 24, 18, 6, 8);

        String printDateAndTime = localDateTime.format(DateTimeFormatter.ISO_DATE_TIME);
        System.out.println(printDateAndTime);
        printLine();

        printDateAndTime = localDateTime.format(DateTimeFormatter.ISO_LOCAL_DATE);
        System.out.println(printDateAndTime);
        printLine();

        printDateAndTime = localDateTime.format(DateTimeFormatter.ISO_LOCAL_TIME);
        System.out.println(printDateAndTime);
        printLine();



        LocalDate localDate = LocalDate.of(2016, Month.MAY, 14);

        DateTimeFormatter f1 = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
        System.out.println(localDate.format(f1));
        printLine();

        DateTimeFormatter f2 = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG);
        System.out.println(localDate.format(f2));
        printLine();

        System.out.println(localDate.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM)));
        printLine();

        System.out.println(localDate.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT)));
        printLine();



        System.out.println(localDate.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL).withLocale(Locale.FRANCE)));
        printLine();

        System.out.println(localDate.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL).withLocale(Locale.JAPAN)));
        printLine();

        System.out.println(localDate.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL).withLocale(new Locale("hin", "IN"))));
        printLine();

        System.out.println(localDate.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL).withLocale(new Locale("de", "DE"))));
        printLine();



        LocalDateTime now = LocalDateTime.now();
        System.out.println(now.format(DateTimeFormatter.ofPattern("dd/MM/Y EEEE hh:mm:ss a")));
        printLine();

        ZonedDateTime zonedDateTime = ZonedDateTime.of(2000, 1, 1, 1, 15, 33, 425000000, ZoneId.of("Europe/Sofia"));
        DateTimeFormatter f3 = DateTimeFormatter.ofPattern("dd/MMMM/uuuu hh:mm:ss a VV xxxxx");
        System.out.println(zonedDateTime.format(f3));
        printLine();
    }

    private static void printLine() {
        System.out.println("------------------------------");
    }
}
