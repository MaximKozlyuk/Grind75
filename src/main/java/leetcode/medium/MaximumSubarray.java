package leetcode.medium;

public class MaximumSubarray {

    /**
     * https://leetcode.com/problems/maximum-subarray/
     */
    public int maxSubArray(int[] nums) {
        var maxSum = nums[0];
        var currentSum = 0;
        for (int num : nums) {
            currentSum = Math.max(num, currentSum + num);
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }

}
