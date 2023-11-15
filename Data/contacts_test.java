package Data;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
public class contacts_test {
    private Scanner scanner;
    private final int CHOICE_EXIT = 5;

    public static void main(String[] args) {

        contacts_test app = new contacts_test();
//        app.start();
        printMenu();

    }
    private static void printMenu() {
        System.out.println("""
                 1. View contacts.
                 2. Add a new contact.
                 3. Search a contact by name.
                 4. Delete an existing contact.
                 5. Exit.
                 Enter an option (1, 2, 3, 4 or 5):
                                          
                """);

    }


//    private void start() {
////        initContacts();
////
////        printWelcome();
////
//        while (true) {
//            printMenu();
//
//            int choice = input.getInt(1, CHOICE_EXIT, "Make a choice: ");
//            if (choice == CHOICE_EXIT) {
//                break;
//            System.out.println("goodbye");
//            }
//            doChoice(choice);
//        }

    //}
}
