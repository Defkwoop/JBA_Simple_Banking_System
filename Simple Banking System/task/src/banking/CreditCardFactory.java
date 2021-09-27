package banking;

import java.util.Random;

public class CreditCardFactory {
    private static final String BIN = "400000";
    private final Random random = new Random();

    public CreditCard createCreditCard() {
        return new CreditCard(createCardNumber(BIN), createPIN());
    }

    private String createCardNumber(String BIN) {
        int accountID = random.nextInt(999999999);
        String formattedID = String.format("%09d", accountID);
        return BIN + formattedID + 8;
    }

    private String createPIN() {
        int pinID = random.nextInt(9999);
        return String.format("%04d", pinID);
    }
}
