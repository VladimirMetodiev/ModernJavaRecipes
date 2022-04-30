package chapter8;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class ModifyDateAndTime {
    public static void main(String[] args) {
        LocalDate localDate = LocalDate.of(2000, 1, 1);

        System.out.println(localDate.plusDays(31));
        printLine();

        System.out.println(localDate.plusMonths(5));
        printLine();

        System.out.println(localDate.plusWeeks(14));
        printLine();

        System.out.println(localDate.plusYears(3));
        printLine();

        localDate = localDate.plusMonths(4).plusDays(13);
        System.out.println(localDate);
        printLine();

        DateTimeFormatter f1 = DateTimeFormatter.ofPattern("d MMMM Y");
        System.out.println(localDate.format(f1));
        printLine();

        DateTimeFormatter f2 = DateTimeFormatter.ofPattern("dd.MM.YYYY [EEEE]");
        System.out.println(localDate.format(f2));
        printLine();

        DateTimeFormatter f3 = DateTimeFormatter.ofPattern("d MMMM Y", Locale.UK);
        localDate = localDate.minusDays(14);
        System.out.println(localDate.format(f3));
        printLine();

        localDate = localDate.minusMonths(3);
        System.out.println(localDate.format(f3));
        printLine();

        localDate = localDate.minusWeeks(3);
        System.out.println(localDate.format(f3));
        printLine();

        System.out.println(localDate.minusYears(15).format(DateTimeFormatter.ofPattern("EEEE d MMMM YY", Locale.GERMANY)));
        printLine();


        LocalTime localTime = LocalTime.of(9, 28, 14);

        System.out.println(localTime);
        printLine();

        System.out.println(localTime.plusSeconds(16));
        printLine();

        DateTimeFormatter f4 = DateTimeFormatter.ofPattern("H:m:s a");
        System.out.println(localTime.plusMinutes(42).format(f4));
        printLine();

        DateTimeFormatter f5 = DateTimeFormatter.ofPattern("HH:mm:ss a");
        System.out.println(localTime.plusHours(6).format(f5));
        printLine();

        System.out.println(localTime.minusSeconds(15).format(f5));
        printLine();

        System.out.println(localTime.minusMinutes(585).format(f5));
        printLine();

        System.out.println(localTime.minusHours(18).format(f5));
        printLine();


        LocalDateTime localDateTime = LocalDateTime.of(2016, 8, 26, 9, 15, 48);

        System.out.println(localDateTime);
        printLine();

        DateTimeFormatter f7 = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
        System.out.println(localDateTime.format(f7));
        printLine();

        DateTimeFormatter f8 = DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM);
        System.out.println(localDateTime.format(f8));
        printLine();

        DateTimeFormatter f9 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
        System.out.println(localDateTime.format(f9));
        printLine();

        Period period = Period.of(4, 4, 4);
        LocalDateTime start = LocalDateTime.of(2015, Month.MAY, 5, 17, 17, 17);
        LocalDateTime end = start.plus(period);
        System.out.println(end.format(f9));
        printLine();


        // Изменение само на едно указано ПОЛЕ
        LocalDateTime newLocalDateTime = LocalDateTime.of(2017, Month.JULY, 1, 5, 58,23);
        System.out.println(newLocalDateTime);
        printLine();

        DateTimeFormatter f10 = DateTimeFormatter.ofPattern("dd/MM/Y EEEE HH:mm:ss a");

        System.out.println(newLocalDateTime.withSecond(45).format(f10));
        printLine();

        System.out.println(newLocalDateTime.withMinute(35).format(f10));
        printLine();

        System.out.println(newLocalDateTime.withHour(16).format(f10));
        printLine();

        System.out.println(newLocalDateTime.withDayOfMonth(8).format(f10));
        printLine();

        System.out.println(newLocalDateTime.withDayOfYear(80).format(f10));
        printLine();

        System.out.println(newLocalDateTime.withMonth(4).format(f10));
        printLine();

        System.out.println(newLocalDateTime.withYear(2051).format(f10));
        printLine();

    }

    private static void printLine() {
        System.out.println("------------------------------");
    }
}
