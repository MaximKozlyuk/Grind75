package leetcode.easy;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LongestPalindromeTest {

    @Test
    public void testNineLetters() {
        assertEquals(new LongestPalindrome().longestPalindrome("ababababa"), 9);
    }

    @Test
    public void testBananasCase() {
        assertEquals(new LongestPalindrome().longestPalindrome("bananas"), 5);
    }

    @Test
    public void testSingleLetter() {
        assertEquals(new LongestPalindrome().longestPalindrome("A"), 1);
    }

    @Test
    public void testTwoLetters() {
        assertEquals(new LongestPalindrome().longestPalindrome("Aa"), 1);
    }

}
