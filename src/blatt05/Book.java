package blatt05;

/**
 * @author Ronja von Kittlitz, Tillmann Brodbeck
 * @version 16.05.17
 */
public class Book extends LibraryItem {

    private String title;
    private String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String getDescription() {
        return "Book - Title: " + title + ", Author: " + author;
    }
}
