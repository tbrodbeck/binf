package blatt04;

/**
 * Betrachten Sie das unten stehende UML-Klassendiagramm einer einfachen Bibliotheksverwaltung.
 * Implementieren Sie die darin deﬁnierten Klassen genau so, wie vorgegeben. Zur Implementierung
 * von mehrwertigen Beziehungen und der Methode search in der Klasse Library können Sie die
 * Klasse List verwenden. Laden Sie sich dafür auch die Klasse Entry herunter.
 *
 * In der Methode search soll die Ausgabe der getDescription()-Methode jedes LibraryItem-Objektes
 * in der Librarydaraufhin untersucht werden, ob Sie den übergebenen String text enthält. Alle
 * LibraryItem-Instanzen, auf die dieszutrifft, sollen in einer List gesammelt und diese dann
 * zurückgegeben werden.
 *
 * @author Ronja von Kittlitz, Tillmann Brodbeck
 * @version 16.05.17
 */
public class Library {

    private List inv;

    public Library() {
        inv = new List();
    }

    public void addItem(LibraryItem item){
        inv.add( item );
    }

    /**
     * delete
     * @param item
     * @throws RuntimeException wenn item nicht gefunden
     */
    public void deleteItem(LibraryItem item){
        inv.reset();
        boolean gefunden = false;
        while (!inv.endpos()) {
            if (inv.elem() == item) {
                inv.delete();
                gefunden = true;
            }
            if(!gefunden)
                inv.advance();
        }
        if (!gefunden)
            throw new RuntimeException( "item nicht gelöscht!" );
    }

    public List search(String text) {
        List rtn = new List();
        inv.reset();
        while (!inv.endpos()){
            if (((LibraryItem)inv.elem()).getDescription().contains( text )){
                rtn.add(inv.elem());
            }
            inv.advance();
        }
        return rtn;
    }
}
