package org.example.task1_case3;
import java.util.*;

public class Matrix {

    public enum Commands{
        DOUBLE_USER("start user user"),
        AI_USER("start easy user"),
        USER_AI("start user easy"),
        AI("start easy easy"),
        EXIT("exit"),
        DEFAULT("default");
private final String field;
       Commands(String line){
           this.field =line;
        }
public String getField(){
           return this.field;
}
    }
    private final char[][] matrix;


    public Matrix(char[][] m) {
        matrix= new char[3][3];
        for (int i = 0; i < 3; i++) {
            System.arraycopy(m[i], 0, matrix[i], 0, 3);

        }

    }

    public Matrix(){
        matrix = new char[3][3];
    }



    public void playTicTacToe(){
        System.out.print("Input command:");
        inputCommand();
    }
    public void inputCommand(){

        Scanner scan = new Scanner(System.in);
        Object input = scan.nextLine();
        Commands option = Arrays.stream(Commands.values())
                .filter(enum1 -> enum1.getField()
                        .equals(input))
                .findFirst()
                .orElse(Commands.DEFAULT);

        switch (option){
            case AI: Game.playAI(matrix); break;
            case AI_USER : Game.playAiUser(matrix);break;
            case DOUBLE_USER: Game.playUsers(matrix);break;
            case EXIT: break;
            case USER_AI : Game.playUserAi(matrix); break;
            case DEFAULT : System.out.println("Bad parameters!");
                System.out.print("Input command:");inputCommand();
            break;
        }
    }


    public void printMatrix(){
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (j == 0) System.out.print("| ");
                System.out.print(matrix[i][j] + " ");
                if (j == 2) System.out.println("|");
            }
        }
        System.out.println("---------");
    }

    public void emptyMatrix(){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matrix[i][j]=' ';
            }
        }
    }

    public void fillMatrix(){
        System.out.println("Enter the coordinates:");
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
        String verification = Character.toString(matrix[coordX - 1][coordY - 1]);
        if (verification.isBlank()) {
            matrix[coordX - 1][coordY - 1] = 'X';
        } else {
            System.out.println("This cell is occupied! Choose another one!");
            System.out.print("Enter the coordinates:");
            fillMatrix();
        }

    }

    private int randomize(){ int min = 1;
        int max = 3;
        int diff = max - min;
        Random random = new Random();
        int i = random.nextInt(diff + 1);
        i += min;
        return  i;}

    public void aiMove(char symbol){
        int coordX = randomize();
        int coordY = randomize();
        char verification = matrix[coordX-1][coordY-1];
        if (verification == ' ') {
            matrix[coordX - 1][coordY - 1] = symbol;
        } else {
            aiMove(symbol);

        }
    }


    public char[][] getMatrix() {
        return matrix;
    }
}

