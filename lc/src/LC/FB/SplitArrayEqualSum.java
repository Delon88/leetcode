package LC.FB;

public class SplitArrayEqualSum {
    public int splitArray(int[] A) {
        int left = 0, right = 0;
        int i = 0, j = A.length - 1;
        while (i <= j) {
            if (left <= right) {
                left += A[i++];
            } else {
                right += A[j--];
            }
        }
        return left == right ? i : -1;
    }

    public static void main(String[] args) {
        int[] test = {2, 3, 5, 0};
        System.out.println(new SplitArrayEqualSum().splitArray(test));
    }
}
