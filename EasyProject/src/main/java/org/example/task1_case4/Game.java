package org.example.task1_case4;

public class Game {
    public static void start() {
        Matrix.emptyMatrix();
        Matrix.printMatrix();
    }

    public static void printGameStatus() {
        System.out.println(GameStatus.gameStatus(Matrix.getMatrix()));
    }


    public static void playAI() {
        start();
        int count = 0;
        char symbol;
        {
            while (GameStatus.gameStatus(Matrix.getMatrix()).equals("Game not finished")) {
                if (count % 2 == 0) symbol = 'X';
                else symbol = 'O';
                System.out.println("Making move level \"easy\"");
                Matrix.aiMove(symbol);
                Matrix.printMatrix();
                count++;
            }
            printGameStatus();
        }
    }

    public static void playUsers() {
        start();
        int count = 0;
        char symbol;
        while (GameStatus.gameStatus(Matrix.getMatrix()).equals("Game not finished")) {

            if (count % 2 == 0) symbol = 'X';
            else symbol = 'O';
            Matrix.fillMatrix(symbol);
            Matrix.printMatrix();
            count++;
        }
        printGameStatus();
    }

    public static void playUserAi() {
        start();
        while (GameStatus.gameStatus(Matrix.getMatrix()).equals("Game not finished")) {
            Matrix.fillMatrix('X');
            Matrix.printMatrix();
            System.out.println("Making move level \"easy\"");
            Matrix.aiMove('O');
            Matrix.printMatrix();
        }
        printGameStatus();
    }

    public static void playAiUser() {
        start();
        while (GameStatus.gameStatus(Matrix.getMatrix()).equals("Game not finished")) {

            System.out.println("Making move level \"easy\"");
            Matrix.aiMove('X');
            Matrix.printMatrix();
            Matrix.fillMatrix('O');
            Matrix.printMatrix();
        }
        printGameStatus();
    }
}
