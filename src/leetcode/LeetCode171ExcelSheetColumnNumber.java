/**
 * Given a column title as appear in an Excel sheet, return its corresponding column number.
 * 
 * For example:
 * 
 *     A -> 1
 *     B -> 2
 *     C -> 3
 *     ...
 *     Z -> 26
 *     AA -> 27
 *     AB -> 28 
 */
package leetcode;

public class LeetCode171ExcelSheetColumnNumber {

    public int titleToNumber(String s) {

        if (null == s) {
            return 0;
        }

        int result = 0;

        for (int i = 0; i < s.length(); i++) {
            int digit = Character.getNumericValue(s.charAt(i)) - 9;
            int pow = s.length() - i - 1;
            result = (int) (result + digit * Math.pow(26, pow));
        }

        return result;
    }
}
