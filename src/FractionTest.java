import java.util.Objects;

/**
 * Created by Ronja on 07.04.17.
 */
public class FractionTest {
    public static void main(String[] args) {
        Fraction f1 = new Fraction(3, 6);
        Fraction f2 = new Fraction(8);
        boolean fehler = false;
        //1. Complier und toString testen
        if (!Objects.equals(f1.toString(), "1/2")) {
            System.out.print("Fehler beim Konstruktor mit Nenner/toString" + f1.toString());
            fehler = true;
        }
        //2. Complier und toSting testen
        if (!Objects.equals(f2.toString(), "8/1")) {
            System.out.print("Fehler beim Konstruktor ohne Nenner/toString" + f2.toString());
            fehler = true;
        }
        //multiply() mit Faktor testen
        Fraction f3 = f1.multiply(3);
        if(!Objects.equals(f3.toString(), "3/2")) {
            System.out.println("Fehler beim multiplizieren mit Faktor" + f3.toString());
            fehler = true;
        }
        //multiply() mit anderem Bruch testen
        Fraction f4 = f1.multiply(f2);
        if(!Objects.equals(f4.toString(), "4/1")){
            System.out.println("Fehler beim multiplizieren mit Bruch");
            fehler = true;
        }
        //mulitply() mit Liste von Brüchen
        Fraction f5 = new Fraction(7,4);
        Fraction f6 = f1.multiply(f4, f5);
        if(!Objects.equals(f6.toString(), "7/2")) {
            System.out.println("Fehler beim multiplizieren von mehreren Brüchen" + f6.toString());
            fehler = true;
        }
        //divide
        Fraction f7 = f1.divide(f2)
        if(!Objects.equals(f7.toString(),"1/16")) {
            System.out.println("Fehler bei divide");
            fehler = true;
        }
        if (!fehler) System.out.println("Kein Fehler");
    }
}
