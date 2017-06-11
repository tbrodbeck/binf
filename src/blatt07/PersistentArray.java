package blatt07;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.NoSuchElementException;

/**
 * Created by Ronja on 08.06.17.
 */
public class PersistentArray {
    private RandomAccessFile f;

    /**
     * Eine Instanz dieser Klasse soll mit einem Integer-Array und einem Namen, unter dem das Array als Datei
     * abgespeichert werden soll, instanziiert werden können. Existiert unter dem Namen bereits eine Datei,
     * soll diese überschrieben werden. Alle Array-Einträge werden dann in die Datei geschrieben.
     * @param a Integer Array
     * @param name Name der Datei
     */
    public PersistentArray(int[] a, String name){
        try {
            String filename;
            filename = name + ".ser";
            File file = new File(filename);
            if(file.exists()) file.delete();
            f = new RandomAccessFile(file, "rw");
        } catch (FileNotFoundException e) { //dieser Fall dürfte nicht eintreten da vorher überprüft wird of file existiert
            throw new RuntimeException("Hier läuft beim File erstellen was falsch");
        }
        reset();
        for(int i = 0; i < a.length; i++) {
            try {
                f.writeInt(a[i]);
            } catch (IOException e) { //Fall dürfte nicht eintreten
                throw new RuntimeException("Hier läuft was beim Schreiben falsch");
            }
        }
        reset();
    }

    /**
     * Es soll auch möglich sein, auf ein bereits existierendes, persistentes Array durch Instanziierung der
     * Wrapper-Klasse nur unter Angabe des richtigen Dateinamens Zugriff zu erlangen.
     * @param name Name des Arrays/ der Datei
     */
    public PersistentArray(String name){
        File file = new File(name + ".ser");
        if(!file.isFile()) throw new IllegalArgumentException("Es gibt keinen Array mit diesem Namen");
        try {
            f = new RandomAccessFile(file, "rw");
        } catch (FileNotFoundException e) { //dieser Fall dürfte nicht eintreten da vorher überprüft wird of file existiert
            throw new RuntimeException("Hier läuft beim File erstellen was falsch");
        }
        reset();
    }

    /**
     * Achten Sie darauf, das man auch die Anzahl der Einträge erfragen kann
     * @return Anzahl der Einträge im Array
     */
    public long eintraegeAnzahl(){
        try {
            return (f.length()/4);
        } catch (IOException e) { //Fall dürfte nicht eintreten
            throw new RuntimeException("Hier läuft was beim Länge zählen falsch");
        }
    }

    /**
     * geht an eine gewünschte Stelle im Array
     * @param position
     */
    public void goTo(long position) {
        if(position < 0) throw new IllegalArgumentException("Position muss positiv sein");
        if(eintraegeAnzahl() < position) throw new NoSuchElementException("Array ist nicht so lang");
        try {
            f.seek(position);
        } catch (IOException e) { //Fall dürfte nicht eintreten (siehe oben)
            throw new RuntimeException("Hier läuft was beim an die richtige Position gehen falsch");
        }
    }

    /**
     * geht an die erste Stelle im Array
     */
    public void reset() {
        goTo(0);
    }

    /**
     *
     * @return ob FilePointer nach letztem Element ist
     */
    public boolean ende(){
        long akPos = 0;
        try {
            akPos = f.getFilePointer();
        } catch (IOException e) { //dürfte nicht auftreten
            throw new RuntimeException("Hier läuft was bei aktueller Position falsch");
        }
        return(eintraegeAnzahl()-akPos<4);
    }
    /**
     * geht eine Stelle weiter
     */
    public void advance() {
        if(ende()) throw new NoSuchElementException("Am Ende des Arrays");
        try {
            f.skipBytes(4);
        } catch (IOException e) { //dürfte nicht auftreten
            throw new RuntimeException("Hier läuft was beim advancen falsch");
        }
    }

    /**
     * Mit einer Instanz schließlich soll man die Einträge verändern können
     * Bleibt an Position stehen
     * @param position Position an die neues Element soll
     * @param neu neues Element
     */
    public void veraendern(long position, int neu){
        goTo(position);
        veraendern(neu);
    }

    /**
     * verändert aktuelles Element und steht danach nach eingefügtem Element
     * @param neu
     */
    public void veraendern(int neu){
        if(ende()) throw new NoSuchElementException("Am Ende des Arrays");
        try {
            f.writeInt(neu);
        } catch (IOException e) { //Fall dürfte nicht eintreten
            throw new RuntimeException("Hier läuft was beim einfügen falsch");
        }
    }

    /**
     * gibt aktuelles Element zurück
     * @return
     */
    public int returnElement() {
        if(ende()) throw new NoSuchElementException("Am Ende des Arrays");
        try {
            return f.readInt();
        } catch (IOException e) {
            throw new RuntimeException("Hier läuft was beim Element zurückgeben falsch");
        }
    }

    /**
     * gibt Element an übergebener Position zurück und bleibt an Position stehen
     * @param position
     * @return
     */
    public int returnElement(long position) {
        goTo(position);
        return returnElement();
    }


    public static void main(String[] args) throws IOException {
        int[] array = {1,2,3};
        PersistentArray p2 = new PersistentArray(array,"a");
        //PersistentArray p2 = new PersistentArray("a");
        //System.out.println(p2.f.readInt());
        //System.out.println(p2.f.readInt());
        //System.out.println(p2.eintraegeAnzahl());
        p2.returnElement();
        p2.returnElement();
        p2.returnElement();
        p2.returnElement();
    }
}
