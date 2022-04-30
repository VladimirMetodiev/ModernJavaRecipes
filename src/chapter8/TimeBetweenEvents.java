package chapter8;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class TimeBetweenEvents {
    public static void main(String[] args) {
        LocalDate theFirstDate = LocalDate.of(2015, Month.JULY, 7);
        LocalDate theSecondDate = LocalDate.of(2195, Month.SEPTEMBER, 5);
        LocalDate today = LocalDate.now();


        System.out.printf("%d days left.%n", ChronoUnit.DAYS.between(today, theSecondDate));
        System.out.printf("%d weeks left.%n", ChronoUnit.WEEKS.between(today, theSecondDate));
        System.out.printf("%d years left.%n", ChronoUnit.YEARS.between(today, theSecondDate));
        System.out.printf("%d century left.%n", ChronoUnit.CENTURIES.between(today, theSecondDate));
        printLine();


        Period period = theFirstDate.until(today);
        System.out.println(period);
        System.out.printf("%d years, %d month(s) and %d day(s)%n", period.getYears(), period.getMonths(), period.getDays());
        printLine();


        period = Period.between(theFirstDate, today);
        System.out.println(period);
        System.out.printf("%d years, %d month(s) and %d day(s)%n", period.getYears(), period.getMonths(), period.getDays());
        printLine();


        Duration duration = Duration.between(theFirstDate.atStartOfDay(), today.atStartOfDay());
        System.out.println(duration);
        System.out.printf("%d day(s)%n", duration.toDays());
        printLine();
    }

    private static void printLine() {
        System.out.println("------------------------------");
    }
}
