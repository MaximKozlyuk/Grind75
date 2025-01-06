package leetcode.medium;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CourseScheduleTest {

    @Test
    public void simpleTrue() {
        var result = new CourseSchedule().canFinish(2, new int[][]{{1, 0}});
        assertTrue(result);
    }

    @Test
    public void simpleFalse() {
        var result = new CourseSchedule().canFinish(
                2, new int[][]{{1, 0}, {0, 1}}
        );
        assertFalse(result);
    }

    @Test
    public void hasCycle() {
        var result = new CourseSchedule().canFinish(
                6,
                new int[][]{
                        {0, 1},
                        {0, 2},
                        {2, 3},
                        {2, 4},
                        {3, 4},
                        {4, 5},
                        {5, 3}
                }
        );
        assertFalse(result);
    }

    @Test
    public void case35() {
        var result = new CourseSchedule().canFinish(
                5,
                new int[][]{
                        {1, 4},
                        {2, 4},
                        {3, 1},
                        {3, 2}
                }
        );
        assertTrue(result);
    }

}
