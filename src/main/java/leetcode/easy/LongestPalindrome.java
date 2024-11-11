package leetcode.easy;

import java.util.HashMap;

public class LongestPalindrome {

    /**
     * https://leetcode.com/problems/longest-palindrome/
     */
    public int longestPalindrome(String s) {
        var lettersCount = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            var currentChar = s.charAt(i);
            lettersCount.merge(currentChar, 1, Integer::sum);
        }
        if (lettersCount.size() == 1) {
            return lettersCount.values().stream().findFirst().get();
        }
        var counts = lettersCount.values().stream().toList();
        var totalCount = 0;
        var singleLetterCase = false;
        var nonEvenCount = false;
        for (int i = 0; i < counts.size(); i++) {
            var currentCount = counts.get(i);
            if (currentCount > 1) {
                totalCount += currentCount / 2;
                if (currentCount % 2 != 0) {
                    nonEvenCount = true;
                }
            } else {
                singleLetterCase = true;
            }
        }
        totalCount = totalCount * 2;
        if (singleLetterCase || nonEvenCount) {
            totalCount += 1;
        }
        return totalCount;
    }

}
