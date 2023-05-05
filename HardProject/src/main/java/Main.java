import stage1.Contacts;
import stage2.PhoneBook;

public class Main {

    public static void main(String[] args) {
        startStage1();
        startStage2();
        startStage3();
    }
    public static void startStage1(){
        Contacts contact1 = new Contacts();
        System.out.println("A Phone Book with a single record created!");
    }
    public static void startStage2(){
        PhoneBook.chooseMenuOption();
    }
    public static void startStage3(){
        stage3.PhoneBook.chooseMenuOption();
    }

}
