package leetcode.easy;

import java.util.HashMap;

public class MajorityElement {

    /**
     * https://leetcode.com/problems/majority-element/
     */
    public int majorityElement(int[] nums) {
        var amountMap = new HashMap<Integer, Integer>();
        for (int num : nums) {
            amountMap.merge(num, 1, Integer::sum);
        }
        var numsSizeHalf = nums.length / 2;
        var majorityElement = amountMap.keySet().stream()
                .filter(element -> amountMap.get(element) > numsSizeHalf)
                .findFirst();
        return majorityElement.get();
    }

}
