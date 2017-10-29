enum Signal {GREEN, YELLOW, RED}

public class TrafficLight {
    Signal color = Signal.GREEN;
    public void change() {
        switch (color) {
            case RED:    color = Signal.GREEN;
                         break;
            case GREEN:  color = Signal.YELLOW;
                         break;
            case YELLOW: color = Signal.RED;
                         break;
        }
    }
    public String toString() {
        return "this is " + color;
    }
    public static void main(String[] args) {
        TrafficLight t = new TrafficLight();
        for (int i = 0; i < 7; i++) {
            System.out.println(t);
            t.change();
        }
    }
}
