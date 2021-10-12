package banking;

import java.util.Scanner;

public class Bank {


    private final Scanner scanner = new Scanner(System.in);
    private final CreditCardFactory creditCardFactory = new CreditCardFactory();

    DatabaseManager databaseManager = new DatabaseManager();
    boolean dbCreated = false;
    private boolean isLoggedIn;
    private boolean running = true;

    public boolean isRunning() {
        return running;
    }

    public void actions() {
        if (!dbCreated) {
            databaseManager.makeDBConnection();
            dbCreated = true;
        }
        System.out.println("1. Create an account \n2. Log into account \n0. Exit");
        int input = scanner.nextInt();
        scanner.nextLine();
        switch (input) {
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
        databaseManager.addAccount(creditCard);
    }

    private void login() {
        System.out.println("Enter your card number:");
        final String creditCardNumber = scanner.nextLine();
        System.out.println("Enter your PIN:");
        final String pin = scanner.nextLine();

        if (databaseManager.login(creditCardNumber, pin)) {

            System.out.println("You have successfully logged in!");
            isLoggedIn = true;
            while (isLoggedIn) {
                loginto(creditCardNumber);
            }
        } else {
            System.out.println("Wrong card number or PIN!");
        }
    }


    public void loginto(String cardNumber) {
        System.out.println("1. Balance \n2. Add income \n3. Do transfer \n4. Close account \n5. Log out \n0. Exit");
        int input = scanner.nextInt();
        scanner.nextLine();
        switch (input) {
            case 1:
                balance(cardNumber);
                break;
            case 2:
                income(cardNumber);
                break;
            case 3:
                transfer(cardNumber);
                break;
            case 4:
                close(cardNumber);
                break;
            case 5:
                logout();
                break;
            case 0:
                exit();
                break;
        }
    }

    private void balance(String cardNumber) {
        final int balance = databaseManager.balance(cardNumber);
        System.out.println("Balance: " + balance);
        loginto(cardNumber);
    }

    private void income(String cardNumber) {
        System.out.println("Enter income: ");
        int income = scanner.nextInt();

        databaseManager.updateBalance(cardNumber, income);
        System.out.println("Income was added!");
        loginto(cardNumber);

    }

    private void transfer(String cardNumber) {
        System.out.println("Transfer\nEnter card number:");
        String ccN = scanner.next();

        if (!CreditCardFactory.check(ccN)) {
            System.out.println("Probably you made a mistake in the card number. Please try again!");
            return;
        }
        if (!databaseManager.isCardInDatabase(ccN)) {
            System.out.println("Such a card does not exist.");
            return;
        }
        if (cardNumber.equals(ccN)) {
            System.out.println("You can't transfer money to the same account!");
            return;
        }
        System.out.println("Enter how much money you want to transfer: ");
        int amount = scanner.nextInt();
        if (amount >= databaseManager.balance(cardNumber)) {
            System.out.println("Not enough money!");
            return;
        }
        databaseManager.updateBalance(ccN, amount);
        databaseManager.updateBalance(cardNumber, -amount);
        System.out.println("Success!");
        loginto(cardNumber);

    }

    private void close(String number) {
        databaseManager.deleteAccount(number);
        System.out.println("The account has been closed!");
    }

    private void logout() {
        System.out.println("You have successfully logged out!");
        isLoggedIn = false;
    }

    private void exit() {
        System.out.println("Bye!");
        running = false;
        isLoggedIn = false;
        databaseManager.closeDBConnection();
    }
}
