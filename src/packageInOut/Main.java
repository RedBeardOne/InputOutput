package packageInOut;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("[a-zA-Z]+\\.[a-zA-Z]+");
        String one;
        Matcher matcher = pattern.matcher(args[0]);
        if (matcher.find()) {
            one = matcher.group(0);
        } else {
            return;
        }
        StringBuilder way = new StringBuilder("D:\\");
        way.append(one);
        System.out.println(way);
    }
}
