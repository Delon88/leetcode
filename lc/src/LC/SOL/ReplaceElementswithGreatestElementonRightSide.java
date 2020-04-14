package LC.SOL;

public class ReplaceElementswithGreatestElementonRightSide {
    class Solution {
        public int[] replaceElements(int[] arr) {
            if (arr.length == 0) return arr;
            int n = arr.length, max = -1;
            for (int i = n - 1; i >= 0; i--) {
                int tmp = arr[i];
                arr[i] = max;
                max = Math.max(tmp, max);
            }
            return arr;
        }
    }
}
