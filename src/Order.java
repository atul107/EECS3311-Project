import java.util.Date;
import java.util.List;

public class Order{
    SystemUser user;
    List<Movie> movies;
    Date dueDate;
    Date returnDate;
    double principalFee;
    double lateFee;
    String status;
    boolean paid;
    int orderID;

    boolean addMovie(Movie movie) {
        movies.add(movie);
        return true;
    }

    boolean removeMovie(Movie movie) {
            movies.remove(movie);
            return true;
    }

    double getTotalFees() {
        return principalFee + lateFee;
    }

    boolean payFee(CreditCard creditCard) {
        if (paid) {
            return false;
        }
        if (creditCard.getCardNumber() == user.getCreditCard().getCardNumber()) {
            paid = true;
            return true;
        }
        return false;
    }

    boolean payFee(int points) {
        if (paid) {
            return false;
        }
        if (points >= user.getPoints()) {
            paid = true;
            return true;
        }
        return false;
    }

    void setStatus(String s) {
        this.status = s;
    }

    int addPoints(int points) {
        user.addPoints(points);
        return points;
    }

    public Object getStatus() {
        return status;
    }


    public <orderID> int getOrderID() {
        return orderID;
    }
}