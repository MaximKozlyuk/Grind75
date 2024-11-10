package leetcode.easy;

public class ValidPalindrome {

    /**
     * https://leetcode.com/problems/valid-palindrome/description/
     */
    static public boolean isPalindrome(String s) {
        var cleanStr = s.replaceAll("[^a-zA-Z0-9]", "");
        cleanStr = cleanStr.toLowerCase();
        var len = cleanStr.length();

        if (len <= 1) {
            return true;
        }

        int leftI = (len / 2) - 1, rightI;
        if (len % 2 == 0) {
            rightI = leftI + 1;
        } else {
            rightI = leftI + 2;
        }

        while (leftI != -1) {
            var leftChar = cleanStr.charAt(leftI);
            var rightChar = cleanStr.charAt(rightI);
            if (leftChar != rightChar) {
                return false;
            }
            leftI--;
            rightI++;
        }
        return true;
    }

}
