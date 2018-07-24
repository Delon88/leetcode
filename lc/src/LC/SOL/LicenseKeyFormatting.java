package LC.SOL;

public class LicenseKeyFormatting {
    class Solution {
        public String licenseKeyFormatting(String S, int K) {
            StringBuilder b = new StringBuilder();
            int count = 0;
            for ( int i = S.length() - 1; i >= 0 ; i--) {
                char c = S.charAt(i);
                if ( c != '-') {
                    count++;
                    b.append(Character.toUpperCase(c));
                    if ( count == K ) {
                        b.append('-');
                        count = 0;
                    }
                }
            }
            if ( b.length() > 0 && b.charAt(b.length()- 1) == '-') b.deleteCharAt(b.length() - 1);
            return b.reverse().toString();
        }
    }
}
