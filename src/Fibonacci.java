/**
 * @author Ronja von Kittlitz, Tillmann Brodbeck
 * @version 10.04.17.
 *
 * Implementieren Sie die Klasse Fibonacci.
 */
public class Fibonacci {

    //Instanzvariablen n1 -> n^-1, n2 -> n^-2
    private int n1;
    private int n2;

    /**
     * Konstruktor
     */
    public Fibonacci() {
        n1 = 1;
        n2 = 0;
    }

    /**
     * Ein Objekt der Klasse Fibonacci besitzt die Instanz-methode next(), die,
     * beginnend mit f(2), immer die nächste Zahl der Fibonacci-Folge zurück
     * gibt. Beim ersten Aufruf von next wird also 1, beim zweiten 2, beim
     * dritten 3, dann 5, 8 usw. zurück gegeben.
     * @return nexte Fibonacci nummer
     */

    public int next() {
        int aktuell = n1 + n2;
        n2 = n1;
        n1 = aktuell;
        return aktuell;
    }
}