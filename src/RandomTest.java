enum Activaty { FUCK1, FUCK2, FUCK3 }

public class RandomTest {
    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            System.out.print(Enums.random(Activaty.class) + "---");
            Activaty[] test = Activaty.class.getEnumConstants();

        }
    }
}