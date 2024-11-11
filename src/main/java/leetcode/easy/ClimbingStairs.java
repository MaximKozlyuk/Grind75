package leetcode.easy;

public class ClimbingStairs {

    /**
     * https://leetcode.com/problems/climbing-stairs/
     */
    public int climbStairs(int n) {
        var first = 0;
        var second = 1;
        for (int i = 0; i < n; i++) {
            var newVal = second + first;
            first = second;
            second = newVal;
        }
        return second;
    }

}
