package leetcode.medium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class NumberOfIslandsTest {

    @Test
    public void generalCase() {
        var grid = new char[][]{
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'},
        };
        Assertions.assertEquals(1, new NumberOfIslands().numIslands(grid));
    }

    @Test
    public void generalCase2() {
        var grid = new char[][]{
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'},
        };
        Assertions.assertEquals(3, new NumberOfIslands().numIslands(grid));
    }

}
