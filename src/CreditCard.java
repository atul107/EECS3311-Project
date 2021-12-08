public class CreditCard {
    long cardNumber;
    String holderName;
    String expiry;
    int cvv;
    long getCardNumber() {
        return cardNumber;
    }
    String tostring() {
        return "Card Number: " + cardNumber + "\n" + "Holder Name: " + holderName + "\n" + "Expiry: " + expiry + "\n" + "CVV: " + cvv;
    }
}