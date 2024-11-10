package easy;

import leetcode.easy.FloodFill;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class FloodFillTest {

    @Test
    public void testHappyWay() {
        int[][] image = {
                {1, 1, 1},
                {1, 1, 0},
                {1, 0, 1}
        };
        int[][] expected = {
                {2, 2, 2},
                {2, 2, 0},
                {2, 0, 1}
        };
        var editedImage = new FloodFill().floodFill(image, 1, 1, 2);
        assertTrue(arraysEqual(expected, editedImage));
    }

    @Test
    public void allZeroCase() {
        int[][] image = {
                {0, 0, 0},
                {0, 0, 0}
        };
        int[][] expected = {
                {0, 0, 0},
                {0, 0, 0}
        };
        var editedImage = new FloodFill().floodFill(image, 0, 0, 0);
        assertTrue(arraysEqual(expected, editedImage));
    }

    @Test
    public void zeroFirstPositionAndRecolor() {
        int[][] image = {
                {0, 0, 0},
                {0, 0, 0}
        };
        int[][] expected = {
                {2, 2, 2},
                {2, 2, 2}
        };
        var editedImage = new FloodFill().floodFill(image, 1, 0, 2);
        assertTrue(arraysEqual(expected, editedImage));
    }

    public boolean arraysEqual(int[][] array1, int[][] array2) {
        if (array1 == null || array2 == null) {
            return array1 == array2;
        }
        if (array1.length != array2.length) {
            return false;
        }
        for (int i = 0; i < array1.length; i++) {
            if (array1[i].length != array2[i].length) {
                return false;
            }
            for (int j = 0; j < array1[i].length; j++) {
                if (array1[i][j] != array2[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

}
