import stage2.Searching;
import stage3.Menu;
import stage3.UserDetails;
import stage4.ReadingFromFile;
import java.io.File;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
       startSearchingStage1();
       startSearchingStage2();
       startSearchingStage3();
       startSearchingStage4(args);
       startSearchingStage5(args);
    }
    private static void startSearchingStage1(){
        stage1.Searching.search();

    }
    private static void startSearchingStage2(){
        Searching.searchEngine();

    }
    private static void startSearchingStage3(){
            UserDetails.setPeople();
            Menu.selectOption();

    }
    private static void startSearchingStage4(String[] args) {
        if (Objects.equals(args[0], "--data") && args[1] != null) {
            File p = new File(args[1]);
            stage4.UserDetails.setPeople(ReadingFromFile.readingFromFile(p));
            stage4.Menu.selectOption();
        }
    }
    private static void startSearchingStage5(String[] args){
        if (Objects.equals(args[0], "--data") && args[1] != null) {
            stage5.Menu.setFile(args[1]);
            stage5.UserDetails.setPeople(stage5.ReadingFromFile.readingFromFile(stage5.Menu.getFile()));
            stage5.Menu.selectOption();
        }
    }

}
