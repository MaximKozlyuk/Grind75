package leetcode.medium;

public final class SearchInRotatedSortedArray {

    /**
     * 33. Search in Rotated Sorted Array
     * https://leetcode.com/problems/search-in-rotated-sorted-array
     *
     * TODO this is a dummy solution, but passes.
     * 1) find pivot, do classic binary search where realMid = (mid + pivot) % nums.length
     */
    public int search(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            }
        }
        return -1;
    }

}
