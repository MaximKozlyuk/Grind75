package leetcode;

public final class TestUtils {

    public static boolean arraysEqual(int[][] array1, int[][] array2) {
        if (array1 == null || array2 == null) {
            return array1 == array2;
        }
        if (array1.length != array2.length) {
            return false;
        }
        for (int i = 0; i < array1.length; i++) {
            if (array1[i].length != array2[i].length) {
                return false;
            }
            for (int j = 0; j < array1[i].length; j++) {
                if (array1[i][j] != array2[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean arraysEqual(int[] arr1, int[] arr2) {
        if (arr1 == null || arr2 == null) {
            return arr1 == arr2;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

}
