package easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ValidAnagramTest {

    @Test
    public void testIsAnagram() {
        assertTrue(new ValidAnagram().isAnagram("anagram", "nagaram"));
    }

    @Test
    public void testNonAnagram() {
        assertFalse(new ValidAnagram().isAnagram("car", "rat"));
    }

    @Test
    public void testOneMoreThanAnother() {
        assertFalse(new ValidAnagram().isAnagram("pupa", "pupa1"));
    }

}
