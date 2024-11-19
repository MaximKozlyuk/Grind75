package leetcode.medium;


import java.util.*;

public final class _01Matrix {

    private static int[][] _matrix;

    private record Point(int x, int y) {

        @Override
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof Point(int x1, int y1)) {
                return (x1 == this.x) && (y1 == this.y);
            } else {
                return false;
            }
        }

        public int distanceTo(Point otherPoint) {
            return Math.abs(otherPoint.x - this.x) + Math.abs(otherPoint.y - this.y);
        }

        public int value() {
            return _matrix[x][y];
        }

        /**
         * @return up to 4 adjacent points in {@link _01Matrix#_matrix}
         */
        public List<Point> adjacent() {
            var result = new LinkedList<Point>();
            // top
            if (y - 1 >= 0) {
                result.add(new Point(x, y - 1));
            }
            // right
            if (x + 1 <= _matrix.length - 1) {
                result.add(new Point(x + 1, y));
            }
            // bottom
            if (y - 1 >= 0) {
                result.add(new Point(x, y - 1));
            }
            // left
            if (x - 1 >= 0) {
                result.add(new Point(x - 1, y));
            }
            return result;
        }

    }

    /**
     * https://leetcode.com/problems/01-matrix/
     */
    public int[][] updateMatrix(int[][] mat) {
        if (mat == null || mat.length == 0) {
            return mat;
        }

        _matrix = mat;
        var lookingFor = 0;
        var result = new int[mat.length][mat[0].length];

        for (int x = 0; x < mat.length; x++) {
            for (int y = 0; y < mat[0].length; y++) {
                var currentPoint = new Point(x, y);
                if (currentPoint.value() == lookingFor) {
                    result[x][y] = 0;
                } else {
                    result[x][y] = distanceToNearest(currentPoint, lookingFor);
                }
            }
        }
        return result;
    }

    private int distanceToNearest(Point searchFrom, int lookingFor) {
        var toLookIn = searchFrom.adjacent();
        var visited = new HashSet<Point>();
        while (!toLookIn.isEmpty()) {
            var toCheck = toLookIn.removeFirst();
            if (toCheck.value() == lookingFor) {
                return searchFrom.distanceTo(toCheck);
            } else {
                var nextToCheck = toCheck.adjacent();
                nextToCheck.removeIf(visited::contains);
                nextToCheck.forEach(toLookIn::addLast);
                visited.add(toCheck);
            }
        }
        throw new RuntimeException("0 not found in mat!");
    }

}
