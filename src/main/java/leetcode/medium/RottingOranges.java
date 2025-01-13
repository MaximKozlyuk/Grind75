package leetcode.medium;

import java.util.ArrayList;

public class RottingOranges {

    private static final int FRESH = 1;
    private static final int ROTTEN = 2;

    private record Point(int x, int y) {
        @Override
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            var objPoint = (RottingOranges.Point) obj;
            return objPoint.x == x && objPoint.y == y;
        }

        @Override
        public int hashCode() {
            return 31 * x + y;
        }
    }

    private record OrangesGrid(int[][] grid) {

        public int nextRotMinute() {
            var gonnaRot = new ArrayList<Point>();
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == FRESH && hasAdjacentRotten(i, j)) {
                        gonnaRot.add(new Point(i, j));
                    }
                }
            }
            for (Point rot : gonnaRot) {
                grid[rot.x][rot.y] = ROTTEN;
            }
            return gonnaRot.size();
        }

        private boolean hasAdjacentRotten(int x, int y) {
            return (y - 1 >= 0 && grid[x][y - 1] == ROTTEN)
                    || (x + 1 < grid.length && grid[x + 1][y] == ROTTEN)
                    || (y + 1 < grid[0].length && grid[x][y + 1] == ROTTEN)
                    || (x - 1 >= 0 && grid[x - 1][y] == ROTTEN);
        }

    }

    /**
     * 994. Rotting Oranges
     * https://leetcode.com/problems/rotting-oranges
     */
    public int orangesRotting(int[][] grid) {
        var freshCountOnStart = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == FRESH) {
                    freshCountOnStart++;
                }
            }
        }
        if (freshCountOnStart == 0) {
            return 0;
        }

        var orangesGrid = new OrangesGrid(grid);
        var minutesCount = 0;
        var totalRotten = 0;
        for (; ; minutesCount++) {
            var currentRotten = orangesGrid.nextRotMinute();
            totalRotten += currentRotten;
            if (totalRotten == freshCountOnStart) {
                return minutesCount + 1;
            }
            if (currentRotten == 0) {
                return -1;
            }
        }
    }

}
