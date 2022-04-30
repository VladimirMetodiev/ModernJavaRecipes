package chapter8;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;

public class ConvertFromTo {
    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(date);

        ZoneId zoneId = ZoneId.systemDefault();
        System.out.println(zoneId);

        // Преобразуване на Date в LocalDate
        LocalDate localDate = date.toInstant().atZone(zoneId).toLocalDate();
        System.out.println(localDate);

        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar);

        // Преобразуване на Calendar в ZonedDateTime
        ZonedDateTime zonedDateTime = ZonedDateTime.ofInstant(calendar.toInstant(), calendar.getTimeZone().toZoneId());
        System.out.println(zonedDateTime);

        // Преобразуване на Calendar в LocalDateTime
        LocalDateTime localDateTime = calendar.toInstant().atZone(calendar.getTimeZone().toZoneId()).toLocalDateTime();
        System.out.println(localDateTime);
    }
}
