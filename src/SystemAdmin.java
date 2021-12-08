public class SystemAdmin extends User {
    long employeeID;

    long getEmployeeID() {
        return employeeID;
    }

    void accept(Visitor visitor) {
        visitor.visit(this);
    }
}