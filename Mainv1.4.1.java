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
                else {
                    tictac[i][j] = ' ';
                }
                if (i == 3) {
                    tictac[i][j] = x;
                    x++;
                }
            }
        }
        int player = 0;
        int check = 0;
        int count = 0;
        String displayInfo = "";
            for (int k=1; ;k++) {
                if (count >= 5) {
                    if ((tictac[0][1] == tictac[0][2] && tictac[0][2] == tictac[0][3] && tictac[0][1]!=' ') || (tictac[1][1] == tictac[1][2] && tictac[1][2] == tictac[1][3] && tictac[1][1] != ' ') || (tictac[2][1] == tictac[2][2] && tictac[2][2] == tictac[2][3] && tictac[2][1] != ' ') || (tictac[0][1] == tictac[1][1] && tictac[1][1] == tictac[2][1] && tictac[0][1] != ' ') || (tictac[0][2] == tictac[1][2] && tictac[1][2] == tictac[2][2] && tictac[0][2] != ' ') || (tictac[0][3] == tictac[1][3] && tictac[1][3] == tictac[2][3] && tictac[0][3] != ' ') || (tictac[0][1] == tictac[1][2] && tictac[1][2] == tictac[2][3] && tictac[0][1] != ' ') || (tictac[0][3] == tictac[1][2] && tictac[1][2] == tictac[2][1] && tictac[0][3] != ' ')) {
                        System.out.println("\n\n\n\nGame Ower!\nPlayer "+player+" win!\nSteps: "+count+"\n\nShow playing field? 0-No 1-Yes");
                        int show = in.nextInt();
                        if (show == 0) {
                            System.out.println("\n-------------\n\tBye\n-------------\n");
                            break;
                        }
                        else {
                            System.out.println("");
                            for (int i = 0; i <= 3; i++) {
                                for (int j = 0; j <= 3; j++) {
                                    System.out.print(tictac[i][j] + " ");
                                }
                                System.out.print("\n");
                            }
                            System.out.println("\n-------------\n\tBye\n-------------\n");
                            break;
                        }
                    }
                    else{
                        if (count == 9){
                            System.out.println("\n\n\n\nGame Ower!\nDraw!\nSteps: "+count+"\n\nShow playing field? 0-No 1-Yes");
                            int show = in.nextInt();
                            if (show == 0) {
                                System.out.println("\n-------------\n\tBye\n-------------\n");
                                break;
                            }
                            else {
                                System.out.println("");
                                for (int i = 0; i <= 3; i++) {
                                    for (int j = 0; j <= 3; j++) {
                                        System.out.print(tictac[i][j] + " ");
                                    }
                                    System.out.print("\n");
                                }
                                System.out.println("\n-------------\n\tBye\n-------------\n");
                                break;
                            }
                        }
                    }
                }
                System.out.println("\n\n\n");
                for (int i = 0; i <= 3; i++) {
                    for (int j = 0; j <= 3; j++) {
                        System.out.print(tictac[i][j] + " ");
                    }
                    System.out.print("\n");
                }
                System.out.print(displayInfo);
                switch (check) {
                    case 0: {
                        player = 1;
                        System.out.println("\nPlayer 1 moves: ");
                        int j;
                        for (;;){
                            System.out.print("x: ");
                            j = in.nextInt();
                            if (j<=0||j>=4){
                                System.out.println("\n\n\n");
                                for (int o = 0; o <= 3; o++) {
                                    for (int p = 0; p <= 3; p++) {
                                        System.out.print(tictac[o][p] + " ");
                                    }
                                    System.out.print("\n");
                                }
                                System.out.println("-->Position is out in border.<--");
                                System.out.println("Player 1 moves: ");
                            }
                            else {
                                break;
                            }
                        }
                        /*do {
                            System.out.print("x: ");
                            j = in.nextInt();
                            if (j<=0||j>=4)System.out.println("Position is out in border.");
                        }while(j<1||j>3);*/
                        int i;
                        for (;;){
                            System.out.print("y: ");
                            i = in.nextInt();
                            if (i<=0||i>=4){
                                System.out.println("\n\n\n");
                                for (int o = 0; o <= 3; o++) {
                                    for (int p = 0; p <= 3; p++) {
                                        System.out.print(tictac[o][p] + " ");
                                    }
                                    System.out.print("\n");
                                }
                                System.out.println("-->Position is out in border.<--");
                                System.out.println("Player 1 moves: ");
                            }
                            else {
                                break;
                            }
                        }
                        /*do {
                            System.out.print("y: ");
                            i = in.nextInt();
                            if (i<=0||i>=4)System.out.println("Position is out in border.");
                        }while(i<1||i>3);*/
                        if (tictac[Math.abs(i - 3)][j] != 'X' && tictac[Math.abs(i - 3)][j] != 'O') {
                            tictac[Math.abs(i - 3)][j] = 'X'; count++;
                            check=1;
                            displayInfo="";
                            //метод вставлять тут
                        } else {
                            displayInfo="-->Position occupied, enter other position.<--";
                            //System.out.println("Position occupied, enter other position.");
                        }
                    }break;
                    case 1: {
                        player = 2;
                        System.out.println("\nPlayer 2 moves: ");
                        int j;
                        for (;;){
                            System.out.print("x: ");
                            j = in.nextInt();
                            if (j<=0||j>=4){
                                System.out.println("\n\n\n");
                                for (int o = 0; o <= 3; o++) {
                                    for (int p = 0; p <= 3; p++) {
                                        System.out.print(tictac[o][p] + " ");
                                    }
                                    System.out.print("\n");
                                }
                                System.out.println("-->Position is out in border.<--");
                                System.out.println("Player 2 moves: ");
                            }
                            else {
                                break;
                            }
                        }
                        /*do {
                            System.out.print("x: ");
                            j = in.nextInt();
                            if (j<=0||j>=4)System.out.println("Position is out in border.");
                        }while(j<1||j>3);*/
                        int i;
                        for (;;){
                            System.out.print("y: ");
                            i = in.nextInt();
                            if (i<=0||i>=4){
                                System.out.println("\n\n\n");
                                for (int o = 0; o <= 3; o++) {
                                    for (int p = 0; p <= 3; p++) {
                                        System.out.print(tictac[o][p] + " ");
                                    }
                                    System.out.print("\n");
                                }
                                System.out.println("-->Position is out in border.<--");
                                System.out.println("Player 2 moves: ");
                            }
                            else {
                                break;
                            }
                        }
                        /*do {
                            System.out.print("y: ");
                            i = in.nextInt();
                            if (i<=0||i>=4)System.out.println("Position is out in border.");
                        }while(i<1||i>3);*/
                        if (tictac[Math.abs(i - 3)][j] != 'X' && tictac[Math.abs(i - 3)][j] != 'O') {
                            tictac[Math.abs(i - 3)][j] = 'O'; count++;
                            check=0;
                            displayInfo="";
                            //метод вставлять тут
                        } else {
                            displayInfo="-->Position occupied, enter other position.<--";
                            //System.out.println("Position occupied, enter other position.");
                        }
                    }break;
            }
        }
    }
    static void outfield(int k, int l, int player, int check) {
        char[][] tictac = new char[4][4];
        int count = 0;
        if (count == 0) {
            char y = 51;
            char x = 48;
            for (int i = 0; i <= tictac.length - 1; i++) {
                for (int j = 0; j <= tictac.length - 1; j++) {
                    if (j == 0) {
                        tictac[i][j] = y;
                        y--;
                    } else {
                        tictac[i][j] = ' ';
                    }
                    if (i == 3) {
                        tictac[i][j] = x;
                        x++;
                    }
                }
                count = 666;
            }
        }
        if (check == 0) {
            if (player == 1) {
                tictac[Math.abs(l - 3)][k] = 'X';
            }
            else if (player == 2) {
                tictac[Math.abs(l - 3)][k] = 'O';
            }
        }
        else if (check == 1){
            System.out.println("");
            for (int i = 0; i <= 3; i++) {
                for (int j = 0; j <= 3; j++) {
                    System.out.print(tictac[i][j] + " ");
                }
                System.out.print("\n");
            }
        }
    }
}
