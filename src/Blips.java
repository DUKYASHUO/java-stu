import java.io.*;

public class Blips implements Externalizable {

    private int i;
    private transient String s;

    public Blips() {

    }

    public Blips(String s, int i) {
        this.i = i;
        this.s = s;
    }

    @Override
    public String toString() {
        return s + i;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        System.out.println("blips write external");
        out.writeObject(s);
        out.writeInt(i);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        System.out.println("blips read external.");
        s = (String)in.readObject();
        i = in.readInt();
    }

    public static void main(String[] args) throws Exception{
//        Blips blips = new Blips("a string", 1);
//        System.out.println(blips);
//        ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream("blips.out"));
//        o.writeObject(blips);
//        o.close();
        // read object from blips.out
        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("blips.out"));
        Blips blips = (Blips)inputStream.readObject();
        System.out.println(blips);
    }
}
