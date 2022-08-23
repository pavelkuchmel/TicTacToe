import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
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
        char question = ' ';
        for (;;k++) {
            showField(tictac);
            setTictac(k%2, tictac);
            if (check(tictac, k)){
                System.out.print("Numbers of moves: "+(k+1)+"\n");
                System.out.print("Show playing field? y/n: ");
                question = in.nextLine().charAt(0);
                if (question=='y'){
                    showField(tictac);
                    System.out.println("---Goodbye---");
                    break;

                }
                else {
                    System.out.println("\n\n\n\n\nGoodbye...\n\n");
                    break;
                }
            }
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
    static int moveX(int p, char[][]field){
        Scanner in = new Scanner(System.in);
        int x;
        do {
            System.out.print("Enter x: ");
            x = in.nextInt();
            if (x<1||x>3) {
                showField(field);
                System.out.println("Position is out in border, enter another position."+"\nPlayer " + (p + 1) + " move:");
                //System.out.println("Player " + (p + 1) + " move:");
            }
        }while(x<1||x>3);
        return (x + x);
    }
    static int moveY(int p, char[][]field, int x){
        int y;
        do {
            Scanner in = new Scanner(System.in);
            System.out.print("Enter y: ");
            y = in.nextInt();
            if (y<1||y>3) {
                showField(field);
                System.out.println("Position is out in border, enter another position."+"\nPlayer " + (p + 1) + " move:");
                System.out.println("Enter x: "+(x/2));
                //System.out.println("Player " + (p + 1) + " move:");
            }
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
                    System.out.println("\nPlayer " + (p + 1) + " move:");
                    x = moveX(player, tictac);
                    y = moveY(player, tictac, x);
                    if ((tictac[y][x] != 'X') && (tictac[y][x] != 'O')) {
                        tictac[y][x] = 'X';
                        return tictac;
                    } else {
                        System.out.println("\nPosition occupied, enter another position.\n");
                    }
                }while (true);
            case 1:
                player = 1;
                do{
                    System.out.println("\nPlayer " + (p + 1) + " move:");
                    x = moveX(player, tictac);
                    y = moveY(player, tictac, x);
                    if ((tictac[y][x] != 'X') && (tictac[y][x] != 'O')) {
                        tictac[y][x] = 'O';
                        return tictac;
                    } else {
                        System.out.println("\nPosition occupied, enter another position.\n");
                    }
                }while (true);
        }
        return tictac;
    }
    static boolean check(char[][] tictac, int player){
        boolean win = false;
        if ((tictac[0][2] == tictac[0][4] && tictac[0][4] == tictac[0][6] && tictac[0][2]!=' ') || (tictac[2][2] == tictac[2][4] && tictac[2][4] == tictac[2][6] && tictac[2][2] != ' ') || (tictac[4][2] == tictac[4][4] && tictac[4][4] == tictac[4][6] && tictac[4][2] != ' ') || (tictac[0][2] == tictac[2][2] && tictac[2][2] == tictac[4][2] && tictac[0][2] != ' ') || (tictac[0][4] == tictac[2][4] && tictac[2][4] == tictac[4][4] && tictac[0][4] != ' ') || (tictac[0][6] == tictac[2][6] && tictac[2][6] == tictac[4][6] && tictac[0][6] != ' ') || (tictac[0][2] == tictac[2][4] && tictac[2][4] == tictac[4][6] && tictac[0][2] != ' ') || (tictac[0][6] == tictac[2][4] && tictac[2][4] == tictac[4][2] && tictac[0][6] != ' ')){
            System.out.print("\n\nPlayer "+(player%2+1)+" win! ");
            win = true;
        }
        return win;
    }
}

