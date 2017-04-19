/**
 * @author Ronja von Kittlitz, Tillmann Brodbeck
 * @version 20.04.17.
 * 2. Implementieren Sie zusätzlich einen Testklasse, die durch die Erzeugung von Objekten des Typs Company und expliziten Anstoß des Garbage Collectors dessen Arbeitsweise im Zusammenspiel mit Konstruktoren und Destruktoren verdeutlicht. Erklären Sie Ihrem Tutor wie Sie vorgegangen sind und was man aus den Ergebnissen Ihrer Testklasse schließen kann.
 */
public class TickerTest {

    public static void main(String[] args) {
        System.out.println("Test:");
        Company java = new Company("Java Inc.");
        Company nutella = new Company("Nutella GmBH");
        Company fussball = new Company("Fussball ABC");
        java.changeStockPrice(555.6);
        testMethode();
        nutella.changeStockPrice(66.6);
        fussball.changeStockPrice(0.1);
        System.out.println("\nErwarteter String: \n+++Java Inc. 555.6+++Zahnpasta in your Face 10.0+++Nutella GmBH 66.6+++Fussball ABC 0.1");

    }

    private static void testMethode(){
        Company mitsubishi = new Company("Mitsubishi CoKG");
        Company zahnpasta = new Company("Zahnpasta in your Face");
        zahnpasta.changeStockPrice(10.0);
    }
}
