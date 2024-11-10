package easy;

import static org.junit.jupiter.api.Assertions.*;

import leetcode.easy.ValidPalindrome;
import org.junit.jupiter.api.Test;


public class ValidPalindromeTest {

    @Test
    public void testHappyWay() {
        assertTrue(ValidPalindrome.isPalindrome("A man, a plan, a canal: Panama"));
    }

    @Test
    public void testHappyWayABC() {
        assertTrue(ValidPalindrome.isPalindrome("abccba"));
    }

    @Test
    public void testHappyWayABC_not() {
        assertFalse(ValidPalindrome.isPalindrome("abccba1"));
    }

    @Test
    public void testRaceACar() {
        assertFalse(ValidPalindrome.isPalindrome("race a car"));
    }

    @Test
    public void testEmpty() {
        assertTrue(ValidPalindrome.isPalindrome("  "));
    }

    @Test
    public void test2LettersFalse() {
        assertFalse(ValidPalindrome.isPalindrome("ab"));
    }

    @Test
    public void test2LettersTrue() {
        assertTrue(ValidPalindrome.isPalindrome("aa"));
    }

}