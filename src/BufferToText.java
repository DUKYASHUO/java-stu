import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

public class BufferToText {

    private static final int BSIZE = 1024;

    public static void main(String[] args) {

        try {
            FileChannel fc = new FileOutputStream("data2.txt").getChannel();
            fc.write(ByteBuffer.wrap("just for fun".getBytes()));
            fc.close();

            fc = new FileInputStream("data2.txt").getChannel();
            ByteBuffer buffer = ByteBuffer.allocate(BSIZE);
            fc.read(buffer);
            buffer.flip();
            System.out.println(buffer.asCharBuffer());

            buffer.rewind();

            String encoding = System.getProperty("file.encoding");
            System.out.println(encoding + "   " + Charset.forName(encoding).decode(buffer));

            fc = new FileOutputStream("data.txt").getChannel();
            fc.write(ByteBuffer.wrap("Some txt".getBytes("UTF-16BE")));
            fc.close();

            fc = new FileInputStream("data.txt").getChannel();
            buffer.clear();
            fc.read(buffer);
            buffer.flip();
            System.out.println(buffer.asCharBuffer());

            fc = new FileOutputStream("data2.txt").getChannel();
            buffer = ByteBuffer.allocate(24);
            buffer.asCharBuffer().put("Some txt");
            fc.write(buffer);
            fc.close();

            fc = new FileInputStream("data2.txt").getChannel();
            buffer.clear();
            fc.read(buffer);
            buffer.flip();
            System.out.println(buffer.asCharBuffer());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
