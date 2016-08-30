/**
 * The count-and-say sequence is the sequence of integers beginning as follows:
 * 1, 11, 21, 1211, 111221, ...
 * 
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 * Given an integer n, generate the nth sequence.
 * 
 * Note: The sequence of integers will be represented as a string.
 */
package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode038CountandSay {

    public String countAndSay(int n) {

        if (0 == n) {
            return null;
        }

        List<String> result = new ArrayList<>();
        result.add("1");

        for (int i = 1; i < n; i++) {
            result.add(countAndSay(result.get(i - 1)));
        }

        return result.get(n - 1);
    }

    private String countAndSay(String s) {

        if (null == s || s.isEmpty()) {
            return s;
        }

        StringBuilder sb = new StringBuilder();

        int i = 0;
        while (i < s.length()) {
            int digit = Character.getNumericValue(s.charAt(i));
            int count = 0;

            int j = i;
            for (; j < s.length(); j++) {
                if (digit == Character.getNumericValue(s.charAt(j))) {
                    count++;
                } else {
                    break;
                }
            }
            sb.append(count);
            sb.append(s.charAt(i));
            i = j;
        }

        return sb.toString();
    }
}
