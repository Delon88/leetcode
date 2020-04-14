package LC.Linkedin.IDI;

import java.util.Arrays;

public class MutualConnections {
    public int[] getConnections(int memberId) {
        return new int[0];
    }

    boolean test0(int srcId, int destId) {
        return srcId == destId;
    }

    boolean test1(int srcId, int destId) {
        int[] cons = getConnections(srcId);
        return Arrays.binarySearch(cons, destId) >= 0;
    }

    boolean isIntersect(int[] a1, int[] a2) {
        int i = 0, j = 0;
        while (i < a1.length && j < a2.length) {
            if (a1[i] == a2[j]) return true;
            else if (a1[i] < a2[j]) i++;
            else j++;
        }
        return false;
    }

    boolean test2(int srcId, int destId) {
        return isIntersect(getConnections(srcId), getConnections(destId));
    }

    boolean test3(int srcId, int destId) {
        int[] srcConns = getConnections(srcId);
        int[] destConns = getConnections(destId);

        for (int i = 0; i < srcConns.length; i++)
            if (isIntersect(getConnections(srcConns[i]), destConns)) return true;

        return false;
    }

    int getDistance(int srcId, int destId) {
        if (test0(srcId, destId)) return 0;
        if (test1(srcId, destId)) return 1;
        if (test2(srcId, destId)) return 2;
        if (test3(srcId, destId)) return 3;
        return -1;
    }
}
