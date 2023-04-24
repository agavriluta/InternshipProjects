import stage1.Searching;
import stage4.Menu;
import stage4.ReadingFromFile;
import stage4.UserDetails;

import java.io.File;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
       startStage4(args);
    }

    private static void startStage4(String[] args) {
        if (Objects.equals(args[0], "--data") && args[1] != null) {
            File p = new File(args[1]);

            UserDetails.setPeople(ReadingFromFile.readingFromFile(p));
            Menu.selectOption();
        }
    }
}
