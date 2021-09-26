import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[][] array = new String[n][n];
        //Outer Loop for number of Rows
        for (int i = 0; i < n; i++) {
            // Inner loop for printing '*' in each column.
            for (int j = 0; j < n; j++) {
                if (
                        (i == n / 2) ||
                                (j == n / 2) ||
                                (i == j) ||
                                (j == n-i-1)
                ) {
                    array[i][j] = "*";
                } else {
                    array[i][j] = ".";
                }
            }
        }
        for (int i = 0; i < n; i++) {
            String string = Arrays.toString(array[i]);
            string = string.replace("[", "");
            string = string.replace(",", "");
            string = string.replace("]", "");
            System.out.println(string);
        }
    }
}
// if dodaj ispod ovog sam kad je na odgovoarajucem
// else if ispod toga