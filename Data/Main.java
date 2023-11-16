package Data;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ContactsManager manager = new ContactsManager("contacts.txt");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println(""" 
                    1. View contacts.
                    2. Add a new contact.
                    3. Search a contact by name.
                    4. Delete an existing contact.
                    5. Exit.
                   Enter an option (1, 2, 3, 4 or 5):
                    """);

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline left-over

            switch (choice) {
                case 1 -> manager.displayContacts();
                case 2 -> {
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter phone number: ");
                    String phoneNumber = scanner.nextLine();
                    manager.addContact(name, phoneNumber);
                }
                case 3 -> {
                    System.out.print("Enter name to search: ");
                    String searchName = scanner.nextLine();
                    Contact found = manager.searchContact(searchName);
                    if (found != null) {
                        System.out.println(found);
                    } else {
                        System.out.println("Contact not found.");
                    }
                }
                case 4 -> {
                    System.out.print("Enter name to delete: ");
                    String deleteName = scanner.nextLine();
                    manager.deleteContact(deleteName);
                }
                case 5 -> {
                    manager.saveContacts();
                    System.out.println("Exiting...");
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice. Please enter a number between 1 and 5.");
            }
        }
    }

    public void contactInfo() {
        Path pathToContacts = Paths.get("contacts.txt");
        System.out.println(pathToContacts);

        try {
            if (Files.notExists(pathToContacts)) {
                Files.createFile(pathToContacts);
            }
        } catch (IOException iox) {
            iox.printStackTrace();
        }

        List<String> moreContacts = Arrays.asList("John | 699696996969");
        try {
            Files.write(pathToContacts, moreContacts, StandardOpenOption.APPEND);
        } catch (IOException iox) {
            System.out.println("Error writing to file " + iox.getMessage());
        }
    }
}

