/**
 * The gray code is a binary numeral system where two successive values differ in only one bit.
 * 
 * Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.
 * 
 * For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:
 * 
 * 00 - 0
 * 01 - 1
 * 11 - 3
 * 10 - 2
 * Note:
 * For a given n, a gray code sequence is not uniquely defined.
 * 
 * For example, [0,2,3,1] is also a valid gray code sequence according to the above definition.
 * 
 * For now, the judge is able to judge based on one instance of gray code sequence. Sorry about that.
 */
package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode089GrayCode {

    public List<Integer> grayCode(int n) {

        boolean[] digits = new boolean[n];
        List<Integer> result = new ArrayList<>();
        result.add(0);
        int totalSize = (int) Math.pow(2, n);

        while (result.size() < totalSize) {

            for (int i = n - 1; i >= 0; i--) {

                digits[i] = !digits[i];
                int num = convertArrayToInt(digits);

                if (result.contains(num)) {
                    digits[i] = !digits[i];
                    continue;
                } else {
                    result.add(num);
                    break;
                }
            }
        }

        return result;
    }

    private int convertArrayToInt(boolean[] digits) {

        if (null == digits) {
            return 0;
        }

        int size = digits.length;
        int result = 0;

        for (int i = 0; i < size; i++) {
            if (digits[i]) {
                result = (int) (result + Math.pow(2, size - i - 1));
            }
        }

        return result;
    }
}
