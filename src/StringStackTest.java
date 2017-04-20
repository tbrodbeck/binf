/**
 * Created by Ronja on 18.04.17.
 */
public class StringStackTest {

    public static String stacktoString(StringStack s) {
        StringStack umkehr = new StringStack();
        String string = "";
        while(!s.empty()) {
            string += s.peek();
            umkehr.push(s.peek());
            s.pop();
        }
        while(!umkehr.empty()){
            s.push(umkehr.peek());
            umkehr.pop();
        }
        return string;
    }

    public static boolean gleich(StringStack s) {
        StringStack kopie = new StringStack(s);
        if(stacktoString(s) != stacktoString(kopie)) {
            System.out.println("Werte nicht gleich");
            return false;
        }
        return true;
    }

    public static void veraendern(StringStack s) {
        StringStack kopie = new StringStack(s);
        System.out.println(s.peek());

    }
}
//HAllo
