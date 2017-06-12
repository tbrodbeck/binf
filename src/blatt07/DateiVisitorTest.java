package blatt07;

/**
 * Created by Ronja on 12.06.17.
 */
public class DateiVisitorTest {

    public static void main(String[] args) {
        Dateisystem ds = new Dateisystem("/Users/Ronja/Übung8");
        DateiVisitor dv = new DateiVisitor();
        ds.accept(dv);
    }
}
