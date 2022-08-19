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
        showField(tictac);
        for (int k=0;;k++) {
            getTictac(k%2, tictac);
            showField(tictac);
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
            System.out.println("Player "+(p+1)+" move:");
            System.out.print("Enter x: ");
            int x = in.nextInt();
            return (x+x);
    }
    static int moveY(int p){
        Scanner in = new Scanner(System.in);
        System.out.println("Player "+(p+1)+" move:");
        System.out.print("Enter y: ");
        int y = in.nextInt();
        return Math.abs((y+y)-6);
    }
    static char[][] getTictac(int p, char[][]tictac) {
        int player = p;
        int x;
        int y;
        boolean check;
        switch (player){
            case 0:
                player = 0;
                do{
                    x = moveX(player);
                    y = moveY(player);
                    if ((tictac[y][x] != 'X') && (tictac[y][x] != 'O')) {
                        tictac[y][x] = 'X';
                        check = true;
                        return tictac;
                    } else {
                        System.out.println("error");
                    }
                }while (true);
            case 1:
                player = 1;
                check = false;
                do{
                    x = moveX(player);
                    y = moveY(player);
                    if ((tictac[y][x] != 'X') && (tictac[y][x] != 'O')) {
                        tictac[y][x] = 'O';
                        check = true;
                        return tictac;
                    } else {
                        System.out.println("\nError\n");
                    }
                }while (true);
        }
        return tictac;
    }
}

