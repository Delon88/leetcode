package LC.SOL;

public class RectangleArea {
    class Solution {
        public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
            int area1 = ( C - A) * ( D - B), area2 = ( G - E) * ( H - F);
            int left = Math.max(A , E), right = Math.max(Math.min(C, G), left);
            int bot = Math.max(B , F), top = Math.max(Math.min(D, H), bot);
            return area1 + area2 - ( right -left) * ( top - bot);
        }
    }
}
