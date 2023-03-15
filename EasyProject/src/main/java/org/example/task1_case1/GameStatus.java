package org.example.task1_case1;

public class GameStatus {

    enum GameState{
        X_WINS("X wins"),
        O_WINS("O wins"),
        DRAW("Draw"),
        GAME_NOT_FINISHED("Game not finished");

        GameState(String s) {
        }
    }
    private static char diagonalCheck(char[][] matrix){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == 0 && j == 0) {
                    if (matrix[i][j] == matrix[i + 1][j + 1] && matrix[i][j] == matrix[i + 2][j + 2]) {
                        if (matrix[i][j] == 'X') return 'X';
                        if (matrix[i][j] == 'O') return 'O';
                    }
                } else if (i == 2 && j == 0) {
                    if (matrix[i][j] == matrix[i - 1][j+1] && matrix[i][j] == matrix[i - 2][j + 2]) {
                        if (matrix[i][j] == 'X') return 'X';
                        if (matrix[i][j] == 'O') return 'O';
                    }
                }


            }

        }
        return '-';
    }

    private static char horizontalCheck(char[][] matrix) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (j == 0) {
                    if (matrix[i][j] == matrix[i][j + 1] && matrix[i][j] == matrix[i][j + 2]) {

                        if (matrix[i][j] == 'O') {
                            return 'O';
                        } else if (matrix[i][j] == 'X') {
                            return 'X';
                        }
                    }
                }
            }
        }


        return '-';
    }

    private static char verticalCheck(char[][] matrix) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == 0) {
                    if (matrix[i][j] == matrix[i + 1][j] && matrix[i][j] == matrix[i+2][j]) {
                        if (matrix[i][j] == 'X') return 'X';
                        if (matrix[i][j] == 'O') return 'O';
                    }
                }
            }


        }
        return '-';
    }

    private static boolean fullnessCheck(char[][] matrix) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (matrix[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

     protected static GameState gameStatus(char[][] matrix) {
        char diagonal = diagonalCheck(matrix);
        char horizontal = horizontalCheck(matrix);
        char vertical = verticalCheck(matrix);
        boolean full = fullnessCheck(matrix);

        if (full) {
            if (diagonal == 'X') return GameState.X_WINS;
            else if (diagonal == 'O') return GameState.O_WINS;

            else if (horizontal == 'X') return GameState.X_WINS;
            else if (horizontal == 'O') return GameState.O_WINS;

            else if (vertical == 'X') return GameState.X_WINS;
            else if (vertical == 'O') return GameState.O_WINS;

            else return GameState.DRAW;
        } else {
            if (diagonal == 'X') return GameState.X_WINS;
            else if (diagonal == 'O') return GameState.O_WINS;

            else if (horizontal == 'X') return GameState.X_WINS;
            else if (horizontal == 'O') return GameState.O_WINS;

            else if (vertical == 'X') return GameState.X_WINS;
            else if (vertical == 'O') return GameState.O_WINS;

            else return GameState.GAME_NOT_FINISHED;
        }

    }
}
