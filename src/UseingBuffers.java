import java.nio.ByteBuffer;
import java.nio.CharBuffer;

public class UseingBuffers {

    public static void main(String[] args) {
        char[] data = "fuck".toCharArray();
        ByteBuffer bb = ByteBuffer.allocate(data.length * 2);
        CharBuffer cb = bb.asCharBuffer();
        cb.put(data);

        System.out.println("cb.rewind() " + cb.rewind());
        symmetricScramble(cb);
        System.out.println(cb.rewind());
    }

    private static void symmetricScramble(CharBuffer buffer) {
        while (buffer.hasRemaining()) {
            System.out.println("buffer.mark() " + buffer.mark());
            char c1 = buffer.get();
            char c2 = buffer.get();
            System.out.println(c1 + "  " + c2 );
            System.out.println("buffer.reset() " + buffer.reset());
            System.out.println("buffer.put(c2).put(c1) " + buffer.put(c2).put(c1));
        }
    }
}
