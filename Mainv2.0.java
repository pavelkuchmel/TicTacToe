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
        //вывод массива с игровым полем
        /*for (int i = 0; i < tictac.length; i++) {
            for (int j = 0; j < tictac.length; j++) {
                System.out.print(tictac[i][j] + " ");
            }
            System.out.print("\n");
        }*/
        //создаем объект класса Field
        Field array = new Field();
        //заполняем массив игрового поля в классе Field
        array.tictac = tictac;
        int player = 0; //---переменная для контоля игрока
        //создаем цикл процесса игры
        for (;;){
            //вызываем метод из класса Field
            array.showField();
            System.out.println("Player "+(player+1)+" moves.");
            System.out.print("X: ");
            int X = in.nextInt();
            System.out.print("Y: ");
            int Y = in.nextInt();
            array.getTictac(X,Y,player);
        }
    }
}
class Field{
    //создаем массив игрового поля
    char[][] tictac = new char[7][7];
    //создаем метод который показывает игровое поле в консоли
    void showField(){
        System.out.println("\n\n\n");
        for (int i = 0; i < tictac.length; i++) {
            for (int j = 0; j < tictac.length; j++) {
                System.out.print(tictac[i][j] + " ");
            }
            System.out.print("\n");
        }
    }
    //создаем метод проверки хода, выбора символа игрока и добавления символа на игровое поле
    char[][] getTictac(int x, int y, int p) {
        y=y+y;
        x=x+x;
        y=Math.abs(y-6);
        //создаем модуль выбора символа игрока
        switch (p){
            case 0:
                if ((tictac[y][x]!='X')&&(tictac[y][x]!='O')) {
                    tictac[y][x] = 'X';
                    return tictac;
                }
            case 1:
                if ((tictac[y][x]!='X')&&(tictac[y][x]!='O')) {
                    tictac[y][x] = 'O';
                    return tictac;
                }
        }
        return tictac;
    }
}
