package AOC2019.DayOne;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class DayOnePartOne {
    private static int fuelSum = 0;

    public static void main(String[] args) throws IOException {
        Files.lines(Path.of("src/resources/input.txt")).forEach(s -> {
            fuelSum += fuelCalc(Integer.valueOf(s));
        });
        System.out.println(fuelSum);
    }

    private static int fuelCalc(int mass) {
        return (int) ((Math.floor(mass / 3)) - 2);
    }
}
