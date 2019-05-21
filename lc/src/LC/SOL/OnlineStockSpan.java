package LC.SOL;

import java.util.Stack;

public class OnlineStockSpan {
    class StockSpanner {

        Stack<int[]> st;

        public StockSpanner() {
            st = new Stack<>();
        }

        public int next(int price) {
            int ret = 1;
            while (!st.isEmpty() && st.peek()[0] <= price) {
                ret += st.pop()[1];
            }
            st.push(new int[]{price, ret});
            return ret;
        }
    }

}
