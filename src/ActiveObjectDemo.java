import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class ActiveObjectDemo {
    private ExecutorService exec = Executors.newSingleThreadExecutor();
    private Random rand = new Random(47);

    private void pause(int factor) {
        try {
            TimeUnit.MILLISECONDS.sleep(100 + rand.nextInt(factor));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public Future<Integer> calculateInt(final int x, final int y) {
        return exec.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                System.out.println("starting " + x + " " + y);
                pause(500);
                return x+y;
            }
        });
    }
    public Future<Float> calculateFloat(final float x, final float y) {
        return exec.submit(new Callable<Float>() {
            @Override
            public Float call() throws Exception {
                System.out.println("tarting " + x + " " + y);
                pause(2000);
                return x + y;
            }
        });
    }
    public void shutdown() {
        exec.shutdown();
    }
    public static void main(String[] args) {
        ActiveObjectDemo d1 = new ActiveObjectDemo();
        List<Future<?>> result = new CopyOnWriteArrayList<Future<?>>();
        for(float f = 0.0f; f < 1.0f; f+= 0.2f)
            result.add(d1.calculateFloat(f,f));
        for(int i = 0; i < 5; i++)
            result.add(d1.calculateInt(i,i));
        System.out.println("All asynch calls made");
        while (result.size() > 0) {
            for(Future<?> f : result)
            if(f.isDone()) {
                try {
                    System.out.println(f.get());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                result.remove(f);
            }
        }
        d1.shutdown();

    }
}
