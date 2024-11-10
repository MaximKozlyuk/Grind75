package easy;

import leetcode.easy.BinarySearch;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class BinarySearchTest {

    @Test
    public void singleValueFound() {
        assertEquals(
                0,
                new BinarySearch().search(new int[]{1}, 1)
        );
    }

    @Test
    public void singleValueNotFound() {
        assertEquals(
                -1,
                new BinarySearch().search(new int[]{1}, 0)
        );
    }

    @Test
    public void twoValuesFoundRight() {
        assertEquals(
                1,
                new BinarySearch().search(new int[]{1, 10}, 10)
        );
    }

    @Test
    public void twoValuesFoundLeft() {
        assertEquals(
                0,
                new BinarySearch().search(new int[]{1, 10}, 1)
        );
    }

    @Test
    public void twoValuesNotFound() {
        assertEquals(
                -1,
                new BinarySearch().search(new int[]{2, 5}, 0)
        );
    }

    @Test
    public void threeValuesFoundLeft() {
        assertEquals(
                0,
                new BinarySearch().search(new int[]{1, 10, 17}, 1)
        );
    }

    @Test
    public void threeValuesFoundCenter() {
        assertEquals(
                1,
                new BinarySearch().search(new int[]{1, 10, 17}, 10)
        );
    }

    @Test
    public void threeValuesFoundRight() {
        assertEquals(
                2,
                new BinarySearch().search(new int[]{1, 10, 17}, 17)
        );
    }

    @Test
    public void threeValuesNotFound() {
        assertEquals(
                -1,
                new BinarySearch().search(new int[]{1, 10, 17}, 1000)
        );
    }

    @Test
    public void manyValuesFoundLeft() {
        assertEquals(
                0,
                new BinarySearch().search(
                        new int[]{-1, 0, 1, 10, 11, 12, 13, 17, 20, 100},
                        -1
                )
        );
    }

    @Test
    public void manyValuesFoundToLeftFromCenter() {
        assertEquals(
                3,
                new BinarySearch().search(
                        new int[]{-1, 0, 1, 10, 11, 12, 13, 17, 20, 100},
                        10
                )
        );
    }

    @Test
    public void manyValuesFoundCenter() {
        assertEquals(
                5,
                new BinarySearch().search(
                        new int[]{-1, 0, 1, 10, 11, 12, 13, 17, 20, 100, 101},
                        12
                )
        );
    }

    @Test
    public void manyValuesFoundRight() {
        assertEquals(
                10,
                new BinarySearch().search(
                        new int[]{-1, 0, 1, 10, 11, 12, 13, 17, 20, 100, 101},
                        101
                )
        );
    }

    @Test
    public void manyValuesNotFound() {
        assertEquals(
                -1,
                new BinarySearch().search(
                        new int[]{-1, 0, 1, 10, 11, 12, 13, 17, 20, 100, 101},
                        321
                )
        );
    }

}
