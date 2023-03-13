package org.example.task1_case3;
import java.util.*;

public class Matrix {

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
        inputCommand();
    }
    public void inputCommand(){
        Scanner scan = new Scanner(System.in);
        System.out.print("Input command:");
        String option = scan.nextLine();

        if ("start easy easy".trim().equals(option.trim()) ) {
            Game.playAI(matrix);
        }
        else if("start easy user".trim().equals(option.trim()) ){
            Game.playAiUser(matrix);
        }
        else if ("start user user".trim().equals(option.trim())) {
            Game.playUsers(matrix);
        }
        else if("exit".trim().equals(option.trim())){

        }
        else if("start user easy".trim().equals(option.trim()) ){
            Game.playUserAi(matrix);
        }
        else{
            System.out.println("Bad parameters!");
            inputCommand();
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

