public abstract class OrderOperations implements Visitor {
    void computeLateFees(SystemAdmin admin) {
        admin.accept(this);
    }
    void setOrderStatus(SystemAdmin admin) {
        admin.accept(this);
    }
    void updateMovieInfo(SystemAdmin admin) {
        admin.accept(this);
    }
    void generateShippingList(SystemAdmin admin) {
        admin.accept(this);
    }
}