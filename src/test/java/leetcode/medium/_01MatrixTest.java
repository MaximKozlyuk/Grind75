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
                {7,0,0,0,1}
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

    @Test
    public void longSingleDimensionCase() {
        var length = 10000;
        var onesAndZeroInEnd = new int[length];
        Arrays.fill(onesAndZeroInEnd, 1);
        onesAndZeroInEnd[length - 1] = 0;
        var testCase = new int[][]{onesAndZeroInEnd};

        var startTime = System.currentTimeMillis();
        var result = new _01Matrix().updateMatrix(testCase);
        var finishTime = System.currentTimeMillis() - startTime;
        System.out.println("LONG TEST TIME " + finishTime);
    }

}
