package AOC2021;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.IntStream;

public class DayTwo {

    private static int position = 0;
    private static int depth = 0;
    private static int aim = 0;
    private static final File path = new File("src/AOC2021/Resources/DayTwo.txt");

    public static void main(String[] args) throws IOException {
        partTwo();
    }

    public static void partOne() throws IOException {
        List<String> movementDirection = new ArrayList<>();
        List<Integer> movementValue = new ArrayList<>();
        String line;
        BufferedReader reader = new BufferedReader(new FileReader(path));
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(" ");
            if (parts.length >= 2) {
                String direction = parts[0].trim();
                int value = Integer.parseInt(parts[1].trim());
                movementDirection.add(direction);
                movementValue.add(value);
            }
        }
        for (int i = 0; i < movementDirection.size(); i++) {
            if (movementDirection.get(i).equals("forward")){
                position += movementValue.get(i);
            } else if (movementDirection.get(i).equals("down")){
                depth += movementValue.get(i);
            } else {
                depth -= movementValue.get(i);
            }
        }
        System.out.println(position * depth);
    }

    public static void partTwo() throws IOException {
        List<String> movementDirection = new ArrayList<>();
        List<Integer> movementValue = new ArrayList<>();
        String line;
        BufferedReader reader = new BufferedReader(new FileReader(path));
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(" ");
            if (parts.length >= 2) {
                String direction = parts[0].trim();
                int value = Integer.parseInt(parts[1].trim());
                movementDirection.add(direction);
                movementValue.add(value);
            }
        }
        IntStream.range(0, movementDirection.size()).forEach(i -> {
            switch (movementDirection.get(i)){
                case "forward":
                    position += movementValue.get(i);
                    depth += movementValue.get(i) * aim;
                    break;
                case "down":
                    aim += movementValue.get(i);
                    break;
                case "up":
                    aim -= movementValue.get(i);
                    break;
            }
            System.out.println("Position: " + position + " || " + "Movement: " + movementValue.get(i) + " || " + "Aim: " + aim + " || " + "Depth: " + depth);
        });
        System.out.println(position * depth);
    }
}
