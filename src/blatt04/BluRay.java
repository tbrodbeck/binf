package blatt04;

/**
 * @author Ronja von Kittlitz, Tillmann Brodbeck
 * @version 16.05.17
 */
public class BluRay extends LibraryItem{

    private String title;
    private String director;

    public BluRay(String title, String director) {
        this.title = title;
        this.director = director;
    }

    public String getTitle() {
        return title;
    }

    public String getDirector() {
        return director;
    }

    @Override
    public String getDescription(){
        return "BluRay - Title: " + title + ", Director: " + director;
    }
}
