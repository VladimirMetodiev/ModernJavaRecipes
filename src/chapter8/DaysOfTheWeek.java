package chapter8;

import java.time.DayOfWeek;

public class DaysOfTheWeek {
    public static void main(String[] args) {
        for(DayOfWeek d : DayOfWeek.values()) {
            System.out.printf("%d %s%n", d.getValue(), d);
        }
    }
}
