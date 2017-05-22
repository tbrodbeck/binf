package blatt05;

import blatt05.Entry;

/**
 * Aufgabe 5.2: Cloneable und clone (30 Punkte)
 * Betrachten Sie die Klassen List und Entry, mit denen der ADT Liste implementiert wurde.
 *
 * Erzeugen Sie auf Basis dieser Klassen eine typsichere Liste. Begründen Sie Ihrem Tutor, ob es sinnvoller
 * ist, von der bestehenden Klasse zu erben und nur die nötigsten Methoden zu überschreiben, oder die Liste
 * vollständig neu zu implementieren.
 *
 * Lesen Sie außerdem die Java - Dokumentation zu dem Interface Cloneable und der Methode Object.clone().
 * Implementieren Sie das Interface Cloneable in Ihrer generischen Liste.
 *
 * @author Ronja von Kittlitz, Tillmann Brodbeck
 * @version 21.05.17
 */
public class GenList<T> implements Cloneable {

    /**
     * Reference on the first Entry of this List
     */
    private Entry begin;
    /**
     * References before the actual Entry of this List
     */
    private Entry pos;

    /**
     * Create a new empty List.
     */
    public GenList() {
        pos = begin = new Entry();
    }

    /**
     * Determines if this List is empty or not.
     *
     * @return <code>true</code>, if there are no elements in this List
     */
    public boolean empty() {
        return begin.next == null;
    }

    /**
     * Determines if it is possible to {@link #advance()} in this List. Returns
     * <code>true</code> if the last position of this List has been reached. An
     * {@link #empty()} List will alway deliver <code>true</code>
     *
     * @return <code>true</code> if the last Entry in this List already has been
     * reached.
     */
    public boolean endpos() { // true, wenn am Ende
        return pos.next == null;
    }

    /**
     * Returns to the beginning of this List.
     */
    public void reset() {
        pos = begin;
    }

    /**
     * Advances one step in this List.
     *
     * @throws RuntimeException if the last Entry of this List already has been reached.
     */
    public void advance() {
        if (endpos()) {
            throw new RuntimeException( "Already at the end of this List" );
        }
        pos = pos.next;
    }

    /**
     * Returns the actual element of this List.
     *
     * @return the actual element
     * @throws RuntimeException if the last Entry of this List already has been reached.
     */
    public T elem() {
        if (endpos()) {
            throw new RuntimeException( "Already at the end of this List" );
        }
        return (T) pos.next.o;
    }

    /**
     * Inserts <code>o</code> in this List. It will be placed before the actual
     * element. After insertion the inserted element will become the actual
     * element.
     *
     * @param x the element to be inserted
     */
    public void add(T x) {
        Entry newone = new Entry( x, pos.next );

        pos.next = newone;
    }

    /**
     * Deletes the actual element of this List. The element after the actual
     * element will become the new actual element.
     *
     * @throws RuntimeException if the last Entry of this List already has been reached.
     */
    public void delete() {
        if (endpos()) {
            throw new RuntimeException( "Already at the end of this List" );
        }
        pos.next = pos.next.next;
    }

    /**
     * Clones the list
     * @return GenList<T> clone
     */
    @Override
    public GenList<T> clone() {
        try {
            return (GenList<T>)super.clone();
        } catch (CloneNotSupportedException i) {
            System.err.println( "Fehler0" );
        }
        return null;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof GenList)
            // check every element
            while(!this.endpos()){
                if (!this.elem().equals( ((GenList) obj).elem() ))
                    return false;
                this.advance();
                ((GenList) obj).advance();
            }
            // check boath lists at the end
            if (((GenList) obj).endpos())
                return true;
        return false;
    }
}
