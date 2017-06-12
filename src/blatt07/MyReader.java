package blatt07;

import java.io.*;
import java.io.Reader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * Machen Sie sich mit den Klassen im Paket java.io der Java-API vertraut. Nutzen
 * Sie das in der Vorlesung vorgestellte Decorator-Pattern, um eine eigene Reader-Klasse zu implementieren mit der man
 *
 * Sie können zur Verarbeitung der regulären Ausdrücke die Klassen java.util.regex.Pattern
 * und java.util.regex.Matcher verwenden.
 *
 * @author Ronja von Kittlitz, Tillmann Brodbeck
 * @version 06.06.17
 */
public class MyReader extends LineNumberReader {

    // our search pattern
    private final Pattern p;

    // counter how often the pattern occures
    private int count;

    /**
     * Create a new line-numbering reader, using the default input-buffer
     * size + a regex for searching
     *
     * @param in A Reader object to provide the underlying stream
     */
    public MyReader(Reader in, String regex) {
        super( in );
        p = Pattern.compile( regex );
        count = 0;
    }

    /**
     *  über die Methode readLine() alle Zeichen von einem Reader bis zum nächsten Zeilenumbruch
     * einlesen und als einen String zurückgeben kann. Der Zeilenumbruch soll nicht mit zurückgegeben werden.
     * Beim Erreichen des Dateiendes soll null zurückgegeben werden.
     *
     * @return A String containing the contents of the line, not including
     * any <a href="#lt">line termination characters</a>, or
     * <tt>null</tt> if the end of the stream has been reached
     * @throws IOException If an I/O error occurs
     */
    @Override
    public String readLine() throws IOException {
        // reading each lines
        String line =  super.readLine();

        if (line != null) {
            Matcher m = p.matcher( line );
            while (m.find())
                count++;
        }

        return line;
    }

    /**
     * Get the current line number.
     *
     * @return The current line number
     * @see #setLineNumber
     */
    @Override
    public int getLineNumber() {
        return super.getLineNumber();
    }

    /**
     * über die Methode getAmountOfMatches() ermitteln kann, wie oft ein dem Konstruktor
     * übergebener regulärer Ausdruck in der zuletzt gelesenen Zeile gefunden wurde.
     * @return count
     */
    public int getAmountOfMatches() {
        return count;
    }
}
