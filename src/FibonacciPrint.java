/**
 * @author Ronja von Kittlitz, Tillmann Brodbeck
 * @version 10.04.17.
 * Implementieren Sie anschließend die Klasse FibonacciPrint. Wenn die Klasse über die Kom- mandozeile aufgerufen wird,
 * soll ihr als Parameter genau eine ganze Zahl n übergeben werden. Diese wird in Java automatisch in das String[] der
 * main Methode übergeben. Von FibonacciPrint sollen alle Fibonacci-Zahlen von f (0) bis f (n) wie folgt formatiert auf
 * der Kommandozeile ausgegeben werden:
 *| n |  f(n)  |
 *+---+--------+
 *|  0|       0|
 */

public class FibonacciPrint {
    public static void main(String[] args){
        if(args.length!= 1) throw new RuntimeException("Es darf nur eine Zahl übergeben werden.");
        int n = Integer.parseInt(args[0]);
        if (n< 2) throw new RuntimeException("n < 2");
        System.out.println("| n |  f(n)  |");
        System.out.println("+---+--------+");
        System.out.println("|  0|       0|");
        System.out.println("|  1|       1|");
        Fibonacci fib = new Fibonacci();
        for(int i = 2; i < n-1 ; i++){
            System.out.printf("|%3d|%8d|%n", i, fib.next());
        }
    }
}
