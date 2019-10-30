package LC.SOL;

public class IntegertoEnglishWords {
    class Solution {

        private final String[] lessThan20 = {"", "One", "Two", "Three", "Four", "Five" , "Six" , "Seven" , "Eight", "Nine",
        "Ten" , "Eleven" , "Twelve" , "Thirteen" , "Fourteen" , "Fifteen" , "Sixteen" , "Seventeen" , "Eighteen" , "Nineteen"};

        private final String[] tens = {"" , "Ten" , "Twenty" , "Thirty", "Forty" , "Fifty" , "Sixty" , "Seventy" , "Eighty" , "Ninety"};

        private final String[] thousands = {"" , "Thousand" , "Million" , "Billion"};

        public String numberToWords(int num) {
            if ( num == 0) return "Zero";
            String w = "";
            int unitIndex = 0;
            while ( num > 0 ) {
                if ( num % 1000 != 0) {
                    w = getWord(num % 1000 ) + thousands[unitIndex] + " "+ w;
                }
                num /= 1000;
                unitIndex++;
            }
            return w.trim();
        }

        String getWord(int num) {
            if ( num == 0 ) return "";
            if ( num < 20 ) {
                return lessThan20[num] + " ";
            } else if ( num < 100) {
                return tens[num / 10] + " " + getWord(num % 10);
            } else {
                return  lessThan20[num / 100]+ " Hundred " + getWord(num % 100);
            }
        }
    }
}
