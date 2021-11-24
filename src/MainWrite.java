import packageInOut.Contact;
import packageInOut.FilesRead;
import packageInOut.FilesWrite;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class MainWrite {
    public static void main(String[] args) throws IOException {
        try {
            createHelloWorld();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            createRandomInt();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            readHundred(100);
        } catch (IOException e) {
            e.printStackTrace();
        }
        FilesWrite file = new FilesWrite();
        try {
            file.writeContact();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeBin() throws IOException {
        try (DataOutputStream someFile = new DataOutputStream(new FileOutputStream("ata.bin"))) {
            someFile.writeInt(12);
        }
    }


    private static void createHelloWorld() throws IOException {
        try (PrintWriter file = new PrintWriter(new FileOutputStream("Hello Java.txt"))) {
            file.print("Hello world");
        }
    }

    public static void createRandomInt() throws IOException {
        try (PrintWriter file = new PrintWriter(new FileOutputStream("Randomize.txt"))) {
            for (int i = 0; i <= 1000; i++) {
                int numb = (int) (-500 + Math.random() * (651 + 500));
                file.print(numb);
                file.print(",");
            }
        }
    }

    public static void readHundred(int size) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("Randomize.txt"), StandardCharsets.UTF_8))) {
            String line;
            List<Integer> collection = new ArrayList<>(size);
            while ((line = reader.readLine()) != null && collection.size() <= size) {
                stringToIntArray(line, collection);
            }
            getAverage(collection);
        }
    }

    private static void stringToIntArray(String line, List<Integer> collection) {
        String[] array = line.split(",");
        for (String s : array) {
            collection.add(Integer.valueOf(s));
        }
    }

    private static void getAverage(List<Integer> collection) {
        int positive = 0;
        int count = 0;
        for (Integer integer : collection) {
            if (integer > 0) {
                positive = positive + integer;
                count++;
            }
        }
        if (count > 0) {
            int middle = positive / count;
            System.out.println("Average " + middle);
        } else {
            System.out.println("No positive numbers");
        }
    }
}

