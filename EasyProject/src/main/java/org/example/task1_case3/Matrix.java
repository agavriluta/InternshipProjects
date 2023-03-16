package org.example.task1_case3;
import java.util.*;

//import static org.example.task1_case3.Matrix.Commands.*;
//import static sun.tools.jconsole.Messages.EXIT;

public class Matrix {

    public enum Commands{
        DOUBLE_USER("start user user"),
        AI_USER("start easy user"),
        USER_AI("start user easy"),
        AI("start easy easy"),
        EXIT("exit");
private final String field;
       Commands(String line){
           this.field =line;
        }
public String getField(){
           return this.field;
}
    }
    private final char[][] matrix;
    private final int col;
    private final int row;

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }

    public Matrix(char[][] m, int col ,int row) {
        matrix= new char[col][row];
        for (int i = 0; i < col; i++) {
            System.arraycopy(m[i], 0, matrix[i], 0, row);

        }
        this.col=col;
        this.row=row;
    }

    public Matrix(int col , int row){
        matrix = new char[col][row];
        this.col = col;
        this.row = row;
    }



    public void playTicTacToe(){
        System.out.print("Input command:");
        inputCommand();
    }
    public void inputCommand(){

        Scanner scan = new Scanner(System.in);
        var input = scan.nextLine();
        var option = Arrays.stream(Commands.values())
                .filter(enum1 -> enum1.getField()
                        .equals(input))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("invalid input"));

        switch (option){
            case AI: Game.playAI(matrix); break;
            case AI_USER : Game.playAiUser(matrix);break;
            case DOUBLE_USER: Game.playUsers(matrix);break;
            case EXIT: break;
            case USER_AI : Game.playUserAi(matrix); break;
            default: System.out.println("Bad parameters!"); inputCommand();
            break;
        }
    }


    public void printMatrix(){
        System.out.println("---------");
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                if (j == 0) System.out.print("| ");
                System.out.print(matrix[i][j] + " ");
                if (j == col-1) System.out.println("|");
            }
        }
        System.out.println("---------");
    }

    public void emptyMatrix(){
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                matrix[i][j]=' ';
            }
        }
    }

    public void fillMatrix(){
        System.out.println("Enter the coordinates:");
        Scanner scanner = new Scanner(System.in);
        int coordX = 0;
        int coordY = 0;
        boolean check = false;
        while (!check) {
            try {
                coordX = scanner.nextInt();
                coordY = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("You should enter numbers!");
                System.out.print("Enter the coordinates:");
                scanner.nextLine();
                continue;
            }

            if (coordX < 1 || coordX > 3 || coordY < 1 || coordY > 3) {
                System.out.println("Coordinates should be from 1 to 3!");
                System.out.print("Enter the coordinates:");
                continue;
            }
            check = true;
        }
        String verification = Character.toString(matrix[coordX - 1][coordY - 1]);
        if (verification.isBlank()) {
            matrix[coordX - 1][coordY - 1] = 'X';
        } else {
            System.out.println("This cell is occupied! Choose another one!");
            System.out.print("Enter the coordinates:");
            fillMatrix();
        }

    }

    private int randomize(){ int min = 1;
        int max = 3;
        int diff = max - min;
        Random random = new Random();
        int i = random.nextInt(diff + 1);
        i += min;
        return  i;}

    public void aiMove(char symbol){
        int coordX = randomize();
        int coordY = randomize();
        char verification = matrix[coordX-1][coordY-1];
        if (verification == ' ') {
            matrix[coordX - 1][coordY - 1] = symbol;
        } else {
            aiMove(symbol);

        }
    }


    public char[][] getMatrix() {
        return matrix;
    }
}

