package AOC2019.DayTwo;

import java.util.Arrays;

public class DayTwoPartTwo {
    public static void main(String[] args) {

        int input[] = {1, 12, 2, 3, 1, 1, 2, 3, 1, 3, 4, 3, 1, 5, 0, 3, 2, 9, 1, 19, 1, 19, 5, 23, 1, 23, 5, 27, 2, 27, 10, 31, 1, 31, 9, 35, 1, 35, 5, 39, 1, 6, 39, 43, 2, 9, 43, 47, 1, 5, 47, 51, 2, 6, 51, 55, 1, 5, 55, 59, 2, 10, 59, 63, 1, 63, 6, 67, 2, 67, 6, 71, 2, 10, 71, 75, 1, 6, 75, 79, 2, 79, 9, 83, 1, 83, 5, 87, 1, 87, 9, 91, 1, 91, 9, 95, 1, 10, 95, 99, 1, 99, 13, 103, 2, 6, 103, 107, 1, 107, 5, 111, 1, 6, 111, 115, 1, 9, 115, 119, 1, 119, 9, 123, 2, 123, 10, 127, 1, 6, 127, 131, 2, 131, 13, 135, 1, 13, 135, 139, 1, 9, 139, 143, 1, 9, 143, 147, 1, 147, 13, 151, 1, 151, 9, 155, 1, 155, 13, 159, 1, 6, 159, 163, 1, 13, 163, 167, 1, 2, 167, 171, 1, 171, 13, 0, 99, 2, 0, 14, 0};
        intCode(input);
    }

    private static void intCode(int[] input) {
        int a = 0;
        for (int i = 0; i < input.length; i++) {
            if (input[a] == 1) {
                int x = input[a + 1];
                int y = input[a + 2];
                int z = input[a + 3];
                input[z] = input[x] + input[y];
                a += 4;
                System.out.println("[" + a + " : " + x + " : " + y + " : " + z + "]");
            } else if (input[a] == 2) {
                int x = input[a + 1];
                int y = input[a + 2];
                int z = input[a + 3];
                input[z] = input[x] * input[y];
                a += 4;
                System.out.println("[" + a + " : " + x + " : " + y + " : " + z + "]");
            } else if (input[a] == 99) {
                break;
            }
        }
        System.out.println(Arrays.toString(input));
    }
}