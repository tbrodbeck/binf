/**
 * @author Ronja von Kittlitz, Tillmann Brodbeck
 * @version 10.04.17.
 *
 * Implementieren Sie die Klasse Fibonacci.
 */
public class Fibonacci {
    // f(n-1)
    private int nMinus1;
    // f(n-2)
    private int nMinus2;

    /**
     * Konstruktor
     */
    public Fibonacci() {
        nMinus1 = 1;
        nMinus2 = 0;
    }
    /**
     * Ein Objekt der Klasse Fibonacci besitzt die Instanz-methode next(), die,
     * beginnend mit f(2), immer die nächste Zahl der Fibonacci-Folge zurück
     * gibt. Beim ersten Aufruf von next wird also 1, beim zweiten 2, beim
     * dritten 3, dann 5, 8 usw. zurück gegeben.
     * @return nexte Fibonacci nummer
     */
    public int next() {
        int n = nMinus1 + nMinus2;
        nMinus2 = nMinus1;
        nMinus1 = n;
        return n;
    }
}