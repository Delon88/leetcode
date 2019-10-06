package LC.SOL;

public class DefanginganIPAddress {
    class Solution {
        public String defangIPaddr(String address) {
            return address.replaceAll("\\.", "\\[\\.\\]");
        }
    }
}
