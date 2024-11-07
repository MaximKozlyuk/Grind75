package easy;

public class BinarySearch {

    /**
     * https://leetcode.com/problems/binary-search/
     * All the integers in nums are unique
     */
    public int search(int[] nums, int target) {
        if (nums.length == 2) {
            return nums[0] == target
                    ? 0
                        : nums[1] == target
                            ? 1 : -1;
        }

        int leftIndex = 0;
        int rightIndex = nums.length - 1;
        for (;;) {
            var center = (leftIndex + rightIndex) / 2;
            var currentValue = nums[center];
            if (currentValue == target) {
                return center;
            }
            if (leftIndex == rightIndex) {
                return -1;
            }

            if (target < currentValue) {
                rightIndex = center - 1;
            } else {
                leftIndex = center + 1;
            }
        }
    }

}
