package leetcode.easy;


public class FirstBadVersion {

    public final int theBadVersion;

    public FirstBadVersion(int theBadVersion) {
        this.theBadVersion = theBadVersion;
    }

    private boolean isBadVersion(int version) {
        return theBadVersion <= version;
    }

    /**
     * https://leetcode.com/problems/first-bad-version/
     */
    public int firstBadVersion(int n) {
        int left = 0, right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

}
