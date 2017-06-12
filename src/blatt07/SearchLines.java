package blatt07;

import java.io.*;

/**
 * Implementieren Sie anschließend ein Kommandozeilenprogramm, das mit einem regulären
 * Ausdruck aufgerufen wird und den Inhalt einer Datei über den Pipe-Operator < zugewiesen
 * bekommt.
 *
 * Ein Aufruf des Programms kann beispielsweise wie folgt aussehen:
 *
 * java io/SearchLines "pu. * c" < Beispiel.java Der Inhalt von Beispiel.java wird damit
 * in den Standard-Eingabestream System.in geschrie-ben.
 *
 * @author Ronja von Kittlitz, Tillmann Brodbeck
 * @version 10.06.17
 */
public class SearchLines {

    public static void main(String[] args) {

        // Prüfen der Form
        if (args.length != 3 || !(args[1].equals( "<" )))
            System.err.println( "Das Programm benötigt genau einen Regex, ein pipe-Symbol und einen Dateinamen!" );

        else {

            File f = new File( args[2] );

            try (FileInputStream fis = new FileInputStream( f )) {

                MyReader reader = new MyReader( new InputStreamReader( fis ), args[0] );

                String line;

                int count = reader.getAmountOfMatches();
            /* Das Programm soll jede Zeile der Datei, die den regulären Ausdruck mindestens
             * einmal enthält, zusammen mit der Zeilennummer auf der Standardkonsole ausgeben.
             * Zusätzlich soll für jede ausgegebene Zeile die Anzahl der Vorkommen des regulären
             * Ausdrucks ausgeben werden. */
                try {
                    while ((line = reader.readLine()) != null) {
                        // if the count went up
                        int n_count;
                        if ((n_count = reader.getAmountOfMatches()) > count) {
                            System.out.println( "Regex \"" + args[0] + "\" wurde in Zeile " + reader.getLineNumber() + " " + (n_count - count) + "x gefunden:" );
                            System.out.println( line + "\n");
                            count = n_count;
                        }
                    }
                // Fehlerausgaben
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        reader.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
