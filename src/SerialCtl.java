import java.io.*;

public class SerialCtl implements Serializable{

    private String a;
    private transient String b;

    public SerialCtl(String a, String b) {
        this.a = "Not transient" + a;
        this.b = "Transient" + b;
    }

    @Override
    public String toString() {
        return a + "\n" + b;
    }

    private void writeObject(ObjectOutputStream outputStream) throws IOException{
        outputStream.defaultWriteObject();
        outputStream.writeObject(b);
    }

    private void readObject(ObjectInputStream inputStream) throws IOException, ClassNotFoundException {
        inputStream.defaultReadObject();
        b = (String) inputStream.readObject();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException{
        SerialCtl serialCtl = new SerialCtl("a", "b");
        ByteArrayOutputStream buf = new ByteArrayOutputStream();
        ObjectOutputStream o = new ObjectOutputStream(buf);
        o.writeObject(serialCtl);

        ObjectInputStream inputStream = new ObjectInputStream(
                new ByteArrayInputStream(buf.toByteArray()));
        SerialCtl sc2 = (SerialCtl)inputStream.readObject();
        System.out.println(sc2);
    }
}
