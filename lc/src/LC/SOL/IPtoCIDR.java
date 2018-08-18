package LC.SOL;

import java.util.ArrayList;
import java.util.List;

public class IPtoCIDR {
    class Solution {
        public List<String> ipToCIDR(String ip, int n) {
            String[] ipStr = ip.split("\\.");
            long x = 0;
            for (int i = 0; i < 4; i++) {
                x = x * 256 + Integer.parseInt(ipStr[i]);
            }
            List<String> ret = new ArrayList<>();
            while (n > 0) {
                long firstOne = x & -x;
                while ( firstOne > n ) firstOne >>>= 1;
                ret.add(toCIDR(x , (int) firstOne) );
                x+= firstOne;
                n-= firstOne;

            }
            return ret;
        }

        int getTrailingZeros(long ip) {
            return Long.numberOfTrailingZeros(ip);
        }

        String toCIDR(long ip, int firstOne) {
            int[] ret = new int[4];
            ret[0] = (int) (ip & 255);
            ip >>= 8;
            ret[1] = (int) (ip & 255);
            ip >>= 8;
            ret[2] = (int) (ip & 255);
            ip >>= 8;
            ret[3] = (int) (ip & 255);
            int len = 32;
            while ( firstOne > 0 ) {
                firstOne >>= 1;
                len--;
            }
            return ret[3] + "." + ret[2] + "." + ret[1] + "." + ret[0] + "/" + (len + 1);
        }
    }

    public static void main(String[] args) {
        System.out.println((6 & -6));
    }
}
