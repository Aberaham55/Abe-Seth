package Data;

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
}


