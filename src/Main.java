import java.io.File;

/**
 * Created by duyashuo on 17-6-5.
 */
public class Main {

    public static void main(String[] args) {

        try {
            test();
        } catch (Exception e) {
//            e.printStackTrace();
        }
    }

    private static void test() throws Exception{
        try {
            File file = new File("testtewetwetwetw");
            System.out.println("----------");
            System.out.println(file.length());
            System.out.println(file.exists());


        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
//            System.out.print(e.getMessage());
        } catch (NullPointerException e) {
            System.out.println("1111111111111");
        }
    }
}
