package blatt10;

/**
 * Führen Sie Model, View und Controller in einer separaten
 * Klasse zusammen. Diese sollte über die
 * Kommandozeilenparameter mit der Höhe und Breite des
 * Spielfeldes sowie die Anzahl der zufällig verteilten
 * Bomben aufgerufen werden können und ein entsprechendes
 * Spiel erzeugen und starten. Es ist nicht nötig, dass aus
 * der graﬁschen Benutzeroberﬂäche heraus ein neues Spiel
 * gestartet werden kann.
 *
 * @author Ronja von Kittlitz, Tillmann Brodbeck
 * @version 29.06.17
 */
public class MineSweeper {

    public static void main(String[] args) {
        if (args.length == 3) {

            MSModel model = null;

            try {
                 model = new MSModel( Integer.parseInt( args[0] ), Integer.parseInt( args[1] ), Integer.parseInt( args[2] ) );
            }
            catch (ClassCastException e){
                System.err.println( "Bitte nur Integer eingeben." );
            }

        }
        else
            System.err.println("Bitte Höhe und Breite des Spielfeldes sowie die Anzahl der zufällig verteilten Bomben eingeben!");
    }

}
