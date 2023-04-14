package org.example.stage2;

import java.util.*;

public class Searching {

    private static List<String[]> listOfData(){
        System.out.println("Enter the number of people:");
        Scanner scan = new Scanner(System.in);
        int size = scan.nextInt();
        scan.nextLine();
        System.out.println("Enter all people:");
        List<String[]> data= new ArrayList<>();
        String[] input = new String[size];
        for (int i = 0; i < input.length; i++) {
            input[i] = scan.nextLine();
        }
        System.out.println();
        for (int i = 0; i < size; i++) {
            data.add(input[i].split(" "));
        }
        return data;
    }
    public static void searchQueries(){
        List<String[]> data = listOfData();
        System.out.println("Enter the number of search queries:");
        Scanner scan = new Scanner(System.in);
        Scanner scanner = new Scanner(System.in);
        int count = scan.nextInt();
        System.out.println();
        int temp = 0, temp2 = 0;
        Set<String[]> res = new HashSet<>();
        for (int i = 0; i < count; i++) {
            System.out.println("Enter data to search people:");
            String searchWord = scanner.nextLine();
            temp2 = 0;
            res.clear();
            for (String[] a:data) {
                temp = 0;
                for (String s : a) {
                    if (s.toLowerCase().contains(searchWord.toLowerCase())) ++temp;
                }
                if (temp != 0) {
                    res.add(a);
                    ++temp2;
                }
            }
            if (temp2 == 0) System.out.println("No matching people found.");
            else {
                System.out.println();
                System.out.println("Found people:");
                for (String[] a: res) {
                    for (int j = 0; j < a.length; j++) {
                        if (j != (a.length - 1)) System.out.print(a[j]+" ");
                        else System.out.println(a[j]);
                    }


                }
                System.out.println();
            }

        }

    }

}

