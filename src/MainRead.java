import packageInOut.Contact;
import packageInOut.FilesRead;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MainRead {
    static int counter = 0;
    public static void main(String[] args) {
        Collection<String> collection = new ArrayList<>();
        List<Contact> contacts = new ArrayList<>();
        FilesRead filesRead = new FilesRead();
        try {
            collection = filesRead.filesRead();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            contacts = FilesRead.stringToContact(collection);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Something went wrong, possible reason");
            e.printStackTrace();
        }
        int count = 0;
        for (Contact contact : contacts) {
            if (count < 5) {
                System.out.println(contact.getName() + " " + contact.getYear());
                count++;
            }
        }
        try {
            writeCollection(contacts);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            readCollection();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Collection<String> collectionReaded = new ArrayList<>();
        try {
            collectionReaded = readCollection();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (String s : collectionReaded) {
            System.out.println(s);
        }
        try {
            writeCollectionWithObj(contacts);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Collection<Contact> collectSerialized = new ArrayList<>();
        try {
            collectSerialized = readCollectionObj();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (Contact contact : collectSerialized) {
            System.out.println("only name");
            System.out.println(contact.getName());
        }
        MainRead test = new MainRead();
        final File folder = new File("F:\\InputOutput");
        test.listFilesForFolder(folder);
        System.out.println("Total count of files in directory " + counter);
    }


    public int listFilesForFolder(final File folder) {
        for (final File fileEntry : folder.listFiles()) {
            if (fileEntry.isDirectory()) {
                listFilesForFolder(fileEntry);
            } else {
                counter++;
            }
        }
        return counter;
    }

    public static void writeCollection(Collection<Contact> contacts) throws IOException {
        try (DataOutputStream collection = new DataOutputStream(new FileOutputStream("contactInBin.data"))) {
            for (Contact contact : contacts) {
                collection.writeUTF(contact.getName() + " " + contact.getSecondName() + " " + contact.getNumber() + " " + contact.getYear());
            }
        }
    }

    public static Collection<String> readCollection() throws IOException {
        Collection<String> phoneBook = new ArrayList<>();
        String result;
        try (DataInputStream inputStream = new DataInputStream(new FileInputStream("contactInBin.data"))) {
            for (int i = 0; i < inputStream.available(); i++) {
                result = inputStream.readUTF();
                phoneBook.add(result);
            }
            return phoneBook;
        }
    }

    public static void writeCollectionWithObj(Collection<Contact> contacts) throws IOException {
        try (ObjectOutputStream someFale = new ObjectOutputStream(new FileOutputStream("object.bin"))) {
            someFale.writeObject(contacts);
        }
    }

    public static Collection<Contact> readCollectionObj() throws IOException {
        Collection<Contact> contacts = new ArrayList<>();
        try (ObjectInputStream stream = new ObjectInputStream(new FileInputStream("object.bin"))) {
            contacts = (ArrayList<Contact>) stream.readObject();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return contacts;
    }
}
