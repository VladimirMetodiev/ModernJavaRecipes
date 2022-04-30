package chapter9;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureInterfaceVarTwo {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService service = Executors.newCachedThreadPool();
        Future<String> result = service.submit(() -> {
            Thread.sleep(7000);
            return "Hi geek ;)";
        });

        System.out.println("This is a Pravetz-16 computer. Processing in progress...");

        while (!result.isDone()) {
            Thread.sleep(200);
            System.out.print(">");
            Thread.sleep(200);
            System.out.print(">");
            Thread.sleep(200);
            System.out.print(">");
            Thread.sleep(200);
            System.out.print(" Expectation");
            Thread.sleep(200);
            System.out.print(".");
            Thread.sleep(200);
            System.out.print(".");
            Thread.sleep(200);
            System.out.println(".");
        }

        System.out.println(result.get());
        service.shutdown();
    }
}
