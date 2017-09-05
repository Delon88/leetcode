package LC.SOL;

public class NextGreaterElementIII {
    public class Solution {
        public int nextGreaterElement(int n) {
            char[] A = Integer.toString(n).toCharArray();

            for (int i = A.length - 1; i >= 1; i--) {
                if (A[i] > A[i - 1]) {
                    reverseRange(A, i, A.length - 1);
                    for (int j = i; j < A.length; j++) {
                        if (A[i - 1] < A[j]) {
                            swap(A, i - 1, j);
                            try {
                                return Integer.parseInt(new String(A));
                            } catch (NumberFormatException ex) {
                                return -1;
                            }
                        }
                    }
                }
            }

            return -1;
        }

        void swap(char[] A, int i, int j) {
            char tmp = A[i];
            A[i] = A[j];
            A[j] = tmp;
        }

        void reverseRange(char[] arr, int i, int j) {
            while (i < j) {
                char tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                i++;
                j--;
            }
        }
    }
}
