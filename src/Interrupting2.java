import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class BlockMutex {
    private Lock lock = new ReentrantLock();
    public BlockMutex() {
        lock.lock();
    }
    public void f() {
        try {
            lock.lockInterruptibly();
            System.out.println("lock acquired in f()");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
class Blocked2 implements Runnable {
    BlockMutex blockMutex = new BlockMutex();
    public void run() {
        System.out.println("waiting for f() in blocked2");
        blockMutex.f();
        System.out.println("Broken out of blocked call");
    }
}
public class Interrupting2 {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new Blocked2());
        t.start();
        TimeUnit.SECONDS.sleep(1);
        System.out.println("Issuing t.interrupt");
        t.interrupt();
    }
}
