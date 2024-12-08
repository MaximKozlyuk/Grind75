package leetcode.medium;

import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacters {

    /**
     * https://leetcode.com/problems/longest-substring-without-repeating-characters/
     */
    public int lengthOfLongestSubstring(String s) {
        int longestLength = 0, currentLength = 0, latestSubstringIndex = 0, i = 0;
        var charSet = new HashSet<Character>();
        while (i < s.length()) {
            var currentChar = s.charAt(i);
            if (charSet.add(currentChar)) {
                currentLength++;
                i++;
            } else {
                if (currentLength > longestLength) {
                    longestLength = currentLength;
                }
                latestSubstringIndex = latestSubstringIndex + 1;
                i = latestSubstringIndex;
                currentLength = 0;
                charSet.clear();
            }
        }
        if (currentLength > longestLength) {
            longestLength = currentLength;
        }
        return longestLength;
    }

}
