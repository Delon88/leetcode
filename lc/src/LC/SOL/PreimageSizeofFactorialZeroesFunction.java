package LC.SOL;

public class PreimageSizeofFactorialZeroesFunction {
    //    Let f(x) be the number of zeroes at the end of x!. (Recall that x! = 1 * 2 * 3 * ... * x, and by convention, 0! = 1.)
//
//    For example, f(3) = 0 because 3! = 6 has no zeroes at the end, while f(11) = 2
//    because 11! = 39916800 has 2 zeroes at the end. Given K, find how many non-negative integers x have the property that f(x) = K.
//
//    Example 1:
//    Input: K = 0
//    Output: 5
//    Explanation: 0!, 1!, 2!, 3!, and 4! end with K = 0 zeroes.
//
//            Example 2:
//    Input: K = 5
//    Output: 0
//    Explanation: There is no x such that x! ends in K = 5 zeroes.
    static class Solution {
        public int preimageSizeFZF(int K) {
            if (K == 0) return 5;

            long t1 = bs(K + 1);
            long t2 = bs(K);
            if (count(t2) != K) return 0;
            else return (int) (t1 - t2);
        }

        long bs(int K) {
            long start = 0, end = 5L * (K + 1), mid = 0;

            while (start < end) {
                mid = start + (end - start) / 2;
                if (count(mid) >= K) {
                    end = mid;
                } else {
                    start = mid + 1;
                }
            }
            return start;
        }

        long count(long N) {
            long count = 0;
            for (long i = N; i >= 5; i /= 5) {
                count += (i / 5);
            }
            return count;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().preimageSizeFZF(1000000000));
    }
}
