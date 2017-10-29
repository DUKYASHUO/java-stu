import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ChannelCopy {
    private static final int BSIZE = 1024;

    public static void main(String[] args) {

        try {
            FileChannel in = new FileInputStream("data.txt").getChannel();
            FileChannel out = new FileOutputStream("data_copy.txt").getChannel();
            ByteBuffer buffer = ByteBuffer.allocate(BSIZE);

//            in.transferTo(0, in.size(), out);
            out.transferFrom(in, 0, out.size());

//            while (in.read(buffer) != -1) {
//                buffer.flip();
//                out.write(buffer);
//                buffer.clear();
//            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
