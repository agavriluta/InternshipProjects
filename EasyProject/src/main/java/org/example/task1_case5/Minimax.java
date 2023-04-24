package org.example.task1_case5;

public class Minimax {

    private static char player;
    private static char oppositePlayer;

    private static char getOppositePlayer(char p) {
        if (p == 'X') oppositePlayer = Player.O.getField();
        if (p == 'O') oppositePlayer = Player.X.getField();
        return oppositePlayer;
    }

    public static void bestMove(char p) {
        player = p;


        int bestScore = Integer.MIN_VALUE;
        int[] bestPosition = new int[2];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (Matrix.getMatrix()[i][j] == ' ') {
                    Matrix.getMatrix()[i][j] = player;
                    int score = minimax(getOppositePlayer(player), false, player, 1);
                    Matrix.getMatrix()[i][j] = ' ';
                    if (score > bestScore) {
                        bestScore = score;
                        bestPosition[0] = i;
                        bestPosition[1] = j;
                    }
                }
            }
        }
        Matrix.getMatrix()[bestPosition[0]][bestPosition[1]] = player;
    }

    private static int minimax(char player, boolean isMaximize, char startPlayer, int depth) {

        switch (GameStatus.gameStatus(Matrix.getMatrix())) {
            case "X wins" -> {
                return startPlayer == Player.X.getField() ? 10 - depth : depth - 10;
            }
            case "O wins" -> {
                return startPlayer == Player.O.getField() ? 10 - depth : depth - 10;
            }
            case "Draw" -> {
                return 0;
            }
        }

        //  boolean end = false;
        int bestScore = isMaximize ? Integer.MIN_VALUE : Integer.MAX_VALUE;

        if (isMaximize) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (Matrix.getMatrix()[i][j] == ' ') {
                        Matrix.getMatrix()[i][j] = player;
                        int score = minimax(getOppositePlayer(player), false, startPlayer, depth + 1);
                        Matrix.getMatrix()[i][j] = ' ';
                        bestScore = Math.max(bestScore, score);
                    }
                }
            }
            return bestScore;
        }
        else {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (Matrix.getMatrix()[i][j] == ' ') {
                        Matrix.getMatrix()[i][j] = player;
                        int score = minimax(getOppositePlayer(player), true, startPlayer, depth + 1);
                        Matrix.getMatrix()[i][j] = ' ';
                        bestScore = Math.min(bestScore, score);
                    }
                }
            }
            return bestScore;
        }
    }
        public static void playUserAi () {
            Game.start();
            while (GameStatus.gameStatus(Matrix.getMatrix()).equals("Game not finished")) {
                Matrix.fillMatrix(Player.X.getField());
                Matrix.printMatrix();
                if (!GameStatus.gameStatus(Matrix.getMatrix()).equals("Game not finished")) break;
                System.out.println("Making move level \"hard\"");
                bestMove(Player.O.getField());
                Matrix.printMatrix();
            }
            Game.printGameStatus();
        }

        public static void playAiUser () {
            Game.start();
            while (GameStatus.gameStatus(Matrix.getMatrix()).equals("Game not finished")) {
                System.out.println("Making move level \"hard\"");
                bestMove(Player.X.getField());
                Matrix.printMatrix();
                if (!GameStatus.gameStatus(Matrix.getMatrix()).equals("Game not finished")) break;
                Matrix.fillMatrix(Player.O.getField());
                Matrix.printMatrix();

            }
            Game.printGameStatus();
        }
        public static void ai(){
        Game.start();
            while (GameStatus.gameStatus(Matrix.getMatrix()).equals("Game not finished")){
                System.out.println("Making move level \"hard\"");
                bestMove(Player.X.getField());
                Matrix.printMatrix();
                if (!GameStatus.gameStatus(Matrix.getMatrix()).equals("Game not finished")) break;
                System.out.println("Making move level \"hard\"");
                bestMove(Player.O.getField());
                Matrix.printMatrix();
            }
            Game.printGameStatus();
        }

    }





