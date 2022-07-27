import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) throws Exception {
        List<Future> arrayOfFutures = new ArrayList<Future>();

        ExecutorService executor = Executors.newFixedThreadPool(5);

        Future<Integer> num1 = executor.submit(() -> {
            try {
                Thread.sleep(3000);
                return 1000;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Future<Integer> num2 = executor.submit(() -> {
            return 400;
        });

        Future<Integer> num3 = executor.submit(() -> {
            try {
                Thread.sleep(800);
                return 2000;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Future<Integer> num4 = executor.submit(() -> {
            try {
                Thread.sleep(3600);
                return 6000;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        arrayOfFutures.add(num1);
        arrayOfFutures.add(num2);
        arrayOfFutures.add(num3);
        arrayOfFutures.add(num4);

        System.out.println(countFinishedFutures(arrayOfFutures));
        executor.shutdown();
    }

    public static int countFinishedFutures(List<Future> futures) {
        // your code here
        int count = 0;

        for (Future future : futures
        ) {
            if (future.isDone()) {
                count += 1;
            }

        }
        return count;
    }
}