public class Fraglich {

    static int a;

    public static void main(String[] args) {
        int a = 5;
        int[] c = {16, 4, 2, 9};

        /*** Stelle 1 **
         a = 5; b ist nicht vergeben; c = {16, 4, 2, 9}; */

        initialize();

        /*** Stelle 3 **
         a = 23; b nicht vergeben; c = {16, 4, 2, 9} */
        // a müsste doch 5 sein?

        for (int b = -1; b < 1; b += 3) {

            /*** Stelle 4 **
             a = 23; b = -1; c = {16, 4, 2, 9} */
            // a = 5
            a /= 2;
            c[b + 2] -= c[b + 2];
        }

        /*** Stelle 5 **
         a = 11; b nicht vergeben; c = {16, 0, 2, 9} */
        // a sollte 2 sein

        for (a = 2; a < 3; a++) {

            int b = 2;
            c[a] -= c[b];

            /*** Stelle 6 **
             a = 2; b = 2; c = {16, 0, 0, 9} */
        }

        /*** Stelle 7 **
         a = 3; b nicht vergeben; c = {16, 0, 0, 9} */


        int b = method(a + c[a - 3]);

        /*** Stelle 9
         a = 3; b = 3; c = {16, 0, 0, 9} ***/
        // b ist 23

        b = 7 + method(++a, c);

        /*** Stelle 11
         a = 4; b = 12; c = {8, 0, 0, 9} ***/

        a = method(method(method(a), new int[]{b, a, c[0], c[2], c[3], c[1]}));
        //6,4,8,0,9,0

        /*** Stelle 15
         a = 4; b = 12; c = {8, 0, 0, 9} ***/
        // a ist 23
    }

    static void initialize() {

        int b = 0;

        a = 23;

        /*** Stelle 2 **
         a = 23; b = 0; c = {16, 4, 2, 9} */
        // c gibts doch hier gar nicht?
    }

    protected static int method(int b) {

        /*** Stelle 8
         a = 3; b = 19; c = {16, 0, 0, 9}
         // c gibts nicht und a = 23
         Stelle 12
         a = 4; b = 4; c = {8, 0, 0, 9}
         // a ist 23 und c nicht da
         Stelle 14
         a = 4; b = 5; c = {8, 0, 0, 9}
         // siehe oben
         ***/

        return a;
    }

    private static int method(int a, int[] c) {

        a++;
        c[0] /= 2;
        c[0] = c[0] + c[1];
        c = new int[4];

        /*** Stelle 10
         a = 5; b = 3; c = {0, 0, 0, 0}
         b gibts nicht
         Stelle 13
         a = 5; b = 3; c = {0, 0, 0, 0} ***/
        // b gibts nicht


        return a;
    }

}

/*
In diesem Programm und allgemeint in Java wird Call by Value verwendet. Das
heißt, dass Methoden-Parameter anhand ihrer übergebenen Werte aufgerufen werden.
In anderen Programmiersprachen gibt es auch Call by Reference und das meint,
dass die Methode direkt Zugriff auf die ihr übergebenen Variablen hat, weil die
Variablen und nicht nur die Werte übergeben werden.
 */