package LC.SOL;

import java.util.Collections;
import java.util.TreeMap;

public class SlidingWindowMedian {
    class Solution {
        public double[] medianSlidingWindow(int[] nums, int k) {
            TreeMap<Long, Integer> minHeap = new TreeMap<>();
            TreeMap<Long, Integer> maxHeap = new TreeMap<>(Collections.reverseOrder());

            int[] maxHeapSize = {k};
            int[] minHeapSize = {0};

            int minHeapCap = k / 2;
            int maxHeapCap = k - minHeapCap;
            for (int i = 0; i < k; i++) {
                maxHeap.put((long) nums[i], maxHeap.getOrDefault((long) nums[i], 0) + 1);
            }

            for (int i = 0; i < minHeapCap; i++) {
                move(maxHeap, minHeap, maxHeapSize, minHeapSize);
            }

            double[] ret = new double[nums.length - k + 1];
            ret[0] = getMedian(maxHeap, minHeap, maxHeapSize, minHeapSize);

            for (int i = 0; i < nums.length - k; i++) {
                // add nums[i + k];
                System.out.println(maxHeap);
                System.out.println(minHeap);
                if (nums[i + k] <= maxHeap.firstKey()) {
                    add(maxHeap, nums[i + k], maxHeapSize);
                } else {
                    add(minHeap, nums[i + k], minHeapSize);
                }

                // remove nums[i]
                if (nums[i] <= maxHeap.firstKey()) {
                    remove(maxHeap, nums[i], maxHeapSize);
                } else {
                    remove(minHeap, nums[i], minHeapSize);
                }

                // rebalance
                if (maxHeapSize[0] > maxHeapCap) {
                    move(maxHeap, minHeap, maxHeapSize, minHeapSize);
                } else if (minHeapSize[0] > minHeapCap) {
                    move(minHeap, maxHeap, minHeapSize, maxHeapSize);
                }

                ret[i + 1] = getMedian(maxHeap, minHeap, maxHeapSize, minHeapSize);
            }
            return ret;
        }


        double getMedian(TreeMap<Long, Integer> maxH, TreeMap<Long, Integer> minH, int[] maxHeapSize, int[] minHeapSize) {
            if (maxHeapSize[0] > minHeapSize[0]) {
                return (double) maxH.firstKey();
            } else return (double) (minH.firstKey() + maxH.firstKey()) / 2.0d;
        }

        void move(TreeMap<Long, Integer> h1, TreeMap<Long, Integer> h2, int[] h1Size, int[] h2Size) {
            long peek = h1.firstKey();
            add(h2, peek, h2Size);
            remove(h1, peek, h1Size);
        }

        void add(TreeMap<Long, Integer> heap, long key, int[] heapSize) {
            heap.put(key, heap.getOrDefault(key, 0) + 1);
            heapSize[0]++;
        }

        void remove(TreeMap<Long, Integer> heap, long key, int[] heapSize) {
            heap.put(key, heap.get(key) - 1);
            if (heap.get(key) <= 0) {
                heap.remove(key);
            }
            heapSize[0]--;
        }
    }
}
