import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EventChecker implements Runnable {
    private IntGenerator generator;
    private final int id;
    public EventChecker(IntGenerator g, int ident) {
        generator = g;
        id = ident;
    }
    public void run() {
        while (!generator.isCanceled()) {
            int val = generator.next();
            if (val % 2 != 0) {
                System.out.println(val + "not event !");
                generator.cancel();
            }
        }
    }
    public static void test(IntGenerator gp, int count) {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < count; i++) {
            exec.execute(new EventChecker(gp, count));
        }
        exec.shutdown();
    }
    public static void test(IntGenerator gp) {
        test(gp, 10);
    }
}
