package leetcode.medium;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertTrue;

public class InsertIntervalTest {

    @Test
    public void multipleOverlapping() {
        int[][] intervals = {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
        int[] newInterval = {4, 8};
        int[][] expected = {{1, 2}, {3, 10}, {12, 16}};
        var result = new InsertInterval().insert(intervals, newInterval);
        assertTrue(Arrays.deepEquals(expected, result));
    }

    @Test
    public void insertPointInterval() {
        int[][] intervals = {{3, 5}, {12, 15}};
        int[] newInterval = {6, 6};
        int[][] expected = {{3, 5}, {6, 6}, {12, 15}};
        var result = new InsertInterval().insert(intervals, newInterval);
        assertTrue(Arrays.deepEquals(expected, result));
    }

    @Test
    public void singleOverlappingInside() {
        int[][] intervals = {{1, 2}, {3, 5}, {6, 7}};
        int[] newInterval = {4, 5};
        int[][] expected = {{1, 2}, {3, 5}, {6, 7}};
        assertTrue(
                Arrays.deepEquals(
                        expected,
                        new InsertInterval().insert(intervals, newInterval)
                )
        );
    }

    @Test
    public void nonOverlappingAdded() {
        int[][] intervals = {{1, 2}, {3, 5}, {6, 7}};
        int[] newInterval = {9, 12};
        int[][] expected = {{1, 2}, {3, 5}, {6, 7}, {9, 12}};
        assertTrue(
                Arrays.deepEquals(
                        expected,
                        new InsertInterval().insert(intervals, newInterval)
                )
        );
    }


    @Test
    public void singleAddedToSingleEnd() {
        int[][] intervals = {{1, 5}};
        int[] newInterval = {6, 8};
        int[][] expected = {{1, 5}, {6, 8}};
        var result = new InsertInterval().insert(intervals, newInterval);
        assertTrue(Arrays.deepEquals(expected, result));
    }

    @Test
    public void singleAddedToSingleStart() {
        int[][] intervals = {{3, 5}};
        int[] newInterval = {1, 2};
        int[][] expected = {{1, 2}, {3, 5}};
        var result = new InsertInterval().insert(intervals, newInterval);
        assertTrue(Arrays.deepEquals(expected, result));
    }

    @Test
    public void widerThanTwo() {
        int[][] intervals = {{2, 3}, {5, 7}};
        int[] newInterval = {0, 6};
        int[][] expected = {{0, 7}};
        var result = new InsertInterval().insert(intervals, newInterval);
        assertTrue(Arrays.deepEquals(expected, result));
    }

    @Test
    public void addedToEmpty() {
        int[][] intervals = {};
        int[] newInterval = {1, 2};
        int[][] expected = {{1, 2}};
        assertTrue(
                Arrays.deepEquals(
                        expected,
                        new InsertInterval().insert(intervals, newInterval)
                )
        );
    }


}
