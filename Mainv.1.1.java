import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char[][] tictac = new char[4][4];
        char y = 51;
        char x = 48;
        for (int i = 0; i <= tictac.length-1; i++) {
            for (int j = 0; j <= tictac.length-1; j++) {
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
        int check=0;
        String displayInfo = "";
            for ( ; ; ) {
                System.out.println("");
                for (int i = 0; i <= 3; i++) {
                    for (int j = 0; j <= 3; j++) {
                        System.out.print(tictac[i][j] + " ");
                    }
                    System.out.print("\n");
                }
                System.out.print(displayInfo);
                switch (check) {
                    case 0: {
                        System.out.println("\nPlayer 1 moves: ");
                        int j;
                        do {
                            System.out.print("x: ");
                            j = in.nextInt();
                            if (j<=0||j>=4)System.out.println("Position is out in border.");
                        }while(j<1||j>3);
                        int i;
                        do {
                            System.out.print("y: ");
                            i = in.nextInt();
                            if (i<=0||i>=4)System.out.println("Position is out in border.");
                        }while(i<1||i>3);
                        if (tictac[Math.abs(i - 3)][j] != 'X' && tictac[Math.abs(i - 3)][j] != 'O') {
                            tictac[Math.abs(i - 3)][j] = 'X';
                            check=1;
                            displayInfo="";
                        } else {
                            displayInfo="Position occupied, enter other position.";
                            //System.out.println("Position occupied, enter other position.");
                        }
                    }break;
                    case 1: {
                        System.out.println("\nPlayer 2 moves: ");
                        int j;
                        do {
                            System.out.print("x: ");
                            j = in.nextInt();
                            if (j<=0||j>=4)System.out.println("Position is out in border.");
                        }while(j<1||j>3);
                        int i;
                        do {
                            System.out.print("y: ");
                            i = in.nextInt();
                            if (i<=0||i>=4)System.out.println("Position is out in border.");
                        }while(i<1||i>3);
                        if (tictac[Math.abs(i - 3)][j] != 'X' && tictac[Math.abs(i - 3)][j] != 'O') {
                            tictac[Math.abs(i - 3)][j] = 'O';
                            check=0;
                            displayInfo="";
                        } else {
                            displayInfo="Position occupied, enter other position.";
                            //System.out.println("Position occupied, enter other position.");
                        }
                    }break;
            }
        }
    }
}
