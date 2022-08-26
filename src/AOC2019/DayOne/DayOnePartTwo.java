package AOC2019.DayOne;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class DayOnePartTwo {
    private static int fuelSum = 0;
    private static int fuelSum2 = 0;

    public static void main(String[] args) throws IOException {
        Files.lines(Path.of("src/resources/DayOne.txt")).forEach(s -> {
            fuelSum += fuelCalc(Integer.valueOf(s));
            fuelSum2 += fuelMassCalc(Integer.valueOf(s));
        });
        System.out.println(fuelSum);
        System.out.println(fuelSum2);
    }

    private static int fuelCalc(int mass) {
        return (int) ((Math.floor(mass / 3)) - 2);
    }

    private static int fuelMassCalc(int mass) {
        int fuel = fuelCalc(mass);
        if (fuel > 0) {
            return fuel + fuelMassCalc(fuel);
        }
        return 0;
    }
}