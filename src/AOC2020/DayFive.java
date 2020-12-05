package AOC2020;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class DayFive {
    public static void main(String[] args) throws IOException {
        List<String> seats = new ArrayList<>();
        Files.lines(Path.of("src/resources/inputDayFive.txt")).forEach(seats::add);

        List<Integer> ids = seats
                .stream()
                .mapToInt(s -> {
                    return (parseRow(s) * 8) + parseCol(s);
                }).boxed()
                .sorted()
                .collect(Collectors.toList());

        int maxID = ids.stream()
                .mapToInt(v -> v)
                .max()
                .orElseThrow(NoSuchElementException::new);

        System.out.println("[Part1] Highest seat ID: " + maxID);

        int expectedSeat = ids.get(0);
        for (Integer id : ids) {
            if (id != expectedSeat) {
                System.out.println("[Part2] My seat: " + expectedSeat);
                break;
            }
            ++expectedSeat;
        }
    }

    public static int parseRow(String s) {
        int lower = 0, upper = 127, rows = 128;

        for (int i = 0; i < 7; i++) {
            rows = rows / 2;
            if (s.charAt(i) == 'F') {
                upper -= rows;
            } else {
                lower += rows;
            }
        }
        return lower;
    }


    public static int parseCol(String s) {
        int lower = 0, upper = 7, cols = 8;
        for (int i = 7; i < s.length(); i++) {
            cols = cols / 2;
            if (s.charAt(i) == 'L') {
                upper -= cols;
            } else {
                lower += cols;
            }
        }
        return lower;
    }
}



