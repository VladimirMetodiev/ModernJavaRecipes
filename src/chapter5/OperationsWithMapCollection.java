package chapter5;

import chapter4.Billionaire;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class OperationsWithMapCollection {
    public static void main(String[] args) {
        Map<String, Double> theRich = new HashMap<>();

        if(theRich.get(billionaires[0].getSurname()) == null) theRich.put(billionaires[0].getSurname(), billionaires[0].getNetWorth());
        theRich.entrySet().forEach(person -> System.out.printf("%s %.1f B%n", person.getKey(), person.getValue()));
        printLine();

        if(!theRich.containsKey(billionaires[0].getSurname())) theRich.put(billionaires[0].getSurname(), 0.0);
        theRich.forEach((k, v) -> System.out.printf("%s %.1f B%n", k, v));
        printLine();


        //Методът .putIfAbsent() добавя нов обект с ключ k и стойност v към Map-ът, ако няма елемент с подобен ключ
        theRich.putIfAbsent(billionaires[1].getSurname(), billionaires[1].getNetWorth());
        theRich.forEach((k, v) -> System.out.printf("%s %.1f B%n", k, v));
        printLine();


        // Методът .computeIfPresent() - ако елементът с указания ключ съществува, тогава обновява стойността
        double money = 5.5;
        theRich.computeIfPresent("Bezos", (key, value) -> value + money);
        System.out.println(theRich.get("Bezos"));

        theRich.computeIfPresent("Ma", (key, value) -> value + money);
        System.out.println(theRich.get("Ma"));
        printLine();


        // Методът .computeIfAbsent() изчислява (или извършва действие), ако елемента с указаният ключ отсъства
        theRich.computeIfAbsent("Ma", value -> 22.8); // ако отсъства добавя името Ma и стойност 22,8
        theRich.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
                .forEach(el -> System.out.printf("%s %.1f B%n", el.getKey(), el.getValue()));
        printLine();

        theRich.computeIfAbsent(billionaires[2].getSurname(), value -> billionaires[2].getNetWorth());
        theRich.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
                .forEach(el -> System.out.printf("%s %.1f B%n", el.getKey(), el.getValue()));
        printLine();


        // Методът .compute() - ако елементът с указания ключ съществува, заменя стойността
        theRich.compute("Ma", (k, v) -> v - 10.0);
        System.out.println(theRich.get("Ma"));
        printLine();


        // Методът .getOrDefault() - ако ключът е наличен (в Map-ът), връща неговата стойност, ако не е наличен, тогава връща указаната по подразбиране стойност
        System.out.println(theRich.getOrDefault("Metodiev", 0.0));
        printLine();


        // Методът .merge() - ако елемента съществува, обединява стойността на елемента с посоченият ключ, със стойността на указания аргумент
        HashMap<String, String> names = new HashMap<>();
        names.put("Vladimir", "Meto");
        names.merge("Vladimir", "diev", (oldVal, newVal) -> oldVal + newVal);
        names.forEach((k, v) -> System.out.printf("%s %s%n", k, v));
        printLine();

        theRich.merge("Ma", 10.0, (oldVal, newVal) -> oldVal + newVal);
        theRich.forEach((k, v) -> System.out.printf("%s %.1f B%n", k, v));
        printLine();


        // Методът .remove() премахва посоченият елемент
        theRich.remove("Ma");
        theRich.forEach((k, v) -> System.out.printf("%s %.1f B%n", k, v));
        printLine();


        // Методите .replace() и .replaceAll() - заменят стойност(-и)
        Arrays.stream(billionaires).forEach(el -> theRich.putIfAbsent(el.getSurname(), el.getNetWorth()));
        theRich.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
                .forEach(el -> System.out.printf("%s %.1f B%n", el.getKey(), el.getValue()));
        printLine();

        theRich.replace("Arnault", 58.0);

        theRich.entrySet()
                .stream()
                .filter(el -> el.getKey().equals("Arnault"))
                .forEach(el -> System.out.printf("%s %.1f B%n", el.getKey(), el.getValue()));

        theRich.replace("Arnault", 58.0, 28.0);

        theRich.entrySet()
                .stream()
                .filter(el -> el.getKey().equals("Arnault"))
                .forEach(el -> System.out.printf("%s %.1f B%n", el.getKey(), el.getValue()));
        printLine();

        BiFunction<String, Double, Double> function = (k, v) -> 0.0;
        theRich.replaceAll(function);    // това е равнозначно на theRich.replaceAll((k, v) -> 0.0);

        theRich.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
                .forEach(el -> System.out.printf("%s %.1f B%n", el.getKey(), el.getValue()));
        printLine();
    }

    private static Billionaire[] billionaires = {
            new Billionaire("Elon", "Musk", 219, 50, "United States", "Tesla, SpaceX", "Automotive"),
            new Billionaire("Jeff", "Bezos", 171, 58, "United States", "Amazon", "Technology"),
            new Billionaire("Bernard", "Arnault", 158, 73, "France", "LVMH", "Fashion & Retail"),
            new Billionaire("Bill", "Gates", 129, 66, "United States", "Microsoft", "Technology"),
            new Billionaire("Warren", "Buffett", 119, 91, "United States", "Berkshire Hathaway", "Finance & Investments"),
            new Billionaire("Larry", "Page", 111, 49, "United States", "Google", "Technology"),
            new Billionaire("Amancio", "Ortega", 59.6, 86, "Spain", "Zara", "Fashion & Retail"),
            new Billionaire("Zhang", "Yiming", 50, 38, "China", "TikTok", "Media & Entertainment"),
            new Billionaire("David", "Thomson", 49.2, 64, "Canada", "Thomson Reuters Corporation", "Media & Entertainment"),
            new Billionaire("Giovanni", "Ferrero", 36.2, 57, "Italy", "Nutella", "Food & Beverage"),
            new Billionaire("Dietrich", "Mateschitz", 27.4, 77, "Austria", "Red Bull", "Food & Beverage"),
            new Billionaire("Susanne", "Klatten", 24.3, 59, "Germany", "BMW", "Automotive")
    };

    private static void printLine() {
        System.out.println("--------------------------------------------------");
    }
}
