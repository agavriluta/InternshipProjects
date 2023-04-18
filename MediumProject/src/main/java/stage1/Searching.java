package stage1;

import java.util.Scanner;
import java.util.stream.IntStream;

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

//        var var1 = IntStream.range(0, arr.length)
//                .filter(index -> arr[index].equals(word))
//                .mapToObj(index -> Integer.valueOf(index).toString())
//                .findFirst()
//                .orElse("Not found");
//        System.out.println(var1);
    }

}
