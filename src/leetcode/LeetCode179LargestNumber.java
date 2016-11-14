/**
 * Given a list of non negative integers, arrange them such that they form the largest number.
 * 
 * For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.
 * 
 * Note: The result may be very large, so you need to return a string instead of an integer.
 */
package leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class LeetCode179LargestNumber {

    private class StringComparator implements Comparator<String> {

        @Override
        public int compare(String o1, String o2) {
            String s1 = o1 + o2;
            String s2 = o2 + o1;

            return s1.compareTo(s2);
        }
    }

    public String largestNumber(int[] nums) {

        String result = new String();

        if (nums == null || nums.length == 0) {
            return result.toString();
        }

        String[] stringNums = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            stringNums[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(stringNums, new StringComparator());

        for (int i = 0; i < stringNums.length; i++) {
            result = stringNums[i] + result;
        }

        int i = 0;
        while (i < result.length()) {
            if (result.charAt(i) != '0') {
                break;
            }
            i++;
        }

        if (i == result.length()) {
            return "0";
        } else {
            return result.substring(i);
        }
    }
}
