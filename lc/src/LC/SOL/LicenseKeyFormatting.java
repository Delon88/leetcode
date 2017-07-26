package LC.SOL;

public class LicenseKeyFormatting {
    public class Solution {
        public String licenseKeyFormatting(String S, int K) {
            StringBuilder b = new StringBuilder();
            int groupLen = 0;
            for (int i = S.length() - 1; i >= 0; i--) {
                if (S.charAt(i) != '-') {
                    b.append(Character.toUpperCase(S.charAt(i)));
                    groupLen++;
                    if (groupLen == K) {
                        b.append('-');
                        groupLen = 0;
                    }
                }
            }
            if (b.length() > 0 && b.charAt(b.length() - 1) == '-') b.deleteCharAt(b.length() - 1);
            b.reverse();
            return b.toString();
        }
    }
}
