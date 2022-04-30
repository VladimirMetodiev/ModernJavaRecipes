package chapter9;

import java.util.concurrent.ForkJoinPool;
import java.util.stream.LongStream;

public class PoolResizing {
    public static void main(String[] args) {
        System.out.println("The CPU of my computer: Intel Pentium Processor N3710 @ 1.60 GHz | 1.60 GHz, Cache 2 Mb");
        System.out.printf("Total cores: %s%n", Runtime.getRuntime().availableProcessors());

        System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "15");

        long total = LongStream.rangeClosed(1, 1000000).parallel().sum();
        System.out.printf("Result = %d%n", total);

        int poolSize = ForkJoinPool.commonPool().getPoolSize();
        System.out.printf("Pool size: %s%n", poolSize);

        // При четири ядра, ако задам размер на общият пул - 15 нишки, на дали ще увелича производителността
    }
}
