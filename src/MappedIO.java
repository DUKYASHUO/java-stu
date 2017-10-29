import java.io.*;
import java.nio.IntBuffer;
import java.nio.channels.FileChannel;

public class MappedIO {
    private static int numOfInts = 4000000;
    private static int numOfBufferInts = 200000;
    private abstract static class Tester {
        private String name;
        public Tester(String name) {
            this.name = name;
        }
        public void runTest() {
            System.out.println("name; " + name);
            try {
                long start = System.currentTimeMillis();
                test();
                System.out.println((System.currentTimeMillis() - start));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        public abstract void test() throws Exception;
    }
    private static Tester[] tests = {
        new Tester("Stream write") {
            @Override
            public void test() throws Exception{
                DataOutputStream dos = new DataOutputStream(
                        new BufferedOutputStream(
                                new FileOutputStream(new File("temp.tmp"))));
                for (int i = 0; i < numOfInts; i++) {
                    dos.write(i);
                }
                dos.close();
            }
        },
        new Tester("Mapped write") {
            @Override
            public void test() throws Exception {
                FileChannel fc = new RandomAccessFile("temp.tmp", "rw").getChannel();
                System.out.println("size" + fc.size());
                IntBuffer ib = fc.map(FileChannel.MapMode.READ_WRITE, 0, fc.size() * 4).asIntBuffer();
                System.out.println("ib: " + ib.limit());
                for (int i = 0; i < numOfInts; i++) {
                    ib.put(i);
                }
                fc.close();
            }
        },
        new Tester("Stream read") {
            @Override
            public void test() throws Exception {
                DataInputStream dis = new DataInputStream(new BufferedInputStream(new FileInputStream("temp.tmp")));
                for (int i = 0; i < numOfInts; i++) {
                    dis.readInt();
                }
                dis.close();
            }
        },
        new Tester("Mapped Read") {
            @Override
            public void test() throws Exception {
                FileChannel fc = new FileInputStream(
                        new File("temp.tmp")).getChannel();
                IntBuffer ib = fc.map(FileChannel.MapMode.READ_ONLY, 0, fc.size()).asIntBuffer();
                while (ib.hasRemaining())
                    ib.get();
                fc.close();
            }
        }
    };

    public static void main(String[] args) {
        for (Tester tester: tests) {
            tester.runTest();
        }
    }

}
