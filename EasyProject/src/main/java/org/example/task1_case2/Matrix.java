package org.example.task1_case2;
import java.util.*;

public class Matrix {

    private final char[][] matrix;
    private final int col;
    private final int row;

    public Matrix(int col , int row){
        matrix = new char[col][row];
        this.col = col;
        this.row = row;
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

    public void aiMove(){
        int coordX = randomize();
        int coordY = randomize();
        char symbol = 'O';
        char verification = matrix[coordX-1][coordY-1];
        if (verification == ' ') {
            matrix[coordX - 1][coordY - 1] = symbol;
        } else {
            aiMove();

        }
    }

    public String untilEnd(){


        while ((!GameStatus.fullnessCheck(matrix,col,row))){
            fillMatrix();
            printMatrix();
            if(!(GameStatus.gameStatus(matrix,col,row)).equals("Game not finished")) return GameStatus.gameStatus(matrix,col,row);
            System.out.println("Making move level \"easy\"");
            aiMove();
            printMatrix();
            if(!(GameStatus.gameStatus(matrix,col,row)).equals("Game not finished")) return GameStatus.gameStatus(matrix,col,row);
        }
        if(!(GameStatus.gameStatus(matrix,col,row)).equals("X wins") || !(GameStatus.gameStatus(matrix,col,row)).equals("O wins")) return GameStatus.gameStatus(matrix,col,row);


        return "-";
    }

}

