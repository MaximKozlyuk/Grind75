package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {

    /**
     * https://leetcode.com/problems/valid-anagram/
     */
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> sMap = new HashMap<>(), tMap = new HashMap<>();
        countCharsInString(s, sMap);
        countCharsInString(t, tMap);
        for (Character ch : sMap.keySet()) {
            var sCount = sMap.get(ch);
            var tChar = tMap.get(ch);
            if (tChar == null || !tChar.equals(sCount)) {
                return false;
            }
        }
        return true;
    }

    private static void countCharsInString(String s, Map<Character, Integer> sMap) {
        for (int i = 0; i < s.length(); i++) {
            var currentChar = s.charAt(i);
            sMap.merge(currentChar, 1, Integer::sum);
        }
    }

}
