package LC.SOL;

public class SearchinaSortedArrayofUnknownSize {
    class Solution {
        interface ArrayReader {
            public int get(int index) ;
        }

        public int search(ArrayReader reader, int target) {
            int start = 0, end = 20000;
            while ( start <= end ) {
                int mid = ( start + end ) / 2;
                int v = reader.get(mid);
                if ( v == target) return mid;
                else if (v < target ) start= mid + 1;
                else end = mid - 1;
            }
            return -1;
        }
    }
}
