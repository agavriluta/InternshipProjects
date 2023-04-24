package org.example.task1_case5;

import java.util.Objects;

public class MediumLevel {

    private static String diagonalCheck(char[][] matrix , char symbol) {
        String rez = "-";
        String temp1 = " ";
        String temp2 = " ";
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                    if (i==0 && j == 0){
                        if (matrix[i][j] == matrix[i+1][j + 1] && matrix[i+2][j+2] == ' ') {
                            if (matrix[i][j] == 'X') temp1 = "22";
                            if (matrix[i][j] == 'O') temp2 = "22";
                        }
                    }
                    if(i == 2 && j == 2){
                        if (matrix[i][j] == matrix[i-1][j - 1] && matrix[i-2][j-2] == ' ') {
                            if (matrix[i][j] == 'X') temp1 = "00";
                            if (matrix[i][j] == 'O') temp2 = "00";
                        }
                   }
                    if (i == 2 && j == 0){
                        if (matrix[i][j] == matrix[i-1][j + 1] && matrix[i-2][j+2] == ' ') {
                             if (matrix[i][j] == 'X') temp1 = "02";
                             if (matrix[i][j] == 'O') temp2 = "02";
                        }
                    }
                if (i == 0 && j == 2){
                    if (matrix[i][j] == matrix[i + 1][j - 1] && matrix[i+2][j-2] == ' ') {
                        if (matrix[i][j] == 'X') temp1 = "20";
                        if (matrix[i][j] == 'O') temp2 = "20";
                    }
                }
            }
        }
        if (symbol == 'X' && !temp1.equals(" ")) rez = temp1;
        if (symbol == 'O' && !temp2.equals(" ")) rez = temp2;
        if (symbol == 'X' &&  temp1.equals(" ") && !(temp2.equals(" "))) rez = temp2;
        if (symbol == 'O' &&  temp2.equals(" ")&& !(temp1.equals(" "))) rez = temp1;
        return rez;
    }

    private static String horizontalCheck(char[][] matrix , char symbol) {
        String rez = "-";
        String temp1 = " ";
        String temp2 = " ";
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                switch (j) {
                    case 0 -> {
                        if (matrix[i][j] == matrix[i][j + 1] && matrix[i][j+2] == ' ') {
                            if (matrix[i][j] == 'X') temp1 = Integer.toString(i).concat(Integer.toString(j));
                            if (matrix[i][j] == 'O') temp2 = Integer.toString(i).concat(Integer.toString(j));
                        }
                    }
                    case 2 -> {
                        if (matrix[i][j] == matrix[i][j - 1] && matrix[i][j-2] == ' ') {
                            if (matrix[i][j] == 'X') temp1 = Integer.toString(i).concat(Integer.toString(j));
                            if (matrix[i][j] == 'O') temp2 = Integer.toString(i).concat(Integer.toString(j));
                        }
                    }
                }
             }
        }
        if (symbol == 'X' && !temp1.equals(" ")) rez = temp1;
        if (symbol == 'O' && !temp2.equals(" ")) rez = temp2;
        if (symbol == 'X' &&  temp1.equals(" ")&& !(temp2.equals(" "))) rez = temp2;
        if (symbol == 'O' &&  temp2.equals(" ")&& !(temp1.equals(" "))) rez = temp1;
        return rez;
    }

    private static String  verticalCheck(char[][] matrix , char symbol) {
        String rez = "-";
        String temp1 = " ";
        String temp2 = " ";
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                switch (i) {
                    case 0 -> {
                        if (matrix[i][j] == matrix[i+1][j] && matrix[i+2][j] == ' ') {
                            if (matrix[i][j] == 'X') temp1 = Integer.toString(i).concat(Integer.toString(j));
                            if (matrix[i][j] == 'O') temp2 = Integer.toString(i).concat(Integer.toString(j));
                        }
                    }
                    case 2 -> {
                        if (matrix[i][j] == matrix[i-1][j] && matrix[i-2][j] == ' ') {
                            if (matrix[i][j] == 'X') temp1 = Integer.toString(i).concat(Integer.toString(j));
                            if (matrix[i][j] == 'O') temp2 = Integer.toString(i).concat(Integer.toString(j));
                        }
                    }
                }
            }
        }
        if (symbol == 'X' && !temp1.equals(" ")) rez = temp1;
        if (symbol == 'O' && !temp2.equals(" ")) rez = temp2;
        if (symbol == 'X' &&  temp1.equals(" ")&& !(temp2.equals(" "))) rez = temp2;
        if (symbol == 'O' &&  temp2.equals(" ")&& !(temp1.equals(" "))) rez = temp1;

        return rez;
    }



    public static String randomORnot(char[][] matrix , char symbol){
        String rezult = "!";
        for (int i = 0; i < 3; i++) {
            switch (i){
                case 0 : rezult = diagonalCheck(matrix, symbol);
                    if (!Objects.equals(rezult, "-")) return rezult;
                case 1 : rezult = horizontalCheck(matrix,symbol) ;
                    if (!Objects.equals(rezult, "-")) return rezult;
                case 2 : rezult = verticalCheck(matrix,symbol);
                    if (!Objects.equals(rezult, "-")) return rezult;
            }
        }
        return rezult;
    }

    public static void playUserAi (){
        Game.start();
        while (GameStatus.gameStatus(Matrix.getMatrix()).equals("Game not finished")) {
            Matrix.fillMatrix('X');
            Matrix.printMatrix();
            if (!GameStatus.gameStatus(Matrix.getMatrix()).equals("Game not finished")) break;
            System.out.println("Making move level \"medium\"");
            Matrix.aiMoveMedium('O');
            Matrix.printMatrix();
        }
        Game.printGameStatus();
    }
    public static void playAiUser (){
        Game.start();
        while (GameStatus.gameStatus(Matrix.getMatrix()).equals("Game not finished")) {

            System.out.println("Making move level \"easy\"");
            Matrix.aiMoveMedium('X');
            Matrix.printMatrix();
            if (!GameStatus.gameStatus(Matrix.getMatrix()).equals("Game not finished")) break;
            Matrix.fillMatrix('O');
            Matrix.printMatrix();

        }
        Game.printGameStatus();
    }

}
