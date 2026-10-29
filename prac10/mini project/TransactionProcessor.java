package Practical_10.Practical_10B;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class TransactionProcessor {

    private ExecutorService executor;

    public TransactionProcessor() {

        executor =
                Executors.newFixedThreadPool(4);
    }

    public void submit(Runnable task) {

        executor.execute(task);
    }

    public void stop() {

        executor.shutdown();

        try {

            executor.awaitTermination(
                    10,
                    TimeUnit.SECONDS);

        }
        catch (InterruptedException e) {

            Thread.currentThread().interrupt();
        }
    }
}