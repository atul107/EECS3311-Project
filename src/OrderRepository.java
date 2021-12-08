import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OrderRepository<orderID> {
    HashMap<Integer, Order> orders;
    long nextID;
    String password;
    private Object Movie;
    private Object CreditCard;

    OrderRepository() {
        orders = new HashMap<Integer, Order>();
        nextID = 0;
        password = "";
    }

    boolean addOrder(Order order, SystemUser systemUser) {
            orders.put(order.getOrderID(), order);
            return true;
    }

    boolean removeOrder(Order order) {

            orders.remove(order.getOrderID());
            return true;
    }
    
    boolean payFeeWithCard(int orderId) {

        orders.get(orderId).payFee((CreditCard) CreditCard);
        return true;
    }

    boolean payFeeWithPoints(int orderId) {

        int points = 0;
        orders.get(orderId).payFee(points);
        return true;
    }

    List<Object> getOrderList(String status, String username) {
        List<Object> result = new ArrayList<>();
        for (Order order : orders.values()) {
            if (order.getStatus().equals(status) ) {
                result.add(Movie);
            }
        }
        return result;
    }

    //get the order HashMap<orderID, Order> orders;
    Order getOrder(int id) {
            return orders.get(id);
    }

    OrderRepository<orderID> getOrderRepository() {
        return this;
    }

    long generateNextId() {
        return nextID++;
    }
}
