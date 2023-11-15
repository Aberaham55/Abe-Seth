package Data;

import java.io.*;
import java.util.*;

public class ContactsManager {
    private List<Contact> contacts;
    private File contactsFile;

    public ContactsManager(String filePath) {
        contacts = new ArrayList<>();
        contactsFile = new File(filePath);
        loadContacts();
    }

    public void loadContacts() {
        try (BufferedReader reader = new BufferedReader(new FileReader(contactsFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" | ");
                contacts.add(new Contact(parts[0], parts[1]));
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
        contacts.add(new Contact(name, phoneNumber));
    }

    public Contact searchContact(String name) {
        for (Contact contact : contacts) {
            if (contact.getName().equalsIgnoreCase(name)) {
                return contact;
            }
        }
        return null;
    }

    public void deleteContact(String name) {
        contacts.removeIf(contact -> contact.getName().equalsIgnoreCase(name));
    }

    public void displayContacts() {
        for (Contact contact : contacts) {
            System.out.println(contact);
        }
    }
}

