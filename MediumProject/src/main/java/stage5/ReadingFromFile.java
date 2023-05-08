package stage5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class ReadingFromFile {
    public static List<Person> readingFromFile (File readingFile) {

        String[] array = new String[]{};
        List<Person> personList = new ArrayList<>();
        try(Scanner scanner = new Scanner(readingFile)){
            while (scanner.hasNextLine()) {
                String temp = scanner.nextLine();
                if (temp != null){
                    array = temp.split("\\s");
                }
                switch (array.length) {
                    case 1 -> personList.add(new Person(array[0])) ;

                    case 2 -> personList.add(new Person(array[0], array[1]));

                    case 3 -> personList.add(new Person(array[0], array[1], array[2]));

                    default -> personList.add(new Person());
                }
            }
        }

        catch (FileNotFoundException e)
        {
            System.out.println("File not found");
        }


        return personList;
    }
}
