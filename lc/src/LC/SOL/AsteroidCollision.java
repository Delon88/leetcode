package LC.SOL;

import java.util.Stack;

public class AsteroidCollision {
    class Solution {
        public int[] asteroidCollision(int[] asteroids) {
            Stack<Integer> pos = new Stack<>();
            Stack<Integer> neg = new Stack<>();
            for (int i = 0; i < asteroids.length; i++) {
                int a = asteroids[i];
                if (a > 0) {
                    if (neg.isEmpty()) {
                        pos.push(i);
                    } else {
                        while (!neg.isEmpty() && Math.abs(asteroids[neg.peek()]) < a) neg.pop();
                        if (neg.isEmpty()) pos.push(i);
                        else if (!neg.isEmpty() && Math.abs(asteroids[neg.peek()]) == a) neg.pop();
                    }
                } else {
                    if (pos.isEmpty()) {
                        neg.push(i);
                    } else {
                        while (!pos.isEmpty() && asteroids[pos.peek()] < Math.abs(a)) pos.pop();
                        if (pos.isEmpty()) neg.push(i);
                        else if (!pos.isEmpty() && asteroids[pos.peek()] == Math.abs(a)) pos.pop();
                    }
                }
            }
            int[] ret = new int[0];
            if (!pos.isEmpty()) {
                ret = new int[pos.size()];
                int i = pos.size() - 1;
                while (!pos.isEmpty()) {
                    ret[i--] = asteroids[pos.pop()];
                }
            } else if (!neg.isEmpty()) {
                ret = new int[neg.size()];
                int i = neg.size() - 1;
                while (!neg.isEmpty()) {
                    ret[i--] = asteroids[neg.pop()];
                }
            }
            return ret;
        }
    }
}
