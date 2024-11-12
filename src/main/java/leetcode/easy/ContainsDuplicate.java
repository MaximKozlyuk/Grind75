package leetcode.easy;

import java.util.HashSet;

public class ContainsDuplicate {

    /**
     * https://leetcode.com/problems/contains-duplicate/
     */
    public boolean containsDuplicate(int[] nums) {
        if (nums == null) {
            return false;
        }
        if (nums.length == 0) {
            return false;
        }
        var numsSet = new HashSet<Integer>(nums.length);
        for (int num : nums) {
            if (!numsSet.add(num)) {
                return true;
            }
        }
        return false;
    }

}
