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
            var otherPoint = (Point)obj;
            return (otherPoint.x == this.x) && (otherPoint.y == this.y);
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
            if (x - 1 >= 0) {
                result.add(new Point(x - 1, y));
            }
            // right
            if (y + 1 <= _matrix[0].length - 1) {
                result.add(new Point(x, y + 1));
            }
            // bottom
            if (x + 1 <= _matrix.length - 1) {
                result.add(new Point(x + 1, y));
            }
            // left
            if (y - 1 >= 0) {
                result.add(new Point(x, y - 1));
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
        if (_matrix.length == 1) {
            return singleDimensionAlg(lookingFor);
        } else {
            return general2DimensionalAlg(lookingFor);
        }
    }

    private int[][] singleDimensionAlg(int lookingFor) {
        var vector = _matrix[0];
        var result = new int[1][vector.length];

        var lookingForIndexes = new ArrayList<Integer>();
        for (int i = 0; i < vector.length; i++) {
            if (vector[i] == lookingFor) {
                lookingForIndexes.add(i);
            }
        }

        for (int i = 0; i < vector.length; i++) {
            var minDistance = vector.length;
            for (int lfi = 0; lfi < lookingForIndexes.size(); lfi++) {
                var currentToCheck = Math.abs(i - lookingForIndexes.get(lfi));
                if (currentToCheck < minDistance) {
                    minDistance = currentToCheck;
                }
            }
            result[0][i] = minDistance;
        }

        return result;
    }

    private int[][] general2DimensionalAlg(int lookingFor) {
        var result = new int[_matrix.length][_matrix[0].length];
        for (int x = 0; x < _matrix.length; x++) {
            for (int y = 0; y < _matrix[0].length; y++) {
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
