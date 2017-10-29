import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.SynchronousQueue;

class LiftOffRunner implements Runnable {
    private BlockingQueue<LiftOff> rockets;
    public LiftOffRunner(BlockingQueue<LiftOff> queue) {
        rockets = queue;
    }
    public void add(LiftOff lo) {
        System.out.println("<<<<------->>>>>>>");
        try{
            rockets.put(lo);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void run() {
        while (!Thread.interrupted()) {
            try {
                System.out.println("-------------");
                LiftOff rocket = rockets.take();
                rocket.run();
            } catch (InterruptedException e) {
                System.out.println("Waking from take");
            }
            System.out.println("Exiting lift off runner");
        }
    }
}

public class TestBlockingQueues {
    static void getKey() {
        try{
            new BufferedReader(
                    new InputStreamReader(System.in)).readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    static void getKey(String message) {
        System.out.println(message);
        getKey();
    }
    static void test(String message, BlockingQueue<LiftOff> queue) {
        System.out.println(message);
        LiftOffRunner runner = new LiftOffRunner(queue);
        Thread t = new Thread(runner);
        t.start();
        for (int i = 0; i < 5; i++) {
            runner.add(new LiftOff(5));
        }
        getKey("press enter ( " + message + ")");
        t.interrupt();
        System.out.println("Finished " + message + "test.");
    }

    public static void main(String[] args) {
        test("linked ", new LinkedBlockingDeque<LiftOff>());
        test("array ", new ArrayBlockingQueue<LiftOff>(3));
        test("sync ", new SynchronousQueue<LiftOff>());
    }
}
