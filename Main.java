import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new File("dataset_91065.txt"));
        int evenCount = 0;
        while (input.hasNextInt()) {
            int number = input.nextInt();
            if (number == 0) {
                break;
            }
            evenCount = number % 2 == 0 ? evenCount + 1 : evenCount;
        }
        System.out.println("\n" + evenCount + " Number");

    }
}