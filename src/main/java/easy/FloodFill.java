package easy;

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

        while (!pixelsToScan.isEmpty()) {
            var currentPixel = pixelsToScan.pop();
            int currX = currentPixel.x, currY = currentPixel.y;

            // top
            if (currY - 1 >= 0) {
                var topColor = image[currX][currY - 1];
                if (topColor == colorBefore) {      // todo editing color-s on the go refactor.
                    var nextPoint = new Point(currX, currY - 1);
                    if (!alreadyProcessed.contains(nextPoint)) {
                        pixelsToScan.add(nextPoint);
                    }
                }
            }

            // right
            if (currX + 1 < image.length) {
                var rightColor = image[currX + 1][currY];
                if (rightColor == colorBefore) {
                    var nextPoint = new Point(currX + 1, currY);
                    if (!alreadyProcessed.contains(nextPoint)) {
                        pixelsToScan.add(nextPoint);
                    }
                }
            }

            // bottom
            if (currY + 1 < image.length) {
                var bottomColor = image[currX][currY + 1];
                if (bottomColor == colorBefore) {
                    var nextPoint = new Point(currX, currY + 1);
                    if (!alreadyProcessed.contains(nextPoint)) {
                        pixelsToScan.add(nextPoint);
                    }
                }
            }

            // left
            if (currX - 1 >= 0) {
                var leftColor = image[currX - 1][currY];
                if (leftColor == colorBefore) {
                    var nextPoint = new Point(currX - 1, currY);
                    if (!alreadyProcessed.contains(nextPoint)) {
                        pixelsToScan.add(nextPoint);
                    }
                }
            }

            image[currX][currY] = color;
            alreadyProcessed.add(currentPixel);
        }
        return image;
    }

}
