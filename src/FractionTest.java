/**
 * @author Ronja von Kittlitz, Tillmann Brodbeck
 * @version 10.04.17.
 *
 * Testen Sie Ihre neue Klasse mit Hilfe einer separaten Testklasse. Das Testprogramm soll einige In- stanzen der Klasse
 * Fraction erzeugen und jede der programmierten Operationen mindestens ein- mal testen. Es soll automatisiert eine
 * Ausgabe erfolgen, ob der jeweilige Test erfolgreich war oder nicht.
 */
public class FractionTest {
    public static void main(String[] args) {
        Fraction f1 = new Fraction(3, 6);
        Fraction f2 = new Fraction(8);
        boolean fehler = false;
        //1. Complier und toString testen
        if (!f1.toString().equals("1/2")) {
            System.out.print("Fehler beim Konstruktor mit Nenner/toString" + f1.toString());
            fehler = true;
        }
        //2. Complier und toSting testen
        if (!f2.toString().equals("8/1")) {
            System.out.print("Fehler beim Konstruktor ohne Nenner/toString" + f2.toString());
            fehler = true;
        }
        //multiply() mit Faktor testen
        Fraction f3 = f1.multiply(3);
        if(!f3.toString().equals("3/2")) {
            System.out.println("Fehler beim multiplizieren mit Faktor" + f3.toString());
            fehler = true;
        }
        //multiply() mit anderem Bruch testen
        Fraction f4 = f1.multiply(f2);
        if(!f4.toString().equals("4/1")){
            System.out.println("Fehler beim multiplizieren mit Bruch");
            fehler = true;
        }
        //mulitply() mit Liste von Brüchen
        Fraction f5 = new Fraction(7,4);
        Fraction f6 = f1.multiply(f4, f5);
        if(!f6.toString().equals("7/2")) {
            System.out.println("Fehler beim multiplizieren von mehreren Brüchen" + f6.toString());
            fehler = true;
        }
        //divide
        Fraction f7 = f1.divide(f2);
        if(!f7.toString().equals("1/16")) {
            System.out.println("Fehler bei divide");
            fehler = true;
        }
        if (!fehler) System.out.println("Kein Fehler");
    }
}
