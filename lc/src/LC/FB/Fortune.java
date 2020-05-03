package LC.FB;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Fortune {

    public String fortune(String fileName) {
        int i = 1;
        String ret = "";
        Random rn = new Random();
        try (Scanner scanner = new Scanner(new BufferedReader(new FileReader(fileName)))) {
            scanner.useDelimiter("%");
            while (scanner.hasNext()) {
                int r = rn.nextInt(i);
                String ele = scanner.next();
                if (r == 0) ret = ele;
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ret;
    }

    public static void main(String args[]) {
        System.out.println(new Fortune().fortune("/Users/admin/Documents/1.txt"));
    }

}
