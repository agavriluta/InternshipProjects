package org.example.task1_case5;



public class GameStatus {
    private static char diagonalCheck(char[][] matrix) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == 0 && j == 0) {
                    if (matrix[i][j] == matrix[i + 1][j + 1] && matrix[i][j] == matrix[i + 2][j + 2]) {
                        if (matrix[i][j] == 'X') return 'X';
                        if (matrix[i][j] == 'O') return 'O';
                    }
                } else if (i == 3 - 1 && j == 0) {
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

    static boolean fullnessCheck(char[][] matrix) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (matrix[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    public static String gameStatus(char[][] matrix) {
        char diagonal = diagonalCheck(matrix);
        char horizontal = horizontalCheck(matrix);
        char vertical = verticalCheck(matrix);
        boolean full = fullnessCheck(matrix);

        if (full) {
            if (diagonal == 'X') return GameState.X_WINS.getState();
            else if (diagonal == 'O') return GameState.O_WINS.getState();

            else if (horizontal == 'X') return GameState.X_WINS.getState();
            else if (horizontal == 'O') return GameState.O_WINS.getState();

            else if (vertical == 'X') return "X wins";
            else if (vertical == 'O') return GameState.O_WINS.getState();

            else return GameState.DRAW.getState();
        } else {
            if (diagonal == 'X') return GameState.X_WINS.getState();
            else if (diagonal == 'O') return GameState.O_WINS.getState();

            else if (horizontal == 'X') return GameState.X_WINS.getState();
            else if (horizontal == 'O') return GameState.O_WINS.getState();

            else if (vertical == 'X') return GameState.X_WINS.getState();
            else if (vertical == 'O') return GameState.O_WINS.getState();

            else return GameState.GAME_NOT_FINISHED.getState();
        }

    }
}
