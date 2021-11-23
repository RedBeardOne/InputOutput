package packageInOut;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MainRead {
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
        }
        catch (Exception e){
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
    }
}
