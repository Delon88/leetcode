package LC.SOL;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class RevealCardsInIncreasingOrder {
    class Solution {
        public int[] deckRevealedIncreasing(int[] deck) {
            int n = deck.length;
            Arrays.sort(deck);
            Queue<Integer> q = new LinkedList<>();
            for ( int i = 0 ; i < n ; i++) q.add(i);
            int[] ret = new int[n];
            for ( int i = 0 ; i < n ; i++) {
                ret[q.poll()] = deck[i];
                q.offer(q.poll());
            }
            return ret;
        }
    }
}
