package leetcode.medium;

import java.util.ArrayList;

public final class InsertInterval {

    /**
     * https://leetcode.com/problems/insert-interval/
     */
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (newInterval == null || newInterval.length == 0) {
            return intervals;
        }
        if (intervals == null || intervals.length == 0) {
            return new int[][]{newInterval};
        }

        var overlappingIntervalIndexes = new ArrayList<Integer>();
        for (int i = 0; i < intervals.length; i++) {
            if (overlap(intervals[i], newInterval)) {
                overlappingIntervalIndexes.add(i);
            }
        }

        if (overlappingIntervalIndexes.isEmpty()) {
            var result = new int[intervals.length + 1][];
            if (intervals[0][0] > newInterval[1]) { // insert into start
                result[0] = newInterval;
                System.arraycopy(intervals, 0, result, 1, intervals.length);
            } else if (intervals[intervals.length - 1][1] < newInterval[0]) {   // insert into end
                result[result.length - 1] = newInterval;
                System.arraycopy(intervals, 0, result, 0, intervals.length);
            } else {
                for (int i = 0; i < intervals.length; i++) {
                    if (newInterval[1] < intervals[i][0]) {
                        System.arraycopy(intervals, 0, result, 0, i);
                        result[i] = newInterval;
                        System.arraycopy(intervals, i, result, i + 1, intervals.length - i);
                        break;
                    }
                }
            }
            return result;
        } else {
            int firstOverlappingIndex = overlappingIntervalIndexes.getFirst();
            var firstOverlapping = intervals[firstOverlappingIndex];
            int lastOverlappingIndex = overlappingIntervalIndexes.getLast();
            var lastOverlapping = intervals[lastOverlappingIndex];
            if (firstOverlappingIndex == lastOverlappingIndex) {
                var intervalStart = firstOverlapping[0];
                var intervalEnd = firstOverlapping[1];
                firstOverlapping[0] = Math.min(intervalStart, newInterval[0]);
                firstOverlapping[1] = Math.max(intervalEnd, newInterval[1]);
                return intervals;
            } else {
                var newMergedInterval = new int[2];
                newMergedInterval[0] = Math.min(newInterval[0], firstOverlapping[0]);
                newMergedInterval[1] = Math.max(newInterval[1], lastOverlapping[1]);

                var resultLength = (intervals.length - overlappingIntervalIndexes.size()) + 1;
                if (resultLength == 0) {
                    return new int[][]{newMergedInterval};
                }
                var result = new int[resultLength][];

                System.arraycopy(intervals, 0, result, 0, firstOverlappingIndex);
                result[firstOverlappingIndex] = newMergedInterval;
                if (resultLength - (firstOverlappingIndex + 1) >= 0) {
                    System.arraycopy(
                            intervals,
                            lastOverlappingIndex + 1,
                            result,
                            firstOverlappingIndex + 1,
                            intervals.length - lastOverlappingIndex - 1
                    );
                }
                return result;
            }
        }
    }

    private boolean overlap(int[] interval, int[] newInterval) {
        var intervalStart = interval[0];
        var intervalEnd = interval[1];
        var newStart = newInterval[0];
        var newEnd = newInterval[1];
        return (newStart >= intervalStart && newStart <= intervalEnd)
                || (newEnd >= intervalStart && newEnd <= intervalEnd)
                || (newStart < intervalStart && newEnd > intervalEnd);
    }

}
