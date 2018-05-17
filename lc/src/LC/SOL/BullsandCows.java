package LC.SOL;

public class BullsandCows {
    class Solution {
        public String getHint(String secret, String guess) {
            int[] sCount = new int[10];
            int[] gCount = new int[10];
            int bull = 0, cow = 0;
            for (int i = 0; i < secret.length(); i++) {
                int s = secret.charAt(i), g = guess.charAt(i);
                if (s == g) {
                    bull++;
                } else {
                    sCount[s - '0']++;
                    gCount[g - '0']++;
                }
            }
            for ( int i = 0 ; i < 10 ; i++) {
                cow += Math.min(sCount[i] , gCount[i]);
            }
            return bull + "A" + cow + "B";
        }
    }
}
