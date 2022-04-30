package chapter9;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.LongStream;

public class OwnPool {
    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool(10);

        ForkJoinTask<Long> task = pool.submit(() -> LongStream.rangeClosed(1, 10_000_000).parallel().sum());

        try {
            long total = task.get();
            System.out.printf("Result = %d%n", total);
            System.out.printf("Pool size: %d%n", pool.getPoolSize());
        }
        catch (InterruptedException | ExecutionException ex) {
            System.out.println(ex.getMessage());
        }
        finally {
            pool.shutdown();
        }
    }
}
