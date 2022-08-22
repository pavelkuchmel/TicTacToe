import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //создание массива с игровым полем
        char[][] tictac = new char[7][7];
        char x = (int)48;
        char y = (int)51;
        for (int i = 0;i < tictac.length;i++){
            for (int j = 0;j < tictac.length;j++){
                tictac[i][j]=' ';
                tictac[5][1]='+';
                tictac[6][0]='0';
                if (i==5||i==3||i==1)tictac[i][j] = '-';
                if (j==1||j==3||j==5)tictac[i][j] = '|';
                if (i==6&&j%2==0){
                    tictac[i][j]=x;
                    x++;
                }
                if (j==0&&i%2==0){
                    tictac[i][j]=y;
                    y--;
                }
            }
        }
        int k = 0;
        for (;;k++) {
            showField(tictac);
            setTictac(k%2, tictac);
            if (check(tictac, k))break;
            if (k==8){
                System.out.println("\nGame over!");
                break;}
        }
    }
    static void showField(char[][]tictac){
        System.out.println("\n\n\n");
        for (int i = 0; i < tictac.length; i++) {
            for (int j = 0; j < tictac.length; j++) {
                System.out.print(tictac[i][j] + " ");
            }
            System.out.print("\n");
        }
    }
    static int moveX(int p){
        Scanner in = new Scanner(System.in);
        int x;
        do {
            //System.out.println("Player " + (p + 1) + " move:");
            System.out.print("Enter x: ");
            x = in.nextInt();
            if (x<1||x>3) {
                System.out.println("Position is out in border, enter other position.");
            }
        }while(x<1||x>3);
        return (x + x);
    }
    static int moveY(int p){
        int y;
        do {
            Scanner in = new Scanner(System.in);
            //System.out.println("Player " + (p + 1) + " move:");
            System.out.print("Enter y: ");
            y = in.nextInt();
            if (y<1||y>3) System.out.println("Position is out in border, enter other position.");
        }while (y<1||y>3);
        return Math.abs((y+y)-6);
    }
    static char[][] setTictac(int p, char[][]tictac) {
        int player = p;
        int x;
        int y;
        switch (player){
            case 0:
                player = 0;
                do{
                    System.out.println("Player " + (p + 1) + " move:");
                    x = moveX(player);
                    y = moveY(player);
                    if ((tictac[y][x] != 'X') && (tictac[y][x] != 'O')) {
                        tictac[y][x] = 'X';
                        return tictac;
                    } else {
                        System.out.println("\nPosition occupied, enter other position.\n");
                    }
                }while (true);
            case 1:
                player = 1;
                do{
                    System.out.println("Player " + (p + 1) + " move:");
                    x = moveX(player);
                    y = moveY(player);
                    if ((tictac[y][x] != 'X') && (tictac[y][x] != 'O')) {
                        tictac[y][x] = 'O';
                        return tictac;
                    } else {
                        System.out.println("\nPosition occupied, enter other position.\n");
                    }
                }while (true);
        }
        return tictac;
    }
    static boolean check(char[][] tictac, int player){
        boolean win = false;
        if ((tictac[0][2] == tictac[0][4] && tictac[0][4] == tictac[0][6] && tictac[0][2]!=' ') || (tictac[2][2] == tictac[2][4] && tictac[2][4] == tictac[2][6] && tictac[2][2] != ' ') || (tictac[4][2] == tictac[4][4] && tictac[4][4] == tictac[4][6] && tictac[4][2] != ' ') || (tictac[0][2] == tictac[2][2] && tictac[2][2] == tictac[4][2] && tictac[0][2] != ' ') || (tictac[0][4] == tictac[2][4] && tictac[2][4] == tictac[4][4] && tictac[0][4] != ' ') || (tictac[0][6] == tictac[2][6] && tictac[2][6] == tictac[4][6] && tictac[0][6] != ' ') || (tictac[0][2] == tictac[2][4] && tictac[2][4] == tictac[4][6] && tictac[0][2] != ' ') || (tictac[0][6] == tictac[2][4] && tictac[2][4] == tictac[4][2] && tictac[0][6] != ' ')){
            System.out.println("\nPlayer "+(player%2+1)+" win!");
            win = true;
        }
        return win;
    }
}

