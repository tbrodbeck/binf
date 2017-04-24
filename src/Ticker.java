/**
 * @author Ronja von Kittlitz, Tillmann Brodbeck
 * @version 19.04.17.
 * In dieser Aufgabe sollen Sie eine Art altertümlichen Börsenticker simulieren, der alle Aktienkurse
 * nacheinander in einer langen Zeichenkette auf dem Bildschirm ausgibt.
 */
public class Ticker {
    /**
     * Implementieren Sie dazu die Klasse Ticker nach dem Singleton - Entwurfsmuster.
     */
    static Ticker ticker;
    private Ticker() {}

    public static Ticker getInstance() {
        if(ticker == null)
            ticker = new Ticker();
        return ticker;
    }

    /**
     * Ein Objekt der Klasse Ticker enthält die Methode print(String text), die den übergebenen String auf
     * der Standard-Konsole ausgibt. Dabei werden alle Zeilenumbrüche entfernt und jeder übergebene String
     * mit +++ von den vorherigen und nachfolgenden String-Objekten getrennt.
     * @param text
     */
    public void print(String text) {
        System.out.print("+++" + text);
    }
}
