package AOC2020;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.atomic.AtomicInteger;


public class DayTwo {
    public static void main(String[] args) throws IOException {
        System.out.println(readFile());
    }

    public static AtomicInteger readFile() throws IOException {
        AtomicInteger validPasswords = new AtomicInteger(0);
        Files.lines(Path.of("src/resources/inputDayTwo.txt")).forEach(s -> {
            int min = Integer.parseInt(s.substring(0, s.indexOf("-")));
            int max = Integer.parseInt(s.substring(s.indexOf("-") + 1, s.indexOf(" ")));
            String key = s.substring(s.indexOf(" ") + 1, s.indexOf(":"));
            String password = s.substring(s.indexOf(":") + 2, s.length());

            if (countKey(password, key, min, max) > 0) {
                validPasswords.addAndGet(1);
            }
        });
        return validPasswords;
    }

    public static int countKey(String str, String key, int min, int max) {
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(min - 1) == key.charAt(0) ^ str.charAt(max - 1) == key.charAt(0)) {
                return 1;
            }
        }
        return 0;
    }
}
