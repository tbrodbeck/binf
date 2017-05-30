package blatt06;

/**
 * Created by Ronja on 29.05.17.
 */
public class FractionTest {

    public static void main (String[] args) {
        Fraction f = Fraction.getFraction(1,2);
        if(!f.toString().equals("1/2")) System.out.println("Fehler: Konstruktor wird nicht richtig aufgerufen");
        Fraction f1 = Fraction.getFraction(1,2);
        Fraction f2 = Fraction.getFraction(2,4);
        if(!(f == f1)) System.out.println("Fehler: Fractions mit gleicher Eingabe sind nicht gleich");
        if(!(f == f2)) System.out.println("Fehler: Fractions mit gleichem Wert sind nicht gleich");
        Fraction f3 = Fraction.getFraction(3);
        if(!f3.toString().equals("3/1")) System.out.println("Fehler: Konstruktor wird nicht richtig aufgerufen(ohne Denominator)");
        Fraction f4 = Fraction.getFraction(3);
        Fraction f5 = Fraction.getFraction(1,4);
        if(!(f == f2)) System.out.println("Fehler: Fractions mit gleichem Wert sind nicht gleich (ohne Denominator)");
        if(f.add(f2) != Fraction.getFraction(1,1)) System.out.println("Fehler beim addieren" );
        if(f.multiply(f2) != Fraction.getFraction(1,4)) System.out.println("Fehler beim multiplizieren" + f.getFraction(1/4));
        if(f.subtract(f5) != Fraction.getFraction(1,4)) System.out.println("Fehler beim subtrahieren");
        if(f.divide(f2) != Fraction.getFraction(1,1)) System.out.println("Fehler beim teilen");
        System.out.println("Test beendet");
    }
}
