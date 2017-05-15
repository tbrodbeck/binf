package blatt02;

/**
 * Created by Ronja on 18.04.17.
 */
public class StringStackTest {
    /**
     * Testet die toString() Methode des StringStacks
     * @return
     */
    private static boolean toStringTest(){
        StringStack s = new StringStack();
        s.push("a");
        s.push("b");
        if (!(s.toString().equals("a b "))) {
            System.out.println("Fehler bei toString sollte sein: a b ist: " + s.toString());
            return false;
        }
        return true;
    }

    /**
     * überprüft mit Hilfe der toString() Methode von StringStack ob der Inhalt von 2 StringStacks gleich ist wobei
     * nicht die Referenzen des Inhalts verglichen werden sondern wie der wirkliche String aussieht
     * @param s
     * @param s2
     * @return ob die gleich sind
     */
    private static boolean inhaltegleich(StringStack s, StringStack s2) {
        if(!((s.toString()).equals(s2.toString()))) {
            System.out.println("inhalte nicht gleich");
            return false;
        }
        return true;
    }

    /**
     * überprüft ob die Referenzen von der Inhalte von 2 übergebenen Strings anders sind
     * @param s
     * @param s2
     * @return ob es mind. ein Element gibt wo die Referenzen gleich sind
     */
    private static boolean referenzenanders(StringStack s, StringStack s2) {
        StringStack umkehr = new StringStack();
        StringStack umkehr2 = new StringStack();
        boolean anders = true;
        while(!s.empty() && !s2.empty() && anders) {
            if(s.empty()||s2.empty()) {
                throw new RuntimeException("Stacks haben eine andere Anzahl Elemente!");
            }
            if(s.peek()==s2.peek()) {
                System.out.println("Referenz gleich");
                anders = false;
            }
            else {
                umkehr.push(s.peek());
                umkehr.push(s2.peek());
                s.pop();
                s2.pop();
            }
        }
        while(!umkehr.empty()&& !umkehr2.empty()) {
            if(umkehr.empty() || umkehr2.empty()) {
                throw new RuntimeException("Umkehrkeller haben andere Länge");
            }
            s.push(umkehr.peek());
            s2.push(umkehr2.peek());
            umkehr.pop();
            umkehr2.pop();
        }
        return anders;
    }


    public static void main(String[] args) {
        boolean funktioniert = toStringTest();
        StringStack s = new StringStack();
        s.push("abc");
        s.push("1klj3;");
        s.push("q");
        s.push("333");
        StringStack kopie = new StringStack(s);
        funktioniert = funktioniert && inhaltegleich(s, kopie);
        funktioniert = funktioniert && referenzenanders(s, kopie);
        if (!funktioniert) System.out.println("Fehler");
        else System.out.println("Kein Fehler");
    }
}