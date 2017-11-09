package LC.SOL;

import java.util.Scanner;

public class SolvetheEquation {
    class Solution {
        public String solveEquation(String equation) {
            String[] parts = equation.split("=");
            Scanner scan = new Scanner(parts[0]).useDelimiter("(?=[-+])");
            int[] left = getXandNumber(scan);
            scan = new Scanner(parts[1]).useDelimiter("(?=[-+])");
            int[] right = getXandNumber(scan);
            if (left[0] - right[0] == 0) {
                if (left[1] != right[1]) {
                    return "No solution";
                } else {
                    return "Infinite solutions";
                }
            } else {
                return "x=" + ((right[1] - left[1]) / (left[0] - right[0]));
            }
        }

        int[] getXandNumber(Scanner scan) {
            int[] ret = {0, 0};
            while (scan.hasNext()) {
                String next = scan.next();
                if (next.contains("x")) {
                    next = next.replaceAll("x", "");
                    if (next.equals("+") || next.equals("")) {
                        ret[0]++;
                    } else if (next.equals("-")) {
                        ret[0]--;
                    } else {
                        ret[0] += Integer.parseInt(next);
                    }
                } else {
                    ret[1] += Integer.parseInt(next);
                }
            }
            return ret;
        }
    }
}
