import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MovieRepository<movieId> {
    HashMap<movieId, Movie> movies;
    long nextID;
    String password;

    MovieRepository() {
//        movies = new HashMap<Movie>();
        nextID = 0;
        password = "";
    }

    boolean addMovie(Movie movie) {
        if (checkMovieExists(movie.getMovieID())) {
            return false;
        }
        movies.put(movie.getMovieID(), movie);
        return true;
    }

    boolean removeMovie(Movie movie) {
        if (checkMovieExists(movie.getMovieID())) {
            movies.remove(movie.getMovieID());
            return true;
        }
        return false;
    }

    private boolean checkMovieExists(Object movieID) {
        return movies.containsKey(movieID);
    }

    List<Movie> getMovieByTitle(String title) {
        List<Movie> result = new ArrayList<Movie>();
        for (Movie movie : movies.values()) {
            if (movie.getTitle().equals(title)) {
                result.add(movie);
            }
        }
        return result;
    }

    List<Movie> getMovieByCategory(String category) {
        List<Movie> result = new ArrayList<Movie>();
        for (Movie movie : movies.values()) {
            if (movie.getCategory().equals(category)) {
                result.add(movie);
            }
        }
        return result;
    }

    boolean getStockAvailability(String title) {
        for (Movie movie : movies.values()) {
            if (movie.getTitle().equals(title)) {
                return movie.getStockAvailability();
            }
        }
        return false;
    }

    int getNumAvailable(String title) {
        for (Movie movie : movies.values()) {
            if (movie.getTitle().equals(title)) {
                return movie.getNumAvailable();
            }
        }
        return 0;
    }
    
    MovieRepository getMovieRepository() {
        return this;
    }
    
    long generateNextId() {
        return nextID++;
    }
}