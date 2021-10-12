package banking;

public class Main {

    public static void main(String[] args) {

        Bank banking = new Bank();
        while (banking.isRunning()) {
            banking.actions();
        }
    }
}