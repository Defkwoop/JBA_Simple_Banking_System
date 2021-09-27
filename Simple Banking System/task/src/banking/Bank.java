package banking;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Bank {


    private final Scanner scanner = new Scanner(System.in);
    private final CreditCardFactory creditCardFactory = new CreditCardFactory();

    Map<String, CreditCard> creditCardDetails = new HashMap<>();

    private boolean running = true;
    public boolean isRunning() {
        return running;
    }

    public void actions() {
        System.out.println("1. Create an account \n2. Log into account \n0. Exit");
        switch (scanner.nextInt()) {
            case 1:
                create();
                break;
            case 2:
                login();
                break;
            case 0:
                exit();
                break;
        }
    }

    private void create() {
        CreditCard creditCard = creditCardFactory.createCreditCard();
        System.out.println("Your card has been created");
        System.out.println("Your card number:");
        System.out.println(creditCard.getCardNumber());
        System.out.println("Your card PIN:");
        System.out.println(creditCard.getCardPIN());
        System.out.println();
        creditCardDetails.put(creditCard.getCardNumber(), creditCard);
    }

    private void login() {
        System.out.println("Enter your card number:");
    }

    private void exit() {
        running = false;
    }


}
