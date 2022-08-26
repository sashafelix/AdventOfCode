package Tools;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class InputScanner {
    private ArrayList<String> result = new ArrayList<>();

    public InputScanner(File input){
        try (Scanner in = new Scanner((new FileReader(input)))) {
            while (in.hasNext()) {
                result.add(in.nextLine());
            }
        }
        catch (Exception e)
        {
            System.err.println(e);
        }
    }

    public ArrayList<String> getResult() { return result; }
}
