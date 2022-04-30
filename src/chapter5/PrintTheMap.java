package chapter5;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class PrintTheMap {
    public static void main(String[] args) {
        HashMap<String, Double> billionaires = new HashMap<>();
        billionaires.put("Jack Ma", 22.8);
        billionaires.put("Jeff Bezos", 171.0);
        billionaires.put("LarryPage", 111.0);
        billionaires.put("Zhang Yiming", 50.0);

        for (String key: billionaires.keySet()) {
            System.out.println(billionaires.get(key));
        }
        printLine();

        for (Map.Entry<String, Double> entry : billionaires.entrySet()) {
            System.out.println(entry);
        }
        printLine();

        for (Map.Entry<String, Double> entry: billionaires.entrySet()) {
            System.out.printf("%-12s | %.1f%n", entry.getKey(), entry.getValue());
        }
        printLine();

        Iterator<Map.Entry<String, Double>> iterator = billionaires.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Double> mEntry = iterator.next();
            System.out.printf("%-12s | %.1f%n", mEntry.getKey(), mEntry.getValue());
        }
        printLine();

        billionaires.forEach((k, v) -> System.out.printf("%-12s | %.1f%n", k, v));
        printLine();

        billionaires.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
                .forEach(el -> System.out.printf("%-12s | %.1f%n", el.getKey(), el.getValue()));
        printLine();
    }

    private static void printLine() {
        System.out.println("------------------------------");
    }
}
