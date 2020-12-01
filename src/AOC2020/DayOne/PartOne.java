package AOC2020.DayOne;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class PartOne {
    public static void main(String[] args) throws IOException {

        ArrayList<Integer> expenses = new ArrayList<>();
        Files.lines(Path.of("src/resources/inputPartOne.txt")).forEach(s -> {
            expenses.add(Integer.valueOf(s));
        });

        int base = 0;
        for (Integer a : expenses) {
            for (Integer b : expenses) {
                for (Integer c : expenses) {
                    if ((a + b + c) == 2020) {
                        System.out.println(a * b * c);
                    }
                }
            }
        }
    }
}
