package leetcode.medium;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class LongestSubstringWithoutRepeatingCharactersTest {

    @Test
    public void test1() {
        var testCase= "pwwkew";
        assertEquals(
                3,
                new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring(testCase)
        );
    }

    @Test
    public void test2() {
        var testCase= "aab";
        assertEquals(
                2,
                new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring(testCase)
        );
    }

    @Test
    public void test3() {
        var testCase= "dvdf";
        assertEquals(
                3,
                new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring(testCase)
        );
    }

}
