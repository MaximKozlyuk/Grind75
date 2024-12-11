package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _3Sum {

    /**
     * https://leetcode.com/problems/3sum/
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        var result = new ArrayList<List<Integer>>();
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int target = -nums[i];
            int j = i + 1, k = nums.length - 1;

            while (j < k) {
                var numsKJSum = nums[j] + nums[k];
                if (numsKJSum == target) {
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                    while (j < k && nums[j] == nums[j - 1]) {
                        j++;
                    }
                    while (j < k && nums[k] == nums[k + 1]) {
                        k--;
                    }
                } else if (numsKJSum > target) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return result;
    }

}
