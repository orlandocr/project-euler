/*
Names scores
Problem 22
Using names.txt (right click and 'Save Link/Target As...'), a 46K text file containing over five-thousand first names, begin by sorting it into alphabetical order. Then working out the alphabetical value for each name, multiply this value by its alphabetical position in the list to obtain a name score.

For example, when the list is sorted into alphabetical order, COLIN, which is worth 3 + 15 + 12 + 9 + 14 = 53, is the 938th name in the list. So, COLIN would obtain a score of 938 × 53 = 49714.

What is the total of all the name scores in the file?
*/

package cr.orly.euler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Euler022
{

    private static final String FILENAME = "z:\\names.txt";

    private List<String> readTextFile(String fileName)
    {
        List<String> names = new ArrayList<String>();
        
        try(BufferedReader br = new BufferedReader(new FileReader(fileName)))
        {
            readLines(names, br);
        } catch (Exception e) {
             System.err.println("FAIL " + e);
        }
        
        return names;
    }

    private void readLines(List<String> names, BufferedReader br) throws IOException
    {
        String line = br.readLine();
        while (line != null) {
            processLine(names, line);
            line = br.readLine();
        }
    }

    private void processLine(List<String> names, String line) {
        line = line.replace("\"", "");
        String[] lineNames = line.split(",");
        for(String lineName: lineNames)
        {
            names.add(lineName);
        }
    }
    
    private int calculateNameScore(String name, int idx)
    {
        assert(isAllUppercase(name));

        int charValues = 0;
        for(char c : name.toCharArray())
        {
            int charValue = c - 'A' + 1;
            charValues += charValue;
        }
        int nameScore = charValues * idx;
        return nameScore;
    }
    
    private boolean isAllUppercase(String name) {
        return name.equals(name.toUpperCase());
    }

    private long calculateTotal(List<String> names)
    {
        Collections.sort(names);
        long total = 0;
        for(int i = 0; i < names.size(); i++)
        {
            String name = names.get(i);
            total += calculateNameScore(name, (i+1));
        }
        return total;
    }
    
    private long calculateTotal()
    {
        List<String> names = readTextFile(FILENAME);
        long total = calculateTotal(names);
        return total;
    }
    
    public static void main(String... args)
    {
        Euler022 e = new Euler022();
        long total = e.calculateTotal();
        System.out.println("The total of all the name scores in the file is " + total);
    }

    
    //NOT 3341480725

}
