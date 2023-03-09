package org.example.task1_case1;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        int col = 3 , row = 3;
        char[][] gameArr = new char[col][row];
        System.out.print("Enter the cells :");
        String symbols = eneterCells(col, row, gameArr);
        printMatrix(gameArr, col, row);
        System.out.print("Enter the coordinates:");
        fillMatrix(gameArr, symbols);
        printMatrix(gameArr, col, row);
        System.out.println(GameStatus.gameStatus(gameArr,col,row));




    }
    public static void printMatrix(char[][] matrix, int lines, int columns) {
        System.out.println("---------");
        for (int i = 0; i < columns; i++) {
            for (int j = 0; j < lines; j++) {
                if (j == 0) System.out.print("|");
                System.out.print(matrix[i][j] + " ");
                if (j == columns-1) System.out.print("|");
            }
            System.out.println();
        }
        System.out.println("---------");
    }

    public static String eneterCells(int column, int line, char[][] matrix) {
        Scanner scan = new Scanner(System.in);
        String symbols = scan.next();
        int count = 0;
        for (int x = 0; x < column; x++) {
            for (int y = 0; y < line; y++) {
                char[] symbolsChar = symbols.toCharArray();
                if (!checkSymbol(symbolsChar[count])) {
                    System.out.println("You should enter only 'X', 'O' or '_' !");
                    System.out.print("Enter the cells :");
                    eneterCells(column, line, matrix);
                } else {
                    if (symbolsChar[count] == '_') matrix[x][y] = ' ';
                    else matrix[x][y] = symbolsChar[count];
                }
                count++;
            }

        }
        return symbols;
    }

    public static void fillMatrix(char[][] matrix, String symbols) {
        Scanner scanner = new Scanner(System.in);
        int coordX = inputCoords(scanner);
        int coordY = inputCoords(scanner);
       char symbol =  inputSymbol(symbols);
        String verification = Character.toString(matrix[coordX-1][coordY-1]);
        if (verification.isBlank()) {
            matrix[coordX - 1][coordY - 1] = symbol;
        } else {
            System.out.println("This cell is occupied! Choose another one!");
            System.out.print("Enter the coordinates:");
            fillMatrix(matrix,symbols);
        }

    }

    public static boolean checkSymbol(char s){
        if (s!='X' && s!='O' && s!='_' ) return false;

        return true;
    }
    public static int inputCoords(Scanner scanner) {

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

    public static boolean checkCoords(int coord) {
        return coord <= 3 && coord >= 1;
    }

    public static char inputSymbol(String symbols) {
        int temp = Integer.MAX_VALUE;
        char tempSymbol = ' ';
        char[] symbolsArr = symbols.toCharArray();
        Map<Character, Integer> amountOfEachSymbol = new HashMap<>();
        for (char c : symbolsArr) {
            if (c != '_') {
                if (amountOfEachSymbol.containsKey(c)) {
                    amountOfEachSymbol.put(c, amountOfEachSymbol.get(c) + 1);
                } else {
                    amountOfEachSymbol.put(c, 1);
                }
            }
        }
        for (Map.Entry<Character, Integer> entry : amountOfEachSymbol.entrySet()) {
            char symbol = entry.getKey();
            int amounSymbol = entry.getValue();
            if (amounSymbol < temp || (symbol == 'X') && amounSymbol == temp ) {
                temp = amounSymbol;
                tempSymbol = symbol;
            }
        }

        return tempSymbol;

    }

    /*public static char enterSymbol() {
        Scanner scanner = new Scanner(System.in);
        char symbol = scanner.next().charAt(0);
        if (symbol != 'X' && symbol != '0') {
            System.out.println("Enter only 'X' or 'O' ");
            System.out.print("Enter please your symbol : ");
            enterSymbol();
        }
        return symbol;
    }*/
}
