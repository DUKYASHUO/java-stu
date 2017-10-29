import java.util.concurrent.TimeUnit;

class NeedCleanup {
    private final int id;

    public NeedCleanup(int ident) {
        id = ident;
        System.out.println("NeedsCleanup " + id);
    }

    public void cleanup() {
        System.out.println("Cleaning up " + id);

    }
}

class Blocked3 implements Runnable {
    private volatile double d = 0.0;

    public void run() {
        while (!Thread.interrupted()) {
            NeedCleanup n1 = new NeedCleanup(1);
            System.out.println("Sleeping");
            try {
                TimeUnit.SECONDS.sleep(1);

                NeedCleanup n2 = new NeedCleanup(2);
                try {
                    System.out.println("calculating");
                    for (int i = 1; i < 250000; i++) {
                        d = d + (Math.PI + Math.E) / d;
                        System.out.println("Finished time-consuming");
                    }
                } finally {
                    n2.cleanup();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                n1.cleanup();
            }
        }
        System.out.println("Exiting via while() test");

    }
}


public class InterruptingIdiom {


}
