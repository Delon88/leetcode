package LC.SOL;

public class ComplementofBase10Integer {
    class Solution {
        public int bitwiseComplement(int N) {
            int X = 1;
            while ( X < N ) X = X * 2 + 1;
            return X - N;
        }
    }
}
