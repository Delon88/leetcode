package LC.SOL;

import java.util.Map;
import java.util.TreeMap;

public class SnapshotArray {
    class SnapshotArray {

        TreeMap<Integer,Integer>[] A;
        int snap_id;
        public SnapshotArray(int length) {
            A = new TreeMap[length];
            for ( int i = 0 ; i < length; i++) {
                A[i] = new TreeMap<>();
                A[i].put(0, 0);
            }
            snap_id = 0;
        }

        public void set(int index, int val) {
            A[index].put(snap_id, val);
        }

        public int snap() {
            return snap_id++;
        }

        public int get(int index, int snap_id) {
            return A[index].floorEntry(snap_id).getValue();
        }
    }

}
