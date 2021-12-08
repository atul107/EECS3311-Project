import java.util.Date;
import java.util.List;

public class Movie {

    String title;
    String category;
    List<String> actors;
    List<String> directors;
    Date releaseDate;
    String description;
    String status;
    boolean available;

    boolean addTo(List<String> list, String v) {
        if (list.contains(v)) {
            return false;
        }
        list.add(v);
        return true;
    }

    boolean removeFrom(List<String> list, String v) {
        if (!list.contains(v)) {
            return false;
        }
        list.remove(v);
        return true;
    }

    String getDescription() {
        return description;
    }

    void setAvailability(boolean rented) {
        available = rented;
    }


    public Object getTitle() {
        return title;
    }

    public <movieId> movieId getMovieID() {
        return null;
    }

    public boolean getStockAvailability() {
        return available;
    }

    public int getNumAvailable() {
        return 0;
    }

    public Object getCategory() {
        return category;
    }
}