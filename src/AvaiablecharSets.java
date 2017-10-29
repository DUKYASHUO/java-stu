import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.SortedMap;

public class AvaiablecharSets {
    public static void main(String[] args) {
        SortedMap<String, Charset> charsets = Charset.availableCharsets();
        Iterator<String> it = charsets.keySet().iterator();
        while (it.hasNext()) {
            String scName = it.next();
            System.out.println("-------" + scName);
            Iterator aliases = charsets.get(scName).aliases().iterator();
            while (aliases.hasNext()) {
                System.out.println(aliases.next());

            }
        }
    }
}
