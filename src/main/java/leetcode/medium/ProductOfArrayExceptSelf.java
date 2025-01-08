package leetcode.medium;

import java.util.ArrayList;

public class ProductOfArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        int productOfAll = 0;
        var zerosIndexes = new ArrayList<Integer>();
        int[] answer = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            var currentI = nums[i];
            if (currentI == 0) {
                zerosIndexes.add(i);
            } else {
                if (productOfAll == 0) {
                    productOfAll = currentI;
                } else {
                    productOfAll *= currentI;
                }
            }
        }

        if (zerosIndexes.isEmpty()) {
            for (int i = 0; i < nums.length; i++) {
                answer[i] = productOfAll / nums[i];
            }
        } else if (zerosIndexes.size() == 1) {
            answer[zerosIndexes.getFirst()] = productOfAll;
        }
        return answer;
    }

}
