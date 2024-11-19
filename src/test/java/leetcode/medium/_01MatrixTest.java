package leetcode.medium;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertTrue;

public class _01MatrixTest {

    @Test
    public void testLineOfZeros() {
        var testCase = new int[][]{{0}, {0}, {0}, {0}, {0}};
        var expected = new int[][]{{0}, {0}, {0}, {0}, {0}};
        var result = new _01Matrix().updateMatrix(testCase);
        assertTrue(Arrays.deepEquals(expected, result));
    }

    @Test
    public void test() {
        var testCase = new int[][]{
                {0,1,0,1,1},
                {1,1,0,0,1},
                {0,0,0,1,0},
                {1,0,1,1,1},
                {1,0,0,0,1}
        };
        var expected = new int[][]{
                {0,1,0,1,2},
                {1,1,0,0,1},
                {0,0,0,1,0},
                {1,0,1,1,1},
                {1,0,0,0,1}
        };
        var result = new _01Matrix().updateMatrix(testCase);
        assertTrue(Arrays.deepEquals(expected, result));
    }

}
