package leetcode.easy;

import java.util.HashMap;

public class RansomNote {

    /**
     * https://leetcode.com/problems/ransom-note/
     */
    public boolean canConstruct(String ransomNote, String magazine) {
        var magLetters = new HashMap<Character, Integer>();
        for (int i = 0; i < magazine.length(); i++) {
            var currentChar = magazine.charAt(i);
            magLetters.merge(currentChar, 1, Integer::sum);
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            var currentChar = ransomNote.charAt(i);
            var currentCharRemaining = magLetters.get(currentChar);
            if (currentCharRemaining == null || currentCharRemaining == 0) {
                return false;
            }
            magLetters.put(currentChar, currentCharRemaining - 1);
        }
        return true;
    }

}
