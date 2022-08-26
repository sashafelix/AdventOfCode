package AOC2018.DayOne;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class DayOne {

    private static final File PATH = new File("src/AOC2018/Resources/DayOne.txt");
    private static ArrayList<String> frequencyChangeSymbol = new ArrayList<>();
    private static ArrayList<Integer> frequencyChangeValue = new ArrayList<>();
    private static ArrayList<Integer> firstRepeat = new ArrayList<>();
    private static int firstRepeatedFrequency = 0;
    private static int frequency = 0;

    public static void main(String[] args) throws IOException {
        readInputFile();
        findFrequency();
        findFirstDuplicateFrequency();

        // Print out results
        System.out.println("Part One: " + frequency);
        System.out.println("Part Two: " + firstRepeatedFrequency);
    }

    public static void readInputFile() throws IOException {
        // Read the input file line by line and split the symbol and value into an array list
        String line;
        BufferedReader reader = new BufferedReader(new FileReader(PATH));
        while ((line = reader.readLine()) != null) {
            frequencyChangeSymbol.add(line.substring(0, 1));
            frequencyChangeValue.add(Integer.valueOf(line.substring(1)));
        }
    }

    public static void findFrequency() {
        // Loop through array lists and calculate final frequency
        for (int i = 0; i < frequencyChangeValue.size(); i++) {
            if (frequencyChangeSymbol.get(i).equals("+")) {
                frequency = frequency + frequencyChangeValue.get(i);
                firstRepeat.add(frequency);
            } else if (frequencyChangeSymbol.get(i).equals("-")) {
                frequency = frequency - frequencyChangeValue.get(i);
                firstRepeat.add(frequency);
            }
        }
    }

    public static void findFirstDuplicateFrequency() {
        for (int i = 0; i < firstRepeat.size(); i++) {
            for (int j = i + 1; j < firstRepeat.size() - 1; j++) {
                if (firstRepeat.get(i).equals(firstRepeat.get(j))) {
                    System.out.println(firstRepeat.get(i));
                    System.out.println(firstRepeat.get(j));
                    firstRepeatedFrequency = firstRepeat.get(i);
                    break;
                }
            }
        }
    }
}

