package Tools;

import java.io.File;

public class DataTray {

    private DataTray(){}

    public static File getInput(int day)
    {
        return new File("data/Day "+((day < 10)?"0"+day:day)+"/DayOne.txt");
    }
    public static File getTest(int day)
    {
        return new File("src/AOC2021/Resources/Sample.txt");
    }
}
