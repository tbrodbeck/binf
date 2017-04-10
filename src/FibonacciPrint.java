/**
 * @author Ronja von Kittlitz, Tillmann Brodbeck
 * @version 10.04.17.
 */
/**
 * Command-Line Program to print a table of a Fibonacci series on the console.
 *
 * @author Mathias Menninghaus (mathias.menninghaus@uos.de)
 *
 */
public class FibonacciPrint {
    /**
     * If one argument with a number n is given, prints a list of Fibonacci
     * numbers, starting with f(0) to f(n).
     *
     * @param args
     * args[0] must contain a number or -help
     */
    public static void main(String[] args) {
        if (args.length == 1) {
            if (args[0].matches("-help")) {
                printHelp();
            } else {
                int n = Integer.parseInt(args[0]);
                if (n > 1) {
                    output(n);
                } else {
                    printHelp();
                }
            }
        } else {
            printHelp();
        }
    }
    /**
     * Prints the usage of the program on the standard console.
     */
    private static void printHelp() {
        System.out.print("Usage: java FibonacciPrint [number] \n");
        System.out.print("[number] is a positive number > 1. ");
        System.out.print("print all Fibonacci numbers from 0 to [number] \n");
    }
    /**
     * Prints all Fibonacci numbers from 0 to n on the standard console.
     *
     * @param n
     * number to which the Fibonacci numbers should be printed.
     */
    private static void output(int n) {
        Fibonacci f = new Fibonacci();
        System.out.println("| n | f(n) |");
        4
        System.out.println("+---+--------+");
        System.out.println("| 0| 0|");
        System.out.println("| 1| 1|");
        for (int i = 0; i < n - 1; i++) {
            System.out.printf("|%3d|%8d|%n", i + 2, f.next());
        }
    }
}