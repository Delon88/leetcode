package LC.SOL;

public class ExcelSheetColumnTitle {
    class Solution {
        public String convertToTitle(int n) {
            StringBuilder b = new StringBuilder();
            while ( n > 0 ) {
                n--;
                b.insert(0, (char) ((n % 26) + 'A'));
                n /=  26;
            }
            return b.toString();
        }
    }

}
