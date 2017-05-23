package blatt05;

/**
 * Testen Sie anschließend automatisiert in einer eigenen Testklasse, ob Sie die Methode clone() korrekt
 * implementiert haben. Achten Sie darauf, auch auf die nicht absoluten Anforderungen an eine clone() -
 * Implementation zu testen. Begründen Sie, wenn Ihre Implementation bewusst einige dieser Anforderungen nicht
 * erfüllt.
 *
 * @author Ronja von Kittlitz, Tillmann Brodbeck
 * @version 21.05.17
 */
public class GenListTest {
    public static void main(String[] args) {

        // Database
        GenList g = new GenList();
        g.add(new Object());
        g.add("hi");
        g.reset();

        GenList<Object> go = new GenList<>();
        go.add(new Object());
        go.delete();
        go.reset();

        GenList<String> gs = new GenList<>();
        gs.add("hiho" );
        gs.add("blabla" );
        gs.add("test12" );
        gs.reset();


        // Test
        // x.clone() !=  x  has to be true
        if (g.clone() == g)
            System.out.println("Fehler1");
        if (go.clone() == go)
            System.out.println("Fehler2");
        if (gs.clone() == gs)
            System.out.println("Fehler3");

        // x.clone().getClass() == x.getClass()  should be true
        if (g.clone().getClass() != g.getClass())
            System.out.println("Fehler4");
        if (go.clone().getClass() != go.getClass())
            System.out.println("Fehler5");
        if (gs.clone().getClass() != gs.getClass())
            System.out.println("Fehler6");

        // x.clone().equals(x)  should be true
        if (!g.clone().equals(g))
            System.out.println("Fehler7");
        if (!go.clone().equals(go))
            System.out.println("Fehler8");
        if (!gs.clone().equals(gs))
            System.out.println("Fehler9");

        // Seiteneffekte testen
        GenList<String> gsc = gs.clone();
        gs.add( "neu" );
        if (gs.clone().equals(gsc))
            System.out.println("Bemerkung: keine seiteneffektfreie Deep-Copy");


        System.out.println("Test von GenList abgeschlossen");

    }

}
