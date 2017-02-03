/**
 * Write a program to find the n-th ugly number.
 * 
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. For example, 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.
 * 
 * Note that 1 is typically treated as an ugly number, and n does not exceed 1690.
 * 
 * Hint:
 * 
 * The naive approach is to call isUgly for every number until you reach the nth one. Most numbers are not ugly. Try to focus your effort on generating only the ugly ones.
 * An ugly number must be multiplied by either 2, 3, or 5 from a smaller ugly number.
 * The key is how to maintain the order of the ugly numbers. Try a similar approach of merging from three sorted lists: L1, L2, and L3.
 * Assume you have Uk, the kth ugly number. Then Uk+1 must be Min(L1 * 2, L2 * 3, L3 * 5).
 */
package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode264UglyNumberII {

    public int nthUglyNumber(int n) {
        List<Integer> result = new ArrayList<>();

        result.add(1);
        int index2 = 0;
        int index3 = 0;
        int index5 = 0;

        while (result.size() < n) {
            int newValue2 = 2 * result.get(index2);
            int newValue3 = 3 * result.get(index3);
            int newValue5 = 5 * result.get(index5);

            int newValue = Math.min(newValue2, Math.min(newValue3, newValue5));

            if (newValue == newValue2) {
                index2++;
            } else if (newValue == newValue3) {
                index3++;
            } else {
                index5++;
            }

            if (!result.contains(newValue)) {
                result.add(newValue);
            }
        }

        return result.get(result.size() - 1);
    }

}
