package stage1;

import java.util.Scanner;

public class Searching {
    private static String[] inputLine(){
        Scanner scan = new Scanner(System.in);
        String inputLine = scan.nextLine();
        return inputLine.split(" ");
    }
    private static String inputWord(){
        Scanner scan = new Scanner(System.in);
        return scan.nextLine();
    }

    public static void search(){
        String[] arr = inputLine();
        String word = inputWord();
        String result = " ";
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(word)) result = Integer.toString(i+1);
        }
        if (result.isBlank()) System.out.println("Not Found");
        else System.out.println(result);
    }

}
