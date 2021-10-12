package banking;

import java.util.Random;

public class CreditCardFactory {
    private static final String BIN = "400000";
    private final Random random = new Random();

    public static boolean check(String ccNumber) {
        int sum = 0;
        boolean alternate = false;
        for (int i = ccNumber.length() - 1; i >= 0; i--) {
            int n = Integer.parseInt(ccNumber.substring(i, i + 1));
            if (alternate) {
                n *= 2;
                if (n > 9) {
                    n = (n % 10) + 1;
                }
            }
            sum += n;
            alternate = !alternate;
        }
        return (sum % 10 == 0);
    }

    public CreditCard createCreditCard() {
        return new CreditCard(createCardNumber(BIN), createPIN());
    }

    private String createCardNumber(String BIN) {
        int accountID = random.nextInt(999999999);
        String formattedID = String.format("%09d", accountID);
        String cardNum = BIN + formattedID;
        for (int i = 0; i <= 9; i++) {
            String checksum = cardNum + i;
            if (check(checksum)) {
                return checksum;
            }
        }
        throw new IllegalStateException("Dumb bitch.");
    }

    private String createPIN() {
        int pinID = random.nextInt(9999);
        return String.format("%04d", pinID);
    }
}