package LC.SOL;

public class SuperWashingMachines {
    class Solution {
        public int findMinMoves(int[] machines) {
            int sum = 0;
            for ( int m : machines) {
                sum+= m;
            }
            if ( sum % 3 != 0 ) return -1;
            
        }
    }
}
