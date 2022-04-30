package chapter8;

import java.time.*;
import java.time.chrono.ChronoLocalDate;
import java.time.temporal.*;
import java.util.ArrayList;
import java.util.List;

public class TemporalQueryInterface {
    public static void main(String[] args) {
        /*
         * @FunctionalInterface
         * public interface TemporalQuery<R> { R queryFrom(TemporalAccessor temporal); }
         *
         * Интерфейсът TemporalQuery предоставя метода queryFrom(TemporalAccessor temporal), които приема стойност от тип TemporalAccessor.
         *
         * Статични методи на класът TemporalQueries:
         * TemporalQuery<Chronology> chronology()
         * TemporalQuery<LocalDate> localDate()
         * TemporalQuery<LocalTime> localTime()
         * TemporalQuery<ZoneOffset> offset()
         * TemporalQuery<TemporalUnit> precision()
         * TemporalQuery<ZoneId> zone()
         * TemporalQuery<ZoneId> zoneId()
         */

        // Обект от тип TemporalAccessor
        ZonedDateTime sofia = ZonedDateTime.now(ZoneId.of("Europe/Sofia"));
        System.out.println(sofia);

        // Първи начин
        Experiment1 exp1 = new Experiment1();
        String result = exp1.queryFrom(sofia);
        System.out.printf("Result: %s%n", result);

        // Втори начин
        String equivalentResult = sofia.query(exp1);
        System.out.printf("Equivalent result: %s%n", equivalentResult);
        printLine();



        LocalDateTime localDateTime = LocalDateTime.of(2015, Month.MAY, 14, 18, 30, 35);
        ZonedDateTime greenwich = localDateTime.atZone(ZoneId.of("Greenwich"));
        System.out.println(greenwich);

        // Първи начин
        Experiment2 exp2 = new Experiment2();
        result = exp2.queryFrom(greenwich);
        System.out.printf("Result: %s%n", result);

        // Втори начин
        equivalentResult = greenwich.query(exp2);
        System.out.printf("Equivalent result: %s%n", equivalentResult);
        printLine();



        // Запитване връщащо списък с датите на всички съботи в текущият месец
        // Тук работя с обект от тип LocalDate
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);
        printLine();

        // Първи начин
        Experiment3 exp3 = new Experiment3();
        List<LocalDate> resultList = exp3.queryFrom(localDate);
        resultList.forEach(System.out::println);
        printLine();

        // Втори начин
        resultList = localDate.query(exp3);
        resultList.forEach(System.out::println);
        printLine();



        // Поръчка връщаща списък с датите на всички високосни години от столетието
        LocalDate theNineteenNinetyNine = LocalDate.of(1999, 1, 1);
        System.out.println(theNineteenNinetyNine);
        printLine();

        Experiment4 exp4 = new Experiment4();
        List<Integer> leapYearList = exp4.queryFrom(theNineteenNinetyNine);
        print(leapYearList);
        printLine();
    }

    private static void printLine() {
        System.out.println("--------------------");
    }

    private static void print(List<Integer> list) {
        int counter = 1;

        for (int a = 0; a < list.size(); a++) {
            if(a < list.size() - 1) {
                if(counter < 5) {
                    System.out.print(list.get(a) + ", ");
                    counter++;
                }
                else {
                    System.out.println(list.get(a));
                    counter = 1;
                }
            }
            else {
                System.out.println(list.get(a) + " (end)");
            }
        }
    }
}

class Experiment1 implements TemporalQuery<String> {
    @Override
    public String queryFrom(TemporalAccessor temporal) {
        if (temporal.isSupported(ChronoField.HOUR_OF_DAY) && temporal.isSupported(ChronoField.MINUTE_OF_HOUR)) {
            int hour = temporal.get(ChronoField.HOUR_OF_DAY);
            int minute = temporal.get(ChronoField.MINUTE_OF_HOUR);
            return hour + ":" + minute;
        }
        return null;
    }
}

class Experiment2 implements TemporalQuery<String> {
    @Override
    public String queryFrom(TemporalAccessor temporal) {
        if (temporal.isSupported(ChronoField.DAY_OF_MONTH) &&
                temporal.isSupported(ChronoField.MONTH_OF_YEAR) &&
                temporal.isSupported(ChronoField.YEAR)) {

            int day = temporal.get(ChronoField.DAY_OF_MONTH);
            int month = temporal.get(ChronoField.MONTH_OF_YEAR);
            int year = temporal.get(ChronoField.YEAR);

            return String.format("%02d/%02d/%d", day, month, year);

        }
        return null;
    }
}

class Experiment3 implements TemporalQuery<List<LocalDate>> {
    @Override
    public List<LocalDate> queryFrom(TemporalAccessor temporal) {
        if(!(temporal instanceof LocalDate))  {
            throw new DateTimeException("This is not LocalDate.");
        }

        LocalDate localDate = (LocalDate)temporal;
        List<LocalDate> resultList = new ArrayList<>();

        ValueRange range = localDate.range(ChronoField.DAY_OF_MONTH);

        for(long dayOfMonth = range.getMinimum(); dayOfMonth <= range.getMaximum(); dayOfMonth++) {
            LocalDate date = localDate.withDayOfMonth((int)dayOfMonth);
            int dayOfWeek = date.get(ChronoField.DAY_OF_WEEK);
            // 1 за понеделник, 2 за вторник, 3 за сряда, 4 за четвъртък, 5 за петък, 6 за събота и 7 за неделя
            if(dayOfWeek == 6) {
                resultList.add(date);
            }
        }

        return resultList;
    }
}

class Experiment4 implements TemporalQuery<List<Integer>> {
    @Override
    public List<Integer> queryFrom(TemporalAccessor temporal) {
        if (!(temporal instanceof ChronoLocalDate)) {
            throw new DateTimeException("This is not ChronoLocalDate.");
        }

        List<Integer> leapYears = new ArrayList<>();

        ChronoLocalDate localDate = (ChronoLocalDate)temporal;

        int year = localDate.get(ChronoField.YEAR);
        int firstYear = year - (year % 100); // ако тук и долу в цикъла укажа 1000, ще получа резултат за 1000 години

        for (int a = 0; a < 100; a++) {
            int y = firstYear + a;
            ChronoLocalDate newLocalDate = localDate.with(ChronoField.YEAR, y);

            if (newLocalDate.isLeapYear()) {
                leapYears.add(newLocalDate.get(ChronoField.YEAR));
            }
        }

        return leapYears;
    }
}