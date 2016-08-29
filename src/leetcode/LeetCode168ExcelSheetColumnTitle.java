/**
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.
 * 
 * For example:
 * 
 *     1 -> A
 *     2 -> B
 *     3 -> C
 *     ...
 *     26 -> Z
 *     27 -> AA
 *     28 -> AB 
 */
package leetcode;

public class LeetCode168ExcelSheetColumnTitle {

    public String convertToTitle(int n) {

        String result = "";

        if (n <= 0) {
            return result;
        }

        while (n > 26) {
            char c;

            if (n % 26 == 0) {
                c = 'Z';
                n = n / 26 - 1;
            } else {
                c = (char) (n % 26 + '0' + 16);
                n = n / 26;
            }
            result = c + result;
        }

        char c = (char) (n + '0' + 16);
        result = c + result;

        return result;
    }
}
