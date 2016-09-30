/**
 * Validate if a given string is numeric.
 * 
 * Some examples:
 * "0" => true
 * " 0.1 " => true
 * "abc" => false
 * "1 a" => false
 * "2e10" => true
 * Note: It is intended for the problem statement to be ambiguous. You should gather all requirements up front before implementing one.
 */
package leetcode;

public class LeetCode065ValidNumber {

    public boolean isNumber(String s) {

        if (null == s || s.isEmpty()) {
            return false;
        }

        int start = 0, end = s.length() - 1;
        while (start < s.length() && s.charAt(start) == ' ') {
            start++;
        }

        while (end >= 0 && s.charAt(end) == ' ') {
            end--;
        }

        if (start > end) {
            return false;
        }

        if (s.charAt(start) == '-' || s.charAt(start) == '+') {
            start++;
        }

        int size = end - start + 1;
        boolean hasDigit = false;
        boolean hasDot = false;
        boolean hasE = false;

        while (start <= end) {

            if (Character.isDigit(s.charAt(start))) {
                hasDigit = true;
                start++;

            } else if (s.charAt(start) == '.') {
                if (hasDot == true || hasE == true || size == 1) {
                    return false;
                }

                hasDot = true;
                start++;

            } else if (s.charAt(start) == 'e') {
                if (hasDigit == false || hasE == true || start == end) {
                    return false;
                }

                hasE = true;
                start++;

                if (s.charAt(start) == '-' || s.charAt(start) == '+') {
                    start++;
                }
                if (start > end) {
                    return false;
                }

            } else {
                return false;
            }
        }

        return true;
    }
}
