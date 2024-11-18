package leetcode.medium;


import java.util.ArrayList;
import java.util.List;

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

        /**
         * @return up to 4 adjacent points in {@link _01Matrix#_matrix}
         */
        public List<Point> adjacent() {
            var result = new ArrayList<Point>(4);
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
        _matrix = mat;
        // 1 class point + equals + distanceTo(otherPoint)
        // current points to search array + next points to search until 0 found (do it for each in matrix)


        return null;
    }

}
