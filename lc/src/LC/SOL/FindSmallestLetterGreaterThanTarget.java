package LC.SOL;

public class FindSmallestLetterGreaterThanTarget {
    class Solution {
        public char nextGreatestLetter(char[] letters, char target) {
            int n = letters.length;
            if (target >= letters[n - 1]) return letters[0];
            else target++;

            int start = 0, end = n - 1;
            while (start < end) {
                int mid = start + (end - start) / 2;
                if (letters[mid] == target) return letters[mid];
                else if (letters[mid] > target) end = mid;
                else start = mid + 1;
            }
            return letters[end];
        }
    }
}
