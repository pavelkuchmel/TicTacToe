import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final char xSymbol = 'X';
        final char oSymbol = 'O';
        final char symbol = ' ';
        final int size = 3;
        char[][] field = new char[size][size];
        initField(field);
        printField(field);
        while (true){
            turn(field, xSymbol);
            printField(field);
            if (checkWin(field, oSymbol)){
                System.out.println("Выиграли крестики.");
                break;
            }
            if (checkWin(field, oSymbol)){
                System.out.println("Выиграли нолики");
            }
            if (checkDraw(field)){
                System.out.println("Ничья");
                break;
            }
        }
    }
    static boolean checkDraw(char[][] field){
        boolean result = true;
        for (int i = 0;i < field.length; i++){
            for (int j = 0; j < field[i].length; j++){
                if (field[i][j] == ' '){
                    result = false;
                }
            }
        }
        return result;
    }
    static boolean checkWin(char[][] field, char symbol){
        boolean result = false;
        for (int i = 0; i < field.length; i++){
            if (field[i][0]==field[i][1]&&field[i][1]==field[i][2]&&field[i][1]==symbol)result=true;
            break;
        }
        for (int j = 0; j < field.length; j++){
            if (field[0][j]==field[1][j]&&field[1][j]==field[2][j]&&field[1][j]==symbol)result=true;
            break;
        }
        if (field[0][0]==field[1][1]&&field[1][1]==field[2][2]&&field[1][1]==symbol)result=true;
        else if (field[0][2]==field[1][1]&&field[1][1]==field[2][0]&&field[1][1]==symbol)result=true;
        return result;
    }
    static void turn(char[][] field, char symbol){
        Scanner in = new Scanner(System.in);
        int string = 0;
        int columb = 0;
        do {
            System.out.print("Введите строки: ");
            string = in.nextInt();
            System.out.print("Введите номер столбца");
            columb = in.nextInt();
        }while (string < 0 || string >2 || columb < 0 || columb > 2 || field[string][columb] != ' ');
        field[string][columb] = symbol;
    }
    static void initField(char[][] field){
        for (int i = 0; i < field.length; i++){
            for (int j = 0; j < field[i].length; j++){
                field[i][j] = ' ';
            }
        }
    }
    static void printLineSeparator(){
        for (int k = 0; k < 3; k++) {
            System.out.print("|---");
        }
        System.out.println('|');
    }
    static void printField(char[][] field) {
        for (int i = 0; i < field.length; i++) {
            printLineSeparator();
            for (int j = 0; j < field[i].length; j++){
                System.out.print("| "+field[i][j]+" ");
            }
            System.out.println('|');
        }
        printLineSeparator();
    }
}
