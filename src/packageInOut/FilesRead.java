package packageInOut;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FilesRead {


    public Collection<String> filesRead() throws IOException {
        Collection<String> collection = new ArrayList<>();
        try (BufferedReader text = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream("Contact.bin"), StandardCharsets.UTF_8))) {
            String line;
            while ((line = text.readLine()) != null) {
                collection.add(line);
            }
        }
        return collection;
    }

    public static List<Contact> stringToContact(Collection<String> collection) throws IOException {
        Contact contact = null;
        List<Contact> contacts = new ArrayList<>();
        Pattern pattern = Pattern.compile("([a-zA-Z]+) \\| ([a-zA-Z]+) \\| ([0-9]+) \\| ([0-9]+)");
        for (String s : collection) {
            Matcher matcher = pattern.matcher(s);
            if (matcher.find()) {
                String one = matcher.group(1);
                String two = matcher.group(2);
                String three = matcher.group(3);
                String four = matcher.group(4);
                int date = Integer.valueOf(four);
                contact = new Contact(one, two, three, date);
                contacts.add(contact);
            }
            contacts.sort((o1, o2) -> {
                int dateOne = o1.getYear();
                int dateTwo = o2.getYear();
                return Integer.compare(dateOne, dateTwo);
            });
        }
        return contacts;
    }

}
