package leetcode.medium;

import leetcode.TestUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class ProductOfArrayExceptSelfTest {

    @Test
    public void testIntegers() {
        var input = new int[]{1, 2, 3, 4};
        var expected = new int[]{24, 12, 8, 6};
        Assertions.assertTrue(
                TestUtils.arraysEqual(
                        expected,
                        new ProductOfArrayExceptSelf().productExceptSelf(input)
                )
        );
    }

    @Test
    public void testWithSingleZero() {
        var input = new int[]{-1, 1, 0, -3, 3};
        var expected = new int[]{0, 0, 9, 0, 0};
        Assertions.assertTrue(
                TestUtils.arraysEqual(
                        expected,
                        new ProductOfArrayExceptSelf().productExceptSelf(input)
                )
        );
    }

    @Test
    public void case23() {
        var input = new int[]{0, 2, 3, 4};
        var expected = new int[]{24, 0, 0, 0};
        Assertions.assertTrue(
                TestUtils.arraysEqual(
                        expected,
                        new ProductOfArrayExceptSelf().productExceptSelf(input)
                )
        );
    }

}
