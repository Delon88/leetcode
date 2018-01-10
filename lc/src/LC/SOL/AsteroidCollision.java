package LC.SOL;

import java.util.Stack;

public class AsteroidCollision {
    class Solution {
        public int[] asteroidCollision(int[] asteroids) {
            Stack<Integer> neg = new Stack<>();
            Stack<Integer> pos = new Stack<>();
            for (int i = 0; i < asteroids.length; i++) {
                int a = asteroids[i];
                if (a > 0) {
                    pos.push(i);
                } else {
                    while (!pos.isEmpty() && asteroids[pos.peek()] < Math.abs(a)) pos.pop();
                    if (pos.isEmpty()) neg.push(i);
                    else if (!pos.isEmpty() && Math.abs(a) == asteroids[pos.peek()]) pos.pop();
                }
            }
            int[] ret = new int[neg.size() + pos.size()];
            int i = ret.length - 1;
            while (!pos.isEmpty()) {
                ret[i--] = asteroids[pos.pop()];
            }
            while (!neg.isEmpty()) {
                ret[i--] = asteroids[neg.pop()];
            }
            return ret;
        }
    }
}
