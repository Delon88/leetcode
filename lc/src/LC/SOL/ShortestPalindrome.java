package LC.SOL;

public class ShortestPalindrome {
    class Solution {
        public String shortestPalindrome(String s) {
            int start = 0, end = s.length() - 1;
            for (; end >= 0; end--) {
                if (s.charAt(start) == s.charAt(end)) start++;
            }
            if (start == s.length()) return s;
            String suffix = s.substring(start);
            return new StringBuilder(suffix).reverse().toString() + shortestPalindrome(s.substring(0, start)) + suffix;
        }
    }
    /**
     Report
     My attempt at an explanation:
     The intuition: We know that it is possible to turn any string into a palindrome by simply concatenating it with its reverse: Ex. aabba + abbaa = aabbaabbaa. But this is not the shortest palindrome. If we could find a palindrome that is a prefix of aabba we could place it in the middle. By placing it in the middle we no longer would need to reverse it and we could only need to reverse the remainder of the string.
     So the longest prefix of aabba that is a palindrome is aa. We can place aa in the middle and perform the reverse trick around it: abb + aa + bba = abbaabba which is the shortest palindrome.

     for (int i = s.length() - 1; i >= 0; i--) {
     if (s.charAt(i) == s.charAt(j)) { j += 1; }
     }
     This loop is tricky. Since the goal is to reduce the number of elements that you have to reverse and concatenate we calculate j as the index which splits the array into two parts.

     s.substring(j) is the suffix that (from the calculation of equal elements) has to be reversed in order to create a palindrome
     s.substring(0,j) is the prefix which may or may not be a palindrome, but is passed to the next recursive call in order to determine.
     Because i goes from len-1 to 0 and j goes from 0 to len-1 they will always cross and s.charAt(i) will equal s.charAt(j). This means j will always be greater than 0, causing the recursion to terminate and guaranteeing a worse case of O(N^2)
     */
}
