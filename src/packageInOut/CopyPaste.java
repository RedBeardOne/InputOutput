package packageInOut;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CopyPaste {
    public static void main(String[] args) {
        int i = 0;
        if (args == null) {
            System.out.println("Please set args");
            return;
        }
        String address = args[0];
        try {
            readWriteBigFile(address);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readWriteBigFile(String address) throws IOException {
        long start = System.currentTimeMillis();
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream(address);

            String str = getName(address);
            fos = new FileOutputStream(str);
            byte[] buffer = new byte[4096];
            int read = 0;
            int len = 0;
            while ((read = fis.read(buffer)) !=-1) {
                fos.write(buffer, 0, len);
            }
        } finally {
            if (fis != null) {
                fis.close();
            }
            if (fos != null) {
                fos.close();
            }
        }
        long finish = System.currentTimeMillis();
        long timeElapsed = finish - start;
        System.out.println(timeElapsed);
    }

    public static void readWriteBigFilePerByte(String address) throws IOException {
        long start = System.currentTimeMillis();
        String str = getName(address);
        try (FileInputStream fis = new FileInputStream(address)) {
            try (FileOutputStream fos = new FileOutputStream(str)) {
                int read = 0;
                while ((read = fis.read()) != -1) {
                    fos.write(read);
                }
            }
        }
        long finish = System.currentTimeMillis();
        long timeElapsed = finish - start;
        System.out.println(timeElapsed);
    }

     public static void readWriteBigFileBuffer(String address) throws IOException{
         long start = System.currentTimeMillis();
         int read = 0;
         String str = getName(address);
         try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(address), 4096)){
             try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(str), 4096)){
                 while ((read = bis.read())!=-1){
                     bos.write(read);
                 }
             }
         }
         long finish = System.currentTimeMillis();
         long timeElapsed = finish - start;
         System.out.println(timeElapsed);
     }
    public static void readWriteBigFileBufferPerBit(String address) throws IOException{
        long start = System.currentTimeMillis();
        int read = 0;
        String str = getName(address);
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(address))){
            try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(str))){
                while ((read = bis.read())!=-1){
                    bos.write(read);
                }
            }
        }
        long finish = System.currentTimeMillis();
        long timeElapsed = finish - start;
        System.out.println(timeElapsed);
    }

    private static String getName(String address) {
        Pattern pattern = Pattern.compile("[a-zA-Z]+\\.[a-zA-Z]+");
        String one = null;
        Matcher matcher = pattern.matcher(address);
        if (matcher.find()) {
            one = matcher.group(0);
        } else {
            System.out.println("Not found coincidences");
        }
        String way = "D:\\" + one;
        return way;
    }
}

