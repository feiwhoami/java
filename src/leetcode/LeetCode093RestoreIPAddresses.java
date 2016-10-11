/**
 * Given a string containing only digits, restore it by returning all possible valid IP address combinations.
 * 
 * For example:
 * Given "25525511135",
 * 
 * return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
 */
package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode093RestoreIPAddresses {

    public List<String> restoreIpAddresses(String s) {

        List<String> result = new ArrayList<>();
        if (null == s || s.length() < 4 || s.length() > 12) {
            return result;
        }
        String curr = new String();

        restoreIpAddressesHelper(s, curr, 0, 0, result);
        return result;
    }

    private void restoreIpAddressesHelper(String s, String curr, int index, int segment, List<String> result) {

        if (index > s.length()) {
            return;
        }

        if (segment > 4) {
            return;
        }

        if (index == s.length() && segment == 4) {
            result.add(new String(curr));
            return;
        }

        if (index < s.length()) {
            if (segment != 0) {
                curr = curr + '.';
            }
            curr = curr + s.charAt(index);
            restoreIpAddressesHelper(s, curr, index + 1, segment + 1, result);

            if (index + 1 < s.length()) {
                int tmp1 = Character.getNumericValue(s.charAt(index)) * 10
                        + Character.getNumericValue(s.charAt(index + 1));
                if (tmp1 <= 99 && tmp1 >= 10) {
                    curr = curr + s.charAt(index + 1);
                    restoreIpAddressesHelper(s, curr, index + 2, segment + 1, result);
                }

                if (index + 2 < s.length()) {
                    int tmp2 = Character.getNumericValue(s.charAt(index)) * 100
                            + Character.getNumericValue(s.charAt(index + 1)) * 10
                            + Character.getNumericValue(s.charAt(index + 2));
                    if (tmp2 <= 255 && tmp2 >= 100) {
                        curr = curr + s.charAt(index + 2);
                        restoreIpAddressesHelper(s, curr, index + 3, segment + 1, result);
                    }
                }
            }
        }
    }
}
