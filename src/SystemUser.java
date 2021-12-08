public class SystemUser extends User {
    int loyaltyPoints;
    CreditCard creditCard;
    Address shippingAddress;
    Address billingAddress;

    int getPoints() {
        return loyaltyPoints;
    }



    Address getShippingAddress() {
       return shippingAddress;
    }

    Address getBillingAddress() {
        return billingAddress;
    }

    void addPoints(int points) {
        loyaltyPoints = points;
    }

    public CreditCard getCreditCard() {
        return creditCard;
    }
}