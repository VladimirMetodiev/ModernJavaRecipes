package chapter7;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FilesClass {
    public static void main(String[] args) {
        /*
         * Класът java.nio.file.Files съдържа статични методи, които поддържат функционални потоци.
         *
         * Методът public static Stream<String> lines(Path path) throws IOException
         * Методът public static Stream<String> lines(Path path, Charset cs) throws IOException
         * Методът public static Stream<Path> list(Path dir) throws IOException
         * Методът public static Stream<Path> walk(Path start, int maxDepth, FileVisitOption... options) throws IOException
         * Методът public static Stream<Path> find(Path start, int maxDepth, BiPredicate<Path, BasicFileAttributes> matcher, FileVisitOption... options) throws IOException
         */

        System.out.println("Enter some text:");
        Scanner input = new Scanner(System.in);
        String text = input.nextLine() + (char)10;
        input.close();
        printLine();

        File file = new File("src\\chapter7\\textFile.txt");

        if(!file.exists()) {
            try {
                file.createNewFile();
            }
            catch (IOException ex) {
                System.err.printf("I/O Exception %s%n", ex.getMessage());
            }
        }

        try(RandomAccessFile raf = new RandomAccessFile(file, "rw"); FileChannel channel = raf.getChannel()) {
            raf.seek(raf.length());

            ByteBuffer buffer = ByteBuffer.allocate(text.getBytes().length);
            buffer.put(text.getBytes());

            buffer.flip();
            channel.write(buffer);
        }
        catch (FileNotFoundException ex) {
            System.err.println("There is not such file.");
        }
        catch (IOException ex) {
            System.err.printf("I/O Exception %s%n", ex.getMessage());
        }


        Path path = Paths.get("src\\chapter7\\textFile.txt");

        try (Stream<String> lines = Files.lines(path)) {
            lines.filter(line -> line.length() >= 80)
                    .sorted(Comparator.comparingInt(String::length).reversed())
                    .limit(5)
                    .forEach(line -> System.out.printf("LENGTH[%d] %s%n", line.length(), line));
        }
        catch (IOException ex) {
            System.err.printf("I/O Exception %s%n", ex.getMessage());
        }
        printLine();


        Path otherPath = Paths.get("src\\chapter4\\wordList.txt");

        try (Stream<String> lines = Files.lines(otherPath)) {
            lines.filter(line -> line.length() > 18)
                    .collect(Collectors.groupingBy(String::length, Collectors.counting()))
                    .forEach((length, count) -> System.out.printf("LENGTH[%d] = %d word(s)%n", length, count));
        }
        catch (IOException ex) {
            System.err.printf("I/O Exception %s%n", ex.getMessage());
        }
        printLine();


        File otherFile = new File("src\\chapter4\\wordList.txt");

        try(Stream<String> lines = new BufferedReader(new FileReader(otherFile)).lines()) {
            Map<Integer, Long> map = lines
                    .filter(line -> line.length() > 18)
                    .collect(Collectors.groupingBy(String::length, Collectors.counting()));

            map.entrySet()
                    .stream()
                    .sorted(Map.Entry.<Integer, Long>comparingByValue().reversed().thenComparing(Map.Entry.comparingByKey()))
                    .forEach(element -> System.out.printf("LENGTH[%d] = %d word(s)%n", element.getKey(), element.getValue()));
        }
        catch (IOException ex) {
            System.err.printf("I/O Exception %s%n", ex.getMessage());
        }
        printLine();
    }

    private static void printLine() {
        System.out.println("--------------------------------------------------");
    }
}



//Input
//Never give up. Today is hard, tomorrow will be worse, but the day after tomorrow will be sunshine. [Jack Ma]
//If you don't give up, you still have a chance. [Jack Ma]
//I don't want to be liked. I want to be respected. [Jack Ma]
//The very important thing you should have is patience. [Jack Ma]
//The opportunities that everyone cannot see are the real opportunities. [Jack Ma]
//Forget about your competitors, just focus on your customers. [Jack Ma]
//A leader should be visionary and have more foresight than an employee. [Jack Ma]
//If we are a good team and know what we want to do, one of us can defeat ten of them. [Jack Ma]
//Try to find the right people, not the best people. [Jack Ma]
//On the path to success, you will notice that the successful ones are not whiners, nor do they complain often. [Jack Ma]
//Adopt and change before any major trends or changes. [Jack Ma]
//If you want to win in the 21st century, you have to empower others, making sure other people are better than you are. Then you will be successful. [Jack Ma]
//Once in your life, try something. Work hard at something. Try to change. Nothing bad can happen. [Jack Ma]


