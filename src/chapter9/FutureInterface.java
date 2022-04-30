package chapter9;

import java.util.Scanner;
import java.util.concurrent.*;

public class FutureInterface {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your name:");

        ExecutorService service = Executors.newCachedThreadPool();
        Future<String> result = service.submit(new GetHello(input.nextLine()));

        getIfNotCancelled(result);
        service.shutdown();
    }

    private static void getIfNotCancelled(Future<String> future) {
        try {
            if (!future.isCancelled()) {
                System.out.println(future.get());
            } else {
                System.out.println("Canceled!");
            }
        } catch (InterruptedException | ExecutionException ex) {
            ex.printStackTrace();
        }
    }
}

class GetHello implements Callable<String> {
    private String name;

    GetHello(String name) {
        this.name = name;
    }

    @Override
    public String call() {
        return String.format("Hello %s!", name);
    }
}
