package AOC2020;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class DayFour {
    public static void main(String[] args) throws IOException {
        List<String> entries = new ArrayList<>();
        AtomicReference<String> passport = new AtomicReference<>("");
        Files.lines(Path.of("src/resources/inputDayFour.txt")).forEach(s -> {
            if (s.equals("")) {
                entries.add(passport.get());
                passport.set("");
            }
            passport.set(passport + " " + s);
        });
        entries.add(passport.get() + " ");
        int validPassport = 0;
        System.out.println(entries.size());

        for (int i = 0; i < entries.size(); i++) {
            String entry = entries.get(i);
            if (entry.contains("byr") &&
                    entry.contains("iyr") &&
                    entry.contains("eyr") &&
                    entry.contains("hgt") &&
                    entry.contains("hcl") &&
                    entry.contains("ecl") &&
                    entry.contains("pid")) {

                int byrIndex = Integer.parseInt(entries.get(i).substring(entries.get(i).indexOf("byr")+4, entries.get(i).indexOf(" ", entries.get(i).indexOf("byr"))));
                System.out.println(byrIndex);
//                int byrIndex = Integer.parseInt(entry.substring(entry.indexOf("byr") + 4, entry.indexOf(" ", entry.indexOf("byr"))));
//                validPassport++;
            }
        }
        System.out.println(validPassport);
    }
}

