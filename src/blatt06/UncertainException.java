package blatt06;

import java.io.IOException;

public class UncertainException {

    private int i = 0;

    public static void uncertain(int number) {
        UncertainException uncertain = new UncertainException();
        int result = 0;

        try {
            System.out.println("uncertain" + number + "()");  // wird aufgerufen mit number von 1 bis 10
            switch (number) {
                case 1:
                    result = uncertain.uncertain1();
                    break;
                case 2:
                    result = uncertain.uncertain2();
                    break;
                case 3:
                    result = uncertain.uncertain3();
                    break;
                case 4:
                    result = uncertain.uncertain4();
                    break;
                case 5:
                    result = uncertain.uncertain5();
                    break;
                case 6:
                    result = uncertain.uncertain6();
                    break;
                case 7:
                    result = uncertain.uncertain7();
                    break;
                case 8:
                    result = uncertain.uncertain8();
                    break;
                case 9:
                    result = uncertain.uncertain9();
                    break;
                case 10:
                    result = uncertain.uncertain10();
                    break;
            }
            System.out.println("result = " + result + ", i = " + uncertain.i);  // wird jeweils aufgerufen, solange keine Exception geworfen wurde
        } catch (Exception e) {
            System.out.println("i = " + uncertain.i + " Exception (" + e.getClass() // wird jeweils sonst aufgerufen
                    .getName() + ")");
        } finally {
        }
    }

    public static void main(String args[]) {
        for (int i = 1; i <= 10; ++i) {
            uncertain(i);
        }
    }

    public int uncertain1() {
        try {
            throw new RuntimeException();
        } catch (RuntimeException e) {  // RuntimeException wird abgefangen
            i++;
            throw new ClassCastException();
        } finally {
            i++;  // i = 2
            throw new NumberFormatException();  // diese Exception überschreibt das Werfen der ClassCastException
        }
    }

    public int uncertain2() {
        for (; ; ) {
            try {
                break;
            } catch (RuntimeException e) {
                i++;
            } finally {  // before the loop breaks this block is executed
                i++;  // i = 1
                throw new RuntimeException();
            }
        }
        // Weil das Programm endet, wenn in finally eine Exception geworfen wird, kann dieses
        // statement niemals erreicht werden:
        // return i++;
    }

    public int uncertain3() {
        do {
            try {
                throw new RuntimeException();
            } catch (RuntimeException e) {
                i++;
                continue;
            } finally {
                i++;
            }
        } while (false);
        return i++;  // RuntimeException wird abgefangen, returns 2, i = 3
    }

    public int uncertain4() {
        try {
            return i++;  // returns 0
        } catch (RuntimeException e) {
            i++;
        } finally {
            i++;  // i = 2
        }
        return i++;
    }

    public int uncertain5() {
        try {
            return i;
        } finally {
            throw new RuntimeException();  // throws RuntimeException, i = 0
        }
    }

    public int uncertain6() {
        try {
            throw new RuntimeException();
        } finally {
            return ++i;  // RuntimeExeption wird überschrieben, returns 0, i = 1
        }
    }

    public int uncertain7() {
        try {
            throw new java.io.IOException();
        } catch (RuntimeException e) {
            i++;
        } finally {
            return i++;  // IOException wird überschrieben, returns 0, i = 1
        }
    }

    public int uncertain8() {
        try {
            throw new NumberFormatException();
        } catch (RuntimeException e) {
            i++;
            throw new RuntimeException();  // throws RuntimeException
        } finally {
            i++;  // i = 2
        }
    }

    public int uncertain9() {
        try {
            throw new ClassCastException();
        } catch (RuntimeException e) {
            return i++;
        } finally {
            return i++;  // returns 1, i = 2
        }
    }

    public int uncertain10() throws IOException {  // weil IOException eine checked Exception ist, muss sie irgendwo (hier beim Methodenaufruf) abgefangen werden
        try {
            throw new java.io.IOException();  // i = 0
        } catch (RuntimeException e) {  // IOExeption ist keine RuntimeExeption
        }
        return 1;

    }
}