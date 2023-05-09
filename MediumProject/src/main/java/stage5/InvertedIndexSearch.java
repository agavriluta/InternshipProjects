package stage5;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class InvertedIndexSearch {
    private static final Map<String, Set<Integer>> indexes;
    static {
        indexes = new HashMap<>();
    }

    private static Map<String, Set<Integer>> mapIndexes(File readingFile){
        String[] array = new String[]{};
        Integer i = 0;
        try(Scanner scanner = new Scanner(readingFile)){
            while (scanner.hasNextLine()) {
                String temp = scanner.nextLine();
                if (temp != null){
                    array = temp.split(" ");
                }
                for (String s : array) {
                    if (!indexes.containsKey(s)) {
                        indexes.put(s, new HashSet<>());
                    }
                    indexes.get(s).add(i);
                }
                ++i;
            }
        }

        catch (FileNotFoundException e)
        {
            System.out.println("File not found");
        }

        return indexes;
    }
    public static void findPerson(String word , File f) {
        Map<String, Set<Integer>> indexes = mapIndexes(f);
        List<Person> people = UserDetails.getPeople();
        Set<Person> personRes = new HashSet<>();
        for (Map.Entry<String, Set<Integer>> d: indexes.entrySet()) {
            if (Objects.equals(word,d.getKey().trim().toLowerCase())){
                for (Integer integer : d.getValue()) {
                    personRes.add(people.get(integer));
                }
            }
        }
        if (personRes.isEmpty()) System.out.println("No matching people found.\n");
        else {
            System.out.println(personRes.size() + " persons found");
            for (Person a : personRes) {
                System.out.println(a.toString());
            }
            System.out.println();
        }
    }
}
