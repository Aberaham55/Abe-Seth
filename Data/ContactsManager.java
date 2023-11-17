package Data;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class ContactsManager {
    private final List<Contact> contacts;
    private final File contactsFile;

    Path pathToContacts = Paths.get("contacts.txt");

    public ContactsManager(String filePath) {
        contacts = new ArrayList<>();
        contactsFile = new File(filePath);
        loadContacts();
    }

    public void loadContacts() {

        try  {
            List<String> contactsFromFile = Files.readAllLines(pathToContacts);
            for (String nextLine : contactsFromFile) {
                String[] parts = nextLine.split("\\|", 2);
                Contact contact = new Contact(parts[0], parts[1]);
                contacts.add(contact);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveContacts() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(contactsFile))) {
            for (Contact contact : contacts) {
                writer.write(contact.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addContact(String name, String phoneNumber) {
        if (contactExists(name)) {
            System.out.println("A contact with this name already exists.");
            return;
        }
        String formattedPhoneNumber = formatPhoneNumber(phoneNumber);
        contacts.add(new Contact(name, formattedPhoneNumber));
    }


    public Contact searchContact(String name) {
        for (Contact contact : contacts) {
            if (contact.getName().trim().equalsIgnoreCase(name.trim())) {
                return contact;
            }
        }
        return null;
    }

    public void deleteContact(String name) {
        contacts.removeIf(contact -> contact.getName().trim().equalsIgnoreCase(name.trim()));
    }

    public void displayContacts() {
        System.out.println("Name       | Phone number |");
        System.out.println("---------------------------");
        for (Contact contact : contacts) {
            System.out.println(String.format("%-10s | %-12s |", contact.getName(), contact.getPhoneNumber()));
        }
    }

    public boolean contactExists(String name) {
        for (Contact contact : contacts) {
            if (contact.getName().trim().equalsIgnoreCase(name.trim())) {
                return true;
            }
        }
        return false;
    }

    public String formatPhoneNumber(String phoneNumber) {
        return phoneNumber.replaceAll("(\\d{3})(\\d{3})(\\d+)", "(\\$1) \\$2-\\$3");
    }

}

