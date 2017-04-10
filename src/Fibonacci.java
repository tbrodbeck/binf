/**
 * @author Ronja von Kittlitz, Tillmann Brodbeck
 * @version 10.04.17.
 */
/**
 *
 * Class Fibonacci, a Fibonacci Object holds the information of a Fibonacci
 * Series. One can get the next number f(n) in the series with the method next,
 * starting with f(2).
 *
 * @author Mathias Menninghaus (mathias.menninghaus@uos.de)
 *
 */
public class Fibonacci {
    /**
     * Holds f(n-1)
     */
    private int nMinus1;
    /**
     * Holds f(n-2)
     */
    private int nMinus2;
    /**
     * Create new Fibonacci series, next would deliver f(2).
     */
    public Fibonacci() {
        nMinus1 = 1;
        nMinus2 = 0;
    }
    /**
     * Get next number in this Fibonacci series. Starts with f(2).
     *
     * @return next number in Fibonacci series.
     */
    public int next() {
        int n = nMinus1 + nMinus2;
        nMinus2 = nMinus1;
        nMinus1 = n;
        return n;
    }
}