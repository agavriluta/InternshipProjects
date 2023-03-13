package org.example.task1_case3;
public class GameStatus {
    private static char diagonalCheck(char[][] matrix, int col, int row) throws ArrayIndexOutOfBoundsException{
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                if (i == 0 && j == 0) {
                    if (matrix[i][j] == matrix[i + 1][j + 1] && matrix[i][j] == matrix[i + 2][j + 2]) {
                        if (matrix[i][j] == 'X') return 'X';
                        if (matrix[i][j] == 'O') return 'O';
                    }
                } else if (i == col - 1 && j == 0) {
                    if (matrix[i][j] == matrix[i - 1][j+1] && matrix[i][j] == matrix[i - 2][j + 2]) {
                        if (matrix[i][j] == 'X') return 'X';
                        if (matrix[i][j] == 'O') return 'O';
                    }
                }


            }

        }
        return '-';
    }

    private static char horizontalCheck(char[][] matrix, int col, int row) {
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
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

    private static char verticalCheck(char[][] matrix, int col, int row) {
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
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

    static boolean fullnessCheck(char[][] matrix, int col, int row) {
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                if (!Character.toString(matrix[i][j]).isEmpty() && Character.toString(matrix[i][j]) != null) {
                    return false;
                }
            }
        }
        return true;
    }

    public static String gameStatus(char[][] matrix, int col, int row) {
        char diagonal = diagonalCheck(matrix, col, row);
        char horizontal = horizontalCheck(matrix, col, row);
        char vertical = verticalCheck(matrix, col, row);
        boolean full = fullnessCheck(matrix, col, row);

        if (full) {
            if (diagonal == 'X') return "X wins";
            else if (diagonal == 'O') return "O wins";

            else if (horizontal == 'X') return "X wins";
            else if (horizontal == 'O') return "O wins";

            else if (vertical == 'X') return "X wins";
            else if (vertical == 'O') return "O wins";

            else return "Draw";
        } else {
            if (diagonal == 'X') return "X wins";
            else if (diagonal == 'O') return "O wins";

            else if (horizontal == 'X') return "X wins";
            else if (horizontal == 'O') return "O wins";

            else if (vertical == 'X') return "X wins";
            else if (vertical == 'O') return "O wins";

            else return "Game not finished";
        }

    }
}
