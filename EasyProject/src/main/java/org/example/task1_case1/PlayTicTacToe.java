package org.example.task1_case1;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class PlayTicTacToe {

    public static void playTicTacToe()
    {
        char[][] gameArr = new char[3][3];
        System.out.print("Enter the cells :");
        String symbols = enterCells(3, 3, gameArr);
        printMatrix(gameArr);
        System.out.print("Enter the coordinates:");
        fillMatrix(gameArr, symbols);
        printMatrix(gameArr);
        System.out.println(GameStatus.gameStatus(gameArr,3, 3));
    }

    protected static void printMatrix(char[][] matrix) {
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (j == 0) System.out.print("| ");
                System.out.print(matrix[i][j] + " ");
                if (j == 3 - 1) System.out.print("|");
            }
            System.out.println();
        }
        System.out.println("---------");
    }

    protected static String enterCells(int column, int line, char[][] matrix) {
        Scanner scan = new Scanner(System.in);
        String symbols = scan.next();
        int count = 0;
        for (int x = 0; x < column; x++) {
            for (int y = 0; y < line; y++) {
                char[] symbolsChar = symbols.toCharArray();
                if (!checkSymbol(symbolsChar[count])) {
                    System.out.println("You should enter only 'X', 'O' or '_' !");
                    System.out.print("Enter the cells :");
                    enterCells(column, line, matrix);
                } else {
                    if (symbolsChar[count] == '_') matrix[x][y] = ' ';
                    else matrix[x][y] = symbolsChar[count];
                }
                count++;
            }

        }
        return symbols;
    }

    protected static void fillMatrix(char[][] matrix, String symbols) {
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
        char symbol = inputSymbol(symbols);
        String verification = Character.toString(matrix[coordX - 1][coordY - 1]);
        if (verification.isBlank()) {
            matrix[coordX - 1][coordY - 1] = symbol;
        } else {
            System.out.println("This cell is occupied! Choose another one!");
            System.out.print("Enter the coordinates:");
            fillMatrix(matrix, symbols);
        }

    }

    public static boolean checkSymbol(char s) {
        return s == 'X' || s == 'O' || s == '_';
    }


    protected static char inputSymbol(String symbols) {
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
            if (amounSymbol < temp || (symbol == 'X') && amounSymbol == temp) {
                temp = amounSymbol;
                tempSymbol = symbol;
            }
        }

        return tempSymbol;

    }

}