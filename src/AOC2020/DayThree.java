package AOC2020;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class DayThree {
    public static void main(String[] args) throws IOException {
        char[][] map = new char[323][31];
        AtomicInteger count = new AtomicInteger(0);
        int treecount = 0;
        int x = 0;
        int y = 1;
        Files.lines(Path.of("src/resources/inputDayThree.txt")).forEach(s -> {
            map[count.get()] = s.toCharArray();
            count.getAndAdd(1);
        });
        for (int i = 0; i <= map.length; i++) {
            if(y >= 323){
                break;
            }
            x = x + 7;x = x % 31;
            if(map[y][x] == '#'){
                treecount++;
            }
            System.out.println("X: " + x);
            System.out.println("Y: " + y);
            System.out.println(map[y][x]);
            y = y + 1;
        }
        System.out.println(treecount);
        System.out.println(50*148*53*64*29);
    }
}

