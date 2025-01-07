package leetcode.medium;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CoinChangeTest {

    @Test
    public void case51() {
        var result = new CoinChange().coinChange(new int[]{186, 419, 83, 408},6249);
        assertEquals(20, result);
    }

}
