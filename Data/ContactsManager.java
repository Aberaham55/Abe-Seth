package Data;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class ContactsManager {
    private List<Contact> contacts;
    private File contactsFile;

    Path pathToContacts = Paths.get("contacts.txt");

    public ContactsManager(String filePath) {
        contacts = new ArrayList<>();
        contactsFile = new File(filePath);
        loadContacts();
    }

    public void loadContacts() {

        try  {
            List<String> contactsFromFile = Files.readAllLines(pathToContacts);
            Iterator<String> contactsIterator = contactsFromFile.iterator();
            while (contactsIterator.hasNext()) {
                String nextLine = contactsIterator.next();
                String[] parts = nextLine.split("\\|");
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
        contacts.add(new Contact(name, phoneNumber));
    }

    public Contact searchContact(String name) {
        for (Contact contact : contacts) {
//            System.out.println(contact.getName());
//            System.out.println(name);
//            System.out.println(contact.getName().equals(name));
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
        for (Contact contact : contacts) {
            System.out.println("NAME: | NUMBER");
            System.out.printf("-------------------------------------%n");
            System.out.println(contact);
            System.out.println();

        }
    }





        public List<String> readFile(Path pathToContacts){
            List<String> linesInFile = new ArrayList<>();
            try {
                linesInFile = Files.readAllLines(pathToContacts);
            } catch (IOException iox){
                iox.printStackTrace();
            }
            return linesInFile;
        }

        public void outputList(List<String> list) {
        for(String listItem : list) {
            System.out.println(listItem);
        }
    }

    public void writeListToFile(Path pathToFile, List<String> listToWrite) {
        try{
            Files.write(pathToFile, listToWrite);
        } catch (IOException iox) {
            iox.printStackTrace();
            System.out.println(iox.getMessage());
        }
    }


}

