package leetcode.medium;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public final class RottingOrangesTest {

    @Test
    public void generalCase() {
        var grid = new int[][]{
                {2,1,1},
                {1,1,0},
                {0,1,1}
        };
        assertEquals(4, new RottingOranges().orangesRotting(grid));
    }

}
