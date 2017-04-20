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
}
