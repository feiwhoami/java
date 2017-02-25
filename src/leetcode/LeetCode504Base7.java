/**
 * Given an integer, return its base 7 string representation.
 * 
 * Example 1:
 * Input: 100
 * Output: "202"
 * Example 2:
 * Input: -7
 * Output: "-10"
 * Note: The input will be in range of [-1e7, 1e7].
 */
package leetcode;

public class LeetCode504Base7 {

    public String convertToBase7(int num) {
        String result = new String();
        boolean negative = false;
        if (num < 0) {
            num = -num;
            negative = true;
        }

        while (num >= 7) {
            int mod = num % 7;
            result = mod + result;
            num = num / 7;
        }

        result = num + result;
        if (negative) {
            result = "-" + result;
        }
        return result;
    }

}
