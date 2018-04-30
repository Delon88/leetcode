package LC.SOL;

public class TrappingRainWater {
    class Solution {
        public int trap1(int[] height) {
            if ( height.length == 0 ) return 0;
            int n = height.length;
            int[] left = new int[n];
            int[] right = new int[n];
            left[0] = height[0];
            right[n - 1] = height[n -1];
            for (int i = 1; i < height.length; i++) {
                left[i] = Math.max(height[i], left[i -1]);
                int j = n - i - 1;
                right[j] = Math.max(height[j] , right[j + 1]);
            }
            int sum = 0 ;
            for ( int i = 0 ; i < n ; i++) {
                sum += Math.min(left[i], right[i]) - height[i];
            }
            return sum;
        }


        public int trap(int[] height) {
            int leftMax = 0, rightMax = 0;
            int left = 0 , right = height.length - 1;
            int ret = 0;
            while ( left <= right ) {
                if ( height[left] <= height[right]) {
                    if ( height[left] >= leftMax ) leftMax = height[left];
                    else ret += leftMax - height[left];
                    left++;
                } else {
                    if ( height[right] >= rightMax) rightMax = height[right];
                    else ret+= rightMax - height[right];
                    right--;
                }
            }
            return ret;
        }

    }
}
