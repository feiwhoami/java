/**
 * Implement atoi to convert a string to an integer.
 */
package leetcode;

public class LeetCode008StringtoIntegeratoi {

    public int myAtoi(String str) {

        if (null == str || str.isEmpty()) {
            return 0;
        }

        int positive;
        int start = 0;
        int length = str.length();

        while (str.charAt(start) == ' ') {
            start++;
        }

        if (str.charAt(start) == '-') {
            positive = -1;
            start++;
        } else if (str.charAt(start) == '+') {
            positive = 1;
            start++;
        } else {
            positive = 1;
        }

        double result = 0;

        for (int i = start; i < str.length(); i++) {
            if (Character.getNumericValue(str.charAt(i)) > 9 || Character.getNumericValue(str.charAt(i)) < 0) {
                return (int) (positive * result / Math.pow(10, length - i));
            }

            result = result + Integer.valueOf(str.substring(i, i + 1)) * Math.pow(10, length - i - 1);
        }

        result = result * positive;

        if (result > Integer.MAX_VALUE)
            return Integer.MAX_VALUE;

        if (result < Integer.MIN_VALUE)
            return Integer.MIN_VALUE;

        return (int) result;
    }
}
