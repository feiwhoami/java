/**
 * A self-dividing number is a number that is divisible by every digit it contains.
 * A self-dividing number is not allowed to contain the digit zero.
 * Given two integers left and right, return a list of all the self-dividing numbers in the range [left, right].

 * Example 1:
 * Input: left = 1, right = 22
 * Output: [1,2,3,4,5,6,7,8,9,11,12,15,22]

 * Example 2:
 * Input: left = 47, right = 85
 * Output: [48,55,66,77]
 */
package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode728SelfDividingNumbers {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> result = new ArrayList<>();

        for (int i = left; i <= right; i++) {
            if (selfDividable((i))) {
                result.add(i);
            }
        }

        return result;
    }

    private boolean selfDividable(int val) {
        int originVal = val;
        List<Integer> digits = new ArrayList<>();

        while (val >= 10) {
            int d = val % 10;
            if (d == 0) {
                return false;
            }

            digits.add(d);
            val = val / 10;
        }
        digits.add(val);

        for (Integer d : digits) {
            if (originVal % d != 0) {
                return false;
            }
        }

        return true;
    }
}
