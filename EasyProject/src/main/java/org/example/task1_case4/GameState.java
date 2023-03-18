package org.example.task1_case4;

enum GameState{
    X_WINS("X wins"),
    O_WINS("O wins"),
    DRAW("Draw"),
    GAME_NOT_FINISHED("Game not finished");

    private final String state;
    private GameState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}