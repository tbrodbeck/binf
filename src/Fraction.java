/**
 * @author Ronja von Kittlitz, Tillmann Brodbeck
 * @version 06/04/2017.
 * Implementieren Sie die Klasse Fraction mit den beiden Instanzvariablen
 * numerator und denominator zur Repräsentation eines Bruches.
 */
public class Fraction {

    private int numerator;
    private int denominator;

    /**
     * Es soll zwei Konstruktoren geben, die den Bruch bei der Instanziierung
     * kürzen. Einer, der mit Nenner und Zähler aufgerufen wird.
     * @param numerator nenner
     * @param denominator zaehler
     */
    public Fraction(int numerator, int denominator) {
        int ggT = ggT(denominator, numerator);
        this.numerator = numerator/ggT;
        this.denominator = denominator/ggT;
    }

    /**
     * und ein zweiter, der eine ganze Zahl annimmt und den Nenner auf 1 setzt
     * Verketten Sie die Konstruktoren.
     * @param numerator ganze Zahl
     */
    public Fraction(int numerator) {
        this(numerator, 1);
    }

    /**
     * Implementieren Sie zusätzlich die folgenden Instanzmethoden, die bei der
     * Ausführung der entsprechenden numerischen Operation immer eine neue
     * Fraction erzeugen.
     * @param factor multiplikativer Faktor
     * @return multiplizierter Bruch
     */
    Fraction multiply(int factor) {
        Fraction neu = new Fraction( numerator * factor, denominator);
        return neu;
    }

    /**
     * Multiplikation mit anderem Bruch
     * @param factor multiplizierender Bruch
     * @return Ergebnis-Bruch
     */
    Fraction multiply(Fraction factor) {
        Fraction neu = new Fraction(numerator * factor.numerator, denominator * factor.denominator);
        return neu;
    }

    /**
     * Dabei erwartet die Methode multiply(Fraction... factors) eine variable
     * Liste von Fraction Instanzen. D.h. sie kann mit beliebig vielen
     * Argumenten vom Typ Fraction aufgerufen werden. Machen Sie es möglich,
     * eine Instanz mit der Methode String toString() als String (z.B.1/4)
     * auszugeben.
     * @param factors
     * @return
     */
    Fraction multiply(Fraction... factors) {
        Fraction neu = this.multiply(new Fraction(1));
        for(Fraction f : factors) {
            neu = neu.multiply(f);
        }
        return neu;
    }

    /**
     * toString() Methode
     * @return Nenner / Teiler
     */
    public String toString() {
        return(numerator + "/" + denominator);
    }

    /**
     * Division mit anderem Bruch
     * @param divisor teilender Bruch
     * @return Ergebnis-Bruch
     */
    public Fraction divide(Fraction divisor){
        return new Fraction(numerator*divisor.denominator, denominator *divisor.numerator);
    }

    /**
     * berechnet den größten gemeinsamen Teiler wie aus Info A bekannt
     * @param i 1. Zahl
     * @param j 2. Zahl
     * @return größter gemeinsamer Teiler
     */
    private int ggT(int i, int j) {
        if(j == 0) return i;
        return ggT(j, i%j);
    }

    /**
     * Erweitern Sie die Klasse Fraction von Blatt 1 um die Methoden add(Fraction addend) und
     * substract(Fraction subtrahend), die die übergebene Fraction addieren bzw. subtrahieren und das Ergebnis als neue Fraction zurückgeben.

     Implementieren Sie zusätzlich die Klassenmethode parseFraction, die eine Fraction wie von der toString-Methode ausgegeben übergeben bekommt und die passende Instanz vom Typ Fraction zurückliefert. Um zu überprüfen, ob der übergebene String einen korrekten Bruch darstellt, sollen Sie die Methode matches(String regex) der Klasse String benutzen und für regex einen passenden regulären Ausdruck einsetzen. Erklären Sie Ihrem Tutor, welche Funktion die einzelnen Komponenten Ihres regulären Ausdrucks haben. In der Dokumentation der Klasse Pattern aus der Java-API ﬁnden sie alles Wissenswerte über die Generierung eines regulären Ausdrucks in Java. Nutzen Sie zur Verarbeitung des String seine Methode split und die Methode Integer.parseInt vom letzten Aufgabenblatt.

     Verwenden Sie die erweiterte Fraction anschließend für ein einfaches Rechenprogramm, das über die Kommandozeile zwei Brüche und einen Operator erhält, die so deﬁnierte Rechnung ausführt und das Ergebnis auf der Standard-Konsole ausgibt. Als Operatoren sind +, -, * und / zulässig. Achten Sie auf Fehlerbehandlung und eine geeignete Ausgabe von Fehlermeldungen auf System.err. Geben Sie bei Fehleingaben auch immer eine Anleitung zur Bedienung des Programms auf der Standard-Konsole aus.

     Hinweis: Das Symbol * hat auf der Konsole eine besondere Bedeutung, deswegen geben Sie dieses beim Testen immer in " an. (Beispiel: java Calculator 1/2 " * " -1/2).
     * @param addend
     */
    add(Fraction addend) {

    }

    substract(Fraction subtrahend) {

    }
}
