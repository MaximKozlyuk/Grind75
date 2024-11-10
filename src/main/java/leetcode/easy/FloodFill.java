package leetcode.easy;

import java.util.ArrayList;
import java.util.Stack;

public class FloodFill {

    private record Point(int x, int y) {
        @Override
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof Point objPoint) {
                return (objPoint.x == this.x) && (objPoint.y == this.y);
            } else {
                return false;
            }
        }
    }

    /**
     * https://leetcode.com/problems/flood-fill/description/
     */
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        var pixelsToScan = new Stack<Point>();
        pixelsToScan.add(new Point(sr, sc));
        var alreadyProcessed = new ArrayList<Point>();
        var colorBefore = image[sr][sc];
        if (colorBefore == color) {
            return image;
        }

        while (!pixelsToScan.isEmpty()) {
            var currentPixel = pixelsToScan.pop();
            int currX = currentPixel.x, currY = currentPixel.y;

            image[currX][currY] = color;
            alreadyProcessed.add(currentPixel);

            // Top
            if (currY - 1 >= 0 && image[currX][currY - 1] == colorBefore) {
                var nextPoint = new Point(currX, currY - 1);
                if (!alreadyProcessed.contains(nextPoint)) {
                    pixelsToScan.add(nextPoint);
                }
            }

            // Right
            if (currX + 1 < image.length && image[currX + 1][currY] == colorBefore) {
                var nextPoint = new Point(currX + 1, currY);
                if (!alreadyProcessed.contains(nextPoint)) {
                    pixelsToScan.add(nextPoint);
                }
            }

            // Bottom
            if (currY + 1 < image[0].length && image[currX][currY + 1] == colorBefore) {
                var nextPoint = new Point(currX, currY + 1);
                if (!alreadyProcessed.contains(nextPoint)) {
                    pixelsToScan.add(nextPoint);
                }
            }

            // Left
            if (currX - 1 >= 0 && image[currX - 1][currY] == colorBefore) {
                var nextPoint = new Point(currX - 1, currY);
                if (!alreadyProcessed.contains(nextPoint)) {
                    pixelsToScan.add(nextPoint);
                }
            }
        }
        return image;
    }

}
