package leetcode.medium;

import java.util.*;

public final class NumberOfIslands {

    private static final char LAND = '1';
    private static final char WATER = '0';

    private record Point(int x, int y) {
        @Override
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            var objPoint = (Point) obj;
            return objPoint.x == x && objPoint.y == y;
        }
    }

    /**
     * https://leetcode.com/problems/number-of-islands
     */
    public int numIslands(char[][] grid) {
        var islandsCount = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == LAND) {
                    determineIslandBordersAndRemoveIt(grid, i, j);
                    islandsCount++;
                }
            }
        }
        return islandsCount;
    }

    private void determineIslandBordersAndRemoveIt(char[][] grid, int i, int j) {
        var islandPoints = new Stack<Point>();
        var startPoint = new Point(i, j);
        var pointsToSearch = new Stack<Point>();
        pointsToSearch.add(startPoint);

        while (!pointsToSearch.isEmpty()) {
            var current = pointsToSearch.pop();

            if (islandPoints.contains(current)) {
                continue;
            }

            islandPoints.add(current);
            var adjacentIslandPoints = adjacentIslandPointsOf(grid, current);
            pointsToSearch.addAll(adjacentIslandPoints);
        }

        for (Point islandPoint : islandPoints) {
            grid[islandPoint.x][islandPoint.y] = WATER;
        }
    }

    // todo можно оптимизировать через pointOf(x,y) который сделает точки singleton-ами
    private List<Point> adjacentIslandPointsOf(char[][] grid, Point point) {
        var result = new ArrayList<Point>(4);
        // top
        var topY = point.y - 1;
        if (topY >= 0 && grid[point.x][topY] == LAND) {
            result.add(new Point(point.x, topY));
        }

        // right
        var rightX = point.x + 1;
        if (rightX < grid.length && grid[rightX][point.y] == LAND) {
            result.add(new Point(rightX, point.y));
        }

        // bottom
        var bottomY = point.y + 1;
        if (bottomY < grid[0].length && grid[point.x][bottomY] == LAND) {
            result.add(new Point(point.x, bottomY));
        }

        // left
        var leftX = point.x - 1;
        if (leftX >= 0 && grid[leftX][point.y] == LAND) {
            result.add(new Point(leftX, point.y));
        }
        return result;
    }

}
