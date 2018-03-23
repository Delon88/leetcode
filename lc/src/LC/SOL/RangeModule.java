package LC.SOL;

import java.util.Map;
import java.util.TreeMap;

public class RangeModule {


//    ddRange(10, 20): null
//    removeRange(14, 16): null
//    queryRange(10, 14): true (Every number in [10, 14) is being tracked)
//    queryRange(13, 15): false (Numbers like 14, 14.03, 14.17 in [13, 15) are not being tracked)
//    queryRange(16, 17): true (The number 16 in [16, 17) is still being tracked, despite the remove operation)


    TreeMap<Integer, Integer> map;

    public RangeModule() {
        map = new TreeMap<>();
    }

    public void addRange(int left, int right) {
        Map.Entry<Integer, Integer> lower = map.floorEntry(left);
        Map.Entry<Integer, Integer> higher = map.floorEntry(right);
        int start = left, end = right;
        if (lower != null) {
            if (lower.getValue() >= left) {
                start = lower.getKey();
            }
        }
        if (higher != null) {
            if (higher.getValue() >= right) {
                end = higher.getValue();
            }
        }
        map.subMap(start, end).clear();
        map.put(start, end);
    }

    public boolean queryRange(int left, int right) {
        Map.Entry<Integer, Integer> floor = map.floorEntry(left);
        if (floor == null) return false;
        if (floor.getValue() >= right) return true;
        return false;
    }

    public void removeRange(int left, int right) {
        Map.Entry<Integer, Integer> lower = map.floorEntry(left);
        Map.Entry<Integer, Integer> higher = map.floorEntry(right);
        if (lower != null) {
            if (lower.getValue() >= left) {
                map.put(lower.getKey(), left);
            }
        }
        if (higher != null) {
            if (higher.getValue() >= right) {
                map.put(right, higher.getValue());
            }
        }
        map.subMap(left, right).clear();
    }

    /**
     * Your RangeModule object will be instantiated and called as such:
     * RangeModule obj = new RangeModule();
     * obj.addRange(left,right);
     * boolean param_2 = obj.queryRange(left,right);
     * obj.removeRange(left,right);
     */
    public static void main(String[] args) {
        RangeModule r = new RangeModule();
        r.addRange(10, 20);
        r.removeRange(14, 16);
        r.queryRange(10, 14);
        r.queryRange(13, 15);
        r.queryRange(16, 17);
    }
}

