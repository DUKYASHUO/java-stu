import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class GetChannel {

    private static final int BSIZE = 1024;
    public static void main(String[] args) throws Exception {
        FileChannel fc = new FileOutputStream("data.txt").getChannel();
        fc.write(ByteBuffer.wrap("Some test".getBytes()));
        fc.close();

        fc = new RandomAccessFile("data.txt", "rw").getChannel();
        fc.position(fc.size());
        fc.write(ByteBuffer.wrap("Some more".getBytes()));
        fc.close();

        fc = new FileInputStream("data.txt").getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(BSIZE);
        fc.read(buffer);
        buffer.flip();

        while (buffer.hasRemaining())
            System.out.println((char)buffer.get());

    }
}
