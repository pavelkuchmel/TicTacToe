import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char[][] tictac = new char[4][4];
        char y = 51;
        char x = 48;
        for (int i = 0; i <= 3; i++) {
            for (int j = 0; j <= 3; j++) {
                if (j == 0) {
                    tictac[i][j] = y;
                    y--;
                }
                if (i == 3) {
                    tictac[i][j] = x;
                    x++;
                }
            }
        }
        for (int i = 0; i <= 3; i++) {
            for (int j = 0; j <= 3; j++) {
                System.out.print(tictac[i][j] + " ");
            }
            System.out.print("\n");
        }
    }
}
