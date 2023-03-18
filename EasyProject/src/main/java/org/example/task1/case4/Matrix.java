package org.example.task1.case4;

import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class Matrix {

    private static final char[][] matrix = new char[3][3];

    public static void playTicTacToe(){
        inputCommand();
    }

   public static void inputCommand(){
       Scanner scan = new Scanner(System.in);
           System.out.print("Input command:");
           String option = scan.nextLine();

               if ("start easy easy".trim().equals(option.trim()) ) {
                   Game.playAI(matrix);
               }
              else if("start easy user".trim().equals(option.trim()) ){
                   Game.playAiUser(matrix);
               }
               else if ("start user user".trim().equals(option.trim())) {
                   Game.playUsers(matrix);
               }
               else if("exit".trim().equals(option.trim())){

               }
               else if("start user easy".trim().equals(option.trim()) ){
                      Game.playUserAi(matrix);
               }
               else if ("start user medium".trim().equals(option.trim())) {
                   MediumLevel.playUserAi(matrix);
               } else if ("start medium  user".trim().equals(option.trim())) {
                   MediumLevel.playAiUser(matrix);

               } else{
                   System.out.println("Bad parameters!");
                   inputCommand();
               }
           }


    public static void printMatrix(){
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

    public static void emptyMatrix(){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matrix[i][j]=' ';
            }
        }
    }

    public static void fillMatrix(char s){
        System.out.print("Enter the coordinates:");
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
            matrix[coordX - 1][coordY - 1] = s;
        } else {
            System.out.println("This cell is occupied! Choose another one!");
            System.out.print("Enter the coordinates:");
            fillMatrix(s);
        }

    }

    public static int randomize(){
        int min = 1;
        int max = 3;
        int diff = max - min;
        Random random = new Random();
        int i = random.nextInt(diff + 1);
        i += min;
        return  i;}

    public static void aiMove(char symbol){
        int coordX = randomize();
        int coordY = randomize();
        char verification = matrix[coordX-1][coordY-1];
        if (verification == ' ') {
            matrix[coordX - 1][coordY - 1] = symbol;
        } else {
            aiMove(symbol);
        }
    }

    public static void aiMoveMedium(char symbol ){
        String rez = MediumLevel.randomORnot( matrix , symbol);
        int coordX = 0;
        int coordY = 0;
        char[] s = rez.toCharArray();
        if(!Objects.equals(rez, "-")){
            coordX = Integer.parseInt(Character.toString(s[0]));
            coordY = Integer.parseInt(Character.toString(s[1]));
            matrix[coordX][coordY] = symbol;
        }
        else {
            coordX = randomize();
            coordY = randomize();
            char verification = Matrix.getMatrix()[coordX - 1][coordY - 1];
            if (verification == ' ') {
                Matrix.getMatrix()[coordX - 1][coordY - 1] = symbol;
            } else {
                aiMove(symbol);

            }
        }
    }
    public static char[][] getMatrix() {
        return matrix;
    }
}