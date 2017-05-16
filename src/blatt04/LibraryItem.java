package blatt04;

/**
 * @author Ronja von Kittlitz, Tillmann Brodbeck
 * @version 16.05.17
 */
public abstract class LibraryItem {

    private boolean isBorrowed;

    public LibraryItem() {
        isBorrowed = false;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void setBorrowed(boolean borrowed) {
        isBorrowed = borrowed;
    }

    public abstract String getDescription();
}
