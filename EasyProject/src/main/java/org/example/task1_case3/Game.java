package org.example.task1_case3;

public class Game {


    public static void playAI(char[][] matrix) {
        Matrix newMatrix = new Matrix(matrix, 3, 3);
        newMatrix.emptyMatrix();
        newMatrix.printMatrix();
        int count = 0;
        char symbol;
        {
            while (GameStatus.gameStatus(newMatrix.getMatrix()).equals("Game not finished")) {
                if (count%2==0) symbol = 'X';
                else symbol = 'O';
                System.out.println("Making move level \"easy\"");
                newMatrix.aiMove(symbol);
                newMatrix.printMatrix();
                count++;
            }
            System.out.println(GameStatus.gameStatus(newMatrix.getMatrix()));


        }
    }
    public static void playUsers (char[][] matrix){
        Matrix newMatrix = new Matrix(matrix, 3, 3);
        newMatrix.emptyMatrix();
        newMatrix.printMatrix();
        while (GameStatus.gameStatus(newMatrix.getMatrix()).equals("Game not finished")) {

            newMatrix.fillMatrix();
            newMatrix.printMatrix();
        }
        System.out.println(GameStatus.gameStatus(newMatrix.getMatrix()));
    }

    public static void playUserAi (char[][] matrix){
        Matrix newMatrix = new Matrix(matrix, 3, 3);
        newMatrix.emptyMatrix();
        newMatrix.printMatrix();
        while (GameStatus.gameStatus(newMatrix.getMatrix()).equals("Game not finished")) {

            System.out.println("Making move level \"easy\"");
            newMatrix.fillMatrix();
            newMatrix.printMatrix();
            newMatrix.aiMove('O');
            newMatrix.printMatrix();
        }
        System.out.println(GameStatus.gameStatus(newMatrix.getMatrix()));
    }
    public static void playAiUser (char[][] matrix){
        Matrix newMatrix = new Matrix(matrix, 3, 3);
        newMatrix.emptyMatrix();
        newMatrix.printMatrix();
        while (GameStatus.gameStatus(newMatrix.getMatrix()).equals("Game not finished")) {

            System.out.println("Making move level \"easy\"");
            newMatrix.aiMove('X');
            newMatrix.printMatrix();
            newMatrix.fillMatrix();
            newMatrix.printMatrix();
        }
        System.out.println(GameStatus.gameStatus(newMatrix.getMatrix()));
    }
}
