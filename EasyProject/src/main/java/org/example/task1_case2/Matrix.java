package org.example.task1_case2;

import java.util.*;

public class Matrix {

    private char[][] matrix;
    private int col;
    private int row;

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
                if (j == col-1) System.out.println(" |");
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
    public void fillMatrix() {
        System.out.print("Enter the coordinates:");
        Scanner scanner = new Scanner(System.in);
        int coordX = inputCoords(scanner);
        int coordY = inputCoords(scanner);
        char symbol = 'X';
        char verification = matrix[coordX-1][coordY-1];
        if (verification == ' ') {
            matrix[coordX - 1][coordY - 1] = symbol;
        } else {
            System.out.println("This cell is occupied! Choose another one!");
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
            aiMove();
            printMatrix();
            if(!(GameStatus.gameStatus(matrix,col,row)).equals("Game not finished")) return GameStatus.gameStatus(matrix,col,row);
        }
        if(!(GameStatus.gameStatus(matrix,col,row)).equals("X wins") || !(GameStatus.gameStatus(matrix,col,row)).equals("O wins")) return GameStatus.gameStatus(matrix,col,row);


        return "-";
    }

//    private char inputSymbol(String symbols) {
//        int temp = Integer.MAX_VALUE;
//        char tempSymbol = ' ';
//        char[] symbolsArr = symbols.toCharArray();
//        Map<Character, Integer> amountOfEachSymbol = new HashMap<>();
//        for (char c : symbolsArr) {
//            if (c != '_') {
//                if (amountOfEachSymbol.containsKey(c)) {
//                    amountOfEachSymbol.put(c, amountOfEachSymbol.get(c) + 1);
//                } else amountOfEachSymbol.put(c, 1);
//            }
//        }
//        for (Map.Entry<Character, Integer> entry : amountOfEachSymbol.entrySet()) {
//            char symbol = entry.getKey();
//            int amounSymbol = entry.getValue();
//            if (amounSymbol < temp || (symbol == 'X') && amounSymbol == temp ) {
//                temp = amounSymbol;
//                tempSymbol = symbol;
//            }
//        }
//
//        return tempSymbol;
//    }

    private int inputCoords(Scanner scanner) {

        int coordinate = scanner.nextInt();
        try {

            if (!checkCoords(coordinate)) {
                System.out.println("Coordinates should be from 1 to 3!");
                System.out.print("Enter the coordinates:");
                inputCoords(scanner);

            }

        } catch (InputMismatchException e) {
            System.out.println("You should enter numbers!");
            System.out.print("Enter the coordinates:");
            inputCoords(scanner);

        }
        return coordinate;
    }

    private boolean checkCoords(int coord) {
        return coord <= 3 && coord >= 1;
    }

}
