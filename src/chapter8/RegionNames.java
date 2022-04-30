package chapter8;

import java.time.ZoneId;
import java.util.Set;

public class RegionNames {
    public static void main(String[] args) {
        Set<String> regionNames = ZoneId.getAvailableZoneIds();
        System.out.printf("There are %d regions.%n", regionNames.size());
        printLine();

        regionNames.forEach(System.out::println);
        printLine();
    }

    private static void printLine() {
        System.out.println("------------------------------");
    }
}
