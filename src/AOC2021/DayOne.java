package AOC2021;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class DayOne {
    public static int currentValue = 0;
    public static void main(String[] args) throws IOException {
        partTwo();
    }

    public static void partOne() throws IOException {
        AtomicInteger measurementCount = new AtomicInteger();
        measurementCount.set(-1);
        Files.lines(Path.of("src/AOC2021/Resources/DayOne.txt")).forEach(s -> {
            if (Integer.valueOf(s) > (currentValue)){
                measurementCount.getAndAdd(1);
            }
            currentValue = (Integer.parseInt(s));
        });
        System.out.println(measurementCount);
    }

    public static void partTwo() throws IOException {
        Scanner scanner = new Scanner(new File("src/AOC2021/Resources/DayOne.txt"));

        int count = 0;
        int[] currentWindow = { scanner.nextInt(), scanner.nextInt(), scanner.nextInt() };
        while (scanner.hasNextInt()) {
            int next = scanner.nextInt();
            if (next > currentWindow[0]) {
                count++;
            }
            currentWindow[0] = currentWindow[1];
            currentWindow[1] = currentWindow[2];
            currentWindow[2] = next;
        }
        System.out.println(count);
    }
}
