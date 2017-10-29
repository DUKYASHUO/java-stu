public class Test {

    private int j;

    public static void main(String[] args) {
//        for (int i = 0; i < 2; i++) {
//            Test test = new Test();
//            Thread inc = test.new Inc;
//            inc.start();
//            Thread dec = test.new Dec;
//            dec.start();
//        }

//
        String str3 = "str";
        String str4 = "ing";

        String str5 = "str" + "ing";
        String str6 = str3 + str4;

        System.out.println(str5.hashCode());
        System.out.println(str6.hashCode());


        System.out.println(str5 == "string");
        System.out.println(str6 == "string");


    }

    synchronized void inc() {
        j--;
    }

    synchronized void dec() {
        j++;
    }

    class Inc implements Runnable{
        public void run() {
            for (int i = 0; i < 100; i++) {
                inc();
            }
        }
    }

    class Dec implements Runnable{
        public void run() {
            for (int j = 0; j < 100; j++){
                dec();
            }
        }
    }
}
