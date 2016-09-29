/**
 * The set [1,2,3,…,n] contains a total of n! unique permutations.
 * 
 * By listing and labeling all of the permutations in order,
 * We get the following sequence (ie, for n = 3):
 * 
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * Given n and k, return the kth permutation sequence.
 * 
 * Note: Given n will be between 1 and 9 inclusive.
 */
package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode060PermutationSequence {

    public String getPermutation(int n, int k) {

        StringBuilder result = new StringBuilder();

        if (0 == n) {
            return result.toString();
        }

        List<Integer> nums = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            nums.add(i);
        }

        int factorial = 1;
        for (int i = 2; i < n; i++) {
            factorial = factorial * i;
        }

        k--;

        while (n != 1) {
            int index = k / factorial;
            result.append(nums.get(index));
            nums.remove(index);
            k = k % factorial;
            factorial = factorial / (n - 1);
            n--;
        }

        result.append(nums.get(0));

        return result.toString();
    }
}
