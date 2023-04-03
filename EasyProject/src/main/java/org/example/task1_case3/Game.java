package org.example.task1_case3;

public class Game {
    private static Matrix newMatrix;

    private static void start(char[][] matrix) {
        newMatrix = new Matrix(matrix);
        newMatrix.emptyMatrix();
        newMatrix.printMatrix();
    }
    private static void printGameStatus(){
        System.out.println(GameStatus.gameStatus(newMatrix.getMatrix()));
    }


    public static void playAI(char[][] matrix) {
        start(matrix);
        int count = 0;
        char symbol;
            while (GameStatus.gameStatus(newMatrix.getMatrix()).equals("Game not finished")) {
                if (count % 2 == 0) symbol = 'X';
                else symbol = 'O';
                System.out.println("Making move level \"easy\"");
                newMatrix.aiMove(symbol);
                newMatrix.printMatrix();
                count++;
            }
           printGameStatus();
    }

    public static void playUsers(char[][] matrix) {
        start(matrix);
        while (GameStatus.gameStatus(newMatrix.getMatrix()).equals("Game not finished")) {

            newMatrix.fillMatrix();
            newMatrix.printMatrix();
        }
        printGameStatus();
    }

    public static void playUserAi(char[][] matrix) {
       start(matrix);
        while (GameStatus.gameStatus(newMatrix.getMatrix()).equals("Game not finished")) {

            System.out.println("Making move level \"easy\"");
            newMatrix.fillMatrix();
            newMatrix.printMatrix();
            newMatrix.aiMove('O');
            newMatrix.printMatrix();
        }
        printGameStatus();
    }

    public static void playAiUser(char[][] matrix) {
        start(matrix);
        while (GameStatus.gameStatus(newMatrix.getMatrix()).equals("Game not finished")) {

            System.out.println("Making move level \"easy\"");
            newMatrix.aiMove('X');
            newMatrix.printMatrix();
            newMatrix.fillMatrix();
            newMatrix.printMatrix();
        }
        printGameStatus();
    }
}
