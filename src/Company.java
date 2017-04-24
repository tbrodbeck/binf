/**
 * @author Ronja von Kittlitz, Tillmann Brodbeck
 * @version 19.04.17.
 * Implementieren Sie zusätzlich die Klasse Company, die eine beliebige Firma repräsentieren soll.
 *
 * Beispielsweise könnte die Ausgabe auf der Kommandozeile folgendermaßen aussehen:
 * +++Weyland Yutani 528.0+++Umbrella 491.0+++Dharma is insolvent
 */
public class Company {
    // Jede Company enthält einen Namen
    private String name;
    private Ticker tick;

    public Company(String name) {
        this.name = name;
        tick = Ticker.getInstance();
    }

    /**
     * und die Methode changeStockPrice(double d), die mit dem übergebenen double und einer geeigneten Meldung
     * über den auf d geänderten Aktienkurs die Methode print von Ticker aufruft.
     * @param d
     */
    public void changeStockPrice(double d) {
        tick.print(name + " " + d);
    }

    /**
     * Außerdem soll die Klasse Company um einen Destruktor, der bei Aufruf einen String mit einer Nachricht
     * über die Insolvenz der Firma an den Ticker schickt, erweitert werden.
     */
    protected void finalize() {
        tick.print("Insolvenz von " + name + " bekanntgegeben.");
    }


}
/*
Nachdem Sie die oben beschriebene Funktionalität umgesetzt haben, bearbeiten Sie folgende Teilauf-gaben:

1. Erklären Sie Ihrem Tutor anhand der implementierten Klassen die Vor- und Nachteile des Singleton - Entwurfsmusters
Vorteile:
-> wenn nur eine Instanz existiert, sinnvolle objektorientierte Lösung
-> bessere Kontrolle über den Zugriff
-> Ressourcenschonend, effizient


Nachteile:
-> Klassenvariablen verschwemmen das Lokalitätsprinzip
-> Gefahr Konzept zu missbrauchen als globale Variable
 */
