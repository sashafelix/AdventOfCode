package AOC2020;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class DayFour {
    public static void main(String[] args) throws IOException {
        List<String> entries = new ArrayList<>();
        AtomicReference<String> passport = new AtomicReference<>("");
        Files.lines(Path.of("src/AOC2020/Resources/inputDayFour.txt")).forEach(s -> {
            if (s.equals("")) {
                entries.add(passport.get());
                passport.set("");
            }
            passport.set(passport + s + " ");
        });
        entries.add(passport.get() + " ");
        int validPassport = 0;
        ArrayList<Object> eclCheck = new ArrayList<>();
        eclCheck.add("amb");
        eclCheck.add("blu");
        eclCheck.add("brn");
        eclCheck.add("gry");
        eclCheck.add("grn");
        eclCheck.add("hzl");
        eclCheck.add("oth");
        char hash = '#';
        String cm = "cm";
        String in = "in";
        int heightInCM = 0;
        int heightInIn = 0;
//        System.out.println(entries.size());

        for (int i = 0; i < entries.size(); i++) {
            String entry = entries.get(i);
            if (entry.contains("byr") &&
                    entry.contains("iyr") &&
                    entry.contains("eyr") &&
                    entry.contains("hgt") &&
                    entry.contains("hcl") &&
                    entry.contains("ecl") &&
                    entry.contains("pid")) {

//                System.out.println(entry);

                int byrValue = Integer.parseInt(entry.substring(entry.indexOf("byr") + 4, entry.indexOf(" ", entry.indexOf("byr"))));
                int iyrValue = Integer.parseInt(entry.substring(entry.indexOf("iyr") + 4, entry.indexOf(" ", entry.indexOf("iyr"))));
                int eyrValue = Integer.parseInt(entry.substring(entry.indexOf("eyr") + 4, entry.indexOf(" ", entry.indexOf("eyr"))));
                String hgtValue = entry.substring(entry.indexOf("hgt") + 4, entry.indexOf(" ", entry.indexOf("hgt")));
                String hclValue = entry.substring(entry.indexOf("hcl") + 4, entry.indexOf(" ", entry.indexOf("hcl")));
                String eclValue = entry.substring(entry.indexOf("ecl") + 4, entry.indexOf(" ", entry.indexOf("ecl")));
                String pidValue = entry.substring(entry.indexOf("pid") + 4, entry.indexOf(" ", entry.indexOf("pid")));


                int cmHeight = 0;
                if(hgtValue.length() == 5 && hgtValue.contains("cm")){
//                    && cmHeight <= 193 && cmHeight >= 153
                    cmHeight = Integer.parseInt(hgtValue.substring(0, 3));
                    System.out.println(cmHeight);

                }
                if (byrValue >= 1920 && byrValue <= 2002 &&
                        iyrValue >= 2010 && iyrValue <= 2020 &&
                        eyrValue >= 2020 && eyrValue <= 2030 &&
                        eclCheck.contains(eclValue) &&
                        hclValue.toUpperCase().matches("[#A-F0-9]+") &&
                        hclValue.length() == 7 &&
                        hclValue.charAt(0) == hash &&
                        pidValue.length() == 9 &&
                        pidValue.matches("[0-9]+") &&
                        cmHeight >= 158 || cmHeight <= 193) {
                    validPassport++;
                }
            }
        }
        System.out.println(validPassport);
    }
}

