package leetcode.easy;

import leetcode.TestUtils;
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
        assertTrue(TestUtils.arraysEqual(expected, editedImage));
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
        assertTrue(TestUtils.arraysEqual(expected, editedImage));
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
        assertTrue(TestUtils.arraysEqual(expected, editedImage));
    }

}
