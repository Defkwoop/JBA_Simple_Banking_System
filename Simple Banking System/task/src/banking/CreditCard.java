package banking;

public class CreditCard {

    private final String cardNumber;
    private final String cardPIN;
    private int balance;

    public CreditCard(String cardNumber, String cardPIN) {
        this.cardNumber = cardNumber;
        this.cardPIN = cardPIN;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getCardPIN() {
        return cardPIN;
    }

    public int getBalance() {
        return balance;
    }
}