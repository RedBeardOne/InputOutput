package packageInOut;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

public class FilesWrite {

    public void writeContact() throws IOException {
        try (PrintWriter write = new PrintWriter(new FileOutputStream ("Contact.bin"))){
            write.println("Vasya | Ivanov | 0732281113 | 1985");
            write.println("Serhiy | Azinov | 0932212153 | 1990");
            write.println("Anri | Jogi | 0946612153 | 1992");
            write.println("Jack | Kobi | 0950002153 | 1991");
            write.println("Zack | Snyder | 0669745453 | 1980");
            write.println("Anya | Kolityna | 0995553457 | 1981");
            write.println("Serhiy | Sobyanin | 0958012153 | 1969");
            write.println("Olha | Hyper | 0662671133 | 1999");
            write.println("Kostay | Azinov | 0734513173 | 2008");
            write.println("Mike | Zybrov | 0959012490 | 1970");
        }
    }
}
