package leetcode.medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public final class KClosestPointsToOrigin {

    /**
     * https://leetcode.com/problems/k-closest-points-to-origin/
     */
    public int[][] kClosest(int[][] points, int k) {
        var kClosest = new PriorityQueue<int[]>(
                Comparator.comparingInt(a -> (a[0] * a[0] + a[1] * a[1]))
        );
        kClosest.addAll(Arrays.asList(points));
        var result = new int[k][2];
        for (int i = 0; i < k; i++) {
            result[i] = kClosest.poll();
        }
        return result;
    }

}
