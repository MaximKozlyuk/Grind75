package leetcode.easy;

import java.math.BigInteger;

public class AddBinary {

    /**
     * https://leetcode.com/problems/add-binary/
     */
    public String addBinary(String a, String b) {
        var bigA = new BigInteger(a, 2);
        var bigB = new BigInteger(b, 2);
        return bigA.add(bigB).toString(2);
    }

}
